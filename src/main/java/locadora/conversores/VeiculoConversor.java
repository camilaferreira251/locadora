/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import locadora.entity.Veiculo;
import locadora.rn.VeiculoRN;

@FacesConverter(value = "VeiculoConversor")
public class VeiculoConversor implements Converter {
    private final VeiculoRN veiculoRN = new VeiculoRN();
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
            Integer id = new Integer(valor);
            return veiculoRN.obter(id);
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Veiculo veiculo = (Veiculo) o;
        return veiculo.getId().toString();
    }
    
}
