package Modelo.DTO;

import Modelo.DTO.Equipo;
import Modelo.DTO.PartidoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-25T14:26:44")
@StaticMetamodel(Partido.class)
public class Partido_ { 

    public static volatile SingularAttribute<Partido, String> arbitro;
    public static volatile SingularAttribute<Partido, Integer> golesLocal;
    public static volatile SingularAttribute<Partido, String> ciudad;
    public static volatile SingularAttribute<Partido, PartidoPK> partidoPK;
    public static volatile SingularAttribute<Partido, String> estadio;
    public static volatile SingularAttribute<Partido, Equipo> equipo_visitante;
    public static volatile SingularAttribute<Partido, Integer> golesVisitante;
    public static volatile SingularAttribute<Partido, Equipo> equipo_local;

}