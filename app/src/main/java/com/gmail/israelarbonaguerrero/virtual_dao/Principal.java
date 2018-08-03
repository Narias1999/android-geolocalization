package com.gmail.israelarbonaguerrero.virtual_dao;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gmail.israelarbonaguerrero.virtual_dao.controlador.Ctrl_Jugador;
import com.gmail.israelarbonaguerrero.virtual_dao.modelo.Jugador;

import java.net.URI;

public class Principal extends AppCompatActivity {

    private Ctrl_Jugador ctrl_jugador;
    private EditText jg_nom, jg_pun;
    private Spinner jg_niv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        ctrl_jugador = new Ctrl_Jugador(this);
        jg_nom = (EditText) findViewById(R.id.jnombre);
        jg_niv = (Spinner) findViewById(R.id.jnivel);
        jg_pun = (EditText) findViewById(R.id.jpuntaje);
    }

    public void Ejecutar(View view) {
        String validar_j = "SELECT coalesce(count(jug_id),0) as jug_id " +
                "FROM jugador WHERE jug_nombre = '" + jg_nom.getText().toString() +"'";
        if (Integer.parseInt(ctrl_jugador.Sql_Buscar(validar_j))> 0) {
            Toast.makeText(this, "Jugador ya registrado", Toast.LENGTH_SHORT).show();
        } else {
            Jugador myJugador = new Jugador(
                    jg_nom.getText().toString(),
                    String.valueOf(jg_niv.getSelectedItemId()),
                    Integer.parseInt(jg_pun.getText().toString()));
            ctrl_jugador.Insert_Jugador(myJugador);
            Toast.makeText(this, "Nuevo Jugador Registrado", Toast.LENGTH_SHORT).show();

        }
    }

    public void Mostrar(View view) {
        Intent ir = new Intent(this,Listar.class);
        startActivity(ir);

    }

    public void Editar(View view) {
            Jugador myJugador = new Jugador(
                    jg_nom.getText().toString(),
                    String.valueOf(jg_niv.getSelectedItemId()),
                    Integer.parseInt(jg_pun.getText().toString()));
            ctrl_jugador.Update_Jugador(myJugador);
            Toast.makeText(this, "Actulizado Jugador", Toast.LENGTH_SHORT).show();


    }

    public void Ruta(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                //Uri.parse("http://maps.google.com/maps?saddr=4.545695136892776,-75.67256734597161&daddr=4.537481262607865,-75.66655919777826"));
                // Uri.parse("http://maps.google.com/maps?origin=4.545695136892776,-75.67256734597161&destination=4.537481262607865,-75.66655919777826"));
                 Uri.parse("http://maps.google.com/maps?saddr=San Gil,Colombia&daddr=Curiti,Colombia"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_LAUNCHER );
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);

    }


    public void Rutajss(View view) {
        Globales.gfromLatitude =4.545695136892776;
        Globales.gfromLongitude =-75.67256734597161;
        Globales.gtoLatitude =4.537481262607865;
        Globales.gtoLongitude =-75.66655919777826;

        Intent ir = new Intent(this, Direccion.class);
        startActivity(ir);
    }
}
