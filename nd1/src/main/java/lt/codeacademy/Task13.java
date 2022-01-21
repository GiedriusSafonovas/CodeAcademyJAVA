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
        Scanner sc = new Scanner(System.in);

        System.out.println("Iveskite zodi:");
        String text = sc.next().toUpperCase();
        String[] phoneAlphabetMapping = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            for(int j = 0; j < phoneAlphabetMapping.length; j++){
                int indeksasTelefonoKeypadSekoje = phoneAlphabetMapping[j].indexOf(text.charAt(i));
                if(indeksasTelefonoKeypadSekoje!=-1){
                    for (int k = 0; k < indeksasTelefonoKeypadSekoje+1; k++) {
                        result += j+2;
                    }
                    result += ",";
                }
            }
        }
        result+="\b";
        System.out.println(result);
    }
}
