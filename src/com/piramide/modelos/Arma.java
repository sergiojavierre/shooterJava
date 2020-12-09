package com.piramide.modelos;

public class Arma {

    private final Integer daño, maxBalas;
    private Integer municion;
    private final TipoArma tipoArma;

    public Arma(Integer daño, Integer municion, Integer maxBalas, TipoArma tipoArma) {
        this.daño = daño;
        this.municion = municion;
        this.maxBalas = maxBalas;
        this.tipoArma = tipoArma;
    }

    public Integer getDaño() {
        return daño;
    }

    public Integer getMunicion() {
        return municion;
    }

    public TipoArma getTipoArma() {
        return tipoArma;
    }

    public void recarga(int balas){
        if(municion + balas > maxBalas){
            municion = maxBalas;
        }
        else {
            this.municion += balas;
        }
    }
}
