package lt.codeacademy;

public class Automobilis extends TransportoPriemone{
    private KuroTipas kuroTipas;
    private int variklioTuris;
    private int cilindruSkaicius;

    @Override
    public void spausdinti() {
        super.spausdinti();
        System.out.printf("kuro tipas: %s,\nvariklio turis: %d,\ncilindru skaicius: %d\n", kuroTipas, variklioTuris, cilindruSkaicius);
    }
}
