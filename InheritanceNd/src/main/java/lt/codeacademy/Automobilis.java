package lt.codeacademy;

public class Automobilis extends TransportoPriemone{
    private KuroTipas kuroTipas;
    private int variklioTuris;
    private int cilindruSkaicius;

    Automobilis(KuroTipas kuroTipas, int variklioTuris, int cilindruSkaicius){
        this(0,"nezinoma", kuroTipas, variklioTuris, cilindruSkaicius);
    }
    Automobilis(int ratuSkaicius, String spalva, KuroTipas kuroTipas, int variklioTuris, int cilindruSkaicius){
        super(ratuSkaicius, spalva);
        this.kuroTipas = kuroTipas;
        this.variklioTuris = variklioTuris;
        this.cilindruSkaicius = cilindruSkaicius;

    }

    @Override
    public void spausdinti() {
        super.spausdinti();
        System.out.printf("kuro tipas: %s,\nvariklio turis: %d,\ncilindru skaicius: %d\n", kuroTipas, variklioTuris, cilindruSkaicius);
    }
}
