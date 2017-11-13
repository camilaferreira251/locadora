/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.validator.ValidatorException;
import locadora.entity.Veiculo;
import locadora.rn.VeiculoRN;
import org.apache.commons.io.IOUtils;
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
    private List<Veiculo> veiculos;
    private static final int MAX_SIZE = 2 * 1024 * 1024;
    private UploadedFile arquivo;


    public VeiculoBean() {
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public UploadedFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
    }

    public void validarImagem(FacesContext context, UIComponent component, Object value) {
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

    public void uploadImagemVeiculo() {
            veiculo.setImagem(arquivo.getContents());
    }
    
    public String nextStep() {
        return "/restrito/aluguel/confirmarAluguel.xhtml";
    }

    public StreamedContent getUploadedFileAsStream() {
        if (arquivo != null) {
            try {
                return new DefaultStreamedContent(arquivo.getInputstream());
            } catch (IOException ex) {
                Logger.getLogger(VeiculoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public StreamedContent getImageStreamed(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        }
        else {
            String id = context.getExternalContext().getRequestParameterMap().get("id");
            byte[] image = null;
            for (Veiculo v : veiculos) {
                if (v.getId().toString() == id) {
                    image = v.getImagem();
                }
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(image));
        }
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
