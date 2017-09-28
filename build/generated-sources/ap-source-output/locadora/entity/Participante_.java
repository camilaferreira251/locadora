package locadora.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import locadora.entity.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-28T11:52:09")
@StaticMetamodel(Participante.class)
public class Participante_ { 

    public static volatile SingularAttribute<Participante, String> telefone;
    public static volatile SingularAttribute<Participante, String> rg;
    public static volatile SingularAttribute<Participante, Integer> id;
    public static volatile SingularAttribute<Participante, Usuario> userId;

}