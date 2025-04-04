package com.storaritech.appcursos.fragmentos;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.storaritech.appcursos.R;
import com.storaritech.appcursos.adaptador.CursosAdapterImg;
import com.storaritech.appcursos.adaptador.CursosAdapterImgUrl;
import com.storaritech.appcursos.entidades.Curso;
import com.storaritech.appcursos.entidades.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link consultarListaCursoImagemUrl.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link consultarListaCursoImagemUrl#newInstance} factory method to
 * create an instance of this fragment.
 */
public class consultarListaCursoImagemUrl extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerCursos;
    ArrayList<Curso> listaCursos;
    ProgressDialog progresso;
    //RequestQueue request;
    JsonObjectRequest jsonObjectReq;

    private OnFragmentInteractionListener mListener;

    public consultarListaCursoImagemUrl() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment consultarListaCursoImagemUrl.
     */
    // TODO: Rename and change types and number of parameters
    public static consultarListaCursoImagemUrl newInstance(String param1, String param2) {
        consultarListaCursoImagemUrl fragment = new consultarListaCursoImagemUrl();
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
        View vista = inflater.inflate(R.layout.fragment_consultar_lista_curso_imagem_url, container, false);


        listaCursos=new ArrayList<>();

        recyclerCursos= vista.findViewById(R.id.idRecyclerImagem);
        recyclerCursos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerCursos.setHasFixedSize(true);

        //request= Volley.newRequestQueue(getContext());

        carregarWEBService();


        return vista;
    }

    private void carregarWEBService() {

        progresso = new ProgressDialog(getContext());
        progresso.setMessage("Buscando...");
        progresso.show();

        String ip = getString(R.string.ip);

        String url = ip + "/webservices/consultarListaImagemUrl.php";


        jsonObjectReq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        //request.add();
        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectReq);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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

    @Override
    public void onErrorResponse(VolleyError error) {

        progresso.hide();
        Toast.makeText(getContext(), "Não foi possível listar os cursos " +error.toString() , Toast.LENGTH_SHORT).show();
        Log.i("ERROR", error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {
        progresso.hide();

        Curso curso = null;
        JSONArray json = response.optJSONArray("curso");


        try {
            for(int i=0; i<json.length();i++){
                curso = new Curso();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);


                curso.setNome(jsonObject.optString("nome"));
                curso.setCategoria(jsonObject.optString("categoria"));
                curso.setProfessor(jsonObject.optString("professor"));
                curso.setUrlImagem(jsonObject.optString("url_imagem"));
                listaCursos.add(curso);
            }

            progresso.hide();
            CursosAdapterImgUrl adapter = new CursosAdapterImgUrl(listaCursos, getContext());
            recyclerCursos.setAdapter(adapter);


        }catch (JSONException e){
            e.printStackTrace();
            progresso.hide();
            Toast.makeText(getContext(), "Não foi possível listar os cursos " +response , Toast.LENGTH_SHORT).show();

        }

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
