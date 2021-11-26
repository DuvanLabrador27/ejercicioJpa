/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duvan
 */
@Entity
@Table(name = "estadisticas_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadisticasEquipo.findAll", query = "SELECT e FROM EstadisticasEquipo e")
    , @NamedQuery(name = "EstadisticasEquipo.findByGolesFavor", query = "SELECT e FROM EstadisticasEquipo e WHERE e.golesFavor = :golesFavor")
    , @NamedQuery(name = "EstadisticasEquipo.findByGolesContra", query = "SELECT e FROM EstadisticasEquipo e WHERE e.golesContra = :golesContra")
    , @NamedQuery(name = "EstadisticasEquipo.findByDiferenciaGoles", query = "SELECT e FROM EstadisticasEquipo e WHERE e.diferenciaGoles = :diferenciaGoles")
    , @NamedQuery(name = "EstadisticasEquipo.findByPartidosJugados", query = "SELECT e FROM EstadisticasEquipo e WHERE e.partidosJugados = :partidosJugados")
    , @NamedQuery(name = "EstadisticasEquipo.findByPartidosGanados", query = "SELECT e FROM EstadisticasEquipo e WHERE e.partidosGanados = :partidosGanados")
    , @NamedQuery(name = "EstadisticasEquipo.findByPartidosPerdidos", query = "SELECT e FROM EstadisticasEquipo e WHERE e.partidosPerdidos = :partidosPerdidos")
    , @NamedQuery(name = "EstadisticasEquipo.findByPuntos", query = "SELECT e FROM EstadisticasEquipo e WHERE e.puntos = :puntos")
    , @NamedQuery(name = "EstadisticasEquipo.findByPromedio", query = "SELECT e FROM EstadisticasEquipo e WHERE e.promedio = :promedio")
    , @NamedQuery(name = "EstadisticasEquipo.findByEquipoCodigo", query = "SELECT e FROM EstadisticasEquipo e WHERE e.equipoCodigo = :equipoCodigo")})
public class EstadisticasEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "goles_favor")
    private int golesFavor;
    @Basic(optional = false)
    @Column(name = "goles_contra")
    private int golesContra;
    @Basic(optional = false)
    @Column(name = "diferencia_goles")
    private int diferenciaGoles;
    @Basic(optional = false)
    @Column(name = "partidos_jugados")
    private int partidosJugados;
    @Basic(optional = false)
    @Column(name = "partidos_ganados")
    private int partidosGanados;
    @Basic(optional = false)
    @Column(name = "partidos_perdidos")
    private int partidosPerdidos;
    @Basic(optional = false)
    @Column(name = "puntos")
    private int puntos;
    @Basic(optional = false)
    @Column(name = "promedio")
    private double promedio;
    @Id
    @Basic(optional = false)
    @Column(name = "equipo_codigo")
    private Integer equipoCodigo;
    @JoinColumn(name = "equipo_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Equipo equipo;

    public EstadisticasEquipo() {
    }

    public EstadisticasEquipo(Integer equipoCodigo) {
        this.equipoCodigo = equipoCodigo;
    }

    public EstadisticasEquipo(Integer equipoCodigo, int golesFavor, int golesContra, int diferenciaGoles, int partidosJugados, int partidosGanados, int partidosPerdidos, int puntos, double promedio) {
        this.equipoCodigo = equipoCodigo;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.diferenciaGoles = diferenciaGoles;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.puntos = puntos;
        this.promedio = promedio;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getDiferenciaGoles() {
        return diferenciaGoles;
    }

    public void setDiferenciaGoles(int diferenciaGoles) {
        this.diferenciaGoles = diferenciaGoles;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Integer getEquipoCodigo() {
        return equipoCodigo;
    }

    public void setEquipoCodigo(Integer equipoCodigo) {
        this.equipoCodigo = equipoCodigo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipoCodigo != null ? equipoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticasEquipo)) {
            return false;
        }
        EstadisticasEquipo other = (EstadisticasEquipo) object;
        if ((this.equipoCodigo == null && other.equipoCodigo != null) || (this.equipoCodigo != null && !this.equipoCodigo.equals(other.equipoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DTO.EstadisticasEquipo[ equipoCodigo=" + equipoCodigo + " ]";
    }
    
}
