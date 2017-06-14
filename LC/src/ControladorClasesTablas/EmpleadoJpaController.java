/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import ClasesTablas.Empleado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ClasesTablas.TurnosSemanales;
import java.util.HashSet;
import java.util.Set;
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
 * @author familia BS
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public String create(Empleado empleado) throws PreexistingEntityException, Exception {
        String resultado = "";
        if (empleado.getTurnosSemanalesSet() == null) {
            empleado.setTurnosSemanalesSet(new HashSet<TurnosSemanales>());
        }
        if (empleado.getPedidoSet() == null) {
            empleado.setPedidoSet(new HashSet<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<TurnosSemanales> attachedTurnosSemanalesSet = new HashSet<TurnosSemanales>();
            for (TurnosSemanales turnosSemanalesSetTurnosSemanalesToAttach : empleado.getTurnosSemanalesSet()) {
                turnosSemanalesSetTurnosSemanalesToAttach = em.getReference(turnosSemanalesSetTurnosSemanalesToAttach.getClass(), turnosSemanalesSetTurnosSemanalesToAttach.getId());
                attachedTurnosSemanalesSet.add(turnosSemanalesSetTurnosSemanalesToAttach);
            }
            empleado.setTurnosSemanalesSet(attachedTurnosSemanalesSet);
            Set<Pedido> attachedPedidoSet = new HashSet<Pedido>();
            for (Pedido pedidoSetPedidoToAttach : empleado.getPedidoSet()) {
                pedidoSetPedidoToAttach = em.getReference(pedidoSetPedidoToAttach.getClass(), pedidoSetPedidoToAttach.getIdPedido());
                attachedPedidoSet.add(pedidoSetPedidoToAttach);
            }
            empleado.setPedidoSet(attachedPedidoSet);
            em.persist(empleado);
            for (TurnosSemanales turnosSemanalesSetTurnosSemanales : empleado.getTurnosSemanalesSet()) {
                Empleado oldIdEmpleadoOfTurnosSemanalesSetTurnosSemanales = turnosSemanalesSetTurnosSemanales.getIdEmpleado();
                turnosSemanalesSetTurnosSemanales.setIdEmpleado(empleado);
                turnosSemanalesSetTurnosSemanales = em.merge(turnosSemanalesSetTurnosSemanales);
                if (oldIdEmpleadoOfTurnosSemanalesSetTurnosSemanales != null) {
                    oldIdEmpleadoOfTurnosSemanalesSetTurnosSemanales.getTurnosSemanalesSet().remove(turnosSemanalesSetTurnosSemanales);
                    oldIdEmpleadoOfTurnosSemanalesSetTurnosSemanales = em.merge(oldIdEmpleadoOfTurnosSemanalesSetTurnosSemanales);
                }
            }
            for (Pedido pedidoSetPedido : empleado.getPedidoSet()) {
                Empleado oldIdEmpleadoOfPedidoSetPedido = pedidoSetPedido.getIdEmpleado();
                pedidoSetPedido.setIdEmpleado(empleado);
                pedidoSetPedido = em.merge(pedidoSetPedido);
                if (oldIdEmpleadoOfPedidoSetPedido != null) {
                    oldIdEmpleadoOfPedidoSetPedido.getPedidoSet().remove(pedidoSetPedido);
                    oldIdEmpleadoOfPedidoSetPedido = em.merge(oldIdEmpleadoOfPedidoSetPedido);
                }
            }
            em.getTransaction().commit();
            resultado = "creado exitosamente";
        } catch (Exception ex) {
            if (findEmpleado(empleado.getIdEmpleado()) != null) {
                throw new PreexistingEntityException("Empleado " + empleado + " already exists.", ex);
            }
            resultado = "ya existe";
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return resultado;
    }

    public void edit(Empleado empleado) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getIdEmpleado());
            Set<TurnosSemanales> turnosSemanalesSetOld = persistentEmpleado.getTurnosSemanalesSet();
            Set<TurnosSemanales> turnosSemanalesSetNew = empleado.getTurnosSemanalesSet();
            Set<Pedido> pedidoSetOld = persistentEmpleado.getPedidoSet();
            Set<Pedido> pedidoSetNew = empleado.getPedidoSet();
            List<String> illegalOrphanMessages = null;
            for (TurnosSemanales turnosSemanalesSetOldTurnosSemanales : turnosSemanalesSetOld) {
                if (!turnosSemanalesSetNew.contains(turnosSemanalesSetOldTurnosSemanales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TurnosSemanales " + turnosSemanalesSetOldTurnosSemanales + " since its idEmpleado field is not nullable.");
                }
            }
            for (Pedido pedidoSetOldPedido : pedidoSetOld) {
                if (!pedidoSetNew.contains(pedidoSetOldPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedido " + pedidoSetOldPedido + " since its idEmpleado field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Set<TurnosSemanales> attachedTurnosSemanalesSetNew = new HashSet<TurnosSemanales>();
            for (TurnosSemanales turnosSemanalesSetNewTurnosSemanalesToAttach : turnosSemanalesSetNew) {
                turnosSemanalesSetNewTurnosSemanalesToAttach = em.getReference(turnosSemanalesSetNewTurnosSemanalesToAttach.getClass(), turnosSemanalesSetNewTurnosSemanalesToAttach.getId());
                attachedTurnosSemanalesSetNew.add(turnosSemanalesSetNewTurnosSemanalesToAttach);
            }
            turnosSemanalesSetNew = attachedTurnosSemanalesSetNew;
            empleado.setTurnosSemanalesSet(turnosSemanalesSetNew);
            Set<Pedido> attachedPedidoSetNew = new HashSet<Pedido>();
            for (Pedido pedidoSetNewPedidoToAttach : pedidoSetNew) {
                pedidoSetNewPedidoToAttach = em.getReference(pedidoSetNewPedidoToAttach.getClass(), pedidoSetNewPedidoToAttach.getIdPedido());
                attachedPedidoSetNew.add(pedidoSetNewPedidoToAttach);
            }
            pedidoSetNew = attachedPedidoSetNew;
            empleado.setPedidoSet(pedidoSetNew);
            empleado = em.merge(empleado);
            for (TurnosSemanales turnosSemanalesSetNewTurnosSemanales : turnosSemanalesSetNew) {
                if (!turnosSemanalesSetOld.contains(turnosSemanalesSetNewTurnosSemanales)) {
                    Empleado oldIdEmpleadoOfTurnosSemanalesSetNewTurnosSemanales = turnosSemanalesSetNewTurnosSemanales.getIdEmpleado();
                    turnosSemanalesSetNewTurnosSemanales.setIdEmpleado(empleado);
                    turnosSemanalesSetNewTurnosSemanales = em.merge(turnosSemanalesSetNewTurnosSemanales);
                    if (oldIdEmpleadoOfTurnosSemanalesSetNewTurnosSemanales != null && !oldIdEmpleadoOfTurnosSemanalesSetNewTurnosSemanales.equals(empleado)) {
                        oldIdEmpleadoOfTurnosSemanalesSetNewTurnosSemanales.getTurnosSemanalesSet().remove(turnosSemanalesSetNewTurnosSemanales);
                        oldIdEmpleadoOfTurnosSemanalesSetNewTurnosSemanales = em.merge(oldIdEmpleadoOfTurnosSemanalesSetNewTurnosSemanales);
                    }
                }
            }
            for (Pedido pedidoSetNewPedido : pedidoSetNew) {
                if (!pedidoSetOld.contains(pedidoSetNewPedido)) {
                    Empleado oldIdEmpleadoOfPedidoSetNewPedido = pedidoSetNewPedido.getIdEmpleado();
                    pedidoSetNewPedido.setIdEmpleado(empleado);
                    pedidoSetNewPedido = em.merge(pedidoSetNewPedido);
                    if (oldIdEmpleadoOfPedidoSetNewPedido != null && !oldIdEmpleadoOfPedidoSetNewPedido.equals(empleado)) {
                        oldIdEmpleadoOfPedidoSetNewPedido.getPedidoSet().remove(pedidoSetNewPedido);
                        oldIdEmpleadoOfPedidoSetNewPedido = em.merge(oldIdEmpleadoOfPedidoSetNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleado.getIdEmpleado();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getIdEmpleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<TurnosSemanales> turnosSemanalesSetOrphanCheck = empleado.getTurnosSemanalesSet();
            for (TurnosSemanales turnosSemanalesSetOrphanCheckTurnosSemanales : turnosSemanalesSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleado (" + empleado + ") cannot be destroyed since the TurnosSemanales " + turnosSemanalesSetOrphanCheckTurnosSemanales + " in its turnosSemanalesSet field has a non-nullable idEmpleado field.");
            }
            Set<Pedido> pedidoSetOrphanCheck = empleado.getPedidoSet();
            for (Pedido pedidoSetOrphanCheckPedido : pedidoSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleado (" + empleado + ") cannot be destroyed since the Pedido " + pedidoSetOrphanCheckPedido + " in its pedidoSet field has a non-nullable idEmpleado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
