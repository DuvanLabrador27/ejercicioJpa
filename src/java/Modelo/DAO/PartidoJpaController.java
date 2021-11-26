/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DAO.exceptions.NonexistentEntityException;
import Modelo.DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.DTO.Equipo;
import Modelo.DTO.Partido;
import Modelo.DTO.PartidoPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Duvan
 */
public class PartidoJpaController implements Serializable {

    public PartidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Partido partido) throws PreexistingEntityException, Exception {
        if (partido.getPartidoPK() == null) {
            partido.setPartidoPK(new PartidoPK());
        }
        partido.getPartidoPK().setEquipoVisitante(partido.getEquipo_visitante().getCodigo());
        partido.getPartidoPK().setEquipoLocal(partido.getEquipo_local().getCodigo());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo equipo = partido.getEquipo_local();
            if (equipo != null) {
                equipo = em.getReference(equipo.getClass(), equipo.getCodigo());
                partido.setEquipo_local(equipo);
            }
            Equipo equipo1 = partido.getEquipo_visitante();
            if (equipo1 != null) {
                equipo1 = em.getReference(equipo1.getClass(), equipo1.getCodigo());
                partido.setEquipo_visitante(equipo1);
            }
            em.persist(partido);
            if (equipo != null) {
                equipo.getPartidoList().add(partido);
                equipo = em.merge(equipo);
            }
            if (equipo1 != null) {
                equipo1.getPartidoList().add(partido);
                equipo1 = em.merge(equipo1);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPartido(partido.getPartidoPK()) != null) {
                throw new PreexistingEntityException("Partido " + partido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Partido partido) throws NonexistentEntityException, Exception {
        partido.getPartidoPK().setEquipoVisitante(partido.getEquipo_visitante().getCodigo());
        partido.getPartidoPK().setEquipoLocal(partido.getEquipo_local().getCodigo());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Partido persistentPartido = em.find(Partido.class, partido.getPartidoPK());
            Equipo equipoOld = persistentPartido.getEquipo_local();
            Equipo equipoNew = partido.getEquipo_local();
            Equipo equipo1Old = persistentPartido.getEquipo_visitante();
            Equipo equipo1New = partido.getEquipo_visitante();
            if (equipoNew != null) {
                equipoNew = em.getReference(equipoNew.getClass(), equipoNew.getCodigo());
                partido.setEquipo_local(equipoNew);
            }
            if (equipo1New != null) {
                equipo1New = em.getReference(equipo1New.getClass(), equipo1New.getCodigo());
                partido.setEquipo_visitante(equipo1New);
            }
            partido = em.merge(partido);
            if (equipoOld != null && !equipoOld.equals(equipoNew)) {
                equipoOld.getPartidoList().remove(partido);
                equipoOld = em.merge(equipoOld);
            }
            if (equipoNew != null && !equipoNew.equals(equipoOld)) {
                equipoNew.getPartidoList().add(partido);
                equipoNew = em.merge(equipoNew);
            }
            if (equipo1Old != null && !equipo1Old.equals(equipo1New)) {
                equipo1Old.getPartidoList().remove(partido);
                equipo1Old = em.merge(equipo1Old);
            }
            if (equipo1New != null && !equipo1New.equals(equipo1Old)) {
                equipo1New.getPartidoList().add(partido);
                equipo1New = em.merge(equipo1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PartidoPK id = partido.getPartidoPK();
                if (findPartido(id) == null) {
                    throw new NonexistentEntityException("The partido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PartidoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Partido partido;
            try {
                partido = em.getReference(Partido.class, id);
                partido.getPartidoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The partido with id " + id + " no longer exists.", enfe);
            }
            Equipo equipo = partido.getEquipo_local();
            if (equipo != null) {
                equipo.getPartidoList().remove(partido);
                equipo = em.merge(equipo);
            }
            Equipo equipo1 = partido.getEquipo_visitante();
            if (equipo1 != null) {
                equipo1.getPartidoList().remove(partido);
                equipo1 = em.merge(equipo1);
            }
            em.remove(partido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Partido> findPartidoEntities() {
        return findPartidoEntities(true, -1, -1);
    }

    public List<Partido> findPartidoEntities(int maxResults, int firstResult) {
        return findPartidoEntities(false, maxResults, firstResult);
    }

    private List<Partido> findPartidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Partido.class));
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

    public Partido findPartido(PartidoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Partido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPartidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Partido> rt = cq.from(Partido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
