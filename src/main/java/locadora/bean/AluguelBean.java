/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.bean;

import java.math.BigDecimal;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import locadora.entity.Aluguel;
import locadora.entity.Usuario;
import locadora.entity.Veiculo;
import locadora.rn.AluguelRN;
import locadora.rn.VeiculoRN;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author jhonatan
 */
@ManagedBean
@RequestScoped
public class AluguelBean {
    private final AluguelRN aluguelRN = new AluguelRN();
    private final VeiculoRN veiculoRN = new VeiculoRN();
    private final UsuarioBean usuarioBean = new UsuarioBean();
    private Aluguel aluguel = new Aluguel();
    private Veiculo veiculo = new Veiculo();
    Usuario usuario = new Usuario();
    private List<Aluguel> alugueis;
    
    public AluguelBean() {
        usuario = usuarioBean.getUsuario();
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel veiculo) {
        this.aluguel = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public SelectItem[] getSelectVeiculo() {
        List<Veiculo> veic = veiculoRN.obterTodos();
        SelectItem[] retorno = new SelectItem[veic.size()];
        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = new SelectItem(veic.get(i), veic.get(i).getModelo());
        }
        return retorno;
    }
    
    public String salvar() {
        aluguel.setId(1);
        aluguel.setValor(new BigDecimal(calcularValor()));
        aluguel.setUsuario(usuarioBean.getUsuarioByLogin("jhon"));
        aluguel.setVeiculoId(veiculo);
        
        System.out.println(aluguel.toString());
        System.out.println(usuario.toString());
        
        if (aluguelRN.salvar(aluguel)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/restrito/home.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao salvar", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }
    
    public Float calcularValor() {
        return veiculo.getValorDiaria().floatValue() * diasAluguel();
    }
    
    public Integer diasAluguel() {
        DateTime dataInicio = new DateTime(aluguel.getDataInicio().getTime());
        DateTime dataFinal = new DateTime(aluguel.getDataFim().getTime());
        Days d = Days.daysBetween(dataInicio, dataFinal);
        return d.getDays();
    }

    public String excluir() {
        aluguelRN.excluir(aluguel);
        alugueis = null;
        return "/admin/formatoEmbalagem/lista-formatoembalagem.xhtml";
    }

    public String alterar() {
        return "/admin/formatoEmbalagem/formatoembalagem.xhtml";
    }

    public String cancelar() {
        return "/admin/formatoEmbalagem/lista-formatoembalagem.xhtml";
    }
    
    public List<Aluguel> getAluguels() {
        if (alugueis == null) {
            alugueis = aluguelRN.obterTodos();
        }
        return alugueis;
    }
}
