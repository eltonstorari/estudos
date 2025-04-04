package com.storaritech.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoLista.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoLista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoLista extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<Itens> listaItens;
    RecyclerView recycler;
    Activity activity;
    IcomunicaFragments interfaceComunFrag;

    Button btLista, btGrid;

    View vista;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentoLista() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoLista.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoLista newInstance(String param1, String param2) {
        FragmentoLista fragment = new FragmentoLista();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_fragmento_lista, container, false);
        btLista = vista.findViewById(R.id.btnList);
        btGrid = vista.findViewById(R.id.btnGrid);

        btLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilidades.VISUALIZACAO = Utilidades.LIST;
                construirRecycler();
            }
        });

        btGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilidades.VISUALIZACAO = Utilidades.GRID;
                construirRecycler();
            }
        });

        construirRecycler();
        return vista;
    }

    private void chamarItens() {
        listaItens.add(new Itens(
                "Jogos",
                "android:layout_width=\"match_parent\"\n" +
                        "        android:layout_height=\"wrap_content\"\n" +
                        "        android:orientation=\"horizontal\"\n" +
                        "        android:layout_marginTop=\"15dp\"",
                R.drawable.img_pequena_pygame, "Desc",
                R.drawable.img_pequena_pygame));

        listaItens.add(new Itens(
                "Marcia",
                "Descrição do Texto",
                R.drawable.img_pequena_revit, "Desc",
                R.drawable.img_pequena_revit));

        listaItens.add(new Itens(
                "Pedro",
                "Descrição do Texto",
                R.drawable.img_pequena_after, "Desc",
                R.drawable.img_pequena_after));
    }


    private void construirRecycler() {




        listaItens = new ArrayList<>();

        recycler = vista.findViewById(R.id.recyclerId);

        if (Utilidades.VISUALIZACAO == Utilidades.LIST){
            recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        else if(Utilidades.VISUALIZACAO == Utilidades.GRID){
            recycler.setLayoutManager(new GridLayoutManager(getContext(),2 ));
        }




        chamarItens();


        AdapterDados adapter = new AdapterDados(listaItens);

        adapter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Selecionou " +
                                listaItens.get(recycler.getChildAdapterPosition(view))
                                .getTitulo(),
                        Toast.LENGTH_LONG).show();


                interfaceComunFrag.enviarItens(listaItens.get(recycler.getChildAdapterPosition(view)));





            }
        });
        recycler.setAdapter(adapter);
    }

    /*public void onClick(View view) {

        switch (view.getId()){
            case  R.id.btnList:
                Utilidades.VISUALIZACAO = Utilidades.LIST;
                break;

            case  R.id.btnGrid:
                Utilidades.VISUALIZACAO = Utilidades.GRID;
                break;
        }


        construirRecycler();
    }*/

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunFrag = (IcomunicaFragments) this.activity;
        }


        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
