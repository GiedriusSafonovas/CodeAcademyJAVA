package lt.codeacademy;

import org.junit.Test;

public class MeniuTest {
  Biudzetas biudzetas = new Biudzetas();

  public MeniuTest(){
    PajamuIrasas pajamos = new PajamuIrasas(21.5f, "2022-02-06", "Pardavimai", true, "nera");
    IslaiduIrasas islaidos =
            new IslaiduIrasas(10, "2022-02-06 12:30", "Pirkimai", "Banko " + "pavedimas", "nera");
    biudzetas.pridetiPajamuIrasa(pajamos);
    biudzetas.pridetiIslaiduIrasa(islaidos);
  }

  @Test
  public void spausdintiVisusIrasusTest() {
    for (PajamuIrasas irasas : biudzetas.getPajamos()) {
      System.out.println(irasas);
    }
    System.out.println();
    for (IslaiduIrasas irasas : biudzetas.getIslaidos()) {
      System.out.println(irasas);
    }
  }
}
