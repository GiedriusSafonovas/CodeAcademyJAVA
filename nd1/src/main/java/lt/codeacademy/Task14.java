package lt.codeacademy;

public class Task14 {
    public static void main(String[] args) {
        String s1 = "vienas";
        String s2 = "du";
        String temp;
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
        temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
    }
}
