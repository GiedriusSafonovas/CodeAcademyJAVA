package lt.codeacademy;

public class Programa {
  public static void main(String[] args) {
    Biudzetas biudzetas = new Biudzetas();

    while (true) {
      String selectedChoice = Meniu.pagrindinisMeniu();
      if(selectedChoice.equals("5")){
        break;
      }
      switch (selectedChoice) {
        case "1":
          biudzetas.pridetiPajamuIrasa(Meniu.pridetiPajamasMeniu());
          break;
        case "2":
          biudzetas.pridetiIslaiduIrasa(Meniu.pridetiIslaidasMeniu());
          break;
        case "3":
          System.out.println(Meniu.gautiPajamuIrasaMeniu(biudzetas));
          break;
        case "4":
          System.out.println(Meniu.gautiIslaiduIrasaMeniu(biudzetas));
          break;
        default:
          System.out.println("Neteisinga komanda");
      }
    }

    // FOR TESTING
//        PajamuIrasas pajamos1 = new PajamuIrasas(10,"2022-02-06","Pardavimai",true,"nera");
//        IslaiduIrasas islaidos = new IslaiduIrasas(10,"2022-02-06 12:30","Pirkimai","Banko " +
//                "pavedimas","nera");
//
//        biudzetas.pridetiPajamuIrasa(pajamos1);
//        biudzetas.pridetiIslaiduIrasa(islaidos);
//
//        PajamuIrasas pi1 = biudzetas.gautiPajamuIrasa("Pardavimai","2022-02-06");
//        System.out.println(pi1);
//
//        IslaiduIrasas ii1 = biudzetas.gautiIslaiduIrasa("Pirkimai","2022-02-06 12:30");
//        System.out.println(ii1);
  }
}
