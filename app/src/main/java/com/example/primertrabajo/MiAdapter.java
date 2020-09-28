package com.example.primertrabajo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MiAdapter extends RecyclerView.Adapter<MiAdapter.MiViewHolder> {

    String N[], F[];
    int A[];
    Context cont;

    public MiAdapter(Context ct, String nombre[], String fund[], int imagen[]){
        this.cont = ct;
        this.N = nombre;
        this.F = fund;
        this.A = imagen;
    }

    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cont);
        View v = inflater.inflate(R.layout.mifila,parent, false);
        return new MiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        holder.eq.setText(this.N[position]);
        holder.fu.setText(this.F[position]);
        holder.im.setImageResource(A[position]);

    }

    @Override
    public int getItemCount() { return  N.length;

    }

    public class MiViewHolder extends RecyclerView.ViewHolder{
        TextView eq, fu;
        ImageView im;

        public MiViewHolder(@NonNull View itemView){
            super(itemView);
            eq = itemView.findViewById(R.id.nombreusuario);
            fu = itemView.findViewById(R.id.email);
            im = itemView.findViewById(R.id.miimagen);
        }
    }
    }