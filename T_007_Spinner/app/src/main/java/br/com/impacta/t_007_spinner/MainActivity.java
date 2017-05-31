package br.com.impacta.t_007_spinner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    // String
    private Spinner sp_nomes;
    private ArrayAdapter<String> adapter_nomes;
    private ArrayList<String> nomes;

    // Produto
    private Spinner sp_produtos;
    private ArrayAdapter<Produto> adapter_produtos;
    private ArrayList<Produto> produtos;

    // HMAux
    private Spinner sp_produtos_hm;
    private ArrayAdapter<HMAux> adapter_produtos_hm;
    private ArrayList<HMAux> produtos_hm;

    private Button btn_selecionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();
    }

    private void initVar() {
        context = getBaseContext();

        sp_nomes = (Spinner) findViewById(R.id.sp_nomes);

        gerarNomes(100);

        adapter_nomes = new ArrayAdapter<String>(
                context,
                android.R.layout.simple_spinner_item,
                nomes
        );

        adapter_nomes.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        sp_nomes.setAdapter(adapter_nomes);

        /// Produtos

        sp_produtos = (Spinner) findViewById(R.id.sp_produtos);

        gerarProdutos(100);

        adapter_produtos = new ArrayAdapter<Produto>(
                context,
                android.R.layout.simple_spinner_item,
                produtos
        );

        adapter_produtos.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        sp_produtos.setAdapter(adapter_produtos);

        sp_produtos.setSelection(encontrePosition(sp_produtos, 81));

        btn_selecionar = (Button) findViewById(R.id.btn_selecao);

        /// Produtos HM

        sp_produtos_hm = (Spinner) findViewById(R.id.sp_produtos_hm);

        gerarProdutos_hm(100);

        adapter_produtos_hm = new ArrayAdapter<HMAux>(
                context,
                android.R.layout.simple_spinner_item,
                produtos_hm
        );

        adapter_produtos_hm.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        sp_produtos_hm.setAdapter(adapter_produtos_hm);
    }

    private int encontrePosition(Spinner sp_produtos, int id) {
        int indice = 0;
        //
        for (int i = 0; i < sp_produtos.getCount(); i++) {
            Produto p1 = (Produto) sp_produtos.getItemAtPosition(i);
            if (p1.getIdproduto() == id) {
                indice = i;
                //
                break;
            }
        }
        //
        return indice;
    }

    private void gerarNomes(int quantidade) {
        nomes = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {
            nomes.add("Nome - " + String.valueOf(i));
        }

    }

    private void gerarProdutos(int quantidade) {
        produtos = new ArrayList<>();

        //'Produto pAux = new Produto();

        Produto coringa = new Produto();
        coringa.setIdproduto(-1);
        coringa.setNome("Selecione um Produto");

        produtos.add(coringa);

        for (int i = 1; i <= quantidade; i++) {
            Produto pAux = new Produto();
            pAux.setIdproduto(i*10);
            pAux.setNome("Nome - " + String.valueOf(i*10));
            pAux.setPreco(0.5*i);
            pAux.setQuantidade(10);
            pAux.setStatus(true);

            produtos.add(pAux);
        }

    }

    private void gerarProdutos_hm(int quantidade) {
        produtos_hm = new ArrayList<>();

        //'Produto pAux = new Produto();

        Produto coringa = new Produto();
        coringa.setIdproduto(-1);
        coringa.setNome("Selecione um Produto");

        produtos_hm.add(coringa.toHashMap());

        for (int i = 1; i <= quantidade; i++) {
            Produto pAux = new Produto();
            pAux.setIdproduto(i*10);
            pAux.setNome("Nome - " + String.valueOf(i*10));
            //pAux.setPreco(0.5*i);
            //pAux.setQuantidade(10);
            //pAux.setStatus(true);

            produtos_hm.add(pAux.toHashMap());
        }

    }


    private void initActions() {

        btn_selecionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto p1 = (Produto) sp_produtos.getSelectedItem();

                Toast.makeText(
                        context,
                        String.valueOf(p1.getIdproduto()),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }
}
