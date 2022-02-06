package lt.codeacademy;

public class Biudzetas {
  PajamuIrasas[] pajamos = new PajamuIrasas[100];
  IslaiduIrasas[] islaidos = new IslaiduIrasas[100];

  public void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas){
    for(int i = 0; i < pajamos.length; i++){
      if(pajamos[i] == null){
        pajamos[i] = pajamuIrasas;
        break;
      }
    }
  }

  public void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas){
    for(int i = 0; i < islaidos.length; i++){
      if(islaidos[i] == null){
        islaidos[i] = islaiduIrasas;
        break;
      }
    }
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
