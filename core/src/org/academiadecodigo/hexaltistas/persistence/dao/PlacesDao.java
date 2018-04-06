package org.academiadecodigo.hexaltistas.persistence.dao;

import org.academiadecodigo.hexaltistas.model.Places;
import org.academiadecodigo.hexaltistas.model.Shout;
import org.academiadecodigo.hexaltistas.persistence.TransactionException;
import org.academiadecodigo.hexaltistas.persistence.jpa.JpaSessionManager;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PlacesDao {

    private JpaSessionManager sm;
    private Places places;


    public List<Places> findAll() {

        try {

            EntityManager em = sm.getCurrentSession();

            CriteriaQuery<Places> criteriaQuery = em.getCriteriaBuilder().createQuery(Places.class);
            Root<Places> root = criteriaQuery.from(Places.class);
            return em.createQuery(criteriaQuery).getResultList();

            // Using JPQL
            // return em.createQuery( "from " + modelType.getSimpleName(), modelType).getResultList();


        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    public Places findById(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.find(Places.class, id);

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }


    public Places saveOrUpdate(Places places) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.merge(places);

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }


    public void delete(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            em.remove(em.find(Places.class, id));

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    public List<Shout> findTop3() {
        List<Shout> top = null;
        try {
            EntityManager em = sm.getCurrentSession();
            //Query q = em.createQuery("SELECT Shouts FROM Places ORDER BY numberOfVotes DESC");
            Query q = em.createQuery("SELECT * FROM Shouts ORDER BY numberOfVotes DESC");
            top = q.getResultList();
        } catch (HibernateException ex) {
            throw new TransactionException(ex);

        }
        return top;
    }

}
