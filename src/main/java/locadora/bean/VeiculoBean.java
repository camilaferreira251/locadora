/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import locadora.entity.Aluguel;
import locadora.entity.Veiculo;
import locadora.rn.VeiculoRN;
import locadora.util.Util;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author jhonatan
 */
@ManagedBean
@RequestScoped
public class VeiculoBean {

    private final VeiculoRN veiculoRN = new VeiculoRN();
    private Veiculo veiculo = new Veiculo();
    private Aluguel aluguel = new Aluguel();
    private List<Veiculo> veiculos;
    private UploadedFile arquivo;
    private static final int MAX_SIZE = 2 * 1024 * 1024;
    private StreamedContent sc;

    public VeiculoBean() {
//        veiculo = (Veiculo) Util.lerDaSessao("veiculo");
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public UploadedFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
    }

    public String nextStep() {
        if (new UsuarioBean().getUsuario() != null) {
            return "/restrito/aluguel/formAluguel.xhtml";
        } else {
            return "/publico/login.xhtml";
        }
    }

    public StreamedContent getImagemVeiculo() {
        String vId = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("veiculoParam");
        if (vId != null) {
            Veiculo v = veiculoRN.obter(Integer.parseInt(vId));
            ByteArrayInputStream img
                    = new ByteArrayInputStream(v.getImagem());
            return new DefaultStreamedContent(img);
        }
        return new DefaultStreamedContent();
    }

    public void validarImagem(FacesContext context, UIComponent component, Object value) throws IOException {
        arquivo = (UploadedFile) value;
        if (arquivo.getSize() > MAX_SIZE) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Arquivo muito grande", "O arquivo deve ter o tamanho máximo de 2MB.");
            throw new ValidatorException(msg);
        }

        if (!(arquivo.getContentType().contains("image/"))) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Tipo de arquivo inválido", "O arquivo deve ser imagem.");
            throw new ValidatorException(msg);
        }
    }

    public String handleFileUpload(FileUploadEvent e) {
        veiculo = (Veiculo) Util.lerDaSessao("veiculo");
        veiculo.setImagem(e.getFile().getContents());

        if (veiculoRN.salvar(veiculo)) {
            FacesMessage message = new FacesMessage("Importado com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, message);
//            Util.deleteDaSessao("veiculo");
            return "/restrito/veiculo/listarVeiculos.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao importar", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public String salvar() {
        if (veiculoRN.salvar(veiculo)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            this.veiculos = null;
            Util.colocarNaSessao("veiculo", veiculo);
//            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("veiculo", this.veiculo);
            this.veiculo = new Veiculo();
            return "/restrito/veiculo/formImagemVeiculo.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao salvar", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public String buscarVeiculos() {
        if (aluguel.getDataFim().before(aluguel.getDataInicio())) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data fim inválida!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
        return "/publico/resultadosBusca.xhtml";
    }

    public String salvarImagem() {
        if (veiculoRN.salvar(veiculo)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            this.veiculos = null;
            Util.colocarNaSessao("veiculo", veiculo);
//            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("veiculo", this.veiculo);
            this.veiculo = new Veiculo();
            return "/restrito/veiculo/listarVeiculos.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao salvar", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public String excluir(Veiculo veiculo) {
        veiculoRN.excluir(veiculo);
        veiculos = null;
        return "/restrito/veiculo/listarVeiculos.xhtml?faces-redirect=true";
    }

    public String alterar(Veiculo veiculo) {
        this.veiculo = veiculo;
        return "/restrito/veiculo/formVeiculo.xhtml";
    }

    public List<Veiculo> getVeiculos() {
        if (veiculos == null) {
            veiculos = veiculoRN.obterTodos();
        }
        return veiculos;
    }

    public List<Veiculo> getVeiculosMaisAlugados() {
        if (veiculos == null) {
            veiculos = veiculoRN.obterMaisAlugados();
        }
        return veiculos;
    }

    public List<Veiculo> getVeiculosBusca() {
        if (veiculos == null) {
            veiculos = veiculoRN.obterPorBusca(aluguel);
        }
        return veiculos;
    }
}
