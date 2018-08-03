package com.gmail.israelarbonaguerrero.virtual_dao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gmail.israelarbonaguerrero.virtual_dao.controlador.Ctrl_Jugador;
import com.gmail.israelarbonaguerrero.virtual_dao.modelo.Jugador;

import java.util.List;

public class Listar extends AppCompatActivity {


    private Ctrl_Jugador ctrl_jugador;
    private RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar);

        ctrl_jugador = new Ctrl_Jugador(this);
        List<Jugador> ljugador = ctrl_jugador.Listar_Jugador("0");
        if (!ljugador.isEmpty()) {
            rcv = (RecyclerView) findViewById(R.id.recycler);
            rcv.setHasFixedSize(true);
            rcv.setLayoutManager(new LinearLayoutManager(this));

            RVjugador adapter = new RVjugador(ljugador);
            rcv.setAdapter(adapter);
        }
    }
}
