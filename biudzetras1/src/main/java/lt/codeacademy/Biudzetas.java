package lt.codeacademy;

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
    for(Irasas irasas : irasuSarasas){
      pajamuIrasai.add((PajamuIrasas) irasas);
    }
    return pajamuIrasai;
  }

  public ArrayList<IslaiduIrasas> gautiIslaiduIrasus() {
    List<Irasas> irasuSarasas = getIrasasByClass(IslaiduIrasas.class);
    ArrayList<IslaiduIrasas> islaiduIrasai = new ArrayList<>();
    for(Irasas irasas : irasuSarasas){
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

  public ArrayList<Irasas> getIrasai() {
    return irasai;
  }
}
