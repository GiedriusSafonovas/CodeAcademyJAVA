package lt.codeacademy.repository;

import lt.codeacademy.irasai.Irasas;
import lt.codeacademy.irasai.IslaiduIrasas;
import lt.codeacademy.irasai.PajamuIrasas;
import lt.codeacademy.utils.HibernateUtil;
import org.hibernate.Session;

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
}
