package lt.codeacademy;

import java.util.Scanner;

/* Nelabai sugalvoju, kur cia nori, kad ta switch-case panaudociau, nebent tikisi, kad kiekvienai raidei rasyciau po switch :)

    switch (raide){
            case "A":
                digit = "2";
                break;
            case "B":
                digit = "22";
                break;
            case "C":
                digit = "222";
                break;
                ...
        }
 */

public class Task13 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Iveskite skaiciu seka:");

        String text = "555,2,22,2,7777";
        String[] digits = text.split(",");
        String[] phoneAlphabetMapping = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String result = "";

        for(String digit : digits){
            int paspaustasSkaicius = Integer.parseInt(digit.substring(0,1));
            int paspaudimuSkaicius = digit.length();

            for (int i = 0; i < phoneAlphabetMapping.length; i++) {
                if(i+2 == paspaustasSkaicius){
                    result += phoneAlphabetMapping[i].charAt(paspaudimuSkaicius-1);
                }
            }
        }

        System.out.println(result);
    }
}
