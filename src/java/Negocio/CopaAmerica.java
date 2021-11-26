/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.DAO.EquipoJpaController;
import Modelo.DAO.EstadisticasEquipoJpaController;
import Modelo.DAO.JugadorJpaController;
import Modelo.DAO.PartidoJpaController;
import Modelo.DTO.Equipo;
import Modelo.DTO.EstadisticasEquipo;
import Modelo.DTO.Jugador;
import Modelo.DTO.Partido;
import Modelo.DTO.PartidoPK;
import Util.Conexion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angie
 */
public class CopaAmerica {

    Conexion con;
    EquipoJpaController equipo;
    PartidoJpaController partido;
    EstadisticasEquipoJpaController estadisticas;
    JugadorJpaController jugador;

    public CopaAmerica() {
        con = Conexion.getConexion();
        equipo = new EquipoJpaController(con.getBd());
        partido = new PartidoJpaController(con.getBd());
        estadisticas = new EstadisticasEquipoJpaController(con.getBd());
        jugador = new JugadorJpaController(con.getBd());
    }

    public List<Equipo> getEquipos() {
        return equipo.findEquipoEntities();
    }

    public List<Partido> getPartidos() {
        return partido.findPartidoEntities();
    }

    public List<Jugador> getJugadores() {
        return jugador.findJugadorEntities();
    }

    public List<EstadisticasEquipo> getEstadisticasEquipo() {
        return estadisticas.findEstadisticasEquipoEntities();
    }

    public Equipo getEquipoId(int codigo) {
        return equipo.findEquipo(codigo);
    }

    public Partido getPartidoId(int numeroFecha, int equipoLocal, int equipoVisitante) {
        PartidoPK partidoPK = new PartidoPK(numeroFecha, equipoLocal, equipoVisitante);
        return partido.findPartido(partidoPK);
    }

    public Jugador getJugadorId(int id) {
        return jugador.findJugador(id);
    }

    public EstadisticasEquipo getEstadisticasEquipoId(int codigo) {
        return estadisticas.findEstadisticasEquipo(codigo);
    }

    public List<EstadisticasEquipo> sortEstadisticasEquipo() {
        return estadisticas.sort();
    }

    public void registrarEquipo(String nombre, String tecnico) {
        this.equipo.create(new Equipo(nombre, tecnico));
    }

    public void registrarPartido(int numeroFecha, int golesLocal, int golesVisitante, String ciudad, String arbitro, String estadio, int equipoLocal, int equipoVisitante) throws Exception {
        PartidoPK partidoPK = new PartidoPK(numeroFecha, equipoLocal, equipoVisitante);
        Partido p = new Partido(partidoPK, golesLocal, golesVisitante, ciudad, arbitro, estadio);
        this.partido.create(p);
    }

    public void registrarJugador(String tipoDocumento, String numeroDocumento, String nombre, String apellido, String date, String paisNacimiento, String ciudadNacimiento, String posicionJuego, int equipoCodigo) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(CopaAmerica.class.getName()).log(Level.SEVERE, null, ex);
        }

        Jugador j = new Jugador(tipoDocumento, numeroDocumento, nombre, apellido, fechaNacimiento, paisNacimiento, ciudadNacimiento, posicionJuego);
        Equipo e = equipo.findEquipo(equipoCodigo);
        j.setEquipoCodigo(e);
        this.jugador.create(j);
    }

    public int idEquipoGanador(Partido partido) {
        if (partido.getGolesLocal() > partido.getGolesVisitante()) {
            return partido.getEquipo_local().getCodigo();
        }
        if (partido.getGolesVisitante() > partido.getGolesLocal()) {
            return partido.getEquipo_visitante().getCodigo();
        }
        return 0;
    }

    public double promedio(int puntos, int partidos_judados) {
        return puntos / partidos_judados;
    }

    public List<Jugador> getJugadoresEquipo(int id) {
        List<Jugador> jugadores = jugador.findJugadorEntities();
        List<Jugador> aux = new ArrayList<>();
        for (Jugador j : jugadores) {
            if (j.getEquipoCodigo().getCodigo() == id) {
                aux.add(j);
            }
        }
        return aux;
    }

}
