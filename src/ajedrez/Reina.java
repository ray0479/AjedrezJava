package ajedrez;

import java.io.IOException;


public class Reina extends Pieza{
    public Reina(boolean esNegro) throws IOException{
        super(esNegro);
        this.PiezaBlanca = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\ReinaBlanca.png";
        this.PiezaNegra = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\ReinaNegra.png";
        this.imagen();
    }



    @Override
    public boolean movimientoValido(Casilla Origen, Casilla Destino) {
        return (Origen.x != Destino.x && Origen.y == Destino.y) || 
                (Origen.x == Destino.x && Origen.y != Destino.y) ||
                (Math.abs(Origen.x - Destino.x) == Math.abs(Origen.y - Destino.y));
    }
}
