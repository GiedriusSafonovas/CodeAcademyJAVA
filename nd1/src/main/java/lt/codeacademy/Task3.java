package lt.codeacademy;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Iveskite sveika sakiciu");
            suma += sc.nextInt();
        }
        System.out.println(suma);
    }
}
