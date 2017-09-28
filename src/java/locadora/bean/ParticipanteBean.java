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
import locadora.entity.Participante;
import locadora.rn.ParticipanteRN;

/**
 *
 * @author jhonatan
 */
@ManagedBean
@RequestScoped
public class ParticipanteBean {
    private final ParticipanteRN rn = new ParticipanteRN();
    private List<Participante> participantes;
    private Participante participante = new Participante();;
    
    public ParticipanteBean() {
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    
    public String incuir() {
        return "formulario.xhtml";
    }

    public String cancelar() {
        return "listagem.xhtml";
    }

    public String salvar() {
        if (rn.salvar(participante)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/index.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao tentar salvar. Tente novamente.", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public String editar() {
        return "formulario.xhtml";
    }

    public String remover() {
        if (rn.remover(participante)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluído!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "listagem.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao excluir!", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public List<Participante> getParticipantes() {
        participantes = rn.getList();
        return participantes;
    }
}