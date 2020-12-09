package com.piramide;

import com.piramide.modelos.Arma;
import com.piramide.modelos.ParteCuerpo;
import com.piramide.modelos.Personaje;
import com.piramide.modelos.TipoArma;

public class Main {

    public static void main(String[] args) {

        Personaje persSergio = new Personaje("sergiojavierre",1);
        Arma pistola1 = new Arma(20,10,10, TipoArma.PISTOLA);
        Arma pistola2 = new Arma(20,10,10, TipoArma.PISTOLA);
        Arma pistola3 = new Arma(20,10,10, TipoArma.PISTOLA);
        Arma rifle1 = new Arma(40,10,10, TipoArma.RIFLE);
        Arma rifle2 = new Arma(40,10,10, TipoArma.RIFLE);
        persSergio.coger(pistola1);
        persSergio.coger(pistola2);
        persSergio.coger(pistola3);
        persSergio.coger(rifle1);
        persSergio.soltarArma(2);
        persSergio.coger(rifle2);

        persSergio.seleccionaArma(2);
        persSergio.muestraArma();
        persSergio.soltarArma(4);
        persSergio.soltarArma(2);
        persSergio.muestraArma();

        Personaje juanCarlos = new Personaje("juancarlos",1);

        persSergio.dispara(juanCarlos, ParteCuerpo.PIERNAS);

        while(persSergio.getSalud()>0){
            juanCarlos.dispara(persSergio, ParteCuerpo.CABEZA);
        }

    }
}
