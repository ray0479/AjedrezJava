package ajedrez;

import java.io.IOException;


public class Torre extends Pieza{
    public Torre(boolean esNegro) throws IOException{
        super(esNegro);
        this.PiezaBlanca = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\TorreBlanca.png";
        this.PiezaNegra = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\TorreNegra.png";
        this.imagen();
    }


    @Override
    public boolean movimientoValido(Casilla Origen, Casilla Destino) {
        return (Origen.x != Destino.x && Origen.y == Destino.y) || (Origen.x == Destino.x && Origen.y != Destino.y);
    }
}