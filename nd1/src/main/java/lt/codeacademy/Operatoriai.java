package lt.codeacademy;

public class Operatoriai {
    public static void main(String[] args) {
        System.out.println(grazinkIrPadidink(1));
        System.out.println(padidinkIrGrazink(1));
    }

    public static int grazinkIrPadidink(int i){
        return i++;
    }

    public static int padidinkIrGrazink(int i){
        return ++i;
    }
}
