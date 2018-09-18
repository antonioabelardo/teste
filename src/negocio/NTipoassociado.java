/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.TipoAssociado;
import java.sql.SQLException;
import java.util.List;
import persistencia.PTipoAssociado;

/**
 *
 * @author toni
 */
public class NTipoassociado {

    PTipoAssociado persistencia;

    public NTipoassociado() {
        persistencia = new PTipoAssociado();
    }

    public void salvar(TipoAssociado parametro) throws SQLException, Exception {

        if (parametro.getDescricao().isEmpty()) {
            throw new Exception("É necessário informar a descrição.");
        }
        if (parametro.getValorMensalidade() < 0.0) {
            throw new Exception("É necessário informar o valor da mensalidade.");
        }

        if (parametro.getIdentificador() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }

    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }

    public TipoAssociado consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<TipoAssociado> listar() throws SQLException {
        return persistencia.listar();
    }

}
