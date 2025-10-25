package ma.projet.dao;

import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.util.List;

public class GenericDao<T, ID extends Serializable> implements IDao<T, ID> {
    private Class<T> clazz;
    public GenericDao(Class<T> clazz) { this.clazz = clazz; }

    @Override
    public T save(T t) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(t);
        tx.commit();
        s.close();
        return t;
    }

    @Override
    public T update(T t) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.update(t);
        tx.commit();
        s.close();
        return t;
    }

    @Override
    public void delete(T t) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.delete(t);
        tx.commit();
        s.close();
    }

    @Override
    public T findById(ID id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        T obj = s.get(clazz, id);
        s.close();
        return obj;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<T> list = s.createQuery("from " + clazz.getSimpleName()).list();
        s.close();
        return list;
    }
}
