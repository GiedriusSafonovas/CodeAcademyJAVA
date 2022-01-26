package lt.codeacademy.kitas_paketas;

import lt.codeacademy.Variklis;

public class AntraKlase extends Variklis {
    AntraKlase variklis = new AntraKlase();

    String a = variklis.protectedVariklisLaukas1;
    String b = variklis.defaultVariklisLaukas1;
    String c = variklis.publicVariklisLaukas1;

    void metodas(){
        variklis.protectedVariklisMetodas1();
        variklis.defaultVariklisMetodas1();
        variklis.publicVariklisMetodas1();
    }
}
