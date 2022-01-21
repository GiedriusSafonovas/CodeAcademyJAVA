package lt.codeacademy;

public class Task12 {
    public static void main(String[] args) {
        System.out.println(arrayToString(new int[] {1,2,3,4,5} ));
    }

    public static String arrayToString(int[] arr){
        String result = "";
        result += "{";
        for(int sk : arr){
            result += sk + ", ";
        }
        result += "\b\b}";

        return result;
    }
}
