/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.rn;

import java.util.List;
import locadora.dao.GenericDAO;
import locadora.entity.Veiculo;

/**
 *
 * @author jhonatan
 */
public class VeiculoRN {
    private final GenericDAO<Veiculo> dao = new GenericDAO<Veiculo>();

    public VeiculoRN() {
    }

    public boolean salvar(Veiculo veiculo) {
        boolean salvou = true;
        if (veiculo.getId() == null) {
            salvou &= dao.criar(veiculo);
        } else {
            salvou &= dao.alterar(veiculo);
        }
        return salvou;
    }

    public boolean excluir(Veiculo v) {
        v = dao.obter(Veiculo.class, v.getId());
        return dao.excluir(v);
    }

    public List<Veiculo> obterTodos() {
        return dao.obterTodos(Veiculo.class);
    }

    public Veiculo obter(Integer id) {
        return dao.obter(Veiculo.class, id);
    }
}
