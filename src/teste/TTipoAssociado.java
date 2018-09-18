/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidade.TipoAssociado;
import java.sql.SQLException;
import java.util.List;
import persistencia.PTipoAssociado;

/**
 *
 * @author toni
 */
public class TTipoAssociado {
    public static void main(String[] args) {
        /*
        Scanner scn = new Scanner(System.in);
        TipoAssociado tp = new TipoAssociado();
        
        System.out.println("Digite a descricao");
        tp.setDescricao(scn.next());
        
         System.out.println("Digite a Mensalidade");
        tp.setValorMensalidade(scn.nextDouble());
        */
        PTipoAssociado pt = new PTipoAssociado();
        
        try {
            List<TipoAssociado> retorno = pt.Listar();
            
            for (TipoAssociado tipo : retorno) {
              
                System.out.println("Indentificador...: "+ tipo.getIndentificador());
                System.out.println("Descrição........: "+ tipo.getDescricao());
                System.out.println("Valormesalidade..: "+ tipo.getValorMensalidade());
                System.out.println("");
            }

        } catch (SQLException e) {
              System.out.println("Deu certo!!!"+ e.getMessage());
        }
 
    }
    
}
