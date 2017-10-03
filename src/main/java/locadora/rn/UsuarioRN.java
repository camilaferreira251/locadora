/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.rn;

import java.util.List;
import locadora.dao.GenericDAO;
import locadora.dao.UsuarioDAO;
import locadora.entity.Papel;
import locadora.entity.Usuario;

/**
 *
 * @author Hugo
 */
public class UsuarioRN {

    private final UsuarioDAO dao = new UsuarioDAO();

    public UsuarioRN() {
    }

    public boolean salvar(Usuario usuario) {
        boolean salvou = true;
        if (usuario.getLogin() == null) {
            salvou &= dao.criar(usuario);
        } else {
            salvou &= dao.alterar(usuario);
        }
        return salvou;
    }

    public boolean excluir(Usuario l) {
        l = dao.obter(Usuario.class, l.getLogin());
        return dao.excluir(l);
    }

    public List<Usuario> obterTodos() {
        return dao.obterTodos(Usuario.class);
    }

    public Usuario obter(String id) {
        return dao.obter(Usuario.class, id);
    }
    
    public Usuario obterPorLogin (String login) {
        return dao.obterPorLogin(login);
    }

    public boolean papel(String papel, Usuario u) {
        try {
            for (Papel p : u.getPapelList()) {
                if (p.getDescricao().equals(papel)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public List<Papel> obterSelecionados(Usuario u) {
        return u.getPapelList();
    }

    public List<Papel> obterPapeis() {
        GenericDAO<Papel> daop = new GenericDAO<Papel>();
        return daop.obterTodos(Papel.class);
    }

    public void atualizarPapeis(Usuario u) {
        PapelRN prn = new PapelRN();
        for (Papel temp : u.getPapelList()) {
            boolean remove = temp.getUsuarioList().remove(u);
            if (remove) {
                System.out.println("excluiu os papeis do usuario " + u.getNome());
            }
            if (prn.salvar(temp)) {
                System.out.println("Lista de usuario_papeis atualizada !!!");
            }
        }
    }

    public boolean salvarPapeis(List<Papel> selecionados, Usuario novoUsuario) {
        PapelRN prn = new PapelRN();
        if (selecionouAdmin(selecionados)) {
            for (Papel temp : prn.obterTodos()) {
                temp.getUsuarioList().add(novoUsuario);
                if (!prn.salvar(temp)) {
                    return false;
                }
            }
        } else {
            for (Papel temp : selecionados) {
                temp.getUsuarioList().add(novoUsuario);
                if (!prn.salvar(temp)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean selecionouAdmin(List<Papel> selecionados) {
        for (Papel papel : selecionados) {
            if (papel.getDescricao().equals("ROLE_ADMIN")) {
                return true;
            }
        }
        return false;
    }
}
