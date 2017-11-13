/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import locadora.entity.Aluguel;

/**
 *
 * @author jhonatan
 */
public class AluguelDAO extends GenericDAO<Aluguel>{
    
    public List<Aluguel> obterTodosByUser(String login) {
        TypedQuery<Aluguel> query = getEntityManager().createNamedQuery("Aluguel.findByUser", Aluguel.class)
                .setParameter("usuario", login);
        return query.getResultList();
    }
}
