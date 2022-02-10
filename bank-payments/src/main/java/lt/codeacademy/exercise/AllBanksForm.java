package lt.codeacademy.exercise;

import java.util.Arrays;
import java.util.List;

public class AllBanksForm extends Form {
  private List<Form> banks;

  public AllBanksForm() {
    banks = Arrays.asList(new LumiForm(), new SepForm(), new ShvedForm());
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
