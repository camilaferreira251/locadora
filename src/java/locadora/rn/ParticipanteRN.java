/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.rn;

import java.util.List;
import locadora.dao.GenericDAO;
import locadora.entity.Participante;

/**
 *
 * @author jhonatan
 */
public class ParticipanteRN {
    private final GenericDAO<Participante> dao = new GenericDAO<Participante>();

    public boolean salvar(Participante participante) {
        if (participante.getTelefone().equals("") || participante.getRg().equals("")) {
            return false;
        } else {
            if (participante.getId() == null) {
                return dao.criar(participante);
            } else {
                return dao.alterar(participante);
            }
        }
    }

    public boolean remover(Participante participante) {
        return dao.excluir(participante);
    }

    public List<Participante> getList() {
        return dao.obterTodos(Participante.class);
    }
}
