package lt.codeacademy.service;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.IslaiduIrasas;
import lt.codeacademy.irasai.PajamuIrasas;

import java.util.ArrayList;
import java.util.List;

public class IrasaiHandler {

    Biudzetas biudzetas;

    public IrasaiHandler(Biudzetas biudzetas){
        this.biudzetas = biudzetas;
    }

    public void pridetiIrasa(Irasas irasas) {
        biudzetas.getIrasai().add(irasas);
    }

    public Irasas gautiIrasa(long unikalusNr) {
        List<Irasas> irasai = biudzetas.getIrasai();
        Irasas ieskomasIrasas = new Irasas(unikalusNr);
        if (irasai.contains(ieskomasIrasas)) {
            int irasoIndeksas = irasai.indexOf(ieskomasIrasas);
            return irasai.get(irasoIndeksas);
        }
        return null;
    }

    public ArrayList<Irasas> gautiVisusIrasus(){
        return biudzetas.getIrasai();
    }

    public ArrayList<PajamuIrasas> gautiPajamuIrasus() {
        List<Irasas> irasuSarasas = getIrasasByClass(PajamuIrasas.class);
        ArrayList<PajamuIrasas> pajamuIrasai = new ArrayList<>();
        for (Irasas irasas : irasuSarasas) {
            pajamuIrasai.add((PajamuIrasas) irasas);
        }
        return pajamuIrasai;
    }

    public ArrayList<IslaiduIrasas> gautiIslaiduIrasus() {
        List<Irasas> irasuSarasas = getIrasasByClass(IslaiduIrasas.class);
        ArrayList<IslaiduIrasas> islaiduIrasai = new ArrayList<>();
        for (Irasas irasas : irasuSarasas) {
            islaiduIrasai.add((IslaiduIrasas) irasas);
        }
        return islaiduIrasai;
    }

    public List<Irasas> getIrasasByClass(Class<? extends Irasas> klase) {
        List<Irasas> result = new ArrayList<>();
        for (Irasas irasas : biudzetas.getIrasai()) {
            if (irasas.getClass() == klase) {
                result.add(irasas);
            }
        }
        return result;
    }

    public float balansas() {
        float sum = 0;
        ArrayList<Irasas> irasai = biudzetas.getIrasai();
        for (Irasas irasas : irasai) {
            if (irasas instanceof PajamuIrasas) {
                sum += irasas.getSuma();
            } else {
                sum -= irasas.getSuma();
            }
        }
        return sum;
    }

    public boolean trintiIrasa(long trinamoIrasoUnikalusNr) {
        Irasas trinamasIrasas = new Irasas(trinamoIrasoUnikalusNr);
        List<Irasas> irasai = biudzetas.getIrasai();
        if (irasai.contains(trinamasIrasas)) {
            irasai.remove(trinamasIrasas);
            return true;
        }
        return false;
    }

    public boolean redaguotiIrasa(long unikalusNr) {
        Irasas redaguojamasIrasas = gautiIrasa(unikalusNr);
        if (!biudzetas.getIrasai().contains(redaguojamasIrasas)) {
            return false;
        }
        IrasuRedaguotojas.redaguotiIrasa(redaguojamasIrasas);
        IrasuRedaguotojas.atnaujintiIrasa(redaguojamasIrasas, biudzetas);
        return true;
    }
}
