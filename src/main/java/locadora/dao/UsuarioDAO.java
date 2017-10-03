/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import javax.persistence.TypedQuery;
import locadora.entity.Usuario;

/**
 *
 * @author jhonatan
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public Usuario obterPorLogin(String login) {
        TypedQuery<Usuario> query = getEntityManager().createNamedQuery("Usuario.findByLogin", Usuario.class)
                .setParameter("login", login);
        return query.getSingleResult();
    }

}
