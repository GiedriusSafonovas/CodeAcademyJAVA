package lt.codeacademy;

public class StringMetodai {
    public static void main(String[] args) {
        String text = "   Laba Diena    ";
        System.out.println(text);
        text = text.trim();
        System.out.println(text);
        System.out.println(text.replace('a','b'));
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
    }
}
