/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import locadora.entity.Papel;
import locadora.rn.PapelRN;

@FacesConverter(value = "PapelConversor")
public class PapelConversor implements Converter {
    private final PapelRN papelRN = new PapelRN();
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
            Integer id = new Integer(valor);
            return papelRN.obter(id);
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Papel papel = (Papel) o;
        return papel.getId().toString();
    }
    
}
