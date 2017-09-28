/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.rn;

import java.util.List;
import locadora.dao.GenericDAO;
import locadora.entity.Usuario;

/**
 *
 * @author jhonatan
 */
public class UsuarioRN {
    private final GenericDAO<Usuario> dao = new GenericDAO<Usuario>();

    public boolean salvar(Usuario usuario) {
        if (usuario.getNome().equals("") || usuario.getEmail().equals("")
                || usuario.getPassword().equals("")) {
            return false;
        } else {
            if (usuario.getId() == null) {
                return dao.criar(usuario);
            } else {
                return dao.alterar(usuario);
            }
        }
    }

    public boolean remover(Usuario usuario) {
        return dao.excluir(usuario);
    }

    public List<Usuario> getList() {
        return dao.obterTodos(Usuario.class);
    }
}
