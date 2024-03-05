package ajedrez;

import java.io.IOException;


public class Rey extends Pieza{
    public Rey(boolean esNegro) throws IOException{
        super(esNegro);
        this.PiezaBlanca = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\ReyBlanco.png";
        this.PiezaNegra = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\ReyNegro.png";
        this.imagen();
    }



    @Override
    public boolean movimientoValido(Casilla Origen, Casilla Destino) {
        return (Math.abs(Origen.x -Destino.x) == 1 && Origen.y == Destino.y) || 
                (Origen.x == Destino.x && Math.abs(Origen.y -Destino.y) == 1) || 
                (Math.abs(Origen.x -Destino.x) == 1 && Math.abs(Origen.y -Destino.y) == 1);
    }
}
