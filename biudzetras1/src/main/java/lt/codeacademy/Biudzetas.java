package lt.codeacademy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

  public boolean trintiIrasa(String trinamoIrasoUnikalusNr) {
    Irasas trinamasIrasas = new Irasas(trinamoIrasoUnikalusNr);
    if (irasai.contains(trinamasIrasas)) {
      irasai.remove(trinamasIrasas);
      return true;
    }
    return false;
  }

  public boolean redaguotiIrasa(String unikalusNr) {
    Irasas redaguojamasIrasas = gautiIrasa(unikalusNr);
    if (!irasai.contains(redaguojamasIrasas)) {
      return false;
    }

    Class klase = redaguojamasIrasas.getClass();
    Class superKlase = klase.getSuperclass();

    redaguotiIrasaPagalKlase(redaguojamasIrasas, superKlase);
    redaguotiIrasaPagalKlase(redaguojamasIrasas, klase);

    atnaujintiIrasa(redaguojamasIrasas);
    return true;
  }

  public void redaguotiIrasaPagalKlase(Irasas redaguojamasIrasas, Class klase) {
    List<Field> klasesLaukai = List.of(klase.getDeclaredFields());
    List<Class> setteriuParametruTipai = new ArrayList<>();
    for (Field laukas : klasesLaukai) {
      setteriuParametruTipai.add(laukas.getType());
    }

    for (Field laukas : klasesLaukai) {
      String laukoPavadinimas = laukas.getName();
      if (laukoPavadinimas.equals("counter") || laukoPavadinimas.equals("unikalusNr")) {
        continue;
      }
      try {
        String geterioPavadinimas =
            "get"
                + laukoPavadinimas.substring(0, 1).toUpperCase(Locale.ROOT)
                + laukoPavadinimas.substring(1);
        Object laukoReiksme = klase.getMethod(geterioPavadinimas).invoke(redaguojamasIrasas);

        if (Meniu.arRedaguoti(laukoPavadinimas.toUpperCase(Locale.ROOT) + " = " + laukoReiksme)) {
          String setterioPavadinimas =
              "set"
                  + laukoPavadinimas.substring(0, 1).toUpperCase(Locale.ROOT)
                  + laukoPavadinimas.substring(1);
          System.out.println("Iveskite nauja reiksme");

          List<Method> scannerioMetodai = List.of(Scan.class.getDeclaredMethods());
          Object naujaVerte = null;
          for (Method scanneris : scannerioMetodai) {
            if (scanneris.getReturnType() == laukas.getType()
                && scanneris.getParameterTypes().length == 0) {
              naujaVerte = scanneris.invoke(null);
            }
          }
          setNewValue(klase, redaguojamasIrasas, laukas.getType(), setterioPavadinimas, naujaVerte);
        }

      } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }

  public void setNewValue(
      Class klase, Irasas irasas, Class duomenuTipas, String setteris, Object naujaVerte)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    klase.getMethod(setteris, duomenuTipas).invoke(irasas, naujaVerte);
  }

  public void atnaujintiIrasa(Irasas irasas) {
    int indeksoNr = irasai.indexOf(irasas);
    irasai.set(indeksoNr, irasas);
  }

  public ArrayList<Irasas> getIrasai() {
    return irasai;
  }
}
