package lt.codeacademy;

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


}
