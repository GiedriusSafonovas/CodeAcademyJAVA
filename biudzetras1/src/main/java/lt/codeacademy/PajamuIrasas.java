package lt.codeacademy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class PajamuIrasas extends Irasas {
  private LocalDate data;
  private boolean pozymisArIBanka;

  public PajamuIrasas(
      float suma, LocalDate data, String kategorija, boolean pozymisArIBanka, String papildomaInfo) {
    super("P", suma, kategorija, papildomaInfo);
    this.data = data;
    this.pozymisArIBanka = pozymisArIBanka;
  }

  public LocalDate getData() {
    return data;
  }

  public boolean isPozymisArIBanka() {
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
        isPozymisArIBanka());
  }
}
