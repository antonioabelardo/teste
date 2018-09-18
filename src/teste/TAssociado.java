/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidade.Associado;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.PAssociado;

/**
 *
 * @author toni
 */
public class TAssociado {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
/*        
        Associado tp = new Associado();
        
        System.out.println("Digite o Nome: ");
        tp.setNome(scn.next());
        
        System.out.println("Digite o Endereço: ");
        tp.setEndereco(scn.next());
        
        System.out.println("Digite o Telefone: ");
        tp.setTelefone(scn.next());
        
        PAssociado per = new PAssociado();
        try {
            per.incluir(tp);
        } catch (SQLException ex) {
            Logger.getLogger(TAssociado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("DEU CERTO!");
*/
//        System.out.println("Digite o código: ");
//       int codigo = scn.nextInt();

//        PAssociado pt = new PAssociado();

//       try {
//            Associado retorno = pt.consultar(codigo);
//
//            if (retorno.getIdentificador()!= 0) {
//                System.out.println("Identificador....: " + retorno.getIdentificador());
//                System.out.println("Nome........: " + retorno.getNome());
//                System.out.println("Telefone....: " + retorno.getTelefone());
//           }else{
//                System.out.println("Tipo associado não encontrado!");
//          }
//       } catch (SQLException ex) {
//         Logger.getLogger(TAssociado.class.getName()).log(Level.SEVERE, null, ex);
//       }
//    }

    

        Associado pt = new Associado();

        try {
            List<Associado> retorno = pt.Listar();

            for (Associado tipo : retorno) {
                System.out.println("Identificador....: " + tipo.getIdentificador());
                System.out.println("Nome.............: " + tipo.getNome());
                System.out.println("Endereço.........: " + tipo.getEndereco());
                System.out.println("Telefone.........: " + tipo.getTelefone());
                System.out.println("Telefone.........: " + tipo.getId_associado());
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("Deu certo!!!" + e.getMessage());
        }

    }

}
