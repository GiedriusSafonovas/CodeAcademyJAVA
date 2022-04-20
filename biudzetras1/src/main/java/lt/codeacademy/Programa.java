package lt.codeacademy;


import lt.codeacademy.service.Scan;

import java.util.Locale;

public class Programa {
  public static void start() {

    System.out.println("Ar norite naudoti duomenu baze? [Y/N]");
    while (true){
      String pasirinkimas = Scan.scanLine();
      if(pasirinkimas.toLowerCase(Locale.ROOT).equals("y")){
        ProgramaDB.run();
        break;
      }else if(pasirinkimas.toLowerCase(Locale.ROOT).equals("n")){
        ProgramaCSV.run();
        break;
      }else{
        System.out.println("Nezinoma komanda");
      }
    }

  }
}
