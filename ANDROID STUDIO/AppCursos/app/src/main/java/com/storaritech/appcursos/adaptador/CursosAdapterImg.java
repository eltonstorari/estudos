package com.storaritech.appcursos.adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.storaritech.appcursos.R;
import com.storaritech.appcursos.entidades.Curso;

import java.util.List;

public class CursosAdapterImg extends RecyclerView.Adapter<CursosAdapterImg.CursosHolder> {


    List<Curso>listaCursosImg;


    public CursosAdapterImg(List<Curso> listaCursos){
        this.listaCursosImg = listaCursos;
    }

    @NonNull
    @Override
    public CursosAdapterImg.CursosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_curso_img, parent, false);
        RecyclerView.LayoutParams layoutParams =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);


            vista.setLayoutParams(layoutParams);


        return new CursosHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull CursosAdapterImg.CursosHolder holder, int position) {

        holder.txtNome.setText(listaCursosImg.get(position).getNome().toString());
        holder.txtCategoria.setText(listaCursosImg.get(position).getCategoria().toString());
        holder.txtProfessor.setText(listaCursosImg.get(position).getProfessor().toString());

        if(listaCursosImg.get(position).getImagem() != null) {
            holder.idImagem.setImageBitmap(listaCursosImg.get(position).getImagem());
        }else{
            holder.idImagem.setImageResource(R.drawable.sem_foto);
        }

    }

    @Override
    public int getItemCount() {
        return listaCursosImg.size();
    }

    public class CursosHolder extends RecyclerView.ViewHolder {

        TextView  txtNome, txtCategoria, txtProfessor;
        ImageView idImagem;

        public CursosHolder(View itemView) {
            super(itemView);

            txtNome = (TextView) itemView.findViewById(R.id.nomeCurso);
            txtCategoria = (TextView) itemView.findViewById(R.id.nomeCategoria);
            txtProfessor = (TextView) itemView.findViewById(R.id.nomeProfessor);
            idImagem =  itemView.findViewById(R.id.idImagem);
        }
    }
}
