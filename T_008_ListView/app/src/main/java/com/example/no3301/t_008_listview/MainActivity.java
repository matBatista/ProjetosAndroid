package com.example.no3301.t_008_listview;

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
    private ListView lvNomes;

    private ArrayAdapter<String> adapterNomes;
    private ArrayList<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        initVar();
        initActions();
    }

    private void initVar() {
        context = getBaseContext();

        lvNomes = (ListView) findViewById(R.id.lvNomes);

        gerarNomes(100);

        adapterNomes = new ArrayAdapter<String>(
                context,
                R.layout.row,
                nomes
        );

        lvNomes.setAdapter(adapterNomes);
    }

    private void gerarNomes(int quantidade) {

        nomes = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {

            nomes.add("Nomes - " + String.valueOf(i));

        }

    }

    private void initActions() {

        lvNomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = (String) parent.getItemAtPosition(position);

                Toast.makeText(context, nome, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
