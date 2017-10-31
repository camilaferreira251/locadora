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
import locadora.entity.Veiculo;
import locadora.rn.VeiculoRN;

/**
 *
 * @author jhonatan
 */
@ManagedBean
@RequestScoped
public class VeiculoBean {
    private final VeiculoRN veiculoRN = new VeiculoRN();
    private Veiculo veiculo = new Veiculo();
    private List<Veiculo> veiculos;
    
    public VeiculoBean() {
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public String salvar() {
        if (veiculoRN.salvar(veiculo)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            this.veiculos = null;
            this.veiculo = new Veiculo();
            return "/restrito/veiculo/cadastrarVeiculo.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao salvar", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public String excluir(Veiculo veiculo) {
        veiculoRN.excluir(veiculo);
        veiculos = null;
        return "/restrito/veiculo/cadastrarVeiculo.xhtml?faces-redirect=true";
    }

    public String alterar(Veiculo veiculo) {
        this.setVeiculo(veiculo);
        veiculos = null;
        return "/restrito/veiculo/cadastrarVeiculo.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "/admin/formatoEmbalagem/lista-formatoembalagem.xhtml";
    }
    
    public List<Veiculo> getVeiculos() {
        if (veiculos == null) {
            veiculos = veiculoRN.obterTodos();
        }
        return veiculos;
    }
}
