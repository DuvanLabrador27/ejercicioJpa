/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Duvan
 */
@Embeddable
public class PartidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "numero_fecha")
    private int numeroFecha;
    @Basic(optional = false)
    @Column(name = "equipo_local")
    private int equipoLocal;
    @Basic(optional = false)
    @Column(name = "equipo_visitante")
    private int equipoVisitante;

    public PartidoPK() {
    }

    public PartidoPK(int numeroFecha, int equipoLocal, int equipoVisitante) {
        this.numeroFecha = numeroFecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public int getNumeroFecha() {
        return numeroFecha;
    }

    public void setNumeroFecha(int numeroFecha) {
        this.numeroFecha = numeroFecha;
    }

    public int getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(int equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public int getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(int equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroFecha;
        hash += (int) equipoLocal;
        hash += (int) equipoVisitante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartidoPK)) {
            return false;
        }
        PartidoPK other = (PartidoPK) object;
        if (this.numeroFecha != other.numeroFecha) {
            return false;
        }
        if (this.equipoLocal != other.equipoLocal) {
            return false;
        }
        if (this.equipoVisitante != other.equipoVisitante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DTO.PartidoPK[ numeroFecha=" + numeroFecha + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + " ]";
    }
    
}
