package com.example.interfazqfinderbd.controller;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.interfazqfinderbd.R;
import com.example.interfazqfinderbd.UsuarioAdapter;
import com.example.interfazqfinderbd.model.DbHelper;


import java.util.List;

public class Listar extends AppCompatActivity {

    private List<String> usuarios;
    private UsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        // Encuentra el ListView
        ListView listView = findViewById(R.id.listView);

        // Obtén la lista de usuarios desde la base de datos
        DbHelper dbHelper = new DbHelper(this);
        usuarios = dbHelper.getUsuarios();

        // Configura el adaptador personalizado
        adapter = new UsuarioAdapter(this, usuarios, new UsuarioAdapter.OnUsuarioActionListener() {
            @Override
            public void onEditarClicked(String usuario) {
                // Acción de editar
                Toast.makeText(Listar.this, "Editar: " + usuario, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onEliminarClicked(String usuario) {
                // Acción de eliminar
                usuarios.remove(usuario); // Elimina el usuario de la lista
                adapter.notifyDataSetChanged(); // Actualiza el ListView
                Toast.makeText(Listar.this, "Eliminado: " + usuario, Toast.LENGTH_SHORT).show();
            }
        });

        // Asigna el adaptador al ListView
        listView.setAdapter(adapter);
    }
}