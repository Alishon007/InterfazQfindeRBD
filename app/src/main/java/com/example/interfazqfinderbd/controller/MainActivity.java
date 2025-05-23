package com.example.interfazqfinderbd.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.interfazqfinderbd.R;
import com.example.interfazqfinderbd.model.ManagerDB;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtApellido, edtCorreo, edtTelefono, edtFecha, edtContrasena;
    Button btnGuardar, btnListar;
    Button btnEliminar, btnEditar;
    ManagerDB managerDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtFecha = findViewById(R.id.edtFecha);
        edtContrasena = findViewById(R.id.edtContrasena);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnListar = findViewById(R.id.btnListar);

        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);

        managerDB = new ManagerDB(MainActivity.this);

        btnGuardar.setOnClickListener(v -> {
            String nombres = edtNombre.getText().toString();
            String apellidos = edtApellido.getText().toString();
            String correo = edtCorreo.getText().toString();
            String telefono = edtTelefono.getText().toString();
            String fecha = edtFecha.getText().toString();
            String contrasena = edtContrasena.getText().toString();

            long result = managerDB.insertUsuario(nombres, apellidos, correo, telefono, fecha, contrasena);
            if (result > 0){
                Toast.makeText(this, "Datos Insertados" + result, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al Insertar" + result, Toast.LENGTH_SHORT).show();
            }
        });


        btnEditar.setOnClickListener(v -> {
            String nombres = edtNombre.getText().toString();
            String apeliidos = edtApellido.getText().toString();
            String correo = edtCorreo.getText().toString();
            String telefono = edtTelefono.getText().toString();
            String fecha = edtFecha.getText().toString();
            String contrasena = edtContrasena.getText().toString();

            int filasActualizadasCiudad = managerDB.updateUsuario(nombres, apeliidos, correo, telefono, fecha, contrasena);

            if (filasActualizadasCiudad > 0 ) {
                Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show();
            }
        });


        btnEliminar.setOnClickListener(v -> {
            String correo = edtCorreo.getText().toString();

            int filasEliminadasUsuario = managerDB.deleteUsuario(correo);

            if (filasEliminadasUsuario > 0 ) {
                Toast.makeText(this, "Datos eliminados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al eliminar", Toast.LENGTH_SHORT).show();
            }
        });



        btnListar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Listar.class);
            startActivity(intent);
        });


    }
}