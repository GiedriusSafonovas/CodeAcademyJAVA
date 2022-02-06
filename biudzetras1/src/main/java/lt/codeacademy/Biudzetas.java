package lt.codeacademy;

import java.time.LocalDate;

public class Biudzetas {
  PajamuIrasas[] pajamos = new PajamuIrasas[100];
  IslaiduIrasas[] islaidos = new IslaiduIrasas[100];

  public void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas){
    for(PajamuIrasas irasas : pajamos){
      if(irasas == null){
        irasas = pajamuIrasas;
        break;
      }
    }
  }

  public void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas){
    for(IslaiduIrasas irasas : islaidos){
      if(irasas == null){
        irasas = islaiduIrasas;
        break;
      }
    }
  }

  public PajamuIrasas gautiPajamuIrasa(String kategorija, String data){
    for(PajamuIrasas irasas : pajamos){
      boolean kategorijosSutampa = irasas.getKategorija().equals(kategorija);
      boolean datosSutampa = irasas.getData() == irasas.stringToDate(data);
      if(kategorijosSutampa && datosSutampa){
        return irasas;
      }
    }
    return null;
  }

  public IslaiduIrasas gautiIslaiduIrasa(String kategorija, String data){
    for(IslaiduIrasas irasas : islaidos){
      boolean kategorijosSutampa = irasas.getKategorija().equals(kategorija);
      boolean datosSutampa = irasas.getDataSuLaiku() == irasas.stringToDate(data);
      if(kategorijosSutampa && datosSutampa){
        return irasas;
      }
    }
    return null;
  }
}
