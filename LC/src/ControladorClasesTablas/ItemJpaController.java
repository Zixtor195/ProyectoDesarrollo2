/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import ClasesTablas.Item;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ClasesTablas.ItemPedido;
import ControladorClasesTablas.exceptions.IllegalOrphanException;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author familia BS
 */
public class ItemJpaController implements Serializable {

    public ItemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Item item) {
        if (item.getItemPedidoSet() == null) {
            item.setItemPedidoSet(new ArrayList<ItemPedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ItemPedido> attachedItemPedidoSet = new ArrayList<ItemPedido>();
            for (ItemPedido itemPedidoSetItemPedidoToAttach : item.getItemPedidoSet()) {
                itemPedidoSetItemPedidoToAttach = em.getReference(itemPedidoSetItemPedidoToAttach.getClass(), itemPedidoSetItemPedidoToAttach.getItemPedidoPK());
                attachedItemPedidoSet.add(itemPedidoSetItemPedidoToAttach);
            }
            item.setItemPedidoSet(attachedItemPedidoSet);
            em.persist(item);
            for (ItemPedido itemPedidoSetItemPedido : item.getItemPedidoSet()) {
                Item oldItemOfItemPedidoSetItemPedido = itemPedidoSetItemPedido.getItem();
                itemPedidoSetItemPedido.setItem(item);
                itemPedidoSetItemPedido = em.merge(itemPedidoSetItemPedido);
                if (oldItemOfItemPedidoSetItemPedido != null) {
                    oldItemOfItemPedidoSetItemPedido.getItemPedidoSet().remove(itemPedidoSetItemPedido);
                    oldItemOfItemPedidoSetItemPedido = em.merge(oldItemOfItemPedidoSetItemPedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Item item) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Item persistentItem = em.find(Item.class, item.getIdItem());
            List<ItemPedido> itemPedidoSetOld = persistentItem.getItemPedidoSet();
            List<ItemPedido> itemPedidoSetNew = item.getItemPedidoSet();
            List<String> illegalOrphanMessages = null;
            for (ItemPedido itemPedidoSetOldItemPedido : itemPedidoSetOld) {
                if (!itemPedidoSetNew.contains(itemPedidoSetOldItemPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItemPedido " + itemPedidoSetOldItemPedido + " since its item field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ItemPedido> attachedItemPedidoSetNew = new ArrayList<ItemPedido>();
            for (ItemPedido itemPedidoSetNewItemPedidoToAttach : itemPedidoSetNew) {
                itemPedidoSetNewItemPedidoToAttach = em.getReference(itemPedidoSetNewItemPedidoToAttach.getClass(), itemPedidoSetNewItemPedidoToAttach.getItemPedidoPK());
                attachedItemPedidoSetNew.add(itemPedidoSetNewItemPedidoToAttach);
            }
            itemPedidoSetNew = attachedItemPedidoSetNew;
            item.setItemPedidoSet(itemPedidoSetNew);
            item = em.merge(item);
            for (ItemPedido itemPedidoSetNewItemPedido : itemPedidoSetNew) {
                if (!itemPedidoSetOld.contains(itemPedidoSetNewItemPedido)) {
                    Item oldItemOfItemPedidoSetNewItemPedido = itemPedidoSetNewItemPedido.getItem();
                    itemPedidoSetNewItemPedido.setItem(item);
                    itemPedidoSetNewItemPedido = em.merge(itemPedidoSetNewItemPedido);
                    if (oldItemOfItemPedidoSetNewItemPedido != null && !oldItemOfItemPedidoSetNewItemPedido.equals(item)) {
                        oldItemOfItemPedidoSetNewItemPedido.getItemPedidoSet().remove(itemPedidoSetNewItemPedido);
                        oldItemOfItemPedidoSetNewItemPedido = em.merge(oldItemOfItemPedidoSetNewItemPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = item.getIdItem();
                if (findItem(id) == null) {
                    throw new NonexistentEntityException("The item with id " + id + " no longer exists.");
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
            Item item;
            try {
                item = em.getReference(Item.class, id);
                item.getIdItem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The item with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ItemPedido> itemPedidoSetOrphanCheck = item.getItemPedidoSet();
            for (ItemPedido itemPedidoSetOrphanCheckItemPedido : itemPedidoSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Item (" + item + ") cannot be destroyed since the ItemPedido " + itemPedidoSetOrphanCheckItemPedido + " in its itemPedidoSet field has a non-nullable item field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(item);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Item> findItemEntities() {
        return findItemEntities(true, -1, -1);
    }

    public List<Item> findItemEntities(int maxResults, int firstResult) {
        return findItemEntities(false, maxResults, firstResult);
    }

    private List<Item> findItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Item.class));
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

    public Item findItem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Item.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Item> rt = cq.from(Item.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
