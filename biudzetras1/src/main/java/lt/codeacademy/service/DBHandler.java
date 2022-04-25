package lt.codeacademy.service;

import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.IslaiduIrasas;
import lt.codeacademy.irasai.PajamuIrasas;
import lt.codeacademy.service.IrasuRedaguotojas;
import lt.codeacademy.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBHandler {

    public void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(pajamuIrasas);
        session.close();
    }

    public void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(islaiduIrasas);
        session.close();
    }

    public Irasas gautiIrasa(long unikalusNr) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Irasas irasas = session.get(Irasas.class, unikalusNr);
        session.close();
        return irasas;
    }

    public float gautiBalansa() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List results = session.createNativeQuery(
                "select sum(suma) from biudzetas.irasas\n" +
                        "join biudzetas.pajamuirasas i on irasas.unikalusnr = i.unikalusnr").list();
        float pajamos = (float) results.get(0);
        results = session.createNativeQuery(
                "select sum(suma) from biudzetas.irasas\n" +
                        "join biudzetas.islaiduirasas i on irasas.unikalusnr = i.unikalusnr").list();
        float islaidos = (float) results.get(0);
        float balansas = pajamos - islaidos;
        session.close();
        return balansas;
    }

    public List<Irasas> gautiVisusIrasus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Irasas> irasuSarasas = session.createQuery("from Irasas", Irasas.class).getResultList();
        session.close();
        return irasuSarasas;
    }

    public boolean trintiIrasa(long unikalusNr) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = session.createQuery("delete from Irasas where unikalusNr = :id").setParameter("id", unikalusNr).executeUpdate();
        transaction.commit();
        session.close();
        return result == 1;
    }

    public void redaguotiIrasa(long unikalusNr){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Irasas redaguojamasIrasas = session.get(Irasas.class, unikalusNr);
        IrasuRedaguotojas.redaguotiIrasa(redaguojamasIrasas);
        session.update(redaguojamasIrasas);
        transaction.commit();
        session.close();
    }

}
