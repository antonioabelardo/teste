/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.TipoAssociado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import teste.TTipoAssociado;

/**
 *
 * @author toni
 */
public class PTipoAssociado {

    public void incluir(TipoAssociado parametro) throws SQLException {

        //Criar a conexão sql para inserção de registro
        String sql = "INSERT INTO "
                + " tipoassociado (descricao, valormensalidade) "
                + "VALUES (?, ?)";

        //Criar a conexão a partir dos metodos da fabrica de conexoes
        Connection cnn = util.Conexao.getConexao();

        //Criar o procedimento para a execução "conta" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores de ? por valore recebidos no medodo
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValorMensalidade());
        prd.execute();
        cnn.close();
    }

    public void alterar(TipoAssociado parametro) throws SQLException {
        //Criar a conexão sql para inserção de registro
        String sql = "UPDATE tipoassociado"
                + "SET (descricao = ? , valormensalidade=?) "
                + "WHERE identificador = ?";

        //Criar a conexão a partir dos metodos da fabrica de conexoes
        Connection cnn = util.Conexao.getConexao();

        //Criar o procedimento para a execução "conta" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores de ? por valore recebidos no medodo
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValorMensalidade());
        prd.setInt(3, parametro.getIndentificador());
        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        //Criar a conexão sql para inserção de registro
        String sql = "DELETE INTO "
                + "FROM tipoassociado"
                + "WHERE (descricao = ? , valormensalidade=?) "
                + "AND identificador";

        //Criar a conexão a partir dos metodos da fabrica de conexoes
        Connection cnn = util.Conexao.getConexao();

        //Criar o procedimento para a execução "conta" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores de ? por valore recebidos no medodo
    }

    public TipoAssociado consultar(int parametro) {
        return null;
    }

    public List<TipoAssociado> Listar() throws SQLException {
        String sql = "SELECT * FROM tipoassociado";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<TipoAssociado> retorno = new ArrayList<TipoAssociado>();

        while (rs.next()) {
            TipoAssociado tipo = new TipoAssociado();

            tipo.setIndentificador(rs.getInt("identificador"));
            tipo.setDescricao(rs.getString("descricao"));
            tipo.setValorMensalidade(rs.getInt("Valormensalidade"));
            
            retorno.add(tipo);

        }
        return retorno;
    }

    public List<TipoAssociado> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
