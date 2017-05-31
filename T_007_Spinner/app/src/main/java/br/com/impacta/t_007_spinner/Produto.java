package br.com.impacta.t_007_spinner;

import java.util.HashMap;

/**
 * Created by nalmir on 23/05/2017.
 */

public class Produto {

    public static String CODIGO = "codigo";
    public static String NOME = "nome";

    private long idproduto;
    private String nome;
    private double preco;
    private int quantidade;
    private boolean status;

    public Produto() {
        this.idproduto = -1;
        this.nome = "sem nome";
        this.preco = 0;
        this.quantidade = -1;
        this.status = false;
    }

    public Produto(long idproduto, String nome, double preco, int quantidade, boolean status) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.status = status;
    }

    public long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(long idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return nome;
    }

//    // HashMap<Key,Value> nome
//    public HashMap<String, String> toHashMap() {
//        HashMap<String, String> hmAux = new HashMap<>();
//
//        hmAux.put(CODIGO, String.valueOf(getIdproduto()));
//        hmAux.put(NOME, String.valueOf(getNome()));
//
//        return hmAux;
//    }

    // HashMap<Key,Value> nome
    public HMAux toHashMap() {
        HMAux hmAux = new HMAux();
        //
        hmAux.put(CODIGO, String.valueOf(getIdproduto()));
        hmAux.put(NOME, String.valueOf(getNome()));

        return hmAux;
    }
}
