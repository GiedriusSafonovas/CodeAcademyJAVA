package lt.codeacademy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IslaiduIrasas extends Irasas {
  private LocalDateTime dataSuLaiku;
  private String atsiskaitymoBudas;

  public IslaiduIrasas(
      float suma,
      String dataSuLaiku,
      String kategorija,
      String atsiskaitymoBudas,
      String papildomaInfo) {

    super("I", suma, kategorija, papildomaInfo);
    this.dataSuLaiku = stringToDate(dataSuLaiku);
    this.atsiskaitymoBudas = atsiskaitymoBudas;
  }

  public LocalDateTime stringToDate(String data) {
    if(data.equals("")){
      return LocalDateTime.now();
    }
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return LocalDateTime.parse(data, format);
  }

  public LocalDateTime getDataSuLaiku() {
    return dataSuLaiku;
  }

  public String getAtsiskaitymoBudas() {
    return atsiskaitymoBudas;
  }

  public void setDataSuLaiku(String dataSuLaiku) {
    this.dataSuLaiku = stringToDate(dataSuLaiku);
  }

  public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
    this.atsiskaitymoBudas = atsiskaitymoBudas;
  }

  @Override
  public String toString() {
    return String.format(
        super.toString()
            + "\nData su laiku: %s\n"
            + "Atsiskaitymo budas: %s\n",
        getDataSuLaiku(),
        getAtsiskaitymoBudas());
  }
}
