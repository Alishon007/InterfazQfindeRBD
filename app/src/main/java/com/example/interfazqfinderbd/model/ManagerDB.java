package com.example.interfazqfinderbd.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class ManagerDB {

    private final DbHelper dbHelper;
    private SQLiteDatabase db;

    public ManagerDB(Context context) {
        dbHelper = new DbHelper(context);
    }



    // Método para abrir la base de datos en modo escritura
    public void openDbWr() {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
    }

    // Método para cerrar la base de datos (opcional)
    public void closeDb() {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    public List<String> getUsuarios() {
        return dbHelper.getUsuarios(); // Aquí usas el método del DBHelper.
    }

    public long insertUsuario(String nombres, String apellidos, String correo, String telefono, String fechaNacimiento, String contrasena) {
        openDbWr(); // Asegurar que la base de datos esté abierta

        ContentValues valores = new ContentValues();
        valores.put("nombres", nombres);
        valores.put("apellidos", apellidos);
        valores.put("correo", correo);
        valores.put("telefono", telefono);
        valores.put("fechaNacimiento", fechaNacimiento);
        valores.put("contrasena", contrasena);

        long resultado = db.insert("Usuario", null, valores);

        closeDb(); // Cerrar la conexión después de insertar
        return resultado;
    }


}
