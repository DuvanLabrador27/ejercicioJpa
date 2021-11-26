/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duvan
 */
@Entity
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findByCodigoJugador", query = "SELECT j FROM Jugador j WHERE j.codigoJugador = :codigoJugador")
    , @NamedQuery(name = "Jugador.findByTipoDocumento", query = "SELECT j FROM Jugador j WHERE j.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Jugador.findByNumeroDocumento", query = "SELECT j FROM Jugador j WHERE j.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Jugador.findByApellido", query = "SELECT j FROM Jugador j WHERE j.apellido = :apellido")
    , @NamedQuery(name = "Jugador.findByFechaNacimiento", query = "SELECT j FROM Jugador j WHERE j.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Jugador.findByPaisNacimiento", query = "SELECT j FROM Jugador j WHERE j.paisNacimiento = :paisNacimiento")
    , @NamedQuery(name = "Jugador.findByCiudadNacimiento", query = "SELECT j FROM Jugador j WHERE j.ciudadNacimiento = :ciudadNacimiento")
    , @NamedQuery(name = "Jugador.findByPosicionJuego", query = "SELECT j FROM Jugador j WHERE j.posicionJuego = :posicionJuego")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_jugador")
    private Integer codigoJugador;
    @Basic(optional = false)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "pais_nacimiento")
    private String paisNacimiento;
    @Basic(optional = false)
    @Column(name = "ciudad_nacimiento")
    private String ciudadNacimiento;
    @Basic(optional = false)
    @Column(name = "posicion_juego")
    private String posicionJuego;
    @JoinColumn(name = "equipo_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Equipo equipoCodigo;

    public Jugador() {
    }

    public Jugador(Integer codigoJugador) {
        this.codigoJugador = codigoJugador;
    }

    public Jugador(String tipoDocumento, String numeroDocumento, String nombre, String apellido, Date fechaNacimiento, String paisNacimiento, String ciudadNacimiento, String posicionJuego) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.paisNacimiento = paisNacimiento;
        this.ciudadNacimiento = ciudadNacimiento;
        this.posicionJuego = posicionJuego;
    }

    public Jugador(Integer codigoJugador, String tipoDocumento, String numeroDocumento, String nombre, String apellido, Date fechaNacimiento, String paisNacimiento, String ciudadNacimiento, String posicionJuego) {
        this.codigoJugador = codigoJugador;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.paisNacimiento = paisNacimiento;
        this.ciudadNacimiento = ciudadNacimiento;
        this.posicionJuego = posicionJuego;
    }

    public Integer getCodigoJugador() {
        return codigoJugador;
    }

    public void setCodigoJugador(Integer codigoJugador) {
        this.codigoJugador = codigoJugador;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getPosicionJuego() {
        return posicionJuego;
    }

    public void setPosicionJuego(String posicionJuego) {
        this.posicionJuego = posicionJuego;
    }

    public Equipo getEquipoCodigo() {
        return equipoCodigo;
    }

    public void setEquipoCodigo(Equipo equipoCodigo) {
        this.equipoCodigo = equipoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoJugador != null ? codigoJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.codigoJugador == null && other.codigoJugador != null) || (this.codigoJugador != null && !this.codigoJugador.equals(other.codigoJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DTO.Jugador[ codigoJugador=" + codigoJugador + " ]";
    }

}
