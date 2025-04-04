package com.storaritech.recyclerview;

        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;

public class AdapterDados extends RecyclerView.Adapter<AdapterDados.ViewDados> implements View.OnClickListener {

    //ArrayList<String>ListaDados;
    ArrayList<Itens>ListaDados;
    private  View.OnClickListener listener;



    public AdapterDados(ArrayList<Itens> listaDados) {

        this.ListaDados = listaDados;
    }


    @NonNull
    @Override
    public ViewDados onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;

        if (Utilidades.VISUALIZACAO  == Utilidades.LIST){
            layout = R.layout.itemlista;
        }else {
            layout = R.layout.itemgrid;
        }


        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, null, false);

        view.setOnClickListener(this);

        return new ViewDados(view);
    }




    @Override
    public void onBindViewHolder(@NonNull ViewDados holder, int position) {

        holder.titulo.setText(ListaDados.get(position).getTitulo());

        if (Utilidades.VISUALIZACAO  == Utilidades.LIST) {
            holder.descricao.setText(ListaDados.get(position).getDescricao());
        }

        holder.imagem.setImageResource(ListaDados.get(position).getImg());

    }




    @Override
    public int getItemCount() {
        return ListaDados.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {

        if(listener != null) {
            listener.onClick(view);
        }

    }


    public class ViewDados extends RecyclerView.ViewHolder {

        TextView titulo, descricao;
        ImageView imagem;

        public ViewDados(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.idTitulo);

            if (Utilidades.VISUALIZACAO  == Utilidades.LIST) {
                descricao = itemView.findViewById(R.id.idTexto);
            }

            //
            imagem = itemView.findViewById(R.id.idImagem);
        }

        /*public void passarDados(String dado) {

            dados.setText(dado);

        }*/
    }
}
