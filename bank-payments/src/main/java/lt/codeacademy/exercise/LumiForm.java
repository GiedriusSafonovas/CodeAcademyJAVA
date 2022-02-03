package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.LumiData;
import lt.codeacademy.exercise.bank.data.ShvedData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class LumiForm extends Form {

  public LumiForm() {
    String[][] duomenys = LumiData.MOCK_DATA;

    for (int i = 0; i < duomenys.length; i++) {
      if (i == 0) {
        Collections.addAll(this.getHeaders(), duomenys[0]);
      } else {
        this.getName().add(duomenys[i][0]);
        this.getDate().add(this.parseDate(duomenys[i][1], "yyyy-MM-dd"));
        this.getIban().add(duomenys[i][2]);
        this.getAmount().add(this.parseAmount(duomenys[i][3]));
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < this.getHeaders().size(); i++) {
      result.append(String.format("%-25s|", this.getHeaders().get(i)));
    }
    result.append("\n");
    for (int i = 0; i < this.getIban().size(); i++) {
      result.append(
          String.format(
              "%-25s|%-25s|%-25s|%-25f|",
              this.getName().get(i),
              this.getDate().get(i),
              this.getIban().get(i),
              this.getAmount().get(i)));
      result.append("\n");
    }

    return result.toString();
  }
}
