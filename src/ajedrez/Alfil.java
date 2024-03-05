package ajedrez;

import java.io.IOException;


public class Alfil extends Pieza{
    public Alfil(boolean esNegro) throws IOException{
        super(esNegro);
        this.PiezaBlanca = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\AlfilBlanco.png";
        this.PiezaNegra = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\AlfilNegro.png";
        this.imagen();
    }



    @Override
    public boolean movimientoValido(Casilla Origen, Casilla Destino) {
        return (Math.abs(Origen.x - Destino.x) == Math.abs(Origen.y - Destino.y));
    }
}
