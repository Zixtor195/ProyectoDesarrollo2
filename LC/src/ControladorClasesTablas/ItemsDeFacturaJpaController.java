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
import ClasesTablas.ItemsDeFactura;
import ClasesTablas.ItemsDeFacturaPK;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import ControladorClasesTablas.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moni
 */
public class ItemsDeFacturaJpaController implements Serializable {

    public ItemsDeFacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemsDeFactura itemsDeFactura) throws PreexistingEntityException, Exception {
        if (itemsDeFactura.getItemsDeFacturaPK() == null) {
            itemsDeFactura.setItemsDeFacturaPK(new ItemsDeFacturaPK());
        }
        itemsDeFactura.getItemsDeFacturaPK().setIdFactura(itemsDeFactura.getFactura().getIdFactura());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura factura = itemsDeFactura.getFactura();
            if (factura != null) {
                factura = em.getReference(factura.getClass(), factura.getIdFactura());
                itemsDeFactura.setFactura(factura);
            }
            em.persist(itemsDeFactura);
            if (factura != null) {
                factura.getItemsDeFacturaCollection().add(itemsDeFactura);
                factura = em.merge(factura);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItemsDeFactura(itemsDeFactura.getItemsDeFacturaPK()) != null) {
                throw new PreexistingEntityException("ItemsDeFactura " + itemsDeFactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemsDeFactura itemsDeFactura) throws NonexistentEntityException, Exception {
        itemsDeFactura.getItemsDeFacturaPK().setIdFactura(itemsDeFactura.getFactura().getIdFactura());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemsDeFactura persistentItemsDeFactura = em.find(ItemsDeFactura.class, itemsDeFactura.getItemsDeFacturaPK());
            Factura facturaOld = persistentItemsDeFactura.getFactura();
            Factura facturaNew = itemsDeFactura.getFactura();
            if (facturaNew != null) {
                facturaNew = em.getReference(facturaNew.getClass(), facturaNew.getIdFactura());
                itemsDeFactura.setFactura(facturaNew);
            }
            itemsDeFactura = em.merge(itemsDeFactura);
            if (facturaOld != null && !facturaOld.equals(facturaNew)) {
                facturaOld.getItemsDeFacturaCollection().remove(itemsDeFactura);
                facturaOld = em.merge(facturaOld);
            }
            if (facturaNew != null && !facturaNew.equals(facturaOld)) {
                facturaNew.getItemsDeFacturaCollection().add(itemsDeFactura);
                facturaNew = em.merge(facturaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ItemsDeFacturaPK id = itemsDeFactura.getItemsDeFacturaPK();
                if (findItemsDeFactura(id) == null) {
                    throw new NonexistentEntityException("The itemsDeFactura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ItemsDeFacturaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemsDeFactura itemsDeFactura;
            try {
                itemsDeFactura = em.getReference(ItemsDeFactura.class, id);
                itemsDeFactura.getItemsDeFacturaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemsDeFactura with id " + id + " no longer exists.", enfe);
            }
            Factura factura = itemsDeFactura.getFactura();
            if (factura != null) {
                factura.getItemsDeFacturaCollection().remove(itemsDeFactura);
                factura = em.merge(factura);
            }
            em.remove(itemsDeFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemsDeFactura> findItemsDeFacturaEntities() {
        return findItemsDeFacturaEntities(true, -1, -1);
    }

    public List<ItemsDeFactura> findItemsDeFacturaEntities(int maxResults, int firstResult) {
        return findItemsDeFacturaEntities(false, maxResults, firstResult);
    }

    private List<ItemsDeFactura> findItemsDeFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemsDeFactura.class));
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

    public ItemsDeFactura findItemsDeFactura(ItemsDeFacturaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemsDeFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemsDeFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemsDeFactura> rt = cq.from(ItemsDeFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
