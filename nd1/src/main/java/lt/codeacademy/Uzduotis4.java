package lt.codeacademy;

public class Uzduotis4 {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
        boolean b4 = false;
        boolean b5 = false;
        boolean b6 = false;

        if(b1) System.out.println("b1");
        if(b2) System.out.println("b2");
        if(b3) System.out.println("b3");
        if(b4) System.out.println("b4");
        if(b5) System.out.println("b5");
        if(b6) System.out.println("b6");

        System.out.println("*************************");

        int sk1 = 10;
        int sk2 = 12;

        float fl1 = 3.5f;
        float fl2 = 3.4f;

        System.out.println("int skaiciu tikrinimas");
        kurisDidesnis(sk1, sk2);
        System.out.println("float skaiciu tikrinimas");
        kurisDidesnis(fl1, fl2);

        System.out.println("*************************");
        System.out.println("int skaiciu tikrinimas");
        kurisDidesnisArLygus(sk1,sk2);
        System.out.println("float skaiciu tikrinimas");
        kurisDidesnisArLygus(fl1,fl2);
    }

    public static void kurisDidesnis(float sk1, float sk2){
        if(sk1 == sk2){
            System.out.println("Lygios");
        }else if(sk1 > sk2){
            System.out.println("Pirma didesne");
        }else {
            System.out.println("Pirma mazesne");
        }
    }

    public static void kurisDidesnisArLygus(float sk1, float sk2){
        if(sk1 <= sk2){
            System.out.println("Pirma mazesne arba lygios");
        }else {
            System.out.println("Pirma didesne arba lygios");
        }
    }

}
