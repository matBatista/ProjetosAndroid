package br.com.impacta.t_008_listview_simpleadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_produtos;
    //private ArrayList<HMAux> produtos;
    private SimpleAdapter adapter_produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();
    }

    private void initVar() {
        context = getBaseContext();

        lv_produtos = (ListView) findViewById(R.id.lv_produtos);

        String[] De = { HMAux.NOME, HMAux.CODIGO };
        int[] Para = { R.id.celula_tv_nome, R.id.celula_tv_codigo };
        adapter_produtos = new SimpleAdapter(
                context,
                gerarProdutos(100),
                R.layout.celula,
                De,
                Para
        );

        lv_produtos.setAdapter(adapter_produtos);
    }

    private ArrayList<HMAux> gerarProdutos(int quantidade) {
        ArrayList<HMAux> produtos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux hmAux = new HMAux();
            hmAux.put(HMAux.CODIGO, String.valueOf(i));
            hmAux.put(HMAux.NOME, "Nome - " + String.valueOf(i));
            hmAux.put(HMAux.VALOR, String.valueOf(i*0.5));

            produtos.add(hmAux);
        }
        //
        return produtos;
    }


    private void initActions() {

    }
}
