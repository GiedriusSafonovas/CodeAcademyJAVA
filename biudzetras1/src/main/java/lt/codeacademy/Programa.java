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
  }
}
