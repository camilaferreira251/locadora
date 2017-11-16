/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.util;

import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author jhonatan
 */
public class Util {

    private Util() {
    }

    public static void naSessao(String chave, Object valor) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessao = externalContext.getSessionMap();
        sessao.remove(chave); //TODO Por que remover antes?
        sessao.put(chave, valor);
    }

    public static Object daSessao(String chave) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessao = externalContext.getSessionMap();
        return sessao.get(chave);
    }

    public static Object lerDaSessao(String chave) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = ec.getSessionMap();
        return sessionMap.get(chave);
    }

    public static void colocarNaSessao(String chave, Object objeto) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = ec.getSessionMap();
        sessionMap.put(chave, objeto);
    }

    public static void deleteDaSessao(String chave) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessao = externalContext.getSessionMap();
        sessao.remove(chave);
    }

    public static Object beanDaRequisicao(String nomeDoBean) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return externalContext.getRequestMap().get(nomeDoBean);
    }

}
