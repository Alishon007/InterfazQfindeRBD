package com.example.interfazqfinderbd.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.interfazqfinderbd.R;
import com.example.interfazqfinderbd.model.ManagerDB;

import java.util.List;

public class Listar extends AppCompatActivity {

    ListView listView;
    ManagerDB managerDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        listView = findViewById(R.id.listView);
        managerDB = new ManagerDB(this);

        // Obtenemos los datos de la base de datos
        List<String> usuarios = managerDB.getUsuarios();

        // Configuramos un adaptador para mostrar los datos en la lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuarios);
        listView.setAdapter(adapter);

    }
}