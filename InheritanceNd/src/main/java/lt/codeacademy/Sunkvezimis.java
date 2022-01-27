package lt.codeacademy;

public class Sunkvezimis extends Automobilis{
    private int krovinioTalpa;
    private int krovinioSvoris;

    Sunkvezimis(KuroTipas kuroTipas, int variklioTuris, int cilindruSkaicius, int krovinioTalpa, int krovinioSvoris){
        this(0, "nezinoma", kuroTipas, variklioTuris, cilindruSkaicius, krovinioTalpa, krovinioSvoris);
    }
    Sunkvezimis(int ratuSkaicius, String spalva, KuroTipas kuroTipas, int variklioTuris, int cilindruSkaicius, int krovinioTalpa, int krovinioSvoris){
        super(ratuSkaicius, spalva, kuroTipas, variklioTuris, cilindruSkaicius);
        this.krovinioTalpa = krovinioTalpa;
        this.krovinioSvoris = krovinioSvoris;
    }

    @Override
    public void spausdinti() {
        super.spausdinti();
        System.out.printf("krovinio talpa: %d,\nkrovinio svoris: %d\n", krovinioTalpa, krovinioSvoris);
    }
}
