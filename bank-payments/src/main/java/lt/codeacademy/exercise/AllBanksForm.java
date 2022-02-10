package lt.codeacademy.exercise;

import java.util.ArrayList;
import java.util.Collections;

public class AllBanksForm extends Form {
  private ArrayList<Form> banks;

  public AllBanksForm() {
    banks = new ArrayList<>();
    Collections.addAll(banks, new LumiForm(), new SepForm(), new ShvedForm());
    mergeForms();
  }

  public void mergeForms() {
    for (Form bank : banks) {
      this.getName().addAll(bank.getName());
      this.getDate().addAll(bank.getDate());
      this.getIban().addAll(bank.getIban());
      this.getAmount().addAll(bank.getAmount());
    }
  }
}
