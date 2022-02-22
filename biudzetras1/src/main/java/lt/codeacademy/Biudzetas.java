package lt.codeacademy;

import java.util.ArrayList;

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

  //  public PajamuIrasas gautiPajamuIrasa(String kategorija, String data) {
  //    for (PajamuIrasas irasas : pajamos) {
  //      boolean kategorijosSutampa = irasas.getKategorija().equals(kategorija);
  //      boolean datosSutampa = irasas.getData().equals(irasas.stringToDate(data));
  //      if (kategorijosSutampa && datosSutampa) {
  //        return irasas;
  //      }
  //    }
  //    return null;
  //  }
  //
  //  public IslaiduIrasas gautiIslaiduIrasa(String kategorija, String data) {
  //    for (IslaiduIrasas irasas : islaidos) {
  //      boolean kategorijosSutampa = irasas.getKategorija().equals(kategorija);
  //      boolean datosSutampa = irasas.getDataSuLaiku().equals(irasas.stringToDate(data));
  //      if (kategorijosSutampa && datosSutampa) {
  //        return irasas;
  //      }
  //    }
  //    return null;
  //  }

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

  public ArrayList<Irasas> getIrasai() {
    return irasai;
  }
}
