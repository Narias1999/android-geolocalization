package com.gmail.israelarbonaguerrero.virtual_dao;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.israelarbonaguerrero.virtual_dao.modelo.Jugador;

import java.util.List;

public class RVjugador extends RecyclerView.Adapter<RVjugador.Jugador_view>{

    private List<Jugador> jugadorList;


    public RVjugador(List<Jugador> jugador) { this.jugadorList = jugador;
    }

    @NonNull
    @Override
    public RVjugador.Jugador_view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lst_jugador, parent,false);
        Jugador_view uv = new Jugador_view(v);
        return uv;
    }

    @Override
    public void onBindViewHolder(@NonNull Jugador_view holder, int i) {
        holder.c1.setText(jugadorList.get(i).getJug_nombre());
        holder.c2.setText(String.valueOf(jugadorList.get(i).getJug_puntaje()));
        holder.c3.setText(jugadorList.get(i).getJug_nivel());
    }


    @Override
    public int getItemCount() {
        return jugadorList.size();
    }

    public class Jugador_view extends RecyclerView.ViewHolder{
        TextView c1,c2,c3;
        public Jugador_view(View itemView){
            super(itemView);
            c1 = itemView.findViewById(R.id.c_nom);
            c2 = itemView.findViewById(R.id.c_pun);
            c3 = itemView.findViewById(R.id.c_niv);
        }
    }

}
