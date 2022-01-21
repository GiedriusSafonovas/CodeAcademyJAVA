package lt.codeacademy;

public class OddTest {
    public static void main(String[] args) {
        System.out.println(isOdd(3));
        System.out.println(isOdd(4));
    }

    public static boolean isOdd(int sk){
        if(sk%2 == 0){
            return true;
        }else {
            return false;
        }
    }
}
