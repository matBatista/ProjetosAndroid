package br.com.impacta.lab_04_heros;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_herois;
    private ArrayList<HM> herois;
    private SimpleAdapter adapter_herois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();
    }



    private void initVar() {
        context = getBaseContext();

        lv_herois = (ListView) findViewById(R.id.lv_herois);

        gerarHerois();

        String[] De = {HM.TEXTO_01, HM.TEXTO_02};
        int[] Para = {R.id.celula_iv_foto, R.id.celula_tv_nome};

        adapter_herois = new SimpleAdapter(
                context,
                herois,
                R.layout.celula,
                De,
                Para
        );

        lv_herois.setAdapter(adapter_herois);
    }

    int [] imagens = {
            R.drawable.avenger01,
            R.drawable.avenger02,
            R.drawable.avenger03,
            R.drawable.avenger04,
            R.drawable.avenger05,
            R.drawable.avenger06,
            R.drawable.avenger07,
            R.drawable.avenger08,
            R.drawable.avenger09,
            R.drawable.avenger10,
            R.drawable.avenger11
    };

    String [] nomes = {
            "Gaviao Arqueiro",
            "War Machine",
            "Thor",
            "Nick Fury",
            "Loke",
            "Iron Man",
            "Hulk",
            "Homem Formiga",
            "Capitao America",
            "Viuva Negra",
            "Agente Wharever"
    };

    String [] poderes = {
            "Nada",
            "Ter um amigo rico",
            "Deus Nordico",
            "Gerenciar Egos",
            "FDP",
            "Homem, Filantropo, Rico",
            "Paciencia",
            "Sortudo",
            "Bom Moco (Chato)",
            "Nao podemos descrever em palavras",
            "Agente Wharever"
    };

    private void gerarHerois() {
        herois = new ArrayList<>();

        for (int i = 0; i < imagens.length; i++) {
            HM hm = new HM();
            hm.put(HM.ID, String.valueOf(i+1));
            hm.put(HM.TEXTO_01, String.valueOf(imagens[i]));
            hm.put(HM.TEXTO_02, String.valueOf(nomes[i]));
            hm.put(HM.TEXTO_03, String.valueOf(poderes[i]));

            herois.add(hm);
        }

    }

    private void initActions() {

        lv_herois.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HM hm = (HM) parent.getItemAtPosition(position);

                Toast.makeText(
                        context,
                        hm.get(HM.TEXTO_03),
                        Toast.LENGTH_SHORT
                ).show();


            }
        });

    }
}
