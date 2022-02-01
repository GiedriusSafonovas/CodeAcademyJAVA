package lt.codeacademy.exercise.menu;

import lt.codeacademy.exercise.bank.data.LumiData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;


public class LumiForm {
    private ArrayList<String> headers = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<LocalDate> date = new ArrayList<>();
    private ArrayList<String> iban = new ArrayList<>();
    private ArrayList<Float> amount = new ArrayList<>();


    public LumiForm() {

        for (int i = 0; i < LumiData.MOCK_DATA.length; i++) {
            if (i == 0) {
                Collections.addAll(this.headers, LumiData.MOCK_DATA[0]);
            } else {
                this.name.add(LumiData.MOCK_DATA[i][0]);
                this.date.add(parseDate(LumiData.MOCK_DATA[i][1]));
                this.iban.add(LumiData.MOCK_DATA[i][2]);
                this.amount.add(parseAmount(LumiData.MOCK_DATA[i][3]));
            }

        }
    }

    public LocalDate parseDate(String date) {
        DateTimeFormatter bankFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, bankFormat);
    }

    public float parseAmount(String amount) {
        amount = amount.replace(',', '.');
        return Float.parseFloat(amount);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < headers.size(); i++) {
            result.append(String.format("%-25s|",headers.get(i)));
        }
            result.append("\n");
        for (int i = 0; i < iban.size(); i++) {
            result.append(String.format("%-25s|%-25s|%-25s|%-25f|",name.get(i),date.get(i),iban.get(i),amount.get(i)));
            result.append("\n");
        }

        return result.toString();
    }
}
