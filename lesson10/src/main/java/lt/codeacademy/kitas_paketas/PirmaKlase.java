package lt.codeacademy.kitas_paketas;

import lt.codeacademy.Variklis;

public class PirmaKlase {
    Variklis variklis = new Variklis();

    String a = variklis.protectedVariklisLaukas1;
    String b = variklis.defaultVariklisLaukas1;
    String c = variklis.publicVariklisLaukas1;

    void metodas() {
        variklis.protectedVariklisMetodas1();
        variklis.defaultVariklisMetodas1();
        variklis.publicVariklisMetodas1();
    }

}
