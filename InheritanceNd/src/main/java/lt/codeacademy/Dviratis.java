package lt.codeacademy;

public class Dviratis extends TransportoPriemone{
    private int pavaruSkaicius;

    @Override
    public void spausdinti() {
        super.spausdinti();
        System.out.println("pavaru skaicius: " + pavaruSkaicius);
    }
}
