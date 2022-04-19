package lt.codeacademy.repository;

import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.IslaiduIrasas;
import lt.codeacademy.irasai.PajamuIrasas;
import lt.codeacademy.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

    public void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(pajamuIrasas);
        session.close();
    }

    public void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(islaiduIrasas);
        session.close();
    }

    public Irasas gautiIrasa(long unikalusNr){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Irasas irasas = session.get(Irasas.class, unikalusNr);
        session.close();
        return irasas;
    }

    public float gautiBalansa(){
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

    public List<Irasas> gautiVisusIrasus(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Irasas> irasuSarasas = session.createQuery("from Irasas", Irasas.class).getResultList();
        session.close();
        return irasuSarasas;
    }


}
