/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import locadora.entity.Papel;
import locadora.rn.PapelRN;

/**
 *
 * @author jhonatan
 */
@ManagedBean
@RequestScoped
public class PapelBean {
    private final PapelRN rn = new PapelRN();
    private List<Papel> papeis;
    private Papel papel = new Papel();
    /** Creates a new instance of PapelBean */
    public PapelBean() {
    }
    
    public String salvar() {
        rn.salvar(papel);
        return "/admin/usuario/papel/lista-papel.xhtml";
    }

    public String novo() {
        return "/admin/usuario/papel/papel.xhtml";
    }

    public String excluir() {
        rn.excluir(papel);
        papeis = null;
        return "/admin/usuario/papel/lista-papel.xhtml";
    }

    public String alterar() {
        return "/admin/usuario/papel/papel.xhtml";
    }

    public String cancelar() {
        return "/admin/usuario/papel/lista-papel.xhtml";
    }

    public String irExcluir() {
        return "/admin/usuario/papel/remover-papel.xhtml";
    }

    public List<Papel> getPapeis() {
        if(papeis==null){
            papeis = rn.obterTodos();
        }
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
    
    
}
