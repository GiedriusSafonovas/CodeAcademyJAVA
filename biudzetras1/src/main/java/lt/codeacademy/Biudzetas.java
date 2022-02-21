package lt.codeacademy;

import java.util.ArrayList;

public class Biudzetas {
  private ArrayList<PajamuIrasas> pajamos = new ArrayList<>();
  private ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();

  public void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas) {
    pajamos.add(pajamuIrasas);
  }

  public void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas) {
    islaidos.add(islaiduIrasas);
  }

  public PajamuIrasas gautiPajamuIrasa(String kategorija, String data) {
    for (PajamuIrasas irasas : pajamos) {
      boolean kategorijosSutampa = irasas.getKategorija().equals(kategorija);
      boolean datosSutampa = irasas.getData().equals(irasas.stringToDate(data));
      if (kategorijosSutampa && datosSutampa) {
        return irasas;
      }
    }
    return null;
  }

  public IslaiduIrasas gautiIslaiduIrasa(String kategorija, String data) {
    for (IslaiduIrasas irasas : islaidos) {
      boolean kategorijosSutampa = irasas.getKategorija().equals(kategorija);
      boolean datosSutampa = irasas.getDataSuLaiku().equals(irasas.stringToDate(data));
      if (kategorijosSutampa && datosSutampa) {
        return irasas;
      }
    }
    return null;
  }

  public float balansas() {
    float sum = 0;
    for (PajamuIrasas irasas : pajamos) {
      sum += irasas.getSuma();
    }
    for (IslaiduIrasas irasas : islaidos) {
      sum -= irasas.getSuma();
    }
    return sum;
  }

  public void trintiIrasa(String trinamoIrasoUnikalusNr) {
    if (trinamoIrasoUnikalusNr.substring(0,1).equals("P")) {
      for (int i = 0; i < pajamos.size(); i++) {
        String irasoSaraseNr = pajamos.get(i).getUnikalusNr();
        if (irasoSaraseNr.equals(trinamoIrasoUnikalusNr)) {
          pajamos.remove(i);
          return;
        }
      }
    } else {
      for (int i = 0; i < islaidos.size(); i++) {
        String irasoSaraseNr = islaidos.get(i).getUnikalusNr();
        if (irasoSaraseNr.equals(trinamoIrasoUnikalusNr)) {
          islaidos.remove(i);
          return;
        }
      }
    }
  }

  public ArrayList<PajamuIrasas> getPajamos() {
    return pajamos;
  }

  public ArrayList<IslaiduIrasas> getIslaidos() {
    return islaidos;
  }
}
