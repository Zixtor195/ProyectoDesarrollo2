/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ClasesTablas.Empleado;
import ClasesTablas.TurnosSemanales;
import ClasesTablas.TurnosSemanalesPK;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import ControladorClasesTablas.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moni
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
        if (turnosSemanales.getTurnosSemanalesPK() == null) {
            turnosSemanales.setTurnosSemanalesPK(new TurnosSemanalesPK());
        }
        turnosSemanales.getTurnosSemanalesPK().setIdEmpleado(turnosSemanales.getEmpleado().getIdEmpleado());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleado = turnosSemanales.getEmpleado();
            if (empleado != null) {
                empleado = em.getReference(empleado.getClass(), empleado.getIdEmpleado());
                turnosSemanales.setEmpleado(empleado);
            }
            em.persist(turnosSemanales);
            if (empleado != null) {
                empleado.getTurnosSemanalesSet().add(turnosSemanales);
                empleado = em.merge(empleado);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTurnosSemanales(turnosSemanales.getTurnosSemanalesPK()) != null) {
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
        turnosSemanales.getTurnosSemanalesPK().setIdEmpleado(turnosSemanales.getEmpleado().getIdEmpleado());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TurnosSemanales persistentTurnosSemanales = em.find(TurnosSemanales.class, turnosSemanales.getTurnosSemanalesPK());
            Empleado empleadoOld = persistentTurnosSemanales.getEmpleado();
            Empleado empleadoNew = turnosSemanales.getEmpleado();
            if (empleadoNew != null) {
                empleadoNew = em.getReference(empleadoNew.getClass(), empleadoNew.getIdEmpleado());
                turnosSemanales.setEmpleado(empleadoNew);
            }
            turnosSemanales = em.merge(turnosSemanales);
            if (empleadoOld != null && !empleadoOld.equals(empleadoNew)) {
                empleadoOld.getTurnosSemanalesSet().remove(turnosSemanales);
                empleadoOld = em.merge(empleadoOld);
            }
            if (empleadoNew != null && !empleadoNew.equals(empleadoOld)) {
                empleadoNew.getTurnosSemanalesSet().add(turnosSemanales);
                empleadoNew = em.merge(empleadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TurnosSemanalesPK id = turnosSemanales.getTurnosSemanalesPK();
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

    public void destroy(TurnosSemanalesPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TurnosSemanales turnosSemanales;
            try {
                turnosSemanales = em.getReference(TurnosSemanales.class, id);
                turnosSemanales.getTurnosSemanalesPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turnosSemanales with id " + id + " no longer exists.", enfe);
            }
            Empleado empleado = turnosSemanales.getEmpleado();
            if (empleado != null) {
                empleado.getTurnosSemanalesSet().remove(turnosSemanales);
                empleado = em.merge(empleado);
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

    public TurnosSemanales findTurnosSemanales(TurnosSemanalesPK id) {
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
