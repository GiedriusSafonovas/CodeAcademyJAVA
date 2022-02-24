package lt.codeacademy;

//3-ia dalis baigta

public class Programa {
  public static void main(String[] args) {
    Biudzetas biudzetas = new Biudzetas();
    PajamuIrasas pajamos = new PajamuIrasas(21.5f, "2022-02-06", "Pardavimai", true, "nera");
    biudzetas.pridetiIrasa(pajamos);

    while (true) {
      String selectedChoice = Meniu.pagrindinisMeniu();
      if (selectedChoice.equals("x")) {
        break;
      }
      switch (selectedChoice) {
        case "1":
          biudzetas.pridetiIrasa(Meniu.pridetiPajamasMeniu());
          break;
        case "2":
          biudzetas.pridetiIrasa(Meniu.pridetiIslaidasMeniu());
          break;
        case "3":
          System.out.println(Meniu.gautiIrasaMeniu(biudzetas));
          break;
        case "4":
          System.out.println("Balansas: " + biudzetas.balansas());
          break;
        case "5":
          Meniu.spausdintiVisusIrasus(biudzetas);
          break;
        case "6":
          Meniu.trintiIrasaMeniu(biudzetas);
          break;
        case "7":
          Meniu.redaguotiIrasaMeniu(biudzetas);
          break;
        default:
          System.out.println("Neteisinga komanda");
      }
    }
  }
}
