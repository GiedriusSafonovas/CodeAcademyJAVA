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

}
