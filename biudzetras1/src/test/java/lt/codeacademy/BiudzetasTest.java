package lt.codeacademy;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BiudzetasTest {

  @Test
  public void balansasTest(){
    Biudzetas biudzetas = new Biudzetas();
    LocalDate data = LocalDate.now();
    LocalDateTime dataSuLaiku = LocalDateTime.now();
    PajamuIrasas pajamos = new PajamuIrasas(20.5F,data,"Pardavimai", true, "nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10.5F,dataSuLaiku,"Pirkimai", "kortele", "nera");
    biudzetas.pridetiIrasa(pajamos);
    biudzetas.pridetiIrasa(islaidos);

    float result = biudzetas.balansas();
    Assert.assertEquals(10.0F,result,0);
  }

}
