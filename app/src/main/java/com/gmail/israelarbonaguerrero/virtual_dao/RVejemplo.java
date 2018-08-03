package com.gmail.israelarbonaguerrero.virtual_dao;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class RVejemplo extends RecyclerView.Adapter<RVejemplo.Ejemplo_view> {
    @NonNull
    @Override
    public RVejemplo.Ejemplo_view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RVejemplo.Ejemplo_view holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Ejemplo_view extends RecyclerView.ViewHolder {
        public Ejemplo_view(View itemView) {
            super(itemView);
        }
    }
}
