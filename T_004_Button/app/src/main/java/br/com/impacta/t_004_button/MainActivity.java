package br.com.impacta.t_004_button;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    Button btn_01;
    Button btn_02;
    Button btn_03;
    View btn_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();

    }

    private void initVar() {

        context = getBaseContext();

        btn_01 = (Button) findViewById(R.id.btn_01);
        btn_02 = (Button) findViewById(R.id.btn_02);
        btn_03 = (Button) findViewById(R.id.btn_03);

        btn_v = (View) findViewById(R.id.btn_v);
    }

    private void initActions() {
//        // Forma Anonima
//        btn_01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        btn_01.setOnClickListener(btnListener);
        btn_02.setOnClickListener(btnListener);
        btn_03.setOnClickListener(btnListener);

        btn_v.setOnClickListener(btnListener);
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String resultado = null;

            switch (v.getId()) {
                case R.id.btn_01:
                    resultado = "Botão 01";
                    btn_02.setOnClickListener(null);
                    break;
                case R.id.btn_02:
                    resultado = "Botão 02";
                    break;
                case R.id.btn_03:
                    resultado = "Botão 03";
                    btn_02.setOnClickListener(btnListener);
                    break;
                case R.id.btn_v:
                    resultado = "VIEW";
                    break;
                default:
                    resultado = "Não Implementado!!";
                    break;
            }

            Toast.makeText(context,resultado, Toast.LENGTH_SHORT).show();
        }
    };
}
