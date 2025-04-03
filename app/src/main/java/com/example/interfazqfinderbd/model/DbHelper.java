package com.example.interfazqfinderbd.model;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    //constructor
    public DbHelper(@Nullable Context context) {
        super(context, Constantes.NAME_BD, null, Constantes.NUM_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Constantes.SENTENCIA_TABLA);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuario"); // Elimina la tabla antigua
        onCreate(db); // Crea la nueva tabla con la estructura actualizada
    }
    public List<String> getUsuarios() {
        List<String> usuarios = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Usuario", null);

        if (cursor.moveToFirst()) {
            do {
                String usuario = cursor.getString(cursor.getColumnIndexOrThrow("nombres")) + " " +
                        cursor.getString(cursor.getColumnIndexOrThrow("apellidos")) + "\n" +
                        cursor.getString(cursor.getColumnIndexOrThrow("correo")) + "\n" +
                        cursor.getString(cursor.getColumnIndexOrThrow("telefono")) + "\n" +
                        cursor.getString(cursor.getColumnIndexOrThrow("fechaNacimiento"));
                usuarios.add(usuario);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return usuarios;
    }

}
