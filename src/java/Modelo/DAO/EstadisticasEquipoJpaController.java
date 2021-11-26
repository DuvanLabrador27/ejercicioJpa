/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DAO.exceptions.IllegalOrphanException;
import Modelo.DAO.exceptions.NonexistentEntityException;
import Modelo.DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.DTO.Equipo;
import Modelo.DTO.EstadisticasEquipo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Duvan
 */
public class EstadisticasEquipoJpaController implements Serializable {

    public EstadisticasEquipoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadisticasEquipo estadisticasEquipo) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Equipo equipoOrphanCheck = estadisticasEquipo.getEquipo();
        if (equipoOrphanCheck != null) {
            EstadisticasEquipo oldEstadisticasEquipoOfEquipo = equipoOrphanCheck.getEstadisticasEquipo();
            if (oldEstadisticasEquipoOfEquipo != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Equipo " + equipoOrphanCheck + " already has an item of type EstadisticasEquipo whose equipo column cannot be null. Please make another selection for the equipo field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo equipo = estadisticasEquipo.getEquipo();
            if (equipo != null) {
                equipo = em.getReference(equipo.getClass(), equipo.getCodigo());
                estadisticasEquipo.setEquipo(equipo);
            }
            em.persist(estadisticasEquipo);
            if (equipo != null) {
                equipo.setEstadisticasEquipo(estadisticasEquipo);
                equipo = em.merge(equipo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstadisticasEquipo(estadisticasEquipo.getEquipoCodigo()) != null) {
                throw new PreexistingEntityException("EstadisticasEquipo " + estadisticasEquipo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadisticasEquipo estadisticasEquipo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadisticasEquipo persistentEstadisticasEquipo = em.find(EstadisticasEquipo.class, estadisticasEquipo.getEquipoCodigo());
            Equipo equipoOld = persistentEstadisticasEquipo.getEquipo();
            Equipo equipoNew = estadisticasEquipo.getEquipo();
            List<String> illegalOrphanMessages = null;
            if (equipoNew != null && !equipoNew.equals(equipoOld)) {
                EstadisticasEquipo oldEstadisticasEquipoOfEquipo = equipoNew.getEstadisticasEquipo();
                if (oldEstadisticasEquipoOfEquipo != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Equipo " + equipoNew + " already has an item of type EstadisticasEquipo whose equipo column cannot be null. Please make another selection for the equipo field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (equipoNew != null) {
                equipoNew = em.getReference(equipoNew.getClass(), equipoNew.getCodigo());
                estadisticasEquipo.setEquipo(equipoNew);
            }
            estadisticasEquipo = em.merge(estadisticasEquipo);
            if (equipoOld != null && !equipoOld.equals(equipoNew)) {
                equipoOld.setEstadisticasEquipo(null);
                equipoOld = em.merge(equipoOld);
            }
            if (equipoNew != null && !equipoNew.equals(equipoOld)) {
                equipoNew.setEstadisticasEquipo(estadisticasEquipo);
                equipoNew = em.merge(equipoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estadisticasEquipo.getEquipoCodigo();
                if (findEstadisticasEquipo(id) == null) {
                    throw new NonexistentEntityException("The estadisticasEquipo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadisticasEquipo estadisticasEquipo;
            try {
                estadisticasEquipo = em.getReference(EstadisticasEquipo.class, id);
                estadisticasEquipo.getEquipoCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadisticasEquipo with id " + id + " no longer exists.", enfe);
            }
            Equipo equipo = estadisticasEquipo.getEquipo();
            if (equipo != null) {
                equipo.setEstadisticasEquipo(null);
                equipo = em.merge(equipo);
            }
            em.remove(estadisticasEquipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadisticasEquipo> findEstadisticasEquipoEntities() {
        return findEstadisticasEquipoEntities(true, -1, -1);
    }

    public List<EstadisticasEquipo> findEstadisticasEquipoEntities(int maxResults, int firstResult) {
        return findEstadisticasEquipoEntities(false, maxResults, firstResult);
    }

    private List<EstadisticasEquipo> findEstadisticasEquipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadisticasEquipo.class));
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

    public EstadisticasEquipo findEstadisticasEquipo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadisticasEquipo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadisticasEquipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadisticasEquipo> rt = cq.from(EstadisticasEquipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<EstadisticasEquipo> sort() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM EstadisticasEquipo e ORDER BY e.puntos DESC").getResultList();
        } finally {
            em.close();
        }
    }
}
