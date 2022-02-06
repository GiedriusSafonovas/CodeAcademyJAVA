package lt.codeacademy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class PajamuIrasas {
  private float suma;
  private LocalDate data;
  private String kategorija;
  private boolean pozymisArIBanka;
  private String papildomaInfo;

  public PajamuIrasas(float suma, String data, String kategorija, boolean pozymisArIBanka, String papildomaInfo) {
    this.suma = suma;
    this.data = stringToDate(data);
    this.kategorija = kategorija;
    this.pozymisArIBanka = pozymisArIBanka;
    this.papildomaInfo = papildomaInfo;
  }

  public LocalDate stringToDate(String data){
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.parse(data,format);
  }
}
