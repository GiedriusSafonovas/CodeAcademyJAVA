package lt.codeacademy;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.IslaiduIrasas;
import lt.codeacademy.irasai.PajamuIrasas;
import lt.codeacademy.service.IrasaiHandler;
import lt.codeacademy.service.LocalIrasuRedaguotojas;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BiudzetasTest {

  @Test
  public void balansasTest() {
    Biudzetas biudzetas = new Biudzetas();
    LocalDate data = LocalDate.now();
    LocalDateTime dataSuLaiku = LocalDateTime.now();
    PajamuIrasas pajamos = new PajamuIrasas(20.5F, data, "Pardavimai", true, "nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10.5F, dataSuLaiku, "Pirkimai", "kortele", "nera");
    IrasaiHandler.pridetiIrasa(pajamos, biudzetas);
    IrasaiHandler.pridetiIrasa(islaidos, biudzetas);

    float result = biudzetas.balansas();
    Assert.assertEquals(10.0F, result, 0);
  }

  @Test
  public void gautiIrasaTest(){
    Biudzetas biudzetas = new Biudzetas();
    LocalDate data = LocalDate.now();
    LocalDateTime dataSuLaiku = LocalDateTime.now();
    PajamuIrasas pajamos = new PajamuIrasas(20.5F, data, "Pardavimai", true, "nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10.5F, dataSuLaiku, "Pirkimai", "kortele", "nera");
    IrasaiHandler.pridetiIrasa(pajamos, biudzetas);
    IrasaiHandler.pridetiIrasa(islaidos, biudzetas);

    Irasas result = IrasaiHandler.gautiIrasa(1L, biudzetas);
    Assert.assertEquals(20.5F,result.getSuma(),0);
  }

  @Test
  public void setNewValueTest() {
    Biudzetas biudzetas = new Biudzetas();
    LocalDate data = LocalDate.now();
    LocalDateTime dataSuLaiku = LocalDateTime.now();
    PajamuIrasas pajamos = new PajamuIrasas(20.5F, data, "Pardavimai", true, "nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10.5F, dataSuLaiku, "Pirkimai", "kortele", "nera");
    IrasaiHandler.pridetiIrasa(pajamos, biudzetas);
    IrasaiHandler.pridetiIrasa(islaidos, biudzetas);

    try {
      LocalIrasuRedaguotojas.setNewValue(Irasas.class, IrasaiHandler.gautiIrasa(1L, biudzetas), float.class, "setSuma", 300F);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException | IllegalAccessException e) {
      e.printStackTrace();
    }
    Assert.assertEquals(300F, IrasaiHandler.gautiIrasa(1L, biudzetas).getSuma(), 0);
  }
}
