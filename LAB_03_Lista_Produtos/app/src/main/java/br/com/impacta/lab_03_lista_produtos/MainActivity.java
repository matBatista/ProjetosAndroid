package br.com.impacta.lab_03_lista_produtos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_produtos;
    private ArrayList<HMAux> produtos;
    private ArrayAdapter<HMAux> adapter_produtos;

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

        gerarProduto(100);

        adapter_produtos = new ArrayAdapter<HMAux>(
                context,
                android.R.layout.simple_list_item_1,
                produtos
        );

        lv_produtos.setAdapter(adapter_produtos);

    }

    private void gerarProduto(int quantidade) {
        produtos = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {
            HMAux mHmAux = new HMAux();

            mHmAux.put(HMAux.CODIGO, String.valueOf(i));
            mHmAux.put(HMAux.NOME, "Nome - " + String.valueOf(i));
            mHmAux.put(HMAux.VALOR, String.valueOf(i*0.5));
            // Nao Recomendado
            mHmAux.put("hugo", "hugo - " + String.valueOf(i));

            produtos.add(mHmAux);
        }
    }

    private void initActions() {

        lv_produtos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAux hmAux = (HMAux) parent.getItemAtPosition(position);

                StringBuilder sb = new StringBuilder();
                sb
                        .append("Codigo: ")
                        .append(hmAux.get(HMAux.CODIGO) + "\n")
                        .append("Nome: ")
                        .append(hmAux.get(HMAux.NOME) + "\n")
                        .append("Valor: ")
                        .append(hmAux.get(HMAux.VALOR) + "\n")
                        .append("Hugo: ")
                        .append(hmAux.get("hugo"));


                Toast.
                        makeText(
                                context,
                                sb.toString(),
                                Toast.LENGTH_SHORT

                        ).show();
            }
        });

    }
}
