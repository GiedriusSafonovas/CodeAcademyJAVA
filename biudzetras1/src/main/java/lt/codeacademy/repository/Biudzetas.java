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



  public ArrayList<Irasas> getIrasai() {
    return irasai;
  }
}
