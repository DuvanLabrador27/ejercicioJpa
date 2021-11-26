/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.DTO.Equipo;
import Modelo.DTO.Jugador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Duvan
 */
public class JugadorJpaController implements Serializable {

    public JugadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jugador jugador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo equipoCodigo = jugador.getEquipoCodigo();
            if (equipoCodigo != null) {
                equipoCodigo = em.getReference(equipoCodigo.getClass(), equipoCodigo.getCodigo());
                jugador.setEquipoCodigo(equipoCodigo);
            }
            em.persist(jugador);
            if (equipoCodigo != null) {
                equipoCodigo.getJugadorList().add(jugador);
                equipoCodigo = em.merge(equipoCodigo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Jugador jugador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador persistentJugador = em.find(Jugador.class, jugador.getCodigoJugador());
            Equipo equipoCodigoOld = persistentJugador.getEquipoCodigo();
            Equipo equipoCodigoNew = jugador.getEquipoCodigo();
            if (equipoCodigoNew != null) {
                equipoCodigoNew = em.getReference(equipoCodigoNew.getClass(), equipoCodigoNew.getCodigo());
                jugador.setEquipoCodigo(equipoCodigoNew);
            }
            jugador = em.merge(jugador);
            if (equipoCodigoOld != null && !equipoCodigoOld.equals(equipoCodigoNew)) {
                equipoCodigoOld.getJugadorList().remove(jugador);
                equipoCodigoOld = em.merge(equipoCodigoOld);
            }
            if (equipoCodigoNew != null && !equipoCodigoNew.equals(equipoCodigoOld)) {
                equipoCodigoNew.getJugadorList().add(jugador);
                equipoCodigoNew = em.merge(equipoCodigoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = jugador.getCodigoJugador();
                if (findJugador(id) == null) {
                    throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.");
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
            Jugador jugador;
            try {
                jugador = em.getReference(Jugador.class, id);
                jugador.getCodigoJugador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.", enfe);
            }
            Equipo equipoCodigo = jugador.getEquipoCodigo();
            if (equipoCodigo != null) {
                equipoCodigo.getJugadorList().remove(jugador);
                equipoCodigo = em.merge(equipoCodigo);
            }
            em.remove(jugador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Jugador> findJugadorEntities() {
        return findJugadorEntities(true, -1, -1);
    }

    public List<Jugador> findJugadorEntities(int maxResults, int firstResult) {
        return findJugadorEntities(false, maxResults, firstResult);
    }

    private List<Jugador> findJugadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jugador.class));
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

    public Jugador findJugador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jugador.class, id);
        } finally {
            em.close();
        }
    }

    public int getJugadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jugador> rt = cq.from(Jugador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Jugador> findJugadorXEquipo(int equipoCodigo) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT j FROM Jugador j WHERE j.equipoCodigo = :equipoCodigo").setParameter("equipoCodigo", equipoCodigo).getResultList();
        } finally {
            em.close();
        }
    }

}
