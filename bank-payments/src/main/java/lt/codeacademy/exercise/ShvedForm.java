package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.ShvedData;

import java.util.Collections;

public class ShvedForm extends Form {
  public ShvedForm() {
    String[][] duomenys = ShvedData.MOCK_DATA;

    for (int i = 0; i < duomenys.length; i++) {
      if (i == 0) {
        Collections.addAll(this.getHeaders(), duomenys[0]);
      } else {
        this.getDate().add(this.parseDate(duomenys[i][0], "dd.MM.yyyy"));
        this.getIban().add(duomenys[i][1]);
        this.getAmount().add(this.parseAmount(duomenys[i][2]));
        this.getName().add(null);
      }
    }
  }

}
