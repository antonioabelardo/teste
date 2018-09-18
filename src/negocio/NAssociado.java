/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Associado;
import java.sql.SQLException;
import java.util.List;
import persistencia.PAssociado;


/**
 *
 * @author toni
 */
public class NAssociado {
        PAssociado persistencia;

    public NAssociado() {
        persistencia = new PAssociado();
    }

    public void salvar(Associado parametro) throws SQLException, Exception {

        if (parametro.getNome().isEmpty()) {
            throw new Exception("É necessário informar um nome.");
        }
        if (parametro.getEndereco().isEmpty()) {
            throw new Exception("É necessário informar um endereco.");
        }
        if (parametro.getTelefone().isEmpty()) {
            throw new Exception("É necessário informar um numero de telefone.");
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

    public Associado consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Associado> listar() throws SQLException {
        return persistencia.listar();
    }

    
}
