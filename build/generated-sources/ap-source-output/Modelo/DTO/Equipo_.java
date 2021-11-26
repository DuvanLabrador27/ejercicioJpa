package Modelo.DTO;

import Modelo.DTO.EstadisticasEquipo;
import Modelo.DTO.Jugador;
import Modelo.DTO.Partido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-25T14:26:44")
@StaticMetamodel(Equipo.class)
public class Equipo_ { 

    public static volatile ListAttribute<Equipo, Jugador> jugadorList;
    public static volatile SingularAttribute<Equipo, Integer> codigo;
    public static volatile SingularAttribute<Equipo, EstadisticasEquipo> estadisticasEquipo;
    public static volatile ListAttribute<Equipo, Partido> partidoList;
    public static volatile SingularAttribute<Equipo, Date> fechaCreacion;
    public static volatile ListAttribute<Equipo, Partido> partidoList1;
    public static volatile SingularAttribute<Equipo, String> tecnico;
    public static volatile SingularAttribute<Equipo, String> nombre;

}