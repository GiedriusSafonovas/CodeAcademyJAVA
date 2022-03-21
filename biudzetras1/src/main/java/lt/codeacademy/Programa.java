package lt.codeacademy;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.service.CSVHandler;
import lt.codeacademy.service.IrasaiHandler;
import lt.codeacademy.service.Meniu;

public class Programa {
  public static void start() {
    Biudzetas biudzetas = new Biudzetas();
    CSVHandler.readFromCSV(biudzetas);

    while (true) {
      String selectedChoice = Meniu.pagrindinisMeniu();
      if (selectedChoice.equals("x")) {
        break;
      }
      switch (selectedChoice) {
        case "1":
          IrasaiHandler.pridetiIrasa(Meniu.pridetiPajamasMeniu(), biudzetas);
          break;
        case "2":
          IrasaiHandler.pridetiIrasa(Meniu.pridetiIslaidasMeniu(), biudzetas);
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
