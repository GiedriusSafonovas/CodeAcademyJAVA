package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.LumiData;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    DecimalFormatSymbols decimalSeparator = new DecimalFormatSymbols();
    decimalSeparator.setDecimalSeparator('.');
    DecimalFormat df = new DecimalFormat(".00", decimalSeparator);

    result.append(
        String.format("%s|%10s|%7s|%25s|%25s|\n", "Eilės nr.", "Date", "Amount", "Name", "Iban"));
    for (int i = 0; i < this.getIban().size(); i++) {
      int eilNr = i + 1;
      result.append(
          String.format(
              "%9d|%s|%7s|%25s|%25s|\n",
              eilNr,
              this.getDate().get(i),
              df.format(this.getAmount().get(i)),
              this.getName().get(i),
              this.getIban().get(i)));
    }
    return result.toString();
  }
}
