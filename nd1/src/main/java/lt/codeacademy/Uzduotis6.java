package lt.codeacademy;

import java.util.Scanner;

public class Uzduotis6 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ageRange();
    }

    public static void ageRange(){
        System.out.println("Iveskite skaiciu");
        int number = sc.nextInt();
        int user_age;
        if(number <= 10){
            System.out.println("user_age is between 0 and 10");
        }else if(number <= 20){
            System.out.println("user_age is between 11 and 20");
        }else if(number <= 30){
            System.out.println("user_age is between 21 and 30");
        }else{
            System.out.println("user_age is over 30");
        }
    }

    public static void colour(){
        System.out.println("Choose between four colours: black, white, red, or blue.");
        String colour = sc.next().toUpperCase();
        if(colour.equals("BLACK")){
            System.out.println("BLACK \"You must be a Goth!\"");
        }else if(colour.equals("WHITE")){
            System.out.println("WHITE \"You are a very pure person\"");
        }else if(colour.equals("RED")){
            System.out.println("RED \"You are fun and outgoing\"");
        }else if(colour.equals("BLUE")){
            System.out.println("BLUE \"You're not a Chelsea fan, are you?\"");
        }
    }
}
