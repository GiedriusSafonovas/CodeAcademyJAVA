package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.LumiData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Form {
    private ArrayList<String> headers = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<LocalDate> date = new ArrayList<>();
    private ArrayList<String> iban = new ArrayList<>();
    private ArrayList<Float> amount = new ArrayList<>();


    public LocalDate parseDate(String date, String format) {
        DateTimeFormatter bankFormat = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, bankFormat);
    }

    public float parseAmount(String amount) {
        amount = amount.replace(',', '.');
        return Float.parseFloat(amount);
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }


    public ArrayList<String> getName() {
        return name;
    }


    public ArrayList<LocalDate> getDate() {
        return date;
    }


    public ArrayList<String> getIban() {
        return iban;
    }


    public ArrayList<Float> getAmount() {
        return amount;
    }

}
