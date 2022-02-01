package lt.codeacademy.exercise;

import lt.codeacademy.exercise.menu.LumiForm;
import lt.codeacademy.exercise.menu.console.ConsoleMenu;
import lt.codeacademy.exercise.menu.console.MainMenu;

public class BankPaymentsApplication {

    private final ConsoleMenu mainMenu;

    public BankPaymentsApplication() {
        this.mainMenu = new MainMenu();
    }

    public void run() {
        String selectedOption = mainMenu.printAndRead();
        switch (selectedOption){
            case "1":
                System.out.println(new LumiForm());
        }
    }
}
