package lt.codeacademy;

import java.util.Scanner;

public class StringToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite skaiciu");
        String stringSkaicius = sc.next();
        int intSkaicius = Integer.parseInt(stringSkaicius);

        System.out.println(intSkaicius);
    }
}
