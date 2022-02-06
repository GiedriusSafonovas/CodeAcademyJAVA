package lt.codeacademy;

public class Uzduotis5 {
    public static void main(String[] args) {
        rodykDiena(5);
    }

    public static void rodykDiena(int savaitesDiena){
        switch (savaitesDiena){
            case 1:
                System.out.println("Pirmadienis");
                break;
            case 2:
                System.out.println("Antradienis");
                break;
            case 3:
                System.out.println("Treciadienis");
                break;
            case 4:
                System.out.println("Ketvirtadienis");
                break;
            case 5:
                System.out.println("Penktadienis");
                break;
            case 6:
                System.out.println("Sestadienis");
                break;
            case 7:
                System.out.println("Sekmadienis");
                break;
        }
    }
}
