package lt.codeacademy;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biudzetas {
  private ArrayList<Irasas> irasai = new ArrayList<>();

  public void pridetiIrasa(Irasas irasas) {
    irasai.add(irasas);
  }

  public Irasas gautiIrasa(String unikalusNr) {
    Irasas ieskomasIrasas = new Irasas(unikalusNr);
    if (irasai.contains(ieskomasIrasas)) {
      int irasoIndeksas = irasai.indexOf(ieskomasIrasas);
      return irasai.get(irasoIndeksas);
    }
    return null;
  }

  public ArrayList<PajamuIrasas> gautiPajamuIrasus() {
    List<Irasas> irasuSarasas = getIrasasByClass(PajamuIrasas.class);
    ArrayList<PajamuIrasas> pajamuIrasai = new ArrayList<>();
    for (Irasas irasas : irasuSarasas) {
      pajamuIrasai.add((PajamuIrasas) irasas);
    }
    return pajamuIrasai;
  }

  public ArrayList<IslaiduIrasas> gautiIslaiduIrasus() {
    List<Irasas> irasuSarasas = getIrasasByClass(IslaiduIrasas.class);
    ArrayList<IslaiduIrasas> islaiduIrasai = new ArrayList<>();
    for (Irasas irasas : irasuSarasas) {
      islaiduIrasai.add((IslaiduIrasas) irasas);
    }
    return islaiduIrasai;
  }

  public List<Irasas> getIrasasByClass(Class<? extends Irasas> klase) {
    List<Irasas> result = new ArrayList<>();
    for (Irasas irasas : irasai) {
      if (irasas.getClass() == klase) {
        result.add(irasas);
      }
    }
    return result;
  }

  public float balansas() {
    float sum = 0;
    for (Irasas irasas : irasai) {
      if (irasas.getUnikalusNr().charAt(0) == 'P') {
        sum += irasas.getSuma();
      } else {
        sum -= irasas.getSuma();
      }
    }
    return sum;
  }

  public void trintiIrasa(String trinamoIrasoUnikalusNr) {
    Irasas trinamasIrasas = new Irasas(trinamoIrasoUnikalusNr);
    irasai.remove(trinamasIrasas);
  }

  // TODO: sugalvoti geresni metoda redagavimui
  public void redaguotiIrasa(String unikalusNr) {

    Irasas redaguojamasIrasas = gautiIrasa(unikalusNr);
    String[] duomenys = redaguojamasIrasas.toString().split("\n");
    List<Field> tevinesKlasesLaukai =
        List.of(redaguojamasIrasas.getClass().getSuperclass().getDeclaredFields());
    int tevinesKlasesLaukuSkaicius = tevinesKlasesLaukai.size() - 2; // be counter ir ID

    for (int i = 0; i < duomenys.length; i++) {
      boolean tevinesKlasesDuomenys = (i <= tevinesKlasesLaukuSkaicius);

      if (i == 0) { // skip ID, nes nekoreguojamas
        continue;
      }

      if (Meniu.arRedaguoti(duomenys[i])) {
        if (tevinesKlasesDuomenys) {
          redaguojamasIrasas = redaguotiIrasoLaukus(i, redaguojamasIrasas);
        } else if (redaguojamasIrasas instanceof PajamuIrasas) {
          redaguojamasIrasas = redaguotiIrasoLaukus(i, (PajamuIrasas) redaguojamasIrasas);
        } else {
          redaguojamasIrasas = redaguotiIrasoLaukus(i, (IslaiduIrasas) redaguojamasIrasas);
        }
      }
    }
  }

  public Irasas redaguotiIrasoLaukus(int laukas, Irasas irasas) {
    switch (laukas) {
        // suma
      case 1:
        System.out.println("Iveskite nauja suma");
        float suma = Scan.scanFloat();
        irasas.setSuma(suma);
        break;
        // kategorija
      case 2:
        System.out.println("Iveskite nauja kategorija");
        String kategorija = Scan.scanLine();
        irasas.setKategorija(kategorija);
        break;
        // papildoma info
      case 3:
        System.out.println("Iveskite nauja papildoma info");
        String papildomaInfo = Scan.scanLine();
        irasas.setPapildomaInfo(papildomaInfo);
        break;
    }
    return irasas;
  }

  public Irasas redaguotiIrasoLaukus(int laukas, PajamuIrasas irasas) {
    switch (laukas) {
        // data
      case 4:
        System.out.println("Iveskite nauja data (yyyy-MM-dd)");
        String data = Scan.scanLine();
        irasas.setData(data);
        break;
        // ar gauta i banka
      case 5:
        System.out.println("Iveskite ar pinigai gauti i banka (true/false)");
        boolean arGautiIBanka = Scan.scanBoolean();
        irasas.setPozymisArIBanka(arGautiIBanka);
        break;
    }
    return irasas;
  }

  public Irasas redaguotiIrasoLaukus(int laukas, IslaiduIrasas irasas) {
    switch (laukas) {
        // data su laiku
      case 4:
        System.out.println("Iveskite nauja data su laiku (yyyy-MM-dd hh:mm)");
        String data = Scan.scanLine();
        irasas.setDataSuLaiku(data);
        break;
        // atsiskaitymo budas
      case 5:
        System.out.println("Iveskite nauja atsiskaitymo buda");
        String atsiskaitymoBudas = Scan.scanLine();
        irasas.setAtsiskaitymoBudas(atsiskaitymoBudas);
        break;
    }
    return irasas;
  }

  public void atnaujintiIrasa(Irasas irasas) {
    int indeksoNr = irasai.indexOf(irasas);
    irasai.set(indeksoNr, irasas);
  }

  public ArrayList<Irasas> getIrasai() {
    return irasai;
  }
}
