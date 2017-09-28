/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import locadora.entity.Usuario;
import locadora.rn.UsuarioRN;

/**
 *
 * @author jhonatan
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {
    
    private final UsuarioRN rn = new UsuarioRN();
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    public UsuarioBean() {
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String incuir() {
        return "formulario.xhtml";
    }

    public String cancelar() {
        return "listagem.xhtml";
    }

    public String salvar() {
        if (rn.salvar(usuario)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/index.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Este email já existe em nossa base de dados."
                    + " Tente novamente com outro email.", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public String editar() {
        return "formulario.xhtml";
    }

    public String remover() {
        if (rn.remover(usuario)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluído!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "listagem.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao excluir!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public List<Usuario> getContatos() {
        usuarios = rn.getList();
        return usuarios;
    }
}
