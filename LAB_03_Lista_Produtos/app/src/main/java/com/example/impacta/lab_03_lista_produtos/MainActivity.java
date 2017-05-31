package com.example.impacta.lab_03_lista_produtos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lvProdutos;
    private ArrayList<HMaux> produtos;
    private ArrayAdapter<HMaux> adapterProdutos;

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

        //PRODUTOS
        gerarProdutos(100);


        adapterProdutos  = new ArrayAdapter<HMaux>(
                context,
                android.R.layout.simple_spinner_dropdown_item,
                produtos
        );

        lvProdutos.setAdapter(adapterProdutos);

    }

    private void gerarProdutos(int quantidade) {
        produtos = new ArrayList<>();

        Produtos coringa = new Produtos();
        coringa.setIdProduto(-1);
        coringa.setNome("PRODUTO NÃO SELECIONADO");

        produtos.add(coringa.toHashMap());

        for (int i = 0; i <= quantidade; i++) {
            HMaux hAux = new HMaux();

            hAux.put(hAux.CODIGO,String.valueOf(i));
            hAux.put(hAux.NOME,"Nome - " + String.valueOf(i * 10));
            hAux.put(hAux.PRECO, String.valueOf(i*0.5));


            produtos.add(hAux);
        }
    }

    private void initActions() {

        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMaux hMaux = (HMaux) parent.getItemAtPosition(position);

                Toast.makeText(context, hMaux.get(hMaux.NOME), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
