package cingo.dao;

import cingo.model.Log;
import cingo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class LogDAO {
    private SessionFactory sessionFactory;

    public LogDAO() {
        sessionFactory = HibernateUtil.getSessionFactory;
    }

    public void saveOrUpdate (Log log) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM Log WHERE conteudo = :conteudo");
        query.setParameter("conteudo", log.getConteudo());
        Log existente = (Log) query.uniqueResult();

        if (existente != null) {
            existente.setVezes(existente.getVezes() + log.getVezes());
            session.update(existente);
        } else {
            session.save(log);
        }

        tx.commit();
        session.close();
    }

    public List<Log> listLog() {
        Session session = sessionFactory.openSession();
        List<Log> logs = session.createQuery("FROM Log ORDER BY vezes DESC", Log.class).list();
        session.close();
        return logs;
    }

    public Log searchId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Log log = session.get(Log.class, id);
        session.close();
        return log;
    }

    public List<Log> listAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Log> logs = session.createQuery("FROM Log", Log.class).list();
        session.close();
        return logs;
    }

    public void delete(Log log) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.delete(log);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
