package com.storaritech.appcursos.interfaces;

import com.storaritech.appcursos.fragmentos.bemVindoFragmento;
import com.storaritech.appcursos.fragmentos.consultarCursoFragmento;
import com.storaritech.appcursos.fragmentos.consultarCursoUrl;
import com.storaritech.appcursos.fragmentos.consultarListaCursoImagem;
import com.storaritech.appcursos.fragmentos.consultarListaCursoImagemUrl;
import com.storaritech.appcursos.fragmentos.consultarListaCursosFragmento;
import com.storaritech.appcursos.fragmentos.desenvolvedorFragmento;
import com.storaritech.appcursos.fragmentos.registrarCursoFragmento;

public interface Ifragmentos  extends

        bemVindoFragmento.OnFragmentInteractionListener,
        consultarCursoFragmento.OnFragmentInteractionListener,
        consultarCursoUrl.OnFragmentInteractionListener,
        consultarListaCursoImagem.OnFragmentInteractionListener,
        consultarListaCursoImagemUrl.OnFragmentInteractionListener,
        consultarListaCursosFragmento.OnFragmentInteractionListener,
        desenvolvedorFragmento.OnFragmentInteractionListener,
        registrarCursoFragmento.OnFragmentInteractionListener
{
}
