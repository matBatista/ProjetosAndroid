package br.com.impacta.lab_02_credito;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_nome;
    private EditText et_idade;

    private CheckBox cb_sao_paulo;
    private Button btn_ac;

    private String mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();
    }

    private void initVar() {
        context = getBaseContext();

        et_nome = (EditText) findViewById(R.id.et_nome);
        et_idade = (EditText) findViewById(R.id.et_idade);

        cb_sao_paulo = (CheckBox) findViewById(R.id.cb_sao_paulo);

        btn_ac = (Button) findViewById(R.id.btn_ac);

        LimparCampos();

    }

    private void LimparCampos() {
        et_nome.setBackground(getResources().getDrawable(R.drawable.borda));
        et_idade.setBackground(getResources().getDrawable(R.drawable.borda));
    }

    private void initActions() {

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validacao()) {
                    analiseCredito();
                } else {
                    exibirErro();
                }
            }
        });

    }

    private boolean validacao() {
        LimparCampos();

        String nome = et_nome.getText().toString().trim();
        int idade = conversao(et_idade.getText().toString());

        if (nome.length() == 0) {
            mensagem = "Erro: Nome é Obrigatório!!!";
            et_nome.setBackground(getResources().getDrawable(R.drawable.borda_erro));

            return false;
        }
        //
        if (idade == -1){
            mensagem = "Erro: Idade é Obrigatória!!!";
            et_idade.setBackground(getResources().getDrawable(R.drawable.borda_erro));

            return false;
        }
        //
        // Erro de Negocio
        if (idade < 18){
            mensagem = "Erro: Idade Inválida!!!";
            et_idade.setBackground(getResources().getDrawable(R.drawable.borda_erro));

            return false;
        }

        return true;
    }

    private int conversao(String idade) {

        try {
            return Integer.parseInt(idade);
        } catch (Exception e) {
            return -1;
        }
    }

    private void analiseCredito() {
        int idade = conversao(et_idade.getText().toString());
        double credito = 0;
        //
        if (cb_sao_paulo.isChecked()){
            if (idade >= 25){
                credito = 5000;
            } else {
                credito = 1000;
            }
        } else {
            if (idade >=25){
                credito = 500;
            }
        }
        //
        Toast.makeText(
                context,
                String.valueOf(credito),
                Toast.LENGTH_SHORT
        ).show();

    }

    private void exibirErro() {
        Toast.makeText(
                context,
                mensagem,
                Toast.LENGTH_SHORT
        ).show();
    }
}
