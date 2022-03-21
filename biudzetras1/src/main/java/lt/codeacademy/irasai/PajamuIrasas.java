package lt.codeacademy.irasai;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(schema = "biudzetas")
public class PajamuIrasas extends Irasas {
  @Column
  private LocalDate data;
  @Column
  private boolean pozymisArIBanka;

  public PajamuIrasas(
      float suma,
      LocalDate data,
      String kategorija,
      boolean pozymisArIBanka,
      String papildomaInfo) {
    super(suma, kategorija, papildomaInfo);
    this.data = data;
    this.pozymisArIBanka = pozymisArIBanka;
  }

  public LocalDate getData() {
    return data;
  }

  public boolean getPozymisArIBanka() {
    return pozymisArIBanka;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public void setPozymisArIBanka(boolean pozymisArIBanka) {
    this.pozymisArIBanka = pozymisArIBanka;
  }

  @Override
  public String toString() {
    return String.format(
        super.toString() + "\nData: %s\n" + "Ar pinigai gauti i banka: %b\n",
        getData(),
        getPozymisArIBanka());
  }
}
