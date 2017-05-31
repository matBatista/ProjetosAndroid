package br.com.impacta.t_007_spinner;

import java.util.HashMap;

/**
 * Created by nalmir on 23/05/2017.
 */

public class HMAux extends HashMap<String, String> {

    @Override
    public String toString() {
        return get(Produto.NOME);
    }
}
