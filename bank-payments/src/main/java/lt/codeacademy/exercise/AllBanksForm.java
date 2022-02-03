package lt.codeacademy.exercise;

public class AllBanksForm extends Form {
  LumiForm lumi;
  SepForm sep;
  ShvedForm shved;

  public AllBanksForm() {
    this.lumi = new LumiForm();
    this.sep = new SepForm();
    this.shved = new ShvedForm();

    mergeForms();
  }

  public void mergeForms(){
    this.getName().addAll(lumi.getName());
    this.getName().addAll(sep.getName());
    this.getName().addAll(shved.getName());

    this.getDate().addAll(lumi.getDate());
    this.getDate().addAll(sep.getDate());
    this.getDate().addAll(shved.getDate());

    this.getIban().addAll(lumi.getIban());
    this.getIban().addAll(sep.getIban());
    this.getIban().addAll(shved.getIban());

    this.getAmount().addAll(lumi.getAmount());
    this.getAmount().addAll(sep.getAmount());
    this.getAmount().addAll(shved.getAmount());
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append(String.format("%25s|%25s|%25s|%25s|\n", "Name", "Date", "Iban", "Amount"));
    for (int i = 0; i < this.getIban().size(); i++) {
      result.append(
              String.format(
                      "%25s|%25s|%25s|%25f|",
                      this.getName().get(i),this.getDate().get(i), this.getIban().get(i), this.getAmount().get(i)));
      result.append("\n");
    }
    return result.toString();
  }
}
