package lt.codeacademy.service;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.IslaiduIrasas;
import lt.codeacademy.irasai.PajamuIrasas;

import java.util.ArrayList;
import java.util.List;

public class IrasaiHandler {

    public static void pridetiIrasa(Irasas irasas, Biudzetas biudzetas) {
        biudzetas.getIrasai().add(irasas);
    }

    public static Irasas gautiIrasa(long unikalusNr, Biudzetas biudzetas) {
        List<Irasas> irasai = biudzetas.getIrasai();
        Irasas ieskomasIrasas = new Irasas(unikalusNr);
        if (irasai.contains(ieskomasIrasas)) {
            int irasoIndeksas = irasai.indexOf(ieskomasIrasas);
            return irasai.get(irasoIndeksas);
        }
        return null;
    }

    public static ArrayList<PajamuIrasas> gautiPajamuIrasus(Biudzetas biudzetas) {
        List<Irasas> irasuSarasas = getIrasasByClass(PajamuIrasas.class, biudzetas);
        ArrayList<PajamuIrasas> pajamuIrasai = new ArrayList<>();
        for (Irasas irasas : irasuSarasas) {
            pajamuIrasai.add((PajamuIrasas) irasas);
        }
        return pajamuIrasai;
    }

    public static ArrayList<IslaiduIrasas> gautiIslaiduIrasus(Biudzetas biudzetas) {
        List<Irasas> irasuSarasas = getIrasasByClass(IslaiduIrasas.class, biudzetas);
        ArrayList<IslaiduIrasas> islaiduIrasai = new ArrayList<>();
        for (Irasas irasas : irasuSarasas) {
            islaiduIrasai.add((IslaiduIrasas) irasas);
        }
        return islaiduIrasai;
    }

    public static List<Irasas> getIrasasByClass(Class<? extends Irasas> klase, Biudzetas biudzetas) {
        List<Irasas> result = new ArrayList<>();
        for (Irasas irasas : biudzetas.getIrasai()) {
            if (irasas.getClass() == klase) {
                result.add(irasas);
            }
        }
        return result;
    }

    public static boolean trintiIrasa(long trinamoIrasoUnikalusNr, Biudzetas biudzetas) {
        Irasas trinamasIrasas = new Irasas(trinamoIrasoUnikalusNr);
        List<Irasas> irasai = biudzetas.getIrasai();
        if (irasai.contains(trinamasIrasas)) {
            irasai.remove(trinamasIrasas);
            return true;
        }
        return false;
    }

    public static boolean redaguotiIrasa(long unikalusNr, Biudzetas biudzetas) {
        Irasas redaguojamasIrasas = gautiIrasa(unikalusNr, biudzetas);
        return LocalIrasuRedaguotojas.redaguotiIrasa(redaguojamasIrasas, biudzetas);
    }
}
