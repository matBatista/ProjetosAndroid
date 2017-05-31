package br.com.impacta.lab_01_login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_nome;
    private EditText et_senha;

    private Button btn_cancelar;
    private Button btn_login;

    private String mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();

        et_nome = (EditText) findViewById(R.id.et_nome);
        et_senha = (EditText) findViewById(R.id.et_senha);

        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    private void inicializarAcao() {

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar_tela();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validacao()){
                    exibirMensagem();
                } else {
                    exibirMensagemErro();
                }
            }


        });


    }

    private void limpar_tela() {
        et_nome.setText("");
        et_senha.setText("");

        et_nome.requestFocus();
    }

    private boolean validacao() {
        String nome = et_nome.getText().toString().trim();
        String senha = et_senha.getText().toString().trim();

        if (nome.length() == 0){
            mensagem = getString(R.string.erro_msg_nome_obrigatorio);

            return false;
        }
        if (senha.length() == 0){
            mensagem = "Erro: Senha é Obrigatoria!!!";

            return false;
        }
        if ( !nome.equalsIgnoreCase("Hugo") || !senha.equals("T123")){
            mensagem = "Erro: Credenciais Invalidas";

            return false;
        }

        mensagem = "Credenciais Validas";

        return true;
    }

    private void exibirMensagem() {
        exibir(mensagem);
    }

    private void exibirMensagemErro() {
        exibir(mensagem);
    }

    private void exibir(String mensagem) {
        Toast.makeText(
                context,
                mensagem,
                Toast.LENGTH_SHORT
        ).show();
    }
}
