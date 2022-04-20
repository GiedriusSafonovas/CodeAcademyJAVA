package lt.codeacademy.repository;

import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.PajamuIrasas;
import lt.codeacademy.utils.UniqueNumberTracker;

import java.util.ArrayList;

public class Biudzetas {
  private ArrayList<Irasas> irasai = new ArrayList<>();

  public Biudzetas(){
    UniqueNumberTracker.resetCounter();
  }

  public float balansas() {
    float sum = 0;
    for (Irasas irasas : irasai) {
      if (irasas instanceof PajamuIrasas) {
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
