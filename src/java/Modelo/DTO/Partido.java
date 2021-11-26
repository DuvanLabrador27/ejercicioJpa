/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duvan
 */
@Entity
@Table(name = "partido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
    , @NamedQuery(name = "Partido.findByNumeroFecha", query = "SELECT p FROM Partido p WHERE p.partidoPK.numeroFecha = :numeroFecha")
    , @NamedQuery(name = "Partido.findByGolesLocal", query = "SELECT p FROM Partido p WHERE p.golesLocal = :golesLocal")
    , @NamedQuery(name = "Partido.findByGolesVisitante", query = "SELECT p FROM Partido p WHERE p.golesVisitante = :golesVisitante")
    , @NamedQuery(name = "Partido.findByCiudad", query = "SELECT p FROM Partido p WHERE p.ciudad = :ciudad")
    , @NamedQuery(name = "Partido.findByArbitro", query = "SELECT p FROM Partido p WHERE p.arbitro = :arbitro")
    , @NamedQuery(name = "Partido.findByEstadio", query = "SELECT p FROM Partido p WHERE p.estadio = :estadio")
    , @NamedQuery(name = "Partido.findByEquipoLocal", query = "SELECT p FROM Partido p WHERE p.partidoPK.equipoLocal = :equipoLocal")
    , @NamedQuery(name = "Partido.findByEquipoVisitante", query = "SELECT p FROM Partido p WHERE p.partidoPK.equipoVisitante = :equipoVisitante")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PartidoPK partidoPK;
    @Basic(optional = false)
    @Column(name = "goles_local")
    private int golesLocal;
    @Basic(optional = false)
    @Column(name = "goles_visitante")
    private int golesVisitante;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "arbitro")
    private String arbitro;
    @Basic(optional = false)
    @Column(name = "estadio")
    private String estadio;
    @JoinColumn(name = "equipo_local", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo_local;
    @JoinColumn(name = "equipo_visitante", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo_visitante;

    public Partido() {
    }

    public Partido(PartidoPK partidoPK) {
        this.partidoPK = partidoPK;
    }

    public Partido(PartidoPK partidoPK, int golesLocal, int golesVisitante, String ciudad, String arbitro, String estadio) {
        this.partidoPK = partidoPK;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.ciudad = ciudad;
        this.arbitro = arbitro;
        this.estadio = estadio;
    }

    public Partido(int numeroFecha, int equipoLocal, int equipoVisitante) {
        this.partidoPK = new PartidoPK(numeroFecha, equipoLocal, equipoVisitante);
    }

    public PartidoPK getPartidoPK() {
        return partidoPK;
    }

    public void setPartidoPK(PartidoPK partidoPK) {
        this.partidoPK = partidoPK;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Equipo getEquipo_local() {
        return equipo_local;
    }

    public void setEquipo_local(Equipo equipo_local) {
        this.equipo_local = equipo_local;
    }

    public Equipo getEquipo_visitante() {
        return equipo_visitante;
    }

    public void setEquipo_visitante(Equipo equipo_visitante) {
        this.equipo_visitante = equipo_visitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partidoPK != null ? partidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.partidoPK == null && other.partidoPK != null) || (this.partidoPK != null && !this.partidoPK.equals(other.partidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DTO.Partido[ partidoPK=" + partidoPK + " ]";
    }
    
}
