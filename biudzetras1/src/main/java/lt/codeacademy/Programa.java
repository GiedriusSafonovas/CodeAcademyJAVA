package lt.codeacademy;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.repository.DBHandler;
import lt.codeacademy.service.CSVHandler;
import lt.codeacademy.service.Meniu;

public class Programa {
  public static void start() {
    Biudzetas biudzetas = new Biudzetas();
    CSVHandler.readFromCSV(biudzetas);
    DBHandler dbHandler = new DBHandler();

    while (true) {
      String selectedChoice = Meniu.pagrindinisMeniu();
      if (selectedChoice.equals("x")) {
        break;
      }
      switch (selectedChoice) {
        case "1":
//          IrasaiHandler.pridetiIrasa(Meniu.pridetiPajamasMeniu(), biudzetas);
          dbHandler.pridetiPajamuIrasa(Meniu.pridetiPajamasMeniu());
          break;
        case "2":
//          IrasaiHandler.pridetiIrasa(Meniu.pridetiIslaidasMeniu(), biudzetas);
          dbHandler.pridetiIslaiduIrasa(Meniu.pridetiIslaidasMeniu());
          break;
        case "3":
//          System.out.println(Meniu.gautiIrasaMeniu(biudzetas));
          System.out.println(Meniu.gautiIrasaMeniu(dbHandler));
          break;
        case "4":
//          System.out.println("Balansas: " + biudzetas.balansas());
          System.out.println(dbHandler.gautiBalansa());
          break;
        case "5":
//          Meniu.spausdintiVisusIrasus(biudzetas);
          Meniu.spausdintiVisusIrasus(dbHandler);
          break;
        case "6":
//          Meniu.trintiIrasaMeniu(biudzetas);
          Meniu.trintiIrasaMeniu(dbHandler);
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
