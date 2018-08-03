package com.gmail.israelarbonaguerrero.virtual_dao.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gmail.israelarbonaguerrero.virtual_dao.base.DAO;
import com.gmail.israelarbonaguerrero.virtual_dao.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Ctrl_Jugador {

    private DAO dao;

    public Ctrl_Jugador(Context context){
        dao = new DAO(context, null, null, 3);
    }

    public void Insert_Jugador(Jugador myJugador){
        ContentValues Values = new ContentValues();
        Values.put("jug_nombre",myJugador.getJug_nombre());
        Values.put("jug_nivel",myJugador.getJug_nivel());
        Values.put("jug_puntaje",myJugador.getJug_puntaje());

        SQLiteDatabase database = dao.getWritableDatabase();
        database.insert("jugador", null, Values);
        database.close();
    }

    public void Update_Jugador(Jugador myJugador){
        ContentValues Values = new ContentValues();
        Values.put("jug_puntaje",myJugador.getJug_puntaje());
        SQLiteDatabase database = dao.getWritableDatabase();
        database.update("jugador", Values,"jug_nombre = '"+
        myJugador.getJug_nombre()+"'",null);
        database.close();
    }

    public String Sql_Buscar(String Sql_Consuta){
        String cargar = "0";
        SQLiteDatabase database = dao.getWritableDatabase();
        String Consulta = Sql_Consuta;
        Cursor cursor = database.rawQuery(Consulta, null);
        if (cursor.moveToFirst()){
            cargar =cursor.getString(0);
        }

        cursor.close();
        database.close();
        return cargar;
    }

    public List<Jugador> Listar_Jugador(String niv){

        List<Jugador> jugadors =new ArrayList<Jugador>();
        SQLiteDatabase database = dao.getWritableDatabase();
        String consulta = "SELECT coalesce(jug_nombre,''), coalesce(jug_nivel,''), " +
                "coalesce(jug_puntaje,0) FROM " +
                " jugador where jug_nivel = '" + niv +
                "' order by jug_puntaje desc limit 4";
        Cursor cursor = database.rawQuery(consulta,null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Jugador temp = new Jugador();
                temp.setJug_nombre(cursor.getString(0));
                temp.setJug_nivel(cursor.getString(1));
                temp.setJug_puntaje(cursor.getInt(2));
                jugadors.add(temp);
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return jugadors;
    }
}
