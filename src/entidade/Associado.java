/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.List;

/**
 *
 * @author toni
 */
public class Associado {

    private int identificadorpk;
    private int id_associado;
    private String nome;
    private String endereco;
    private String telefone;

    private TipoAssociado tipoassociado;

    public Associado() {
        tipoassociado = new TipoAssociado();
    }

    public void setTipoassociado(TipoAssociado tipoassociado) {
        this.tipoassociado = tipoassociado;
    }

    public int getId_associado() {
        return id_associado;
    }

    public void setId_associado(int id_associado) {
        this.id_associado = id_associado;
    }

    public int getIdentificador() {
        return identificadorpk;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public TipoAssociado getTipoassociado() {
        return tipoassociado;
    }

    public void setIdentificador(int identificador) {
        this.identificadorpk = identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Associado> Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
