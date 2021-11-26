package Modelo.DTO;

import Modelo.DTO.Equipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-25T14:26:44")
@StaticMetamodel(EstadisticasEquipo.class)
public class EstadisticasEquipo_ { 

    public static volatile SingularAttribute<EstadisticasEquipo, Integer> golesContra;
    public static volatile SingularAttribute<EstadisticasEquipo, Integer> partidosGanados;
    public static volatile SingularAttribute<EstadisticasEquipo, Integer> partidosPerdidos;
    public static volatile SingularAttribute<EstadisticasEquipo, Double> promedio;
    public static volatile SingularAttribute<EstadisticasEquipo, Equipo> equipo;
    public static volatile SingularAttribute<EstadisticasEquipo, Integer> diferenciaGoles;
    public static volatile SingularAttribute<EstadisticasEquipo, Integer> equipoCodigo;
    public static volatile SingularAttribute<EstadisticasEquipo, Integer> partidosJugados;
    public static volatile SingularAttribute<EstadisticasEquipo, Integer> puntos;
    public static volatile SingularAttribute<EstadisticasEquipo, Integer> golesFavor;

}