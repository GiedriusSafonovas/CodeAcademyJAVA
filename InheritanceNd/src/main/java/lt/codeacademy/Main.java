package lt.codeacademy;

public class Main {
    public static void main(String[] args) {
        initTransportas();
    }

    public static void initTransportas(){
        Automobilis automobilis1 = new Automobilis(KuroTipas.Benzinas, 3,3);
        Automobilis automobilis2 = new Automobilis(4, "Juoda",KuroTipas.Benzinas, 3,3);
        Dviratis dviratis1 = new Dviratis(21);
        Dviratis dviratis2 = new Dviratis(2, "Geltona",21);
        Sunkvezimis sunkvezimis1 = new Sunkvezimis(KuroTipas.Benzinas, 3,3,4,5);
        Sunkvezimis sunkvezimis2 = new Sunkvezimis(6, "Juoda",KuroTipas.Benzinas, 3,3,4,5);

        automobilis1.spausdinti();
        System.out.println("----------------");
        automobilis2.spausdinti();
        System.out.println("----------------");
        dviratis1.spausdinti();
        System.out.println("----------------");
        dviratis2.spausdinti();
        System.out.println("----------------");
        sunkvezimis1.spausdinti();
        System.out.println("----------------");
        sunkvezimis2.spausdinti();
    }
}
