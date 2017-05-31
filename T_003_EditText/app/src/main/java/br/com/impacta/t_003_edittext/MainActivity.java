package br.com.impacta.t_003_edittext;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText etName;
    private EditText etPassword;
    private Button bLogin;
    private Button bCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();

    }

    private void inicializarAcao() {
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                String resultado = null;

                if (!name.equalsIgnoreCase("hugo") || !password.equals("T123"))
                {
                    resultado = "Credencais Invalidas";
                }
                else
                {
                    resultado = "Credencais Validas";
                }

                Toast.makeText(
                        context,
                        resultado,
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                limparTela();
            }
        });
    }

    private void limparTela() {
        etName.setText("");
        etPassword.setText("");
        etName.requestFocus();
    }

    private void inicializarVariavel() {
        context = getBaseContext();

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);

        bLogin = (Button) findViewById(R.id.bLogin);
        bCancel = (Button) findViewById(R.id.bCancel);
    }
}
