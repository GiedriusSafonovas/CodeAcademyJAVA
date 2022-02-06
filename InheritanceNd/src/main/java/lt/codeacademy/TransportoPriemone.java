package lt.codeacademy;

public class TransportoPriemone {
    private int ratuSkaicius;
    private String spalva;

    TransportoPriemone(){
        this(0,"nezinoma");
    }

    TransportoPriemone(int ratuSkaicius, String spalva){
        this.ratuSkaicius = ratuSkaicius;
        this.spalva = spalva;
    }

    public void spausdinti(){
        System.out.printf("Ratu skaicius: %d,\nspalva: %s\n", ratuSkaicius, spalva);
    }

    public int getRatuSkaicius() {
        return ratuSkaicius;
    }

    public String getSpalva() {
        return spalva;
    }
}
