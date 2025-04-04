package com.storaritech.recyclerview;

import java.io.Serializable;

public class Itens implements Serializable{

    private String titulo;
    private String descricao;
    private int img;
    private String descricaoDetalhe;
    private int imgDetalhe;


    public Itens() {

    }

    public String getDescricaoDetalhe() {
        return descricaoDetalhe;
    }

    public void setDescricaoDetalhe(String descricaoDetalhe) {
        this.descricaoDetalhe = descricaoDetalhe;
    }

    public int getImgDetalhe() {
        return imgDetalhe;
    }

    public void setImgDetalhe(int imgDetalhe) {
        this.imgDetalhe = imgDetalhe;
    }

    public Itens(String titulo, String descricao, int img, String descricaoDetalhe, int imgDetalhe) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.img = img;
        this.descricaoDetalhe = descricaoDetalhe;
        this.imgDetalhe = imgDetalhe;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Itens(String titulo, String descricao, int img) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.img = img;

    }
}
