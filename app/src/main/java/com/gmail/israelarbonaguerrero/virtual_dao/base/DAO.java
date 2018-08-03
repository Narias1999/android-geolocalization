package com.gmail.israelarbonaguerrero.virtual_dao.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO extends SQLiteOpenHelper {

    private static String DBNAME = "VIRTUAL";
    private static int DBVERSION = 1;

    public DAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, factory, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dll_jugador = "create table jugador(";
        dll_jugador += "jug_id integer primary key autoincrement,";
        dll_jugador += "jug_nombre text,";
        dll_jugador += "jug_nivel text,";
        dll_jugador += "jug_puntaje int)";

        db.execSQL(dll_jugador);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dll_jugador = "drop table if exists jugador";
        db.execSQL(dll_jugador);
        onCreate(db);
    }
}
