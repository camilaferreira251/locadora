/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import locadora.entity.Papel;
import locadora.entity.Usuario;
import locadora.rn.UsuarioRN;

/**
 *
 * @author jhonatan
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {
    private static final Logger LOG = Logger.getLogger(UsuarioBean.class.getName());

    private final String ADMIN = "ROLE_ADMIN";
    private final String USER = "ROLE_USER";
    private Usuario usuario = new Usuario();
    private final UsuarioRN rn = new UsuarioRN();
    private List<Usuario> usuarios;
    private Usuario novoUsuario = new Usuario();
    private Map<String, Papel> papeis;
    private List<Papel> selecionados;

    /** Creates a new instance of embalagemBean */
    public UsuarioBean() {
    }

    //public String getBomDia() {
      //  DateFormat df = new SimpleDateFormat("HH");
        //if (Integer.parseInt(df.format(new Date())) >= 12 && Integer.parseInt(df.format(new Date())) <= 18) {
        //    return "Boa tarde! ";
        //}
        //if (Integer.parseInt(df.format(new Date())) >= 18 && Integer.parseInt(df.format(new Date())) <= 23) {
          //  return "Boa noite! ";
        //}
        //return "Bom dia! ";
   // }

    public boolean isAdministrador() {
        return rn.papel(ADMIN, getUsuario());
    }

    public boolean isUser() {
        return rn.papel(USER, getUsuario());
    }

    public Usuario getUsuario() {
        try {
            FacesContext f = FacesContext.getCurrentInstance();
            ExternalContext e = f.getExternalContext();
            LOG.log(Level.INFO, e.getRemoteUser());
            usuario = rn.obterPorLogin(e.getRemoteUser());
        } catch (Exception e) {
        }
        return usuario;
    }
    
    public Usuario getUsuarioByLogin(String login) {
        return rn.obterPorLogin(login);
    } 

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String salvar() {
        try {
            novoUsuario = rn.obter(novoUsuario.getLogin());
        } catch (Exception e) {
        }
        try {
            rn.atualizarPapeis(novoUsuario);
        } catch (Exception e) {
        }
        novoUsuario.setPapelList(selecionados);
        rn.salvar(novoUsuario);
        rn.salvarPapeis(selecionados, novoUsuario);
        return "/restrito/home.xhtml";
    }

    public String alterar() {
        return "/admin/usuario/usuario.xhtml";
    }

    public String cancelar() {
        return "/admin/usuario/lista-usuario.xhtml";
    }

    public String novo() {
        return "/admin/usuario/usuario.xhtml";
    }

    public String excluir() {
        novoUsuario = rn.obter(novoUsuario.getLogin());
        rn.atualizarPapeis(novoUsuario);
        rn.excluir(novoUsuario);
        return "/admin/usuario/lista-usuario.xhtml";
    }

    public String irExcluir() {
        return "/admin/usuario/remover-usuario.xhtml";
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = rn.obterTodos();
        }
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Map<String, Papel> getPapeis() {
        if (papeis == null) {
            papeis = new HashMap<String, Papel>();
        }
        List<Papel> ps = rn.obterPapeis();
        for (Papel temp : ps) {
            papeis.put(temp.getDescricao(), temp);
        }
        return papeis;
    }

    public void setMovies(Map<String, Papel> papeis) {
        this.papeis = papeis;
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

    public List<Papel> getSelecionados() {
        if (selecionados == null) {
            selecionados = new ArrayList<Papel>();
            try {
                selecionados = novoUsuario.getPapelList();
            } catch (Exception e) {
            }
        }
        return selecionados;
    }

    public void setSelecionados(List<Papel> selecionados) {
        this.selecionados = selecionados;
    }
}
