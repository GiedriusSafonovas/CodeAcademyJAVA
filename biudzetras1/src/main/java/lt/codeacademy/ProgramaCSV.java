package lt.codeacademy;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.service.CSVHandler;
import lt.codeacademy.service.IrasaiHandler;
import lt.codeacademy.service.Meniu;

public class ProgramaCSV {

    public static void run() {
        IrasaiHandler irasaiHandler = new IrasaiHandler(new Biudzetas());
        CSVHandler.readFromCSV(irasaiHandler);

        while (true) {
            String selectedChoice = Meniu.pagrindinisMeniuCSV();
            if (selectedChoice.equals("x")) {
                break;
            }
            switch (selectedChoice) {
                case "1":
                    irasaiHandler.pridetiIrasa(Meniu.pridetiPajamasMeniu());
                    break;
                case "2":
                    irasaiHandler.pridetiIrasa(Meniu.pridetiIslaidasMeniu());
                    break;
                case "3":
                    System.out.println(Meniu.gautiIrasaMeniu(irasaiHandler));
                    break;
                case "4":
                    System.out.println("Balansas: " + irasaiHandler.balansas());
                    break;
                case "5":
                    Meniu.spausdintiVisusIrasus(irasaiHandler);
                    break;
                case "6":
                    Meniu.trintiIrasaMeniu(irasaiHandler);
                    break;
                case "7":
                    Meniu.redaguotiIrasaMeniu(irasaiHandler);
                    break;
                case "8":
                    Meniu.irasytiCSVMeniu(irasaiHandler);
                    break;
                default:
                    System.out.println("Neteisinga komanda");
            }
        }
    }
}
