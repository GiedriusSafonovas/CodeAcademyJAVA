package lt.codeacademy.service;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.IslaiduIrasas;
import lt.codeacademy.irasai.PajamuIrasas;
import lt.codeacademy.repository.DBHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Meniu {

  public static String pagrindinisMeniu() {
    System.out.println(
        "[1] - prideti pajamas\n[2] - prideti islaidas\n[3] - gauti irasa\n"
            + "[4] - balansas\n[5] - visi irasai\n[6] - trinti irasa\n[7] - redaguoti irasa\n"
            + "[8] - irasyti i CSV\n[x] - baigti");
    return Scan.scanLine();
  }

  public static PajamuIrasas pridetiPajamasMeniu() {
    System.out.println("Iveskite suma");
    float suma = Scan.scanFloat();
    System.out.println("Iveskite data (yyyy-MM-dd)");
    LocalDate data = Scan.scanDate();
    System.out.println("Iveskite kategorija");
    String kategorija = Scan.scanLine();
    System.out.println("Iveskite ar pinigai gauti i banka (true/false)");
    boolean pozymisArIBanka = Scan.scanBoolean();
    System.out.println("Iveskite papildoma info");
    String papildomaInfo = Scan.scanLine();
    return new PajamuIrasas(suma, data, kategorija, pozymisArIBanka, papildomaInfo);
  }

  public static IslaiduIrasas pridetiIslaidasMeniu() {
    System.out.println("Iveskite suma");
    float suma = Scan.scanFloat();
    System.out.println("Iveskite data su laiku (yyyy-MM-dd HH:mm)");
    LocalDateTime dataSuLaiku = Scan.scanDateTime();
    System.out.println("Iveskite kategorija");
    String kategorija = Scan.scanLine();
    System.out.println("Iveskite atsiskaitymo buda");
    String atsiskaitymoBudas = Scan.scanLine();
    System.out.println("Iveskite papildoma info");
    String papildomaInfo = Scan.scanLine();
    return new IslaiduIrasas(suma, dataSuLaiku, kategorija, atsiskaitymoBudas, papildomaInfo);
  }

  private static long gautiIrasoNumeriIsVartotojo() {
    System.out.println("Iveskite iraso unikalu numeri");
    return Scan.scanLong();
  }

  public static Irasas gautiIrasaMeniu(Biudzetas biudzetas) {
    long unikalusNr = gautiIrasoNumeriIsVartotojo();
    return IrasaiHandler.gautiIrasa(unikalusNr, biudzetas);
  }

  public static Irasas gautiIrasaMeniu(DBHandler dbHandler) {
    long unikalusNr = gautiIrasoNumeriIsVartotojo();
    return dbHandler.gautiIrasa(unikalusNr);
  }

  public static void spausdintiVisusIrasus(Biudzetas biudzetas) {
    System.out.println(biudzetas.getIrasai());
  }

  public static void spausdintiVisusIrasus(DBHandler dbHandler) {
    System.out.println(dbHandler.gautiVisusIrasus());
  }

  public static void trintiIrasaMeniu(Biudzetas biudzetas) {
    long unikalusNr = gautiIrasoNumeriIsVartotojo();
    deletionResult(IrasaiHandler.trintiIrasa(unikalusNr, biudzetas),unikalusNr);
  }

  public static void trintiIrasaMeniu(DBHandler dbHandler) {
    long unikalusNr = gautiIrasoNumeriIsVartotojo();
    deletionResult(dbHandler.trintiIrasa(unikalusNr), unikalusNr);
  }

  private static void deletionResult(boolean result, long unikalusNr){
    if(result){
      System.out.println("Irasas " + unikalusNr + " istrintas");
    } else {
      System.out.println("Tokio iraso nera");
    }
  }

  public static void redaguotiIrasaMeniu(Biudzetas biudzetas) {
    long unikalusNr = gautiIrasoNumeriIsVartotojo();
    if (IrasaiHandler.redaguotiIrasa(unikalusNr, biudzetas)) {
      System.out.println("Iraso duomenys pakeisti");
    } else {
      System.out.println("Tokio iraso nera");
    }
  }

  public static boolean arRedaguoti(String duomenys) {
    while (true) {
      System.out.println(duomenys);
      System.out.println("[1] - redaguoti, [2] - toliau");
      String atsakymas = Scan.scanLine();
      if (atsakymas.equals("1")) {
        return true;
      } else if (atsakymas.equals("2")) {
        return false;
      } else {
        System.out.println("Nezinoma komanda");
      }
    }
  }

  public static void irasytiCSVMeniu(Biudzetas biudzetas) {
    CSVHandler.writeToCsv(IrasaiHandler.gautiPajamuIrasus(biudzetas), IrasaiHandler.gautiIslaiduIrasus(biudzetas));
  }
}
