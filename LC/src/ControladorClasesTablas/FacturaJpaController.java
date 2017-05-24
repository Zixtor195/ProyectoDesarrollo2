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
import java.util.HashSet;
import java.util.Set;
import ClasesTablas.Pagos;
import ControladorClasesTablas.exceptions.IllegalOrphanException;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import ControladorClasesTablas.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public String create(Factura factura) throws PreexistingEntityException, Exception {
        
        String resultado =" ";
        if (factura.getItemsDeFacturaSet() == null) {
            factura.setItemsDeFacturaSet(new HashSet<ItemsDeFactura>());
        }
        if (factura.getPagosSet() == null) {
            factura.setPagosSet(new HashSet<Pagos>());
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
            Set<ItemsDeFactura> attachedItemsDeFacturaSet = new HashSet<ItemsDeFactura>();
            for (ItemsDeFactura itemsDeFacturaSetItemsDeFacturaToAttach : factura.getItemsDeFacturaSet()) {
                itemsDeFacturaSetItemsDeFacturaToAttach = em.getReference(itemsDeFacturaSetItemsDeFacturaToAttach.getClass(), itemsDeFacturaSetItemsDeFacturaToAttach.getItemsDeFacturaPK());
                attachedItemsDeFacturaSet.add(itemsDeFacturaSetItemsDeFacturaToAttach);
            }
            factura.setItemsDeFacturaSet(attachedItemsDeFacturaSet);
            Set<Pagos> attachedPagosSet = new HashSet<Pagos>();
            for (Pagos pagosSetPagosToAttach : factura.getPagosSet()) {
                pagosSetPagosToAttach = em.getReference(pagosSetPagosToAttach.getClass(), pagosSetPagosToAttach.getPagosPK());
                attachedPagosSet.add(pagosSetPagosToAttach);
            }
            factura.setPagosSet(attachedPagosSet);
            em.persist(factura);
            if (idPedido != null) {
                idPedido.getFacturaSet().add(factura);
                idPedido = em.merge(idPedido);
            }
            for (ItemsDeFactura itemsDeFacturaSetItemsDeFactura : factura.getItemsDeFacturaSet()) {
                Factura oldFacturaOfItemsDeFacturaSetItemsDeFactura = itemsDeFacturaSetItemsDeFactura.getFactura();
                itemsDeFacturaSetItemsDeFactura.setFactura(factura);
                itemsDeFacturaSetItemsDeFactura = em.merge(itemsDeFacturaSetItemsDeFactura);
                if (oldFacturaOfItemsDeFacturaSetItemsDeFactura != null) {
                    oldFacturaOfItemsDeFacturaSetItemsDeFactura.getItemsDeFacturaSet().remove(itemsDeFacturaSetItemsDeFactura);
                    oldFacturaOfItemsDeFacturaSetItemsDeFactura = em.merge(oldFacturaOfItemsDeFacturaSetItemsDeFactura);
                }
            }
            for (Pagos pagosSetPagos : factura.getPagosSet()) {
                Factura oldFacturaOfPagosSetPagos = pagosSetPagos.getFactura();
                pagosSetPagos.setFactura(factura);
                pagosSetPagos = em.merge(pagosSetPagos);
                if (oldFacturaOfPagosSetPagos != null) {
                    oldFacturaOfPagosSetPagos.getPagosSet().remove(pagosSetPagos);
                    oldFacturaOfPagosSetPagos = em.merge(oldFacturaOfPagosSetPagos);
                }
            }
            em.getTransaction().commit();
            resultado = "creado exitosamente";
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
        return resultado;
    }

    public String edit(Factura factura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        String resultado = "";
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getIdFactura());
            Pedido idPedidoOld = persistentFactura.getIdPedido();
            Pedido idPedidoNew = factura.getIdPedido();
            Set<ItemsDeFactura> itemsDeFacturaSetOld = persistentFactura.getItemsDeFacturaSet();
            Set<ItemsDeFactura> itemsDeFacturaSetNew = factura.getItemsDeFacturaSet();
            Set<Pagos> pagosSetOld = persistentFactura.getPagosSet();
            Set<Pagos> pagosSetNew = factura.getPagosSet();
            List<String> illegalOrphanMessages = null;
            for (ItemsDeFactura itemsDeFacturaSetOldItemsDeFactura : itemsDeFacturaSetOld) {
                if (!itemsDeFacturaSetNew.contains(itemsDeFacturaSetOldItemsDeFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItemsDeFactura " + itemsDeFacturaSetOldItemsDeFactura + " since its factura field is not nullable.");
                }
            }
            for (Pagos pagosSetOldPagos : pagosSetOld) {
                if (!pagosSetNew.contains(pagosSetOldPagos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pagos " + pagosSetOldPagos + " since its factura field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPedidoNew != null) {
                idPedidoNew = em.getReference(idPedidoNew.getClass(), idPedidoNew.getIdPedido());
                factura.setIdPedido(idPedidoNew);
            }
            Set<ItemsDeFactura> attachedItemsDeFacturaSetNew = new HashSet<ItemsDeFactura>();
            for (ItemsDeFactura itemsDeFacturaSetNewItemsDeFacturaToAttach : itemsDeFacturaSetNew) {
                itemsDeFacturaSetNewItemsDeFacturaToAttach = em.getReference(itemsDeFacturaSetNewItemsDeFacturaToAttach.getClass(), itemsDeFacturaSetNewItemsDeFacturaToAttach.getItemsDeFacturaPK());
                attachedItemsDeFacturaSetNew.add(itemsDeFacturaSetNewItemsDeFacturaToAttach);
            }
            itemsDeFacturaSetNew = attachedItemsDeFacturaSetNew;
            factura.setItemsDeFacturaSet(itemsDeFacturaSetNew);
            Set<Pagos> attachedPagosSetNew = new HashSet<Pagos>();
            for (Pagos pagosSetNewPagosToAttach : pagosSetNew) {
                pagosSetNewPagosToAttach = em.getReference(pagosSetNewPagosToAttach.getClass(), pagosSetNewPagosToAttach.getPagosPK());
                attachedPagosSetNew.add(pagosSetNewPagosToAttach);
            }
            pagosSetNew = attachedPagosSetNew;
            factura.setPagosSet(pagosSetNew);
            factura = em.merge(factura);
            if (idPedidoOld != null && !idPedidoOld.equals(idPedidoNew)) {
                idPedidoOld.getFacturaSet().remove(factura);
                idPedidoOld = em.merge(idPedidoOld);
            }
            if (idPedidoNew != null && !idPedidoNew.equals(idPedidoOld)) {
                idPedidoNew.getFacturaSet().add(factura);
                idPedidoNew = em.merge(idPedidoNew);
            }
            for (ItemsDeFactura itemsDeFacturaSetNewItemsDeFactura : itemsDeFacturaSetNew) {
                if (!itemsDeFacturaSetOld.contains(itemsDeFacturaSetNewItemsDeFactura)) {
                    Factura oldFacturaOfItemsDeFacturaSetNewItemsDeFactura = itemsDeFacturaSetNewItemsDeFactura.getFactura();
                    itemsDeFacturaSetNewItemsDeFactura.setFactura(factura);
                    itemsDeFacturaSetNewItemsDeFactura = em.merge(itemsDeFacturaSetNewItemsDeFactura);
                    if (oldFacturaOfItemsDeFacturaSetNewItemsDeFactura != null && !oldFacturaOfItemsDeFacturaSetNewItemsDeFactura.equals(factura)) {
                        oldFacturaOfItemsDeFacturaSetNewItemsDeFactura.getItemsDeFacturaSet().remove(itemsDeFacturaSetNewItemsDeFactura);
                        oldFacturaOfItemsDeFacturaSetNewItemsDeFactura = em.merge(oldFacturaOfItemsDeFacturaSetNewItemsDeFactura);
                    }
                }
            }
            for (Pagos pagosSetNewPagos : pagosSetNew) {
                if (!pagosSetOld.contains(pagosSetNewPagos)) {
                    Factura oldFacturaOfPagosSetNewPagos = pagosSetNewPagos.getFactura();
                    pagosSetNewPagos.setFactura(factura);
                    pagosSetNewPagos = em.merge(pagosSetNewPagos);
                    if (oldFacturaOfPagosSetNewPagos != null && !oldFacturaOfPagosSetNewPagos.equals(factura)) {
                        oldFacturaOfPagosSetNewPagos.getPagosSet().remove(pagosSetNewPagos);
                        oldFacturaOfPagosSetNewPagos = em.merge(oldFacturaOfPagosSetNewPagos);
                    }
                }
            }
            em.getTransaction().commit();
            resultado = "modificado exitosamente";
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
        
        return resultado;
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
            Set<ItemsDeFactura> itemsDeFacturaSetOrphanCheck = factura.getItemsDeFacturaSet();
            for (ItemsDeFactura itemsDeFacturaSetOrphanCheckItemsDeFactura : itemsDeFacturaSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Factura (" + factura + ") cannot be destroyed since the ItemsDeFactura " + itemsDeFacturaSetOrphanCheckItemsDeFactura + " in its itemsDeFacturaSet field has a non-nullable factura field.");
            }
            Set<Pagos> pagosSetOrphanCheck = factura.getPagosSet();
            for (Pagos pagosSetOrphanCheckPagos : pagosSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Factura (" + factura + ") cannot be destroyed since the Pagos " + pagosSetOrphanCheckPagos + " in its pagosSet field has a non-nullable factura field.");
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
