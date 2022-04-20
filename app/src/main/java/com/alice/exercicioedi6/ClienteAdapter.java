package com.alice.exercicioedi6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ClienteAdapter extends ArrayAdapter<Cliente> {
    private final Context context;
    private final ArrayList<Cliente> elementos;
    public ClienteAdapter(Context context, ArrayList<Cliente> elementos){
        super(context, R.layout.mylist, elementos);
        this.context = context;
        this.elementos = elementos;

    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.mylist, parent, false);
        TextView nomeCliente = (TextView) rowView.findViewById(R.id.textView);
        TextView matriculaCliente = (TextView) rowView.findViewById(R.id.textView2);
        TextView enderecoCliente = (TextView) rowView.findViewById(R.id.textView3);
        TextView complementoCliente = (TextView) rowView.findViewById(R.id.textView4);
        TextView numeroCliente = (TextView) rowView.findViewById(R.id.textView5);
        TextView cidadeCliente = (TextView) rowView.findViewById(R.id.textView6);


        nomeCliente.setText(elementos.get(position).getNome());
        matriculaCliente.setText(elementos.get(position).getMatricula());
        enderecoCliente.setText(elementos.get(position).getEndereco());
        complementoCliente.setText(elementos.get(position).getComplemento());
        numeroCliente.setText(elementos.get(position).getNumero());
        cidadeCliente.setText(elementos.get(position).getCidade());
        return rowView;
    }


}
