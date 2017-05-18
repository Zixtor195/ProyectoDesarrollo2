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
import ClasesTablas.Pedido;
import ClasesTablas.Item;
import ClasesTablas.ItemPedido;
import ClasesTablas.ItemPedidoPK;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import ControladorClasesTablas.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class ItemPedidoJpaController implements Serializable {

    public ItemPedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemPedido itemPedido) throws PreexistingEntityException, Exception {
        if (itemPedido.getItemPedidoPK() == null) {
            itemPedido.setItemPedidoPK(new ItemPedidoPK());
        }
        itemPedido.getItemPedidoPK().setIdItem(itemPedido.getItem().getIdItem());
        itemPedido.getItemPedidoPK().setIdPedido(itemPedido.getPedido().getIdPedido());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido pedido = itemPedido.getPedido();
            if (pedido != null) {
                pedido = em.getReference(pedido.getClass(), pedido.getIdPedido());
                itemPedido.setPedido(pedido);
            }
            Item item = itemPedido.getItem();
            if (item != null) {
                item = em.getReference(item.getClass(), item.getIdItem());
                itemPedido.setItem(item);
            }
            em.persist(itemPedido);
            if (pedido != null) {
                pedido.getItemPedidoSet().add(itemPedido);
                pedido = em.merge(pedido);
            }
            if (item != null) {
                item.getItemPedidoSet().add(itemPedido);
                item = em.merge(item);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItemPedido(itemPedido.getItemPedidoPK()) != null) {
                throw new PreexistingEntityException("ItemPedido " + itemPedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemPedido itemPedido) throws NonexistentEntityException, Exception {
        itemPedido.getItemPedidoPK().setIdItem(itemPedido.getItem().getIdItem());
        itemPedido.getItemPedidoPK().setIdPedido(itemPedido.getPedido().getIdPedido());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemPedido persistentItemPedido = em.find(ItemPedido.class, itemPedido.getItemPedidoPK());
            Pedido pedidoOld = persistentItemPedido.getPedido();
            Pedido pedidoNew = itemPedido.getPedido();
            Item itemOld = persistentItemPedido.getItem();
            Item itemNew = itemPedido.getItem();
            if (pedidoNew != null) {
                pedidoNew = em.getReference(pedidoNew.getClass(), pedidoNew.getIdPedido());
                itemPedido.setPedido(pedidoNew);
            }
            if (itemNew != null) {
                itemNew = em.getReference(itemNew.getClass(), itemNew.getIdItem());
                itemPedido.setItem(itemNew);
            }
            itemPedido = em.merge(itemPedido);
            if (pedidoOld != null && !pedidoOld.equals(pedidoNew)) {
                pedidoOld.getItemPedidoSet().remove(itemPedido);
                pedidoOld = em.merge(pedidoOld);
            }
            if (pedidoNew != null && !pedidoNew.equals(pedidoOld)) {
                pedidoNew.getItemPedidoSet().add(itemPedido);
                pedidoNew = em.merge(pedidoNew);
            }
            if (itemOld != null && !itemOld.equals(itemNew)) {
                itemOld.getItemPedidoSet().remove(itemPedido);
                itemOld = em.merge(itemOld);
            }
            if (itemNew != null && !itemNew.equals(itemOld)) {
                itemNew.getItemPedidoSet().add(itemPedido);
                itemNew = em.merge(itemNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ItemPedidoPK id = itemPedido.getItemPedidoPK();
                if (findItemPedido(id) == null) {
                    throw new NonexistentEntityException("The itemPedido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ItemPedidoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemPedido itemPedido;
            try {
                itemPedido = em.getReference(ItemPedido.class, id);
                itemPedido.getItemPedidoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemPedido with id " + id + " no longer exists.", enfe);
            }
            Pedido pedido = itemPedido.getPedido();
            if (pedido != null) {
                pedido.getItemPedidoSet().remove(itemPedido);
                pedido = em.merge(pedido);
            }
            Item item = itemPedido.getItem();
            if (item != null) {
                item.getItemPedidoSet().remove(itemPedido);
                item = em.merge(item);
            }
            em.remove(itemPedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemPedido> findItemPedidoEntities() {
        return findItemPedidoEntities(true, -1, -1);
    }

    public List<ItemPedido> findItemPedidoEntities(int maxResults, int firstResult) {
        return findItemPedidoEntities(false, maxResults, firstResult);
    }

    private List<ItemPedido> findItemPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemPedido.class));
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

    public ItemPedido findItemPedido(ItemPedidoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemPedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemPedido> rt = cq.from(ItemPedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
