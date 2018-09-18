/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author toni
 */
public class Conexao {

    private static Connection conexao;

    private static Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/clubefatesg20182", "postgres", "123456");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver JDBC não encontrado! Verique as biblotecas da aplicação.");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Caminho, banco de dados, usuário ou senha incorretos. Favor verifique!");
        }
        return null;
    }

    public static Connection getConexao() {
        try {
            while (conexao == null || conexao.isClosed()) {
                conexao = Conexao.conectar();
                System.out.println("Tentando conexão...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
}
