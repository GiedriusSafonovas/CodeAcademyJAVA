package lt.codeacademy;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite sakini");
        String text = sc.nextLine();

        System.out.println("---------i---------");
        System.out.println(text.toUpperCase());

        System.out.println("---------ii--------");
        System.out.println(text.length());

        System.out.println("---------iii-------");
        int paskutinisTarpas = text.lastIndexOf(" ");
        System.out.println(text.substring(paskutinisTarpas+1));

        System.out.println("---------iv--------");
        System.out.println(text.replace('a','W'));

        System.out.println("---------v---------");
        System.out.println(text.replaceAll("e", "RAIDE"));

        System.out.println("---------vi--------");
        int pirmasTarpas = text.indexOf(" ");
        System.out.println( text.substring(paskutinisTarpas+1) +
                            text.substring(pirmasTarpas,paskutinisTarpas+1) +
                            text.substring(0,pirmasTarpas));
    }
}
