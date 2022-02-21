package lt.codeacademy;

import org.junit.Assert;
import org.junit.Test;

public class BiudzetasTest {
  Biudzetas biudzetas = new Biudzetas();
  PajamuIrasas pajamos = new PajamuIrasas(21.5f, "2022-02-06", "Pardavimai", true, "nera");
  IslaiduIrasas islaidos =
      new IslaiduIrasas(10, "2022-02-06 12:30", "Pirkimai", "Banko " + "pavedimas", "nera");

  @Test
  public void gautiPajamuIrasaTest() {
    biudzetas.pridetiPajamuIrasa(pajamos);
    PajamuIrasas result = biudzetas.gautiPajamuIrasa("Pardavimai", "2022-02-06");
    Assert.assertEquals(pajamos, result);
  }

  @Test
  public void gautiIslaiduIrasaTest() {
    biudzetas.pridetiIslaiduIrasa(islaidos);
    IslaiduIrasas result = biudzetas.gautiIslaiduIrasa("Pirkimai", "2022-02-06 12:30");
    Assert.assertEquals(islaidos, result);
  }

  @Test
  public void balansasTest() {
    biudzetas.pridetiPajamuIrasa(pajamos);
    biudzetas.pridetiIslaiduIrasa(islaidos);
    float result = biudzetas.balansas();
    float expected = 21.5f - 10;
    Assert.assertEquals(expected, result, 0);
  }
}
