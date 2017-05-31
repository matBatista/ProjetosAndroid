package br.com.impacta.t_001_textview_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_titulo_hugo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);


        tv_titulo_hugo = (TextView) findViewById(R.id.tv_titulo);

        String var1 = tv_titulo_hugo.getText().toString();
        String var2 = "iOs";

        tv_titulo_hugo.setText(var1 + " - "  + var2);
        tv_titulo_hugo.setTextColor(getResources().getColor(R.color.azul));


    }


}
