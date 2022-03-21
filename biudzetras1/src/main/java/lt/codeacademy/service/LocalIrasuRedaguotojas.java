package lt.codeacademy.service;

import lt.codeacademy.repository.Biudzetas;
import lt.codeacademy.irasai.Irasas;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

public class LocalIrasuRedaguotojas {


    public static boolean redaguotiIrasa(Irasas redaguojamasIrasas, Biudzetas biudzetas) {
        if (!biudzetas.getIrasai().contains(redaguojamasIrasas)) {
            return false;
        }

        Class klase = redaguojamasIrasas.getClass();
        Class superKlase = klase.getSuperclass();

        redaguotiIrasaPagalKlase(redaguojamasIrasas, superKlase);
        redaguotiIrasaPagalKlase(redaguojamasIrasas, klase);

        atnaujintiIrasa(redaguojamasIrasas, biudzetas);
        return true;
    }

    private static void redaguotiIrasaPagalKlase(Irasas redaguojamasIrasas, Class klase) {
        List<Field> klasesLaukai = List.of(klase.getDeclaredFields());

        for (Field laukas : klasesLaukai) {
            String laukoPavadinimas = laukas.getName();
            if (laukoPavadinimas.equals("counter") || laukoPavadinimas.equals("unikalusNr")) {
                continue;
            }
            try {
                String geterioPavadinimas = gautiGetterioPavadinima(laukoPavadinimas);
                Object laukoReiksme = klase.getMethod(geterioPavadinimas).invoke(redaguojamasIrasas);

                if (Meniu.arRedaguoti(laukoPavadinimas.toUpperCase(Locale.ROOT) + " = " + laukoReiksme)) {
                    redaguotiLauka(laukoPavadinimas, laukas, klase, redaguojamasIrasas);
                }

            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void redaguotiLauka(
            String laukoPavadinimas, Field laukas, Class klase, Irasas redaguojamasIrasas)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String setterioPavadinimas = gautiSetterioPavadinima(laukoPavadinimas);
        System.out.println("Iveskite nauja reiksme");

        List<Method> scannerioMetodai = List.of(Scan.class.getDeclaredMethods());
        Object naujaVerte = gautiNaujaLaukoReiksme(scannerioMetodai, laukas);

        setNewValue(klase, redaguojamasIrasas, laukas.getType(), setterioPavadinimas, naujaVerte);
    }

    private static Object gautiNaujaLaukoReiksme(List<Method> scannerioMetodai, Field laukas)
            throws IllegalAccessException, InvocationTargetException {
        for (Method scanneris : scannerioMetodai) {
            if (scanneris.getReturnType() == laukas.getType()
                    && scanneris.getParameterTypes().length == 0) {
                return scanneris.invoke(null);
            }
        }
        return null;
    }

    public static void setNewValue(
            Class klase, Irasas irasas, Class duomenuTipas, String setteris, Object naujaVerte)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        klase.getMethod(setteris, duomenuTipas).invoke(irasas, naujaVerte);
    }

    private static String gautiGetterioPavadinima(String laukoPavadinimas) {
        return "get"
                + laukoPavadinimas.substring(0, 1).toUpperCase(Locale.ROOT)
                + laukoPavadinimas.substring(1);
    }

    private static String gautiSetterioPavadinima(String laukoPavadinimas) {
        return "set"
                + laukoPavadinimas.substring(0, 1).toUpperCase(Locale.ROOT)
                + laukoPavadinimas.substring(1);
    }

    public static void atnaujintiIrasa(Irasas irasas, Biudzetas biudzetas) {
        List<Irasas> irasai = biudzetas.getIrasai();
        int indeksoNr = irasai.indexOf(irasas);
        irasai.set(indeksoNr, irasas);
    }

}
