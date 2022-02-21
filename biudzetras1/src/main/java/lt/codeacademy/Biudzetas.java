package lt.codeacademy;

import java.util.ArrayList;

public class Biudzetas {
  ArrayList<PajamuIrasas> pajamos = new ArrayList<>();
  ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();

  public void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas){
    pajamos.add(pajamuIrasas);
  }

  public void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas){
    islaidos.add(islaiduIrasas);
  }

  public PajamuIrasas gautiPajamuIrasa(String kategorija, String data){
    for(PajamuIrasas irasas : pajamos){
      boolean kategorijosSutampa = irasas.getKategorija().equals(kategorija);
      boolean datosSutampa = irasas.getData().equals(irasas.stringToDate(data));
      if(kategorijosSutampa && datosSutampa){
        return irasas;
      }
    }
    return null;
  }

  public IslaiduIrasas gautiIslaiduIrasa(String kategorija, String data){
    for(IslaiduIrasas irasas : islaidos){
      boolean kategorijosSutampa = irasas.getKategorija().equals(kategorija);
      boolean datosSutampa = irasas.getDataSuLaiku().equals(irasas.stringToDate(data));
      if(kategorijosSutampa && datosSutampa){
        return irasas;
      }
    }
    return null;
  }
}
