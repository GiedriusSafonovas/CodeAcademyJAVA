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
}
