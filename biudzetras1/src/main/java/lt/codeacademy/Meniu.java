package lt.codeacademy;

public class Meniu {


  public static String pagrindinisMeniu() {
    System.out.println(
        "[1] - prideti pajamas\n[2] - prideti islaidas\n[3] - gauti pajamas\n[4] - gauti islaidas\n"
            + "[5] - balansas\n[6] - visi irasai\n[7] - trinti irasa\n[x] - baigti");
    return Scan.scanLine();
  }

  public static PajamuIrasas pridetiPajamasMeniu() {
    System.out.println("Iveskite suma");
    float suma = Scan.scanFloat();
    System.out.println("Iveskite data (yyyy-MM-dd)");
    String data = Scan.scanLine();
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
    String dataSuLaiku = Scan.scanLine();
    System.out.println("Iveskite kategorija");
    String kategorija = Scan.scanLine();
    System.out.println("Iveskite atsiskaitymo buda");
    String atsiskaitymoBudas = Scan.scanLine();
    System.out.println("Iveskite papildoma info");
    String papildomaInfo = Scan.scanLine();
    return new IslaiduIrasas(suma, dataSuLaiku, kategorija, atsiskaitymoBudas, papildomaInfo);
  }

  public static PajamuIrasas gautiPajamuIrasaMeniu(Biudzetas biudzetas){
    System.out.println("Iveskite kategorija");
    String kategorija = Scan.scanLine();
    System.out.println("Iveskite data (yyyy-MM-dd)");
    String data = Scan.scanLine();
    return biudzetas.gautiPajamuIrasa(kategorija,data);
  }

  public static IslaiduIrasas gautiIslaiduIrasaMeniu(Biudzetas biudzetas){
    System.out.println("Iveskite kategorija");
    String kategorija = Scan.scanLine();
    System.out.println("Iveskite data su laiku (yyyy-MM-dd HH:mm)");
    String dataSuLaiku = Scan.scanLine();
    return biudzetas.gautiIslaiduIrasa(kategorija,dataSuLaiku);
  }

  public static void spausdintiVisusIrasus(Biudzetas biudzetas){
    for (PajamuIrasas irasas : biudzetas.getPajamos()){
      System.out.println(irasas);
    }
    System.out.println();
    for (IslaiduIrasas irasas : biudzetas.getIslaidos()){
      System.out.println(irasas);
    }
  }

  public static void trintiIrasaMeniu(Biudzetas biudzetas){
    System.out.println("Iveskite iraso unikalu numeri");
    String unikalusNr = Scan.scanLine();
    biudzetas.trintiIrasa(unikalusNr);
  }
}
