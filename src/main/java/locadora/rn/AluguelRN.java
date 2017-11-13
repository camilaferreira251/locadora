/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.rn;

import java.util.List;
import locadora.dao.AluguelDAO;
import locadora.entity.Aluguel;
import locadora.entity.Usuario;

/**
 *
 * @author jhonatan
 */
public class AluguelRN {
    private final AluguelDAO dao = new AluguelDAO();

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
    
    public List<Aluguel> obterTodosPorLogin(Usuario user) {
        return dao.obterTodosByUser(user.getLogin());
    }

    public Aluguel obter(String id) {
        return dao.obter(Aluguel.class, id);
    }
}
