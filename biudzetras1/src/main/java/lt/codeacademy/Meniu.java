package lt.codeacademy;

public class Meniu {

  public static String pagrindinisMeniu() {
    System.out.println(
        "[1] - prideti pajamas\n[2] - prideti islaidas\n[3] - gauti irasa\n"
            + "[4] - balansas\n[5] - visi irasai\n[6] - trinti irasa\n[7] - redaguoti irasa\n[x] - baigti");
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

  private static String gautiIrasoNumeriIsVartotojo() {
    System.out.println("Iveskite iraso unikalu numeri");
    return Scan.scanLine();
  }

  public static Irasas gautiIrasaMeniu(Biudzetas biudzetas) {
    String unikalusNr = gautiIrasoNumeriIsVartotojo();
    return biudzetas.gautiIrasa(unikalusNr);
  }

  public static void spausdintiVisusIrasus(Biudzetas biudzetas) {
    System.out.println(biudzetas.getIrasai());
  }

  public static void trintiIrasaMeniu(Biudzetas biudzetas) {
    String unikalusNr = gautiIrasoNumeriIsVartotojo();
    biudzetas.trintiIrasa(unikalusNr);
  }

  public static void redaguotiIrasaMeniu(Biudzetas biudzetas) {
    String unikalusNr = gautiIrasoNumeriIsVartotojo();
    biudzetas.redaguotiIrasa(unikalusNr);
  }

  public static boolean arRedaguoti(String duomenys) {
    while (true) {
      System.out.println(duomenys);
      System.out.println("[1] - redaguoti, [2] - toliau");
      String atsakymas = Scan.scanLine();
      if(atsakymas.equals("1")){
        return true;
      }else if(atsakymas.equals("2")){
        return false;
      }else {
        System.out.println("Nezinoma komanda");
      }
    }
  }
}
