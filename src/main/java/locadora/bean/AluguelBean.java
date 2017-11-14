/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;
import locadora.entity.Aluguel;
import locadora.entity.Veiculo;
import locadora.rn.AluguelRN;
import locadora.rn.VeiculoRN;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
    private List<Aluguel> alugueis;

    public AluguelBean() {
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
        aluguel.setValor(new BigDecimal(calcularValor()));
        aluguel.setUsuario(usuarioBean.getUsuario());
        aluguel.setVeiculoId(veiculo);

        if (aluguelRN.salvar(aluguel)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            this.alugueis = null;
            this.aluguel = new Aluguel();
            return "/restrito/aluguel/cadastrarAluguel.xhtml";
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

    public StreamedContent getImageStreamed() throws IOException {
        byte[] image = aluguel.getVeiculoId().getImagem();
        return new DefaultStreamedContent(new ByteArrayInputStream(image));
    }

    public String excluir(Aluguel aluguel) {
        aluguelRN.excluir(aluguel);
        alugueis = null;
        return "/restrito/aluguel/cadastrarAluguel.xhtml?faces-redirect=true";
    }

    public String alterar(Aluguel aluguel) {
        this.setAluguel(aluguel);
        alugueis = null;
        return "/restrito/aluguel/cadastrarAluguel.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "/admin/formatoEmbalagem/lista-formatoembalagem.xhtml";
    }

    public List<Aluguel> getAluguels() {
        if (alugueis == null) {
            if (usuarioBean.isAdministrador()) {
                alugueis = aluguelRN.obterTodos();
            } else {
                alugueis = aluguelRN.obterTodosPorLogin(usuarioBean.getUsuario());
            }
        }
        return alugueis;
    }
}
