/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import locadora.entity.Veiculo;
import locadora.rn.VeiculoRN;

/**
 *
 * @author jhonatan
 */
@ManagedBean
@RequestScoped
public class VeiculoBean {
    private final VeiculoRN veiculoRN = new VeiculoRN();;
    private Veiculo veiculo = new Veiculo();;
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
        veiculoRN.salvar(veiculo);
        return "/restrito/veiculo/cadastrarVeiculo.xhtml";
    }

    public String excluir() {
        veiculoRN.excluir(veiculo);
        veiculos = null;
        return "/admin/formatoEmbalagem/lista-formatoembalagem.xhtml";
    }

    public String alterar() {
        return "/admin/formatoEmbalagem/formatoembalagem.xhtml";
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
