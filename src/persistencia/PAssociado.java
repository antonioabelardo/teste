/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Associado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toni
 */
public class PAssociado {

    public void incluir(Associado parametro) throws SQLException {

        //Criar a conexão sql para inserção de registro
        String sql = "INSERT INTO "
                + " associado (nome,endereco,telefone) "
                + "VALUES (?, ?, ?)";

        //Criar a conexão a partir dos metodos da fabrica de conexoes
        Connection cnn = util.Conexao.getConexao();

        //Criar o procedimento para a execução "conta" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores de ? por valore recebidos no medodo
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getEndereco());
        prd.setString(3, parametro.getTelefone());
        prd.execute();
        cnn.close();
    }

    public void alterar(Associado parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "UPDATE associado SET"
                + " nome = ?,"
                + " endereco = ?  "
                + " telefone = ?  "
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getEndereco());
        prd.setString(3, parametro.getTelefone());

        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        //Criar a conexão sql para inserção de registro
        String sql = "DELETE INTO "
                + "FROM associado"
                + "WHERE (nome = ? , endereco = ? , telefone = ?) "
                + "AND identificador";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setInt(1, parametro);

        prd.execute();
        cnn.close();
    }

    public Associado consultar(int parametro) throws SQLException {

        String sql = "SELECT identificadorpk, nome, endereco, telefone"
                + " FROM associado WHERE identificador = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Associado retorno = new Associado();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
        }

        return retorno;
    }

    public List<Associado> listar() throws SQLException {

        String sql = "SELECT * FROM associado";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<Associado> retorno = new ArrayList<Associado>();

        while (rs.next()) {
            Associado tipo = new Associado();

            tipo.setIdentificador(rs.getInt("identificador"));
            tipo.setNome(rs.getString("nome"));
            tipo.setEndereco(rs.getString("endereco"));
            tipo.setTelefone(rs.getString("telefone"));

            retorno.add(tipo);
        }

        return retorno;
    }

}
