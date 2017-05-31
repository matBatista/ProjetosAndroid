package com.example.impacta.t_008_listview_simpleadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public Context context;

    public ListView lvProdutos;
    //public ArrayList<HMaux> produtos;
    public SimpleAdapter adapterProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();
    }

    private void initVar() {

        context = getBaseContext();
        lvProdutos = (ListView) findViewById(R.id.lvProdutos);

        String[] De = { HMaux.NOME,HMaux.CODIGO};
        int[] Para = { R.id.celula_txtNome, R.id.celula_txtCodigo};

        adapterProdutos = new SimpleAdapter(
                context,
                gerarProduto(100),
                R.layout.celula,
                De,
                Para
        );

        lvProdutos.setAdapter(adapterProdutos);
    }

    private ArrayList<HMaux> gerarProduto(int quantidade) {
        ArrayList<HMaux> produtos = new ArrayList<>();
        //

        for (int i = 1; i <= quantidade; i++) {
            HMaux hMaux = new HMaux();

            hMaux.put(hMaux.CODIGO,String.valueOf(i));
            hMaux.put(hMaux.NOME,"Nome - " + String.valueOf(i));
            hMaux.put(hMaux.PRECO,String.valueOf(i * 0.5));

            produtos.add(hMaux);
        }

        //
        return produtos;
    }


    private void initActions() {

    }
}
