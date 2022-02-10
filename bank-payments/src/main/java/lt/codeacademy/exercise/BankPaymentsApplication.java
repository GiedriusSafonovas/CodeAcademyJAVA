package lt.codeacademy.exercise;

import lt.codeacademy.exercise.menu.console.ConsoleMenu;
import lt.codeacademy.exercise.menu.console.MainMenu;

public class BankPaymentsApplication {

  private final ConsoleMenu mainMenu;

  public BankPaymentsApplication() {
    this.mainMenu = new MainMenu();
  }

  public void run() {
    while (true) {
      String selectedOption = mainMenu.printAndRead();
      if (selectedOption.equals("0")) {
        break;
      }
      switch (selectedOption) {
        case "1":
          System.out.println("**************LUMI DATA**************");
          System.out.println(new LumiForm());
          break;
        case "2":
          System.out.println("**************SEP DATA**************");
          System.out.println(new SepForm());
          break;
        case "3":
          System.out.println("**************SHVED DATA**************");
          System.out.println(new ShvedForm());
          break;
        case "4":
          System.out.println("**************ALL DATA**************");
          System.out.println(new AllBanksForm());
          break;
      }
    }
  }
}
