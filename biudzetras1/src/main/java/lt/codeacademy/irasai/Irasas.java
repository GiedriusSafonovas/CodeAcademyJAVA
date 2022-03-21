package lt.codeacademy.irasai;

import lombok.NoArgsConstructor;
import lt.codeacademy.utils.UniqueNumberTracker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(schema = "biudzetas")
public class Irasas {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private long unikalusNr;
  @Column
  private float suma;
  @Column
  private String kategorija;
  @Column
  private String papildomaInfo;

  public Irasas(long unikalusNr) {
    this.unikalusNr = unikalusNr;
  }

  public Irasas(float suma, String kategorija, String papildomaInfo) {
    this.unikalusNr = UniqueNumberTracker.getCounter();
    this.suma = suma;
    this.kategorija = kategorija;
    this.papildomaInfo = papildomaInfo;
  }

  public long getUnikalusNr() {
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

  public void setUnikalusNr(long unikalusNr) {
    this.unikalusNr = unikalusNr;
  }

  public void setSuma(float suma) {
    this.suma = suma;
  }

  public void setKategorija(String kategorija) {
    this.kategorija = kategorija;
  }

  public void setPapildomaInfo(String papildomaInfo) {
    this.papildomaInfo = papildomaInfo;
  }

  @Override
  public String toString() {
    return String.format(
        "Unikalus numeris: %s\n" + "Suma: %.2f\n" + "Kategorija: %s\n" + "Papildoma info: %s",
        getUnikalusNr(), getSuma(), getKategorija(), getPapildomaInfo());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Irasas) {
      return (unikalusNr == (((Irasas) obj).getUnikalusNr()));
    }
    return false;
  }
}
