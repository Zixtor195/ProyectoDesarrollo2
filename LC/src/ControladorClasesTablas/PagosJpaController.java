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
import ClasesTablas.Factura;
import ClasesTablas.Pagos;
import ClasesTablas.PagosPK;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import ControladorClasesTablas.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class PagosJpaController implements Serializable {

    public PagosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public String create(Pagos pagos) throws PreexistingEntityException, Exception {
        String resultado = "";
        if (pagos.getPagosPK() == null) {
            pagos.setPagosPK(new PagosPK());
        }
       //pagos.getPagosPK().setIdFactura(pagos.getFactura().getIdFactura());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura factura = pagos.getFactura();
            if (factura != null) {
                factura = em.getReference(factura.getClass(), factura.getIdFactura());
                pagos.setFactura(factura);
            }
            em.persist(pagos);
            if (factura != null) {
                factura.getPagosSet().add(pagos);
                factura = em.merge(factura);
            }
            em.getTransaction().commit();
            resultado = "creado exitosamente";
        } catch (Exception ex) {
            if (findPagos(pagos.getPagosPK()) != null) {
                throw new PreexistingEntityException("Pagos " + pagos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return resultado;
    }

    public void edit(Pagos pagos) throws NonexistentEntityException, Exception {
        pagos.getPagosPK().setIdFactura(pagos.getFactura().getIdFactura());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pagos persistentPagos = em.find(Pagos.class, pagos.getPagosPK());
            Factura facturaOld = persistentPagos.getFactura();
            Factura facturaNew = pagos.getFactura();
            if (facturaNew != null) {
                facturaNew = em.getReference(facturaNew.getClass(), facturaNew.getIdFactura());
                pagos.setFactura(facturaNew);
            }
            pagos = em.merge(pagos);
            if (facturaOld != null && !facturaOld.equals(facturaNew)) {
                facturaOld.getPagosSet().remove(pagos);
                facturaOld = em.merge(facturaOld);
            }
            if (facturaNew != null && !facturaNew.equals(facturaOld)) {
                facturaNew.getPagosSet().add(pagos);
                facturaNew = em.merge(facturaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PagosPK id = pagos.getPagosPK();
                if (findPagos(id) == null) {
                    throw new NonexistentEntityException("The pagos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PagosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pagos pagos;
            try {
                pagos = em.getReference(Pagos.class, id);
                pagos.getPagosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pagos with id " + id + " no longer exists.", enfe);
            }
            Factura factura = pagos.getFactura();
            if (factura != null) {
                factura.getPagosSet().remove(pagos);
                factura = em.merge(factura);
            }
            em.remove(pagos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pagos> findPagosEntities() {
        return findPagosEntities(true, -1, -1);
    }

    public List<Pagos> findPagosEntities(int maxResults, int firstResult) {
        return findPagosEntities(false, maxResults, firstResult);
    }

    private List<Pagos> findPagosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pagos.class));
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

    public Pagos findPagos(PagosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pagos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pagos> rt = cq.from(Pagos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
