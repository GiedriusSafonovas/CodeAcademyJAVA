package lt.codeacademy;

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
    biudzetas.pridetiIrasa(pajamos);
    biudzetas.pridetiIrasa(islaidos);

    float result = biudzetas.balansas();
    Assert.assertEquals(10.0F, result, 0);
  }

  @Test
  public void setNewValueTest() {
    Biudzetas biudzetas = new Biudzetas();
    LocalDate data = LocalDate.now();
    LocalDateTime dataSuLaiku = LocalDateTime.now();
    PajamuIrasas pajamos = new PajamuIrasas(20.5F, data, "Pardavimai", true, "nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10.5F, dataSuLaiku, "Pirkimai", "kortele", "nera");
    biudzetas.pridetiIrasa(pajamos);
    biudzetas.pridetiIrasa(islaidos);

    try {
      biudzetas.setNewValue(Irasas.class, biudzetas.gautiIrasa("P1"), float.class, "setSuma", 300F);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    Assert.assertEquals(300F, biudzetas.gautiIrasa("P1").getSuma(), 0);
  }
}
