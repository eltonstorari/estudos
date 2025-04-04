package com.storaritech.appcursos.adaptador;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.storaritech.appcursos.R;
import com.storaritech.appcursos.entidades.Curso;
import com.storaritech.appcursos.entidades.MySingleton;

import java.util.List;

public class CursosAdapterImgUrl extends RecyclerView.Adapter<CursosAdapterImgUrl.CursosHolder> {


    List<Curso>listaCursos;
    //RequestQueue request;
    Context context;


    public CursosAdapterImgUrl(List<Curso> listaCursos, Context context
    ){
        this.listaCursos = listaCursos;
        //this.context = context;
        //request = Volley.newRequestQueue(context);


    }

    @NonNull
    @Override
    public CursosAdapterImgUrl.CursosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_curso_img, parent, false);
        RecyclerView.LayoutParams layoutParams =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);


            vista.setLayoutParams(layoutParams);


        return new CursosHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull CursosAdapterImgUrl.CursosHolder holder, int position) {

        holder.txtNome.setText(listaCursos.get(position).getNome().toString());
        holder.txtCategoria.setText(listaCursos.get(position).getCategoria().toString());
        holder.txtProfessor.setText(listaCursos.get(position).getProfessor().toString());




        if(listaCursos.get(position).getUrlImagem() != null) {
            carregarImagemWEBService(listaCursos.get(position).getUrlImagem(), holder);
        }else{
            holder.idImagem.setImageResource(R.drawable.sem_foto);
        }

    }

    private void carregarImagemWEBService(String urlImagem, final CursosHolder holder) {

        String ip = context.getString(R.string.ip);

        String caminhoImagem = ip + "/webservices/" + urlImagem;
        caminhoImagem = caminhoImagem.replace(" ", "%20");

        ImageRequest imageReq = new ImageRequest(caminhoImagem, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                holder.idImagem.setImageBitmap(response);

            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Erro ao carregar Imagem", Toast.LENGTH_SHORT).show();

            }
        });

        //request.add(imageReq);
        MySingleton.getInstance(context).addToRequestQueue(imageReq);
    }

    @Override
    public int getItemCount() {
        return listaCursos.size();
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
