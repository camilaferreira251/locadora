/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import locadora.entity.Aluguel;
import locadora.entity.Veiculo;

/**
 *
 * @author jhonatan
 */
public class VeiculoDAO extends GenericDAO<Veiculo> {

    public List<Veiculo> obterVeiculosMaisAlugados() {
        String squery = "SELECT v.* FROM Veiculo v JOIN Aluguel a\n"
                + "ON a.veiculo_id = v.id GROUP BY v.id ORDER BY COUNT(v.id) DESC;";
        Query query = getEntityManager().createNativeQuery(squery, Veiculo.class);
        return query.getResultList();
    }

    public List<Veiculo> obterVeiculosBusca(Aluguel a) {
        String squery = "SELECT v.* FROM Veiculo v\n"
                + "WHERE v.id NOT IN (SELECT a.veiculo_id FROM Aluguel a\n"
                + "WHERE a.dataInicio BETWEEN ? AND ? \n"
                + "OR a.dataFim BETWEEN ? AND ? )";
        Query query = getEntityManager().createNativeQuery(squery, Veiculo.class)
                .setParameter(1, a.getDataInicio(), TemporalType.TIMESTAMP)
                .setParameter(2, a.getDataFim(), TemporalType.TIMESTAMP)
                .setParameter(3, a.getDataInicio(), TemporalType.TIMESTAMP)
                .setParameter(4, a.getDataFim(), TemporalType.TIMESTAMP);
        return (List<Veiculo>) query.getResultList();
    }
}
