package lt.codeacademy;

public class Main {
    public static void main(String[] args) {
        initTransportas();
    }

    public static void initTransportas(){
        Automobilis a1 = new Automobilis(KuroTipas.Benzinas, 3,3);
        Automobilis a2 = new Automobilis(4, "Juoda",KuroTipas.Benzinas, 3,3);
        Dviratis d1 = new Dviratis(21);
        Dviratis d2 = new Dviratis(2, "Geltona",21);
        Sunkvezimis s1 = new Sunkvezimis(KuroTipas.Benzinas, 3,3,4,5);
        Sunkvezimis s2 = new Sunkvezimis(6, "Juoda",KuroTipas.Benzinas, 3,3,4,5);

        a1.spausdinti();
        System.out.println("----------------");
        a2.spausdinti();
        System.out.println("----------------");
        d1.spausdinti();
        System.out.println("----------------");
        d2.spausdinti();
        System.out.println("----------------");
        s1.spausdinti();
        System.out.println("----------------");
        s2.spausdinti();
    }
}
