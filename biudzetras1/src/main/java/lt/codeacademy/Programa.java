package lt.codeacademy;

public class Programa {
  public static void main(String[] args) {
    Biudzetas biudzetas = new Biudzetas();
    PajamuIrasas pajamos1 = new PajamuIrasas(10,"2022-02-06","Pardavimai",true,"nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10,"2022-02-06 12:30","Pirkimai","Banko pavedimas","nera");

    biudzetas.pridetiPajamuIrasa(pajamos1);
    biudzetas.pridetiIslaiduIrasa(islaidos);

    PajamuIrasas pi1 = biudzetas.gautiPajamuIrasa("Pardavimai","2022-02-06");
    IslaiduIrasas ii1 = biudzetas.gautiIslaiduIrasa("Pirkimai","2022-02-06 12:30");


  }
}
