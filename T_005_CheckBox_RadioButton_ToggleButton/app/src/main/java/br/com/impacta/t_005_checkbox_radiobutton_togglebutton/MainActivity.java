package br.com.impacta.t_005_checkbox_radiobutton_togglebutton;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Context context;
    // Declarei as minhas variaveis
    private CheckBox cb_ios;
    private CheckBox cb_android;

    private RadioGroup rg;
    private RadioButton rb_m;
    private RadioButton rb_f;

    private ToggleButton tb_tomada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVar();
        initActions();
    }

    private void initVar() {
        context = getBaseContext();

        cb_ios = (CheckBox) findViewById(R.id.cb_ios);
        cb_android = (CheckBox) findViewById(R.id.cb_android);

        rg  = (RadioGroup) findViewById(R.id.rg);
        rb_m = (RadioButton) findViewById(R.id.rb_m);
        rb_f = (RadioButton) findViewById(R.id.rb_f);

        tb_tomada = (ToggleButton) findViewById(R.id.tb_tomada);

        // Preencher com dados vindos do banco
        VindoDoBancoDeDados();

        // Puxar a informacao da tela para o banco
        DaTelaParaBancoDados();
    }

    private void VindoDoBancoDeDados() {
        Aluno a1 = new Aluno();
        a1.setSabe_ios(0);
        a1.setSabe_android(1);
        a1.setSexo("M");
        a1.setAtivo(true);

        if (a1.getSabe_ios() == 1) {
            cb_ios.setChecked(true);
        } else {
            cb_ios.setChecked(false);
        }
        //
        if (a1.getSabe_android() == 1) {
            cb_android.setChecked(true);
        } else {
            cb_android.setChecked(false);
        }
        //
//        if (a1.getSexo().equalsIgnoreCase("M")){
//            rb_m.setChecked(true);
//        } else {
//            rb_f.setChecked(true);
//        }
        switch (a1.getSexo().toLowerCase()){
            case "m":
                rb_m.setChecked(true);
                break;
            case "f":
                rb_f.setChecked(true);
                break;
            default:
                break;
        }
        //
        tb_tomada.setChecked(a1.isAtivo());

    }

    private void DaTelaParaBancoDados() {
        Aluno a2 = new Aluno();

        if (cb_ios.isChecked()){
            a2.setSabe_ios(1);
        } else {
            a2.setSabe_ios(0);
        }
        //
        if (cb_android.isChecked()){
            a2.setSabe_android(1);
        } else {
            a2.setSabe_android(0);
        }
        //
        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb_m:
                a2.setSexo("M");
                break;
            case R.id.rb_f:
                a2.setSexo("F");
                break;
            default:
                a2.setSexo("I");
                break;
        }
        //
        a2.setAtivo(tb_tomada.isChecked());



    }

    private void initActions() {

    }

    private class Aluno{
        private int sabe_ios;
        private int sabe_android;

        private String sexo;

        private boolean ativo;

        public int getSabe_ios() {
            return sabe_ios;
        }

        public void setSabe_ios(int sabe_ios) {
            this.sabe_ios = sabe_ios;
        }

        public int getSabe_android() {
            return sabe_android;
        }

        public void setSabe_android(int sabe_android) {
            this.sabe_android = sabe_android;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public boolean isAtivo() {
            return ativo;
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }
    }
}
