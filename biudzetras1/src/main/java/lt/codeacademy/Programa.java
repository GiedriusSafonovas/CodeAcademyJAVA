package lt.codeacademy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Programa {
  public static void main(String[] args) {
    Biudzetas biudzetas = new Biudzetas();
    CSVHandler.readFromCSV(biudzetas);

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
        case "8":
          Meniu.irasytiCSVMeniu(biudzetas);
          break;
        default:
          System.out.println("Neteisinga komanda");
      }
    }
  }
}
