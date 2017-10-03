/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.rn;

import java.util.List;
import locadora.dao.GenericDAO;
import locadora.entity.Aluguel;

/**
 *
 * @author jhonatan
 */
public class AluguelRN {
    private final GenericDAO<Aluguel> dao = new GenericDAO<Aluguel>();

    public AluguelRN() {
    }

    public boolean salvar(Aluguel aluguel) {
        boolean salvou = true;
        if (aluguel.getId() == null) {
            salvou &= dao.criar(aluguel);
        } else {
            salvou &= dao.alterar(aluguel);
        }
        return salvou;
    }

    public boolean excluir(Aluguel a) {
        a = dao.obter(Aluguel.class, a.getId());
        return dao.excluir(a);
    }

    public List<Aluguel> obterTodos() {
        return dao.obterTodos(Aluguel.class);
    }

    public Aluguel obter(String id) {
        return dao.obter(Aluguel.class, id);
    }
}
