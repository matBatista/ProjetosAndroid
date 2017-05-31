package br.com.impacta.t_008_listview_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nalmir on 30/05/2017.
 */

public class HugoAdpter extends BaseAdapter {

    private Context context;

    // Le xml transforma em um binario
    private LayoutInflater mInflater;
    private int resource;
    private ArrayList<HM> dados;

    private long idseleted = -1;

    public void setIdseleted(long idseleted) {
        this.idseleted = idseleted;

        notifyDataSetChanged();
    }

    private int contador = 0;
    private boolean bNovo = false;

    public HugoAdpter(Context context, int resource, ArrayList<HM> dados) {
        this.context = context;
        //
//        this.mInflater = (LayoutInflater)
//                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mInflater = LayoutInflater.from(context);

        this.resource = resource;
        this.dados = dados;
    }

    // Devolve a quantidade de registros da minha colecao
    @Override
    public int getCount() {
        return dados.size();
    }

    // Devolve o objeto referenciado pelo parametro position
    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    // Devolve o ID do obejcto referenciado pelo parametro position
    @Override
    public long getItemId(int position) {
        // Resgatei o OBJETO
        HM hm = dados.get(position);

        return Long.parseLong(hm.get(HM.ID));
    }

    // Criar a View contendo Layout + Informacao do objeto referenciado pelo parametro position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        bNovo = false;

        if (convertView == null){
            contador += 1;
            bNovo = true;

            convertView = mInflater.inflate(resource, parent, false);
        }

        // Acesso ao Layout da celula
        TextView tv_nome = (TextView)
                convertView.findViewById(R.id.celula_tv_nome);
        TextView tv_telefone = (TextView)
                convertView.findViewById(R.id.celula_tv_telefone);
        TextView tv_contador = (TextView)
                convertView.findViewById(R.id.celula_tv_contador);
        LinearLayout ll = (LinearLayout)
                convertView.findViewById(R.id.celula_ll);

        // Recuperar os dados daquela position
        HM hm = dados.get(position);

        tv_nome.setText(hm.get(HM.TEXTO_01));
        tv_telefone.setText(hm.get(HM.TEXTO_02));

        if (bNovo){
            tv_contador.setText(String.valueOf(contador));
        }

        // Financeiro
        if (hm.get(HM.TEXTO_03).equals("0")){
            tv_nome.setTextColor(context.getColor(R.color.bom_pagador));
        } else {
            tv_nome.setTextColor(context.getColor(R.color.inadimplente));
        }

        if ( idseleted == Long.parseLong(hm.get(HM.ID))){
            ll.setBackgroundColor(context.getColor(R.color.selecionado));
        } else {
            ll.setBackgroundColor(context.getColor(R.color.nao_selecionado));
        }


        return convertView;
    }
}
