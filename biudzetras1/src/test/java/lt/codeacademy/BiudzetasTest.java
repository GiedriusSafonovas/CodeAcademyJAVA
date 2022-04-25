package lt.codeacademy;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.IslaiduIrasas;
import lt.codeacademy.irasai.PajamuIrasas;
import lt.codeacademy.service.IrasaiHandler;
import lt.codeacademy.service.IrasuRedaguotojas;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BiudzetasTest {

  @Test
  public void balansasTest() {
    IrasaiHandler irasaiHandler = new IrasaiHandler(new Biudzetas());
    LocalDate data = LocalDate.now();
    LocalDateTime dataSuLaiku = LocalDateTime.now();
    PajamuIrasas pajamos = new PajamuIrasas(20.5F, data, "Pardavimai", true, "nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10.5F, dataSuLaiku, "Pirkimai", "kortele", "nera");
    irasaiHandler.pridetiIrasa(pajamos);
    irasaiHandler.pridetiIrasa(islaidos);

    float result = irasaiHandler.balansas();
    Assert.assertEquals(10.0F, result, 0);
  }

  @Test
  public void gautiIrasaTest(){
    IrasaiHandler irasaiHandler = new IrasaiHandler(new Biudzetas());
    LocalDate data = LocalDate.now();
    LocalDateTime dataSuLaiku = LocalDateTime.now();
    PajamuIrasas pajamos = new PajamuIrasas(20.5F, data, "Pardavimai", true, "nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10.5F, dataSuLaiku, "Pirkimai", "kortele", "nera");
    irasaiHandler.pridetiIrasa(pajamos);
    irasaiHandler.pridetiIrasa(islaidos);

    Irasas result = irasaiHandler.gautiIrasa(1L);
    Assert.assertEquals(20.5F,result.getSuma(),0);
  }

  @Test
  public void setNewValueTest() {
    IrasaiHandler irasaiHandler = new IrasaiHandler(new Biudzetas());
    LocalDate data = LocalDate.now();
    LocalDateTime dataSuLaiku = LocalDateTime.now();
    PajamuIrasas pajamos = new PajamuIrasas(20.5F, data, "Pardavimai", true, "nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10.5F, dataSuLaiku, "Pirkimai", "kortele", "nera");
    irasaiHandler.pridetiIrasa(pajamos);
    irasaiHandler.pridetiIrasa(islaidos);

    try {
      IrasuRedaguotojas.setNewValue(Irasas.class, irasaiHandler.gautiIrasa(1L), float.class, "setSuma", 300F);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException | IllegalAccessException e) {
      e.printStackTrace();
    }
    Assert.assertEquals(300F, irasaiHandler.gautiIrasa(1L).getSuma(), 0);
  }
}
