package lt.codeacademy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IslaiduIrasas {
  private float suma;
  private LocalDateTime dataSuLaiku;
  private String kategorija;
  private String atsiskaitymoBudas;
  private String papildomaInfo;

  public IslaiduIrasas(float suma, String dataSuLaiku, String kategorija, String atsiskaitymoBudas, String papildomaInfo) {
    this.suma = suma;
    this.dataSuLaiku = stringToDate(dataSuLaiku);
    this.kategorija = kategorija;
    this.atsiskaitymoBudas = atsiskaitymoBudas;
    this.papildomaInfo = papildomaInfo;
  }

  public LocalDateTime stringToDate(String data){
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return LocalDateTime.parse(data,format);
  }

  public float getSuma() {
    return suma;
  }

  public LocalDateTime getDataSuLaiku() {
    return dataSuLaiku;
  }

  public String getKategorija() {
    return kategorija;
  }

  public String getAtsiskaitymoBudas() {
    return atsiskaitymoBudas;
  }

  public String getPapildomaInfo() {
    return papildomaInfo;
  }
}
