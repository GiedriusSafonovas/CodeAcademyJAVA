package lt.codeacademy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class PajamuIrasas extends Irasas {
  private LocalDate data;
  private boolean pozymisArIBanka;

  public PajamuIrasas(
      float suma, String data, String kategorija, boolean pozymisArIBanka, String papildomaInfo) {
    super("P", suma, kategorija, papildomaInfo);
    this.data = stringToDate(data);
    this.pozymisArIBanka = pozymisArIBanka;
  }

  public LocalDate stringToDate(String data) {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.parse(data, format);
  }

  public LocalDate getData() {
    return data;
  }

  public boolean isPozymisArIBanka() {
    return pozymisArIBanka;
  }

  @Override
  public String toString() {
    return String.format(
        "==PAJAMU IRASAS==\n" + super.toString() + "\nData: %s\n" + "Ar pinigai gauti i banka: %b\n",
        getData(),
        isPozymisArIBanka());
  }
}
