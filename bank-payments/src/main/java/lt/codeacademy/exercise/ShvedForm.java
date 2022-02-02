package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.ShvedData;

import java.util.Collections;

public class ShvedForm extends Form{
    public ShvedForm() {
        String[][] duomenys = ShvedData.MOCK_DATA;

        for (int i = 0; i < duomenys.length; i++) {
            if (i == 0) {
                Collections.addAll(this.getHeaders(), duomenys[0]);
            } else {
                this.getDate().add(this.parseDate(duomenys[i][0],"dd.MM.yyyy"));
                this.getIban().add(duomenys[i][1]);
                this.getAmount().add(this.parseAmount(duomenys[i][2]));
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.getHeaders().size(); i++) {
            result.append(String.format("%-25s|",this.getHeaders().get(i)));
        }
        result.append("\n");
        for (int i = 0; i < this.getIban().size(); i++) {
            result.append(String.format("%-25s|%-25s|%-25f|"
                    ,this.getDate().get(i),this.getIban().get(i),this.getAmount().get(i)));
            result.append("\n");
        }

        return result.toString();
    }
}
