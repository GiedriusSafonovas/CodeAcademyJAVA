package lt.codeacademy;

import org.junit.Assert;
import org.junit.Test;


public class BiudzetasTest {
    Biudzetas biudzetas = new Biudzetas();

    @Test
    public void gautiPajamuIrasaTest(){
        PajamuIrasas pajamos = new PajamuIrasas(10,"2022-02-06","Pardavimai",true,"nera");
        biudzetas.pridetiPajamuIrasa(pajamos);
        PajamuIrasas result = biudzetas.gautiPajamuIrasa("Pardavimai","2022-02-06");
        Assert.assertEquals(result,pajamos);
    }

    @Test
    public void gautiIslaiduIrasaTest(){
        IslaiduIrasas islaidos = new IslaiduIrasas(10,"2022-02-06 12:30","Pirkimai","Banko " +
                "pavedimas","nera");
        biudzetas.pridetiIslaiduIrasa(islaidos);
        IslaiduIrasas result = biudzetas.gautiIslaiduIrasa("Pirkimai","2022-02-06 12:30");
        Assert.assertEquals(result,islaidos);
    }
}
