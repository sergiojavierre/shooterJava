package com.piramide.modelos;

public class Personaje {

    private static final Integer POS_PICO = 0;
    private static final Integer MIN_ARMAS_INVENTARIO = 1;
    private static final Integer MAX_ARMAS_INVENTARIO = 5;

    private Integer salud;
    private final String alias;
    private Integer nivel;
    private Arma armaSeleccionada;

    Arma[] armas;

    public Personaje(String alias, Integer nivel) {
        this.salud = 100;
        this.alias = alias;
        this.nivel = nivel;
        this.armas = new Arma[MAX_ARMAS_INVENTARIO];
        Arma pico = new Arma(5,null,null,TipoArma.PICO);
        this.armas[POS_PICO] = pico;
        this.armaSeleccionada = this.armas[POS_PICO];
    }

    public Integer getSalud() {
        return salud;
    }

    public void coger(Arma arma){
        for(int i = MIN_ARMAS_INVENTARIO; i < MAX_ARMAS_INVENTARIO; i++){
            if(this.armas[i] == null){
                this.armas[i] = arma;
                return;
            }
        }
        System.out.println("No tienes sitio para el arma "+arma.getTipoArma());
    }

    public void soltarArma(Integer posicion){
        if(posicion == POS_PICO){
            //no puedo soltar el pico
            System.out.println("No puedo soltar el "+this.armas[POS_PICO].getTipoArma());
        }
        else{
            //es otra arma distinta al pico
            //miro si la que quiero soltar es la seleccionada
            if(armaSeleccionada == this.armas[posicion]){
                //voy mirando hacia atrás a ver si tengo otras
                for(int i = MAX_ARMAS_INVENTARIO-1; i >= POS_PICO; i--){
                    //la anterior es distinta de vacío?
                    if(this.armas[i] != null){
                        this.armaSeleccionada = this.armas[i];
                        break;
                    }
                }
            }
            this.armas[posicion] = null;
        }
    }

    public void seleccionaArma(Integer seleccion){
        if(armas[seleccion] != null) {
            this.armaSeleccionada = armas[seleccion];
        }
        else{
            System.out.println("En tu seleccion no hay armas");
        }
    }

    public void muestraArma(){
        System.out.println("Llevo arma "+armaSeleccionada.getTipoArma());
    }

    private void aplicarDaño(Personaje p, Integer daño){
        p.salud -= daño;
    }

    public void dispara(Personaje p, ParteCuerpo parte){

        Integer dañoAplicado = armaSeleccionada.getDaño();
        if(parte == ParteCuerpo.CABEZA){
            dañoAplicado *= 3;
        }
        else if(parte == ParteCuerpo.TRONCO){
            dañoAplicado *= 2;
        }
        else if(parte == ParteCuerpo.PIERNAS){
            dañoAplicado *= 1;
        }
        System.out.println(
                alias+" daña a "+p.alias+
                        " con "+armaSeleccionada.getTipoArma()+" y hace "+
                        dañoAplicado);
        p.aplicarDaño(p,dañoAplicado);
        if(p.getSalud() <= 0){
            System.out.println("Aniquilado");
        }
    }

}
