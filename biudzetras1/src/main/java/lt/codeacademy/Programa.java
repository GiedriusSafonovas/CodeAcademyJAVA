package lt.codeacademy;

public class Programa {
  public static void main(String[] args) {
    Biudzetas biudzetas = new Biudzetas();
    PajamuIrasas pajamos1 = new PajamuIrasas(10,"2022-02-06","Pardavimai",true,"nera");
    IslaiduIrasas islaidos = new IslaiduIrasas(10,"2022-02-06 12:30","Pirkimai","Banko pavedimas","nera");
  }
}
