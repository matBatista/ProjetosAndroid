package com.example.impacta.lab_03_lista_produtos;

import java.util.HashMap;

/**
 * Created by no3301 on 25/05/2017.
 */

public class HMaux extends HashMap<String,String> {


    public static String CODIGO = "codigo";
    public static String NOME = "nome";
    public static String PRECO = "preco";

    @Override
    public String toString() {  return get(NOME);    }
}
