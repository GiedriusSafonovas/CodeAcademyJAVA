package lt.codeacademy;

public class Irasas {
  private static int counter;
  private final String unikalusNr;
  private float suma;
  private String kategorija;
  private String papildomaInfo;

  public Irasas(String unikalusNr){
    this.unikalusNr = unikalusNr;
  }

  public Irasas(String irasoTipas, float suma, String kategorija, String papildomaInfo) {
    counter++;
    this.unikalusNr = irasoTipas + counter;
    this.suma = suma;
    this.kategorija = kategorija;
    this.papildomaInfo = papildomaInfo;
  }

  public static int getCounter() {
    return counter;
  }

  public String getUnikalusNr() {
    return unikalusNr;
  }

  public float getSuma() {
    return suma;
  }

  public String getKategorija() {
    return kategorija;
  }

  public String getPapildomaInfo() {
    return papildomaInfo;
  }

  @Override
  public String toString() {
    return String.format(
        "Unikalus numeris: %s\n" + "Suma: %.2f\n" + "Kategorija: %s\n" + "Papildoma info: %s",
        getUnikalusNr(), getSuma(), getKategorija(), getPapildomaInfo());
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Irasas){
      return unikalusNr.equals(((Irasas) obj).getUnikalusNr());
    }
    return false;
  }
}
