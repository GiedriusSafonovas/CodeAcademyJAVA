package lt.codeacademy;

public class Task13 {
    public static void main(String[] args) {
        String text = "WXYZ";
        String[] alphabetMapping = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            for(int j = 0; j < alphabetMapping.length; j++){
                int indeksasSekoje = alphabetMapping[j].indexOf(text.charAt(i));
                if(indeksasSekoje!=-1){
                    for (int k = 0; k < indeksasSekoje+1; k++) {
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
