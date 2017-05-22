/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import ClasesTablas.TurnosSemanales;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import ControladorClasesTablas.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author familia BS
 */
public class TurnosSemanalesJpaController implements Serializable {

    public TurnosSemanalesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TurnosSemanales turnosSemanales) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(turnosSemanales);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTurnosSemanales(turnosSemanales.getId()) != null) {
                throw new PreexistingEntityException("TurnosSemanales " + turnosSemanales + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TurnosSemanales turnosSemanales) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            turnosSemanales = em.merge(turnosSemanales);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = turnosSemanales.getId();
                if (findTurnosSemanales(id) == null) {
                    throw new NonexistentEntityException("The turnosSemanales with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TurnosSemanales turnosSemanales;
            try {
                turnosSemanales = em.getReference(TurnosSemanales.class, id);
                turnosSemanales.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turnosSemanales with id " + id + " no longer exists.", enfe);
            }
            em.remove(turnosSemanales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TurnosSemanales> findTurnosSemanalesEntities() {
        return findTurnosSemanalesEntities(true, -1, -1);
    }

    public List<TurnosSemanales> findTurnosSemanalesEntities(int maxResults, int firstResult) {
        return findTurnosSemanalesEntities(false, maxResults, firstResult);
    }

    private List<TurnosSemanales> findTurnosSemanalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TurnosSemanales.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TurnosSemanales findTurnosSemanales(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TurnosSemanales.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnosSemanalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TurnosSemanales> rt = cq.from(TurnosSemanales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
