package lt.codeacademy;

import lt.codeacademy.service.DBHandler;
import lt.codeacademy.service.Meniu;

public class ProgramaDB {
    public static void run(){
        DBHandler dbHandler = new DBHandler();

        while (true) {
            String selectedChoice = Meniu.pagrindinisMeniuDB();
            if (selectedChoice.equals("x")) {
                break;
            }
            switch (selectedChoice) {
                case "1":
                    dbHandler.pridetiPajamuIrasa(Meniu.pridetiPajamasMeniu());
                    break;
                case "2":
                    dbHandler.pridetiIslaiduIrasa(Meniu.pridetiIslaidasMeniu());
                    break;
                case "3":
                    System.out.println(Meniu.gautiIrasaMeniu(dbHandler));
                    break;
                case "4":
                    System.out.println(dbHandler.gautiBalansa());
                    break;
                case "5":
                    Meniu.spausdintiVisusIrasus(dbHandler);
                    break;
                case "6":
                    Meniu.trintiIrasaMeniu(dbHandler);
                    break;
                case "7":
                    Meniu.redaguotiIrasaMeniu(dbHandler);
                    break;
                default:
                    System.out.println("Neteisinga komanda");
            }
        }
    }
}
