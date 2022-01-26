package lt.codeacademy;

public class Masina {
        Ratas ratas;
    {
        ratas = new Ratas();
        protectedMasinaLaukas1 = ratas.protectedRatasLaukas1;
        defaultMasinaLaukas1 = ratas.defaultRatasLaukas1;
        publicMasinaLaukas1 = ratas.publicRatasLaukas1;
    }

    protected String protectedMasinaLaukas1;
    protected String protectedMasinaLaukas2;

    String defaultMasinaLaukas1;
    String defaultMasinaLaukas2;

    public String publicMasinaLaukas1;
    public String publicMasinaLaukas2;

    protected void protectedMasinaMetodas1(){
        ratas.protectedRatasMetodas1();
    }
    protected void protectedMasinaMetodas2(){}

    void defaultMasinaMetodas1(){
        ratas.defaultRatasMetodas1();
    }
    void defaultMasinaMetodas2(){}

    public void publicMasinaMetodas1(){
        ratas.publicRatasMetodas1();
    }
    public void publicMasinaMetodas2(){}

}
