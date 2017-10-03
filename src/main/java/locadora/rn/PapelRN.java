/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.rn;

import java.util.List;
import locadora.dao.GenericDAO;
import locadora.entity.Papel;

/**
 *
 * @author Hugo
 */
public class PapelRN {

    private final GenericDAO<Papel> dao = new GenericDAO<Papel>();

    public boolean salvar(Papel p) {
        boolean salvou = true;
        if (p.getId() == null) {
            salvou &= dao.criar(p);
        } else {
            salvou &= dao.alterar(p);
        }
        return salvou;
    }

    public boolean excluir(Papel p) {
        p = dao.obter(Papel.class, p.getId());
        return dao.excluir(p);
    }

    public List<Papel> obterTodos() {
        return dao.obterTodos(Papel.class);
    }

    public Papel obter(Integer id) {
        return dao.obter(Papel.class, id);
    }
}
