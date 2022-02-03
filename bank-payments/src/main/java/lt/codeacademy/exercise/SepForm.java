package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.SepData;

import java.util.Collections;

public class SepForm extends Form {

  public SepForm() {
    String[][] duomenys = SepData.MOCK_DATA;

    for (int i = 0; i < duomenys.length; i++) {
      if (i == 0) {
        Collections.addAll(this.getHeaders(), duomenys[0]);
      } else {
        this.getDate().add(this.parseDate(duomenys[i][0], "dd.MM.yyyy"));
        this.getName().add(duomenys[i][1]);
        this.getIban().add(duomenys[i][2]);
        this.getAmount().add(this.parseAmount(duomenys[i][3]));
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < this.getHeaders().size(); i++) {
      result.append(String.format("%25s|", this.getHeaders().get(i)));
    }
    result.append("\n");
    for (int i = 0; i < this.getIban().size(); i++) {
      result.append(
          String.format(
              "%25s|%25s|%25s|%25f|",
              this.getDate().get(i),
              this.getName().get(i),
              this.getIban().get(i),
              this.getAmount().get(i)));
      result.append("\n");
    }

    return result.toString();
  }
}
