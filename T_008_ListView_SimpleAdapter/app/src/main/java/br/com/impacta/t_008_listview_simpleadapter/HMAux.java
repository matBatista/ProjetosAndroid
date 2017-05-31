package br.com.impacta.t_008_listview_simpleadapter;

import java.util.HashMap;

/**
 * Created by nalmir on 25/05/2017.
 */

public class HMAux extends HashMap<String, String> {

    public static final String CODIGO = "codigo";
    public static final String NOME = "nome";
    public static final String VALOR = "valor";

    @Override
    public String toString() {
        return get(NOME);
    }
}
