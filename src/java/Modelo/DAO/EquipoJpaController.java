/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DAO.exceptions.IllegalOrphanException;
import Modelo.DAO.exceptions.NonexistentEntityException;
import Modelo.DTO.Equipo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.DTO.EstadisticasEquipo;
import Modelo.DTO.Jugador;
import java.util.ArrayList;
import java.util.List;
import Modelo.DTO.Partido;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Duvan
 */
public class EquipoJpaController implements Serializable {

    public EquipoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Equipo equipo) {
        if (equipo.getJugadorList() == null) {
            equipo.setJugadorList(new ArrayList<Jugador>());
        }
        if (equipo.getPartidoList() == null) {
            equipo.setPartidoList(new ArrayList<Partido>());
        }
        if (equipo.getPartidoList1() == null) {
            equipo.setPartidoList1(new ArrayList<Partido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadisticasEquipo estadisticasEquipo = equipo.getEstadisticasEquipo();
            if (estadisticasEquipo != null) {
                estadisticasEquipo = em.getReference(estadisticasEquipo.getClass(), estadisticasEquipo.getEquipoCodigo());
                equipo.setEstadisticasEquipo(estadisticasEquipo);
            }
            List<Jugador> attachedJugadorList = new ArrayList<Jugador>();
            for (Jugador jugadorListJugadorToAttach : equipo.getJugadorList()) {
                jugadorListJugadorToAttach = em.getReference(jugadorListJugadorToAttach.getClass(), jugadorListJugadorToAttach.getCodigoJugador());
                attachedJugadorList.add(jugadorListJugadorToAttach);
            }
            equipo.setJugadorList(attachedJugadorList);
            List<Partido> attachedPartidoList = new ArrayList<Partido>();
            for (Partido partidoListPartidoToAttach : equipo.getPartidoList()) {
                partidoListPartidoToAttach = em.getReference(partidoListPartidoToAttach.getClass(), partidoListPartidoToAttach.getPartidoPK());
                attachedPartidoList.add(partidoListPartidoToAttach);
            }
            equipo.setPartidoList(attachedPartidoList);
            List<Partido> attachedPartidoList1 = new ArrayList<Partido>();
            for (Partido partidoList1PartidoToAttach : equipo.getPartidoList1()) {
                partidoList1PartidoToAttach = em.getReference(partidoList1PartidoToAttach.getClass(), partidoList1PartidoToAttach.getPartidoPK());
                attachedPartidoList1.add(partidoList1PartidoToAttach);
            }
            equipo.setPartidoList1(attachedPartidoList1);
            em.persist(equipo);
            if (estadisticasEquipo != null) {
                Equipo oldEquipoOfEstadisticasEquipo = estadisticasEquipo.getEquipo();
                if (oldEquipoOfEstadisticasEquipo != null) {
                    oldEquipoOfEstadisticasEquipo.setEstadisticasEquipo(null);
                    oldEquipoOfEstadisticasEquipo = em.merge(oldEquipoOfEstadisticasEquipo);
                }
                estadisticasEquipo.setEquipo(equipo);
                estadisticasEquipo = em.merge(estadisticasEquipo);
            }
            for (Jugador jugadorListJugador : equipo.getJugadorList()) {
                Equipo oldEquipoCodigoOfJugadorListJugador = jugadorListJugador.getEquipoCodigo();
                jugadorListJugador.setEquipoCodigo(equipo);
                jugadorListJugador = em.merge(jugadorListJugador);
                if (oldEquipoCodigoOfJugadorListJugador != null) {
                    oldEquipoCodigoOfJugadorListJugador.getJugadorList().remove(jugadorListJugador);
                    oldEquipoCodigoOfJugadorListJugador = em.merge(oldEquipoCodigoOfJugadorListJugador);
                }
            }
            for (Partido partidoListPartido : equipo.getPartidoList()) {
                Equipo oldEquipoOfPartidoListPartido = partidoListPartido.getEquipo_local();
                partidoListPartido.setEquipo_local(equipo);
                partidoListPartido = em.merge(partidoListPartido);
                if (oldEquipoOfPartidoListPartido != null) {
                    oldEquipoOfPartidoListPartido.getPartidoList().remove(partidoListPartido);
                    oldEquipoOfPartidoListPartido = em.merge(oldEquipoOfPartidoListPartido);
                }
            }
            for (Partido partidoList1Partido : equipo.getPartidoList1()) {
                Equipo oldEquipo1OfPartidoList1Partido = partidoList1Partido.getEquipo_visitante();
                partidoList1Partido.setEquipo_visitante(equipo);
                partidoList1Partido = em.merge(partidoList1Partido);
                if (oldEquipo1OfPartidoList1Partido != null) {
                    oldEquipo1OfPartidoList1Partido.getPartidoList1().remove(partidoList1Partido);
                    oldEquipo1OfPartidoList1Partido = em.merge(oldEquipo1OfPartidoList1Partido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Equipo equipo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo persistentEquipo = em.find(Equipo.class, equipo.getCodigo());
            EstadisticasEquipo estadisticasEquipoOld = persistentEquipo.getEstadisticasEquipo();
            EstadisticasEquipo estadisticasEquipoNew = equipo.getEstadisticasEquipo();
            List<Jugador> jugadorListOld = persistentEquipo.getJugadorList();
            List<Jugador> jugadorListNew = equipo.getJugadorList();
            List<Partido> partidoListOld = persistentEquipo.getPartidoList();
            List<Partido> partidoListNew = equipo.getPartidoList();
            List<Partido> partidoList1Old = persistentEquipo.getPartidoList1();
            List<Partido> partidoList1New = equipo.getPartidoList1();
            List<String> illegalOrphanMessages = null;
            if (estadisticasEquipoOld != null && !estadisticasEquipoOld.equals(estadisticasEquipoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain EstadisticasEquipo " + estadisticasEquipoOld + " since its equipo field is not nullable.");
            }
            for (Jugador jugadorListOldJugador : jugadorListOld) {
                if (!jugadorListNew.contains(jugadorListOldJugador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Jugador " + jugadorListOldJugador + " since its equipoCodigo field is not nullable.");
                }
            }
            for (Partido partidoListOldPartido : partidoListOld) {
                if (!partidoListNew.contains(partidoListOldPartido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Partido " + partidoListOldPartido + " since its equipo field is not nullable.");
                }
            }
            for (Partido partidoList1OldPartido : partidoList1Old) {
                if (!partidoList1New.contains(partidoList1OldPartido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Partido " + partidoList1OldPartido + " since its equipo1 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (estadisticasEquipoNew != null) {
                estadisticasEquipoNew = em.getReference(estadisticasEquipoNew.getClass(), estadisticasEquipoNew.getEquipoCodigo());
                equipo.setEstadisticasEquipo(estadisticasEquipoNew);
            }
            List<Jugador> attachedJugadorListNew = new ArrayList<Jugador>();
            for (Jugador jugadorListNewJugadorToAttach : jugadorListNew) {
                jugadorListNewJugadorToAttach = em.getReference(jugadorListNewJugadorToAttach.getClass(), jugadorListNewJugadorToAttach.getCodigoJugador());
                attachedJugadorListNew.add(jugadorListNewJugadorToAttach);
            }
            jugadorListNew = attachedJugadorListNew;
            equipo.setJugadorList(jugadorListNew);
            List<Partido> attachedPartidoListNew = new ArrayList<Partido>();
            for (Partido partidoListNewPartidoToAttach : partidoListNew) {
                partidoListNewPartidoToAttach = em.getReference(partidoListNewPartidoToAttach.getClass(), partidoListNewPartidoToAttach.getPartidoPK());
                attachedPartidoListNew.add(partidoListNewPartidoToAttach);
            }
            partidoListNew = attachedPartidoListNew;
            equipo.setPartidoList(partidoListNew);
            List<Partido> attachedPartidoList1New = new ArrayList<Partido>();
            for (Partido partidoList1NewPartidoToAttach : partidoList1New) {
                partidoList1NewPartidoToAttach = em.getReference(partidoList1NewPartidoToAttach.getClass(), partidoList1NewPartidoToAttach.getPartidoPK());
                attachedPartidoList1New.add(partidoList1NewPartidoToAttach);
            }
            partidoList1New = attachedPartidoList1New;
            equipo.setPartidoList1(partidoList1New);
            equipo = em.merge(equipo);
            if (estadisticasEquipoNew != null && !estadisticasEquipoNew.equals(estadisticasEquipoOld)) {
                Equipo oldEquipoOfEstadisticasEquipo = estadisticasEquipoNew.getEquipo();
                if (oldEquipoOfEstadisticasEquipo != null) {
                    oldEquipoOfEstadisticasEquipo.setEstadisticasEquipo(null);
                    oldEquipoOfEstadisticasEquipo = em.merge(oldEquipoOfEstadisticasEquipo);
                }
                estadisticasEquipoNew.setEquipo(equipo);
                estadisticasEquipoNew = em.merge(estadisticasEquipoNew);
            }
            for (Jugador jugadorListNewJugador : jugadorListNew) {
                if (!jugadorListOld.contains(jugadorListNewJugador)) {
                    Equipo oldEquipoCodigoOfJugadorListNewJugador = jugadorListNewJugador.getEquipoCodigo();
                    jugadorListNewJugador.setEquipoCodigo(equipo);
                    jugadorListNewJugador = em.merge(jugadorListNewJugador);
                    if (oldEquipoCodigoOfJugadorListNewJugador != null && !oldEquipoCodigoOfJugadorListNewJugador.equals(equipo)) {
                        oldEquipoCodigoOfJugadorListNewJugador.getJugadorList().remove(jugadorListNewJugador);
                        oldEquipoCodigoOfJugadorListNewJugador = em.merge(oldEquipoCodigoOfJugadorListNewJugador);
                    }
                }
            }
            for (Partido partidoListNewPartido : partidoListNew) {
                if (!partidoListOld.contains(partidoListNewPartido)) {
                    Equipo oldEquipoOfPartidoListNewPartido = partidoListNewPartido.getEquipo_local();
                    partidoListNewPartido.setEquipo_local(equipo);
                    partidoListNewPartido = em.merge(partidoListNewPartido);
                    if (oldEquipoOfPartidoListNewPartido != null && !oldEquipoOfPartidoListNewPartido.equals(equipo)) {
                        oldEquipoOfPartidoListNewPartido.getPartidoList().remove(partidoListNewPartido);
                        oldEquipoOfPartidoListNewPartido = em.merge(oldEquipoOfPartidoListNewPartido);
                    }
                }
            }
            for (Partido partidoList1NewPartido : partidoList1New) {
                if (!partidoList1Old.contains(partidoList1NewPartido)) {
                    Equipo oldEquipo1OfPartidoList1NewPartido = partidoList1NewPartido.getEquipo_visitante();
                    partidoList1NewPartido.setEquipo_visitante(equipo);
                    partidoList1NewPartido = em.merge(partidoList1NewPartido);
                    if (oldEquipo1OfPartidoList1NewPartido != null && !oldEquipo1OfPartidoList1NewPartido.equals(equipo)) {
                        oldEquipo1OfPartidoList1NewPartido.getPartidoList1().remove(partidoList1NewPartido);
                        oldEquipo1OfPartidoList1NewPartido = em.merge(oldEquipo1OfPartidoList1NewPartido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = equipo.getCodigo();
                if (findEquipo(id) == null) {
                    throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.");
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
            Equipo equipo;
            try {
                equipo = em.getReference(Equipo.class, id);
                equipo.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            EstadisticasEquipo estadisticasEquipoOrphanCheck = equipo.getEstadisticasEquipo();
            if (estadisticasEquipoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the EstadisticasEquipo " + estadisticasEquipoOrphanCheck + " in its estadisticasEquipo field has a non-nullable equipo field.");
            }
            List<Jugador> jugadorListOrphanCheck = equipo.getJugadorList();
            for (Jugador jugadorListOrphanCheckJugador : jugadorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the Jugador " + jugadorListOrphanCheckJugador + " in its jugadorList field has a non-nullable equipoCodigo field.");
            }
            List<Partido> partidoListOrphanCheck = equipo.getPartidoList();
            for (Partido partidoListOrphanCheckPartido : partidoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the Partido " + partidoListOrphanCheckPartido + " in its partidoList field has a non-nullable equipo field.");
            }
            List<Partido> partidoList1OrphanCheck = equipo.getPartidoList1();
            for (Partido partidoList1OrphanCheckPartido : partidoList1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the Partido " + partidoList1OrphanCheckPartido + " in its partidoList1 field has a non-nullable equipo1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(equipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Equipo> findEquipoEntities() {
        return findEquipoEntities(true, -1, -1);
    }

    public List<Equipo> findEquipoEntities(int maxResults, int firstResult) {
        return findEquipoEntities(false, maxResults, firstResult);
    }

    private List<Equipo> findEquipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipo.class));
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

    public Equipo findEquipo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipo> rt = cq.from(Equipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
