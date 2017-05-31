package com.example.impacta.lab_03_lista_produtos;

/**
 * Created by no3301 on 25/05/2017.
 */

public class Produtos {

    public static String CODIGO = "codigo";
    public static String NOME = "nome";

    private long idProduto;
    private String nome;
    private double preco;
    private int qtdeMin;
    private boolean status;

    public Produtos() {
        this.idProduto = -1;
        this.nome = "SEM PRODUTO";
        this.preco = 0;
        this.qtdeMin = 0;
        this.status = false;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
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

    public int getQtdeMin() {
        return qtdeMin;
    }

    public void setQtdeMin(int qtdeMin) {
        this.qtdeMin = qtdeMin;
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

    public HMaux toHashMap(){

        HMaux hmAux = new HMaux();

        hmAux.put(CODIGO,String.valueOf(getIdProduto()));
        hmAux.put(NOME,String.valueOf(getNome()));

        return hmAux;
    }

}
