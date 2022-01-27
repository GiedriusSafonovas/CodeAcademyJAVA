package lt.codeacademy;

public class Dviratis extends TransportoPriemone {
    private int pavaruSkaicius;

    Dviratis(int pavaruSkaicius) {
        this(0,"nezinoma", pavaruSkaicius);
    }

    Dviratis(int ratuSkaicius, String spalva, int pavaruSkaicius) {
        super(ratuSkaicius, spalva);
        this.pavaruSkaicius = pavaruSkaicius;
    }

    @Override
    public void spausdinti() {
        super.spausdinti();
        System.out.println("pavaru skaicius: " + pavaruSkaicius);
    }
}
