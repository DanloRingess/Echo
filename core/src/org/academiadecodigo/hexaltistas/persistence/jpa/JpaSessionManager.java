package org.academiadecodigo.hexaltistas.persistence.jpa;


import org.academiadecodigo.hexaltistas.persistence.SessionManager;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class JpaSessionManager implements SessionManager<EntityManager> {

    private EntityManagerFactory emf;

    private EntityManager em;

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void startSession() {

        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    @Override
    public void stopSession() {

        if (em != null) {
            em.close();
        }

        em = null;
    }

    /**
     * @see SessionManager#getCurrentSession()
     */
    @Override
    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }
}
