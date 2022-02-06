package lt.codeacademy;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        String[] menesiai = {"Sausis", "Vasaris", "Kovas", "Balandis",
                "Geguze", "Birzelis", "Liepa", "Rugpjutis",
                "Rugsejis", "Spalis", "Lapkritis", "Gruodis"};

        System.out.println("Masyvo dydis: " + menesiai.length);
        String pirmasMenuo = menesiai[0];
        System.out.println("Masyvo pirma reiksme: " + pirmasMenuo);
        String paskutinisMenuo = menesiai[menesiai.length-1];
        System.out.println("Masyvo paskutine reiksme " + paskutinisMenuo);

        System.out.println("************************");

        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite menesio nr. [1-12]");
        int sk = sc.nextInt();
        String pasirinktasMenuo = menesiai[sk-1];
        String menuoPo;
        String menuoPries;
        if(sk == 1){
            menuoPries = paskutinisMenuo;
        }else{
            menuoPries = menesiai[sk-2];
        }
        if(sk == 12){
            menuoPo = pirmasMenuo;
        }else{
            menuoPo = menesiai[sk];
        }
        System.out.println("Pasirinktas menuo: " + pasirinktasMenuo);
        System.out.println("Menuo pries pasirinkta: " + menuoPries);
        System.out.println("Menuo po pasirinkto: " + menuoPo);


    }



}
