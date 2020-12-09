package com.piramide.modelos;

public class Material {

    private final TipoMaterial tipo;

    public Material(TipoMaterial tipo){
        this.tipo = tipo;
    }

    public TipoMaterial getTipo(){
        return this.tipo;
    }

}
