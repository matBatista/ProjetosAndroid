package br.com.impacta.t_008_listview_baseadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_nomes;
    private ArrayList<HM> nomes;
    private HugoAdpter adapter_nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();
    }

    private void initVar() {
        context = getBaseContext();

        lv_nomes = (ListView) findViewById(R.id.lv_nomes);

        gerarNomes(10000);

        adapter_nomes = new HugoAdpter(
                context,
                R.layout.celula_m,
                nomes
        );

        lv_nomes.setAdapter(adapter_nomes);
    }

    private void gerarNomes(int quantidade) {
        nomes = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {
            HM hm = new HM();
            hm.put(HM.ID, String.valueOf(i*10));
            hm.put(HM.TEXTO_01, "Nome - " + String.valueOf(i*10));
            hm.put(HM.TEXTO_02, "Telefone - " + String.valueOf(i*10));
            hm.put(HM.TEXTO_03, String.valueOf(i%2));

            nomes.add(hm);
        }
    }

    private void initActions() {

        lv_nomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter_nomes.setIdseleted(id);
            }
        });

    }
}
