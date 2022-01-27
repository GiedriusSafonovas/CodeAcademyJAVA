package lt.codeacademy;

public class Sunkvezimis extends Automobilis{
    private int krovinioTalpa;
    private int krovinioSvoris;

    @Override
    public void spausdinti() {
        super.spausdinti();
        System.out.printf("krovinio talpa: %d,\nkrovinio svoris: %d\n", krovinioTalpa, krovinioSvoris);
    }
}
