package org.academiadecodigo.hexaltistas.persistence.dao;

import org.academiadecodigo.hexaltistas.model.User;
import org.academiadecodigo.hexaltistas.persistence.TransactionException;
import org.academiadecodigo.hexaltistas.persistence.jpa.JpaSessionManager;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {

    private JpaSessionManager sm;
    private User user;


    public List<User> findAll() {

        try {

            EntityManager em = sm.getCurrentSession();

            CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            return em.createQuery(criteriaQuery).getResultList();

            // Using JPQL
            // return em.createQuery( "from " + modelType.getSimpleName(), modelType).getResultList();


        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    public User findById(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.find(User.class, id);

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }


    public User saveOrUpdate(User user) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.merge(user);

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }


    public void delete(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            em.remove(em.find(User.class, id));

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }


}
