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
import ClasesTablas.ItemPedido;
import java.util.HashSet;
import java.util.Set;
import ClasesTablas.Factura;
import ClasesTablas.Pedido;
import ControladorClasesTablas.exceptions.IllegalOrphanException;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import ControladorClasesTablas.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moni
 */
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) throws PreexistingEntityException, Exception {
        if (pedido.getItemPedidoSet() == null) {
            pedido.setItemPedidoSet(new HashSet<ItemPedido>());
        }
        if (pedido.getFacturaSet() == null) {
            pedido.setFacturaSet(new HashSet<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado idEmpleado = pedido.getIdEmpleado();
            if (idEmpleado != null) {
                idEmpleado = em.getReference(idEmpleado.getClass(), idEmpleado.getIdEmpleado());
                pedido.setIdEmpleado(idEmpleado);
            }
            Set<ItemPedido> attachedItemPedidoSet = new HashSet<ItemPedido>();
            for (ItemPedido itemPedidoSetItemPedidoToAttach : pedido.getItemPedidoSet()) {
                itemPedidoSetItemPedidoToAttach = em.getReference(itemPedidoSetItemPedidoToAttach.getClass(), itemPedidoSetItemPedidoToAttach.getItemPedidoPK());
                attachedItemPedidoSet.add(itemPedidoSetItemPedidoToAttach);
            }
            pedido.setItemPedidoSet(attachedItemPedidoSet);
            Set<Factura> attachedFacturaSet = new HashSet<Factura>();
            for (Factura facturaSetFacturaToAttach : pedido.getFacturaSet()) {
                facturaSetFacturaToAttach = em.getReference(facturaSetFacturaToAttach.getClass(), facturaSetFacturaToAttach.getIdFactura());
                attachedFacturaSet.add(facturaSetFacturaToAttach);
            }
            pedido.setFacturaSet(attachedFacturaSet);
            em.persist(pedido);
            if (idEmpleado != null) {
                idEmpleado.getPedidoSet().add(pedido);
                idEmpleado = em.merge(idEmpleado);
            }
            for (ItemPedido itemPedidoSetItemPedido : pedido.getItemPedidoSet()) {
                Pedido oldPedidoOfItemPedidoSetItemPedido = itemPedidoSetItemPedido.getPedido();
                itemPedidoSetItemPedido.setPedido(pedido);
                itemPedidoSetItemPedido = em.merge(itemPedidoSetItemPedido);
                if (oldPedidoOfItemPedidoSetItemPedido != null) {
                    oldPedidoOfItemPedidoSetItemPedido.getItemPedidoSet().remove(itemPedidoSetItemPedido);
                    oldPedidoOfItemPedidoSetItemPedido = em.merge(oldPedidoOfItemPedidoSetItemPedido);
                }
            }
            for (Factura facturaSetFactura : pedido.getFacturaSet()) {
                Pedido oldIdPedidoOfFacturaSetFactura = facturaSetFactura.getIdPedido();
                facturaSetFactura.setIdPedido(pedido);
                facturaSetFactura = em.merge(facturaSetFactura);
                if (oldIdPedidoOfFacturaSetFactura != null) {
                    oldIdPedidoOfFacturaSetFactura.getFacturaSet().remove(facturaSetFactura);
                    oldIdPedidoOfFacturaSetFactura = em.merge(oldIdPedidoOfFacturaSetFactura);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPedido(pedido.getIdPedido()) != null) {
                throw new PreexistingEntityException("Pedido " + pedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getIdPedido());
            Empleado idEmpleadoOld = persistentPedido.getIdEmpleado();
            Empleado idEmpleadoNew = pedido.getIdEmpleado();
            Set<ItemPedido> itemPedidoSetOld = persistentPedido.getItemPedidoSet();
            Set<ItemPedido> itemPedidoSetNew = pedido.getItemPedidoSet();
            Set<Factura> facturaSetOld = persistentPedido.getFacturaSet();
            Set<Factura> facturaSetNew = pedido.getFacturaSet();
            List<String> illegalOrphanMessages = null;
            for (ItemPedido itemPedidoSetOldItemPedido : itemPedidoSetOld) {
                if (!itemPedidoSetNew.contains(itemPedidoSetOldItemPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItemPedido " + itemPedidoSetOldItemPedido + " since its pedido field is not nullable.");
                }
            }
            for (Factura facturaSetOldFactura : facturaSetOld) {
                if (!facturaSetNew.contains(facturaSetOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + facturaSetOldFactura + " since its idPedido field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEmpleadoNew != null) {
                idEmpleadoNew = em.getReference(idEmpleadoNew.getClass(), idEmpleadoNew.getIdEmpleado());
                pedido.setIdEmpleado(idEmpleadoNew);
            }
            Set<ItemPedido> attachedItemPedidoSetNew = new HashSet<ItemPedido>();
            for (ItemPedido itemPedidoSetNewItemPedidoToAttach : itemPedidoSetNew) {
                itemPedidoSetNewItemPedidoToAttach = em.getReference(itemPedidoSetNewItemPedidoToAttach.getClass(), itemPedidoSetNewItemPedidoToAttach.getItemPedidoPK());
                attachedItemPedidoSetNew.add(itemPedidoSetNewItemPedidoToAttach);
            }
            itemPedidoSetNew = attachedItemPedidoSetNew;
            pedido.setItemPedidoSet(itemPedidoSetNew);
            Set<Factura> attachedFacturaSetNew = new HashSet<Factura>();
            for (Factura facturaSetNewFacturaToAttach : facturaSetNew) {
                facturaSetNewFacturaToAttach = em.getReference(facturaSetNewFacturaToAttach.getClass(), facturaSetNewFacturaToAttach.getIdFactura());
                attachedFacturaSetNew.add(facturaSetNewFacturaToAttach);
            }
            facturaSetNew = attachedFacturaSetNew;
            pedido.setFacturaSet(facturaSetNew);
            pedido = em.merge(pedido);
            if (idEmpleadoOld != null && !idEmpleadoOld.equals(idEmpleadoNew)) {
                idEmpleadoOld.getPedidoSet().remove(pedido);
                idEmpleadoOld = em.merge(idEmpleadoOld);
            }
            if (idEmpleadoNew != null && !idEmpleadoNew.equals(idEmpleadoOld)) {
                idEmpleadoNew.getPedidoSet().add(pedido);
                idEmpleadoNew = em.merge(idEmpleadoNew);
            }
            for (ItemPedido itemPedidoSetNewItemPedido : itemPedidoSetNew) {
                if (!itemPedidoSetOld.contains(itemPedidoSetNewItemPedido)) {
                    Pedido oldPedidoOfItemPedidoSetNewItemPedido = itemPedidoSetNewItemPedido.getPedido();
                    itemPedidoSetNewItemPedido.setPedido(pedido);
                    itemPedidoSetNewItemPedido = em.merge(itemPedidoSetNewItemPedido);
                    if (oldPedidoOfItemPedidoSetNewItemPedido != null && !oldPedidoOfItemPedidoSetNewItemPedido.equals(pedido)) {
                        oldPedidoOfItemPedidoSetNewItemPedido.getItemPedidoSet().remove(itemPedidoSetNewItemPedido);
                        oldPedidoOfItemPedidoSetNewItemPedido = em.merge(oldPedidoOfItemPedidoSetNewItemPedido);
                    }
                }
            }
            for (Factura facturaSetNewFactura : facturaSetNew) {
                if (!facturaSetOld.contains(facturaSetNewFactura)) {
                    Pedido oldIdPedidoOfFacturaSetNewFactura = facturaSetNewFactura.getIdPedido();
                    facturaSetNewFactura.setIdPedido(pedido);
                    facturaSetNewFactura = em.merge(facturaSetNewFactura);
                    if (oldIdPedidoOfFacturaSetNewFactura != null && !oldIdPedidoOfFacturaSetNewFactura.equals(pedido)) {
                        oldIdPedidoOfFacturaSetNewFactura.getFacturaSet().remove(facturaSetNewFactura);
                        oldIdPedidoOfFacturaSetNewFactura = em.merge(oldIdPedidoOfFacturaSetNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pedido.getIdPedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
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
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<ItemPedido> itemPedidoSetOrphanCheck = pedido.getItemPedidoSet();
            for (ItemPedido itemPedidoSetOrphanCheckItemPedido : itemPedidoSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the ItemPedido " + itemPedidoSetOrphanCheckItemPedido + " in its itemPedidoSet field has a non-nullable pedido field.");
            }
            Set<Factura> facturaSetOrphanCheck = pedido.getFacturaSet();
            for (Factura facturaSetOrphanCheckFactura : facturaSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the Factura " + facturaSetOrphanCheckFactura + " in its facturaSet field has a non-nullable idPedido field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleado idEmpleado = pedido.getIdEmpleado();
            if (idEmpleado != null) {
                idEmpleado.getPedidoSet().remove(pedido);
                idEmpleado = em.merge(idEmpleado);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
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

    public Pedido findPedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
