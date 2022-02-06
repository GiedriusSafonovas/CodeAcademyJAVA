package lt.codeacademy;

public class Masina {

    Ratas ratas;
    protected String protectedMasinaLaukas1;
    String defaultMasinaLaukas1;
    public String publicMasinaLaukas1;

    {
        ratas = new Ratas();
        protectedMasinaLaukas1 = ratas.protectedRatasLaukas1;
        defaultMasinaLaukas1 = ratas.defaultRatasLaukas1;
        publicMasinaLaukas1 = ratas.publicRatasLaukas1;
    }

    protected void protectedMasinaMetodas1() {
        ratas.protectedRatasMetodas1();
    }

    void defaultMasinaMetodas1() {
        ratas.defaultRatasMetodas1();
    }

    public void publicMasinaMetodas1() {
        ratas.publicRatasMetodas1();
    }
}
