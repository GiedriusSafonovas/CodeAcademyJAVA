package lt.codeacademy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IslaiduIrasas extends Irasas {
  private LocalDateTime dataSuLaiku;
  private String atsiskaitymoBudas;

  public IslaiduIrasas(
      float suma,
      LocalDateTime dataSuLaiku,
      String kategorija,
      String atsiskaitymoBudas,
      String papildomaInfo) {

    super("I", suma, kategorija, papildomaInfo);
    this.dataSuLaiku = dataSuLaiku;
    this.atsiskaitymoBudas = atsiskaitymoBudas;
  }

  public LocalDateTime getDataSuLaiku() {
    return dataSuLaiku;
  }

  public String getAtsiskaitymoBudas() {
    return atsiskaitymoBudas;
  }

  public void setDataSuLaiku(LocalDateTime dataSuLaiku) {
    this.dataSuLaiku = dataSuLaiku;
  }

  public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
    this.atsiskaitymoBudas = atsiskaitymoBudas;
  }

  @Override
  public String toString() {
    return String.format(
        super.toString() + "\nData su laiku: %s\n" + "Atsiskaitymo budas: %s\n",
        getDataSuLaiku(),
        getAtsiskaitymoBudas());
  }
}
