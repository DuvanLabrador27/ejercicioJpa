package Modelo.DTO;

import Modelo.DTO.Equipo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-25T14:26:44")
@StaticMetamodel(Jugador.class)
public class Jugador_ { 

    public static volatile SingularAttribute<Jugador, String> ciudadNacimiento;
    public static volatile SingularAttribute<Jugador, String> tipoDocumento;
    public static volatile SingularAttribute<Jugador, String> posicionJuego;
    public static volatile SingularAttribute<Jugador, Date> fechaNacimiento;
    public static volatile SingularAttribute<Jugador, Integer> codigoJugador;
    public static volatile SingularAttribute<Jugador, String> apellido;
    public static volatile SingularAttribute<Jugador, Equipo> equipoCodigo;
    public static volatile SingularAttribute<Jugador, String> numeroDocumento;
    public static volatile SingularAttribute<Jugador, String> paisNacimiento;
    public static volatile SingularAttribute<Jugador, String> nombre;

}