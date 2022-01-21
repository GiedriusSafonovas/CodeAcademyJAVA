package lt.codeacademy;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        String[] menesiai = {"Sausis", "Vasaris", "Kovas", "Balandis",
                "Geguze", "Birzelis", "Liepa", "Rugpjutis",
                "Rugsejis", "Spalis", "Lapkritis", "Gruodis"};

        System.out.println("Masyvo dydis: " + menesiai.length);
        System.out.println("Masyvo pirma reiksme: " + menesiai[0]);
        System.out.println("Masyvo paskutine reiksme " + menesiai[menesiai.length-1]);

        System.out.println("************************");

        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite menesio nr. [1-12]");
        int sk = sc.nextInt();
        System.out.println(menesiai[sk-1]);
    }



}
