package locadora.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import locadora.entity.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-28T11:52:09")
@StaticMetamodel(Papel.class)
public class Papel_ { 

    public static volatile ListAttribute<Papel, Usuario> usuarioList;
    public static volatile SingularAttribute<Papel, String> authority;
    public static volatile SingularAttribute<Papel, Integer> id;

}