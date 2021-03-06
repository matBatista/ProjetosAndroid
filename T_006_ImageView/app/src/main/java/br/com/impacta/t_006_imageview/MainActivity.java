package br.com.impacta.t_006_imageview;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_foto;
    private Button btn_projeto;
    private Button btn_sdcard;
    private TextView txtDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();
    }

    /**
     * Fase Inicializacao
     */
    private void initVar() {
        iv_foto = (ImageView) findViewById(R.id.iv_foto);
        btn_projeto = (Button) findViewById(R.id.btn_projeto);
        btn_sdcard = (Button) findViewById(R.id.btn_sdcard);
        txtDados = (TextView) findViewById(R.id.txtDados);
        //Limpar a area da imagem
        //iv_foto.setImageBitmap(null);
    }


    private void initActions() {
        iv_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_foto.setImageResource(R.drawable.coruja_3);
            }
        });

        btn_projeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Consumir uma imagem pertence ao projeto
                iv_foto.setImageResource(R.drawable.coruja_1);
            }
        });

        btn_sdcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caminho = "/sdcard/nova_mae.jpg";

                iv_foto.setImageBitmap(BitmapFactory.decodeFile(caminho));

                txtDados.setText(caminho);
            }
        });

    }
}
