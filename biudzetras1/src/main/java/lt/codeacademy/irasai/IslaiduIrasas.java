package lt.codeacademy.irasai;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(schema = "biudzetas")
public class IslaiduIrasas extends Irasas {
  @Column
  private LocalDateTime dataSuLaiku;
  @Column
  private String atsiskaitymoBudas;

  public IslaiduIrasas(
      float suma,
      LocalDateTime dataSuLaiku,
      String kategorija,
      String atsiskaitymoBudas,
      String papildomaInfo) {

    super(suma, kategorija, papildomaInfo);
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
