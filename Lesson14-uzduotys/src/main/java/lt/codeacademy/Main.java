package lt.codeacademy;

public class Main {
    public static void main(String[] args) {
        Uzduotis2.printText();
        System.out.println(putStringInArray(new String[1],"hello"));
        System.out.println(putStringInArray(new String[]{"a",null},"hello"));
        System.out.println(putStringInArray(new String[0],"hello"));
        System.out.println(putStringInArray(null,"hello"));
    }

    public static boolean putStringInArray(String[] masyvas,String tekstas){
        if(masyvas == null){
            return false;
        }
        for(String elementas : masyvas){
            if(elementas == null){
                elementas = tekstas;
                return true;
            }
        }
        return false;
    }
}
