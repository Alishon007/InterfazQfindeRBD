package com.example.interfazqfinderbd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private List<String> usuarios;
    private OnUsuarioActionListener listener;

    public UsuarioAdapter(Context context, List<String> usuarios, OnUsuarioActionListener listener) {
        this.context = context;
        this.usuarios = usuarios;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_usuario, parent, false);
        }

        TextView textUsuario = convertView.findViewById(R.id.textUsuario);
        Button btnEditar = convertView.findViewById(R.id.btnEditar);
        Button btnEliminar = convertView.findViewById(R.id.btnEliminar);

        String usuario = usuarios.get(position);
        textUsuario.setText(usuario);

        btnEditar.setOnClickListener(v -> listener.onEditarClicked(usuario));
        btnEliminar.setOnClickListener(v -> listener.onEliminarClicked(usuario));

        return convertView;
    }

    public interface OnUsuarioActionListener {
        void onEditarClicked(String usuario);
        void onEliminarClicked(String usuario);
    }
}