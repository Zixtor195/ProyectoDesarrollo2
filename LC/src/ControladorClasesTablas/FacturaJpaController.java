/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import ClasesTablas.Factura;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ClasesTablas.Pedido;
import ClasesTablas.ItemsDeFactura;
import java.util.ArrayList;
import java.util.Collection;
import ClasesTablas.Pagos;
import ControladorClasesTablas.exceptions.IllegalOrphanException;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import ControladorClasesTablas.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moni
 */
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) throws PreexistingEntityException, Exception {
        if (factura.getItemsDeFacturaCollection() == null) {
            factura.setItemsDeFacturaCollection(new ArrayList<ItemsDeFactura>());
        }
        if (factura.getPagosCollection() == null) {
            factura.setPagosCollection(new ArrayList<Pagos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido idPedido = factura.getIdPedido();
            if (idPedido != null) {
                idPedido = em.getReference(idPedido.getClass(), idPedido.getIdPedido());
                factura.setIdPedido(idPedido);
            }
            Collection<ItemsDeFactura> attachedItemsDeFacturaCollection = new ArrayList<ItemsDeFactura>();
            for (ItemsDeFactura itemsDeFacturaCollectionItemsDeFacturaToAttach : factura.getItemsDeFacturaCollection()) {
                itemsDeFacturaCollectionItemsDeFacturaToAttach = em.getReference(itemsDeFacturaCollectionItemsDeFacturaToAttach.getClass(), itemsDeFacturaCollectionItemsDeFacturaToAttach.getItemsDeFacturaPK());
                attachedItemsDeFacturaCollection.add(itemsDeFacturaCollectionItemsDeFacturaToAttach);
            }
            factura.setItemsDeFacturaCollection(attachedItemsDeFacturaCollection);
            Collection<Pagos> attachedPagosCollection = new ArrayList<Pagos>();
            for (Pagos pagosCollectionPagosToAttach : factura.getPagosCollection()) {
                pagosCollectionPagosToAttach = em.getReference(pagosCollectionPagosToAttach.getClass(), pagosCollectionPagosToAttach.getPagosPK());
                attachedPagosCollection.add(pagosCollectionPagosToAttach);
            }
            factura.setPagosCollection(attachedPagosCollection);
            em.persist(factura);
            if (idPedido != null) {
                idPedido.getFacturaSet().add(factura);
                idPedido = em.merge(idPedido);
            }
            for (ItemsDeFactura itemsDeFacturaCollectionItemsDeFactura : factura.getItemsDeFacturaCollection()) {
                Factura oldFacturaOfItemsDeFacturaCollectionItemsDeFactura = itemsDeFacturaCollectionItemsDeFactura.getFactura();
                itemsDeFacturaCollectionItemsDeFactura.setFactura(factura);
                itemsDeFacturaCollectionItemsDeFactura = em.merge(itemsDeFacturaCollectionItemsDeFactura);
                if (oldFacturaOfItemsDeFacturaCollectionItemsDeFactura != null) {
                    oldFacturaOfItemsDeFacturaCollectionItemsDeFactura.getItemsDeFacturaCollection().remove(itemsDeFacturaCollectionItemsDeFactura);
                    oldFacturaOfItemsDeFacturaCollectionItemsDeFactura = em.merge(oldFacturaOfItemsDeFacturaCollectionItemsDeFactura);
                }
            }
            for (Pagos pagosCollectionPagos : factura.getPagosCollection()) {
                Factura oldFacturaOfPagosCollectionPagos = pagosCollectionPagos.getFactura();
                pagosCollectionPagos.setFactura(factura);
                pagosCollectionPagos = em.merge(pagosCollectionPagos);
                if (oldFacturaOfPagosCollectionPagos != null) {
                    oldFacturaOfPagosCollectionPagos.getPagosCollection().remove(pagosCollectionPagos);
                    oldFacturaOfPagosCollectionPagos = em.merge(oldFacturaOfPagosCollectionPagos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactura(factura.getIdFactura()) != null) {
                throw new PreexistingEntityException("Factura " + factura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getIdFactura());
            Pedido idPedidoOld = persistentFactura.getIdPedido();
            Pedido idPedidoNew = factura.getIdPedido();
            Collection<ItemsDeFactura> itemsDeFacturaCollectionOld = persistentFactura.getItemsDeFacturaCollection();
            Collection<ItemsDeFactura> itemsDeFacturaCollectionNew = factura.getItemsDeFacturaCollection();
            Collection<Pagos> pagosCollectionOld = persistentFactura.getPagosCollection();
            Collection<Pagos> pagosCollectionNew = factura.getPagosCollection();
            List<String> illegalOrphanMessages = null;
            for (ItemsDeFactura itemsDeFacturaCollectionOldItemsDeFactura : itemsDeFacturaCollectionOld) {
                if (!itemsDeFacturaCollectionNew.contains(itemsDeFacturaCollectionOldItemsDeFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItemsDeFactura " + itemsDeFacturaCollectionOldItemsDeFactura + " since its factura field is not nullable.");
                }
            }
            for (Pagos pagosCollectionOldPagos : pagosCollectionOld) {
                if (!pagosCollectionNew.contains(pagosCollectionOldPagos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pagos " + pagosCollectionOldPagos + " since its factura field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPedidoNew != null) {
                idPedidoNew = em.getReference(idPedidoNew.getClass(), idPedidoNew.getIdPedido());
                factura.setIdPedido(idPedidoNew);
            }
            Collection<ItemsDeFactura> attachedItemsDeFacturaCollectionNew = new ArrayList<ItemsDeFactura>();
            for (ItemsDeFactura itemsDeFacturaCollectionNewItemsDeFacturaToAttach : itemsDeFacturaCollectionNew) {
                itemsDeFacturaCollectionNewItemsDeFacturaToAttach = em.getReference(itemsDeFacturaCollectionNewItemsDeFacturaToAttach.getClass(), itemsDeFacturaCollectionNewItemsDeFacturaToAttach.getItemsDeFacturaPK());
                attachedItemsDeFacturaCollectionNew.add(itemsDeFacturaCollectionNewItemsDeFacturaToAttach);
            }
            itemsDeFacturaCollectionNew = attachedItemsDeFacturaCollectionNew;
            factura.setItemsDeFacturaCollection(itemsDeFacturaCollectionNew);
            Collection<Pagos> attachedPagosCollectionNew = new ArrayList<Pagos>();
            for (Pagos pagosCollectionNewPagosToAttach : pagosCollectionNew) {
                pagosCollectionNewPagosToAttach = em.getReference(pagosCollectionNewPagosToAttach.getClass(), pagosCollectionNewPagosToAttach.getPagosPK());
                attachedPagosCollectionNew.add(pagosCollectionNewPagosToAttach);
            }
            pagosCollectionNew = attachedPagosCollectionNew;
            factura.setPagosCollection(pagosCollectionNew);
            factura = em.merge(factura);
            if (idPedidoOld != null && !idPedidoOld.equals(idPedidoNew)) {
                idPedidoOld.getFacturaSet().remove(factura);
                idPedidoOld = em.merge(idPedidoOld);
            }
            if (idPedidoNew != null && !idPedidoNew.equals(idPedidoOld)) {
                idPedidoNew.getFacturaSet().add(factura);
                idPedidoNew = em.merge(idPedidoNew);
            }
            for (ItemsDeFactura itemsDeFacturaCollectionNewItemsDeFactura : itemsDeFacturaCollectionNew) {
                if (!itemsDeFacturaCollectionOld.contains(itemsDeFacturaCollectionNewItemsDeFactura)) {
                    Factura oldFacturaOfItemsDeFacturaCollectionNewItemsDeFactura = itemsDeFacturaCollectionNewItemsDeFactura.getFactura();
                    itemsDeFacturaCollectionNewItemsDeFactura.setFactura(factura);
                    itemsDeFacturaCollectionNewItemsDeFactura = em.merge(itemsDeFacturaCollectionNewItemsDeFactura);
                    if (oldFacturaOfItemsDeFacturaCollectionNewItemsDeFactura != null && !oldFacturaOfItemsDeFacturaCollectionNewItemsDeFactura.equals(factura)) {
                        oldFacturaOfItemsDeFacturaCollectionNewItemsDeFactura.getItemsDeFacturaCollection().remove(itemsDeFacturaCollectionNewItemsDeFactura);
                        oldFacturaOfItemsDeFacturaCollectionNewItemsDeFactura = em.merge(oldFacturaOfItemsDeFacturaCollectionNewItemsDeFactura);
                    }
                }
            }
            for (Pagos pagosCollectionNewPagos : pagosCollectionNew) {
                if (!pagosCollectionOld.contains(pagosCollectionNewPagos)) {
                    Factura oldFacturaOfPagosCollectionNewPagos = pagosCollectionNewPagos.getFactura();
                    pagosCollectionNewPagos.setFactura(factura);
                    pagosCollectionNewPagos = em.merge(pagosCollectionNewPagos);
                    if (oldFacturaOfPagosCollectionNewPagos != null && !oldFacturaOfPagosCollectionNewPagos.equals(factura)) {
                        oldFacturaOfPagosCollectionNewPagos.getPagosCollection().remove(pagosCollectionNewPagos);
                        oldFacturaOfPagosCollectionNewPagos = em.merge(oldFacturaOfPagosCollectionNewPagos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factura.getIdFactura();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ItemsDeFactura> itemsDeFacturaCollectionOrphanCheck = factura.getItemsDeFacturaCollection();
            for (ItemsDeFactura itemsDeFacturaCollectionOrphanCheckItemsDeFactura : itemsDeFacturaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Factura (" + factura + ") cannot be destroyed since the ItemsDeFactura " + itemsDeFacturaCollectionOrphanCheckItemsDeFactura + " in its itemsDeFacturaCollection field has a non-nullable factura field.");
            }
            Collection<Pagos> pagosCollectionOrphanCheck = factura.getPagosCollection();
            for (Pagos pagosCollectionOrphanCheckPagos : pagosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Factura (" + factura + ") cannot be destroyed since the Pagos " + pagosCollectionOrphanCheckPagos + " in its pagosCollection field has a non-nullable factura field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Pedido idPedido = factura.getIdPedido();
            if (idPedido != null) {
                idPedido.getFacturaSet().remove(factura);
                idPedido = em.merge(idPedido);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
