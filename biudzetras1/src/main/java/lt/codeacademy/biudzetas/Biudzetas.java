package lt.codeacademy.biudzetas;

import lt.codeacademy.irasai.Irasas;

import java.util.ArrayList;

public class Biudzetas {
  private ArrayList<Irasas> irasai = new ArrayList<>();

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

  public ArrayList<Irasas> getIrasai() {
    return irasai;
  }
}
