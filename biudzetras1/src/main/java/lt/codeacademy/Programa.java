package lt.codeacademy;

public class Programa {
  public static void main(String[] args) {
    Biudzetas biudzetas = new Biudzetas();

    while (true) {
      String selectedChoice = Meniu.pagrindinisMeniu();
      if (selectedChoice.equals("x")) {
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
        case "5":
          System.out.println("Balansas: " + biudzetas.balansas());
          break;
        case "6":
          Meniu.spausdintiVisusIrasus(biudzetas);
          break;
        case "7":
          Meniu.trintiIrasaMeniu(biudzetas);
          break;
        default:
          System.out.println("Neteisinga komanda");
      }
    }
  }
}
