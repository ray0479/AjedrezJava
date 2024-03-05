package ajedrez;

import java.io.IOException;


public class Caballo extends Pieza{
    public Caballo(boolean esNegro) throws IOException{
        super(esNegro);
        this.PiezaBlanca = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\CaballoBlanco.png";
        this.PiezaNegra = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\CaballoNegro.png";
        this.imagen();
    }


    @Override
    public boolean movimientoValido(Casilla Origen, Casilla Destino) {
        return (Math.abs(Origen.x - Destino.x) == 2 && Math.abs(Origen.y - Destino.y) == 1) || 
                (Math.abs(Origen.x - Destino.x) == 1 && Math.abs(Origen.y - Destino.y) == 2);
    }
}