package ajedrez;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class Pieza {
    ImageIcon img;
    String PiezaNegra;
    String PiezaBlanca;
    boolean esNegro;
    
    public Pieza(boolean esNegro){
        this.esNegro = esNegro;
    }
    
    public void imagen() throws IOException{
        if(this.esNegro){
            Image imagen = ImageIO.read(new File(this.PiezaNegra));
            imagen = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            img = new ImageIcon(imagen);
        }else{
            Image imagen = ImageIO.read(new File(this.PiezaBlanca));
            imagen = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            img = new ImageIcon(imagen);
        }
    }

    @Override
    public boolean equals(Object obj) {
        Pieza p = (Pieza) obj;
        return (p.PiezaBlanca == null ? this.PiezaBlanca == null : p.PiezaBlanca.equals(this.PiezaBlanca));
    }
    
    public abstract boolean movimientoValido(Casilla Origen, Casilla Destino);
}
