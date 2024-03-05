package ajedrez;

import java.io.IOException;


public class Peon extends Pieza{
    public Peon(boolean esNegro) throws IOException{
        super(esNegro);
        this.PiezaBlanca = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\PeonBlanco.png";
        this.PiezaNegra = "C:\\Users\\rayco\\Documents\\NetBeansProjects\\Ajedrez\\img\\PeonNegro.png";
        this.imagen();
    }



    @Override
    public boolean movimientoValido(Casilla Origen, Casilla Destino) {
        int nCasillas = (this.esNegro)? 1:-1;
        if(Origen.x == 1 || Origen.x == 6){
            return (Destino.pieza == null && Origen.x + nCasillas == Destino.x && Origen.y == Destino.y) ||
                    (Destino.pieza == null && Origen.x + nCasillas*2 == Destino.x && Origen.y == Destino.y) ||
                (Destino.pieza != null && Origen.x + nCasillas == Destino.x && Origen.y != Destino.y);
        }
        return (Destino.pieza == null && Origen.x + nCasillas == Destino.x && Origen.y == Destino.y) || 
                (Destino.pieza != null && Origen.x + nCasillas == Destino.x && Origen.y != Destino.y);
    }



    
}
