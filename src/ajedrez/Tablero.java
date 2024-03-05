package ajedrez;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public final class Tablero extends JPanel{
    Casilla[][] casillas = new Casilla[8][8];
    boolean movimientoIniciado = false;
    Turnos turnos;
    Casilla casillaSeleccionada;
    Casilla aux;
    public Tablero(Turnos turnos) throws IOException{
        this.setVisible(true);
        setLayout(new GridLayout(8,8));
        this.casillas();
        this.colocarPiezas();
        this.turnos = turnos;
    }
    public void casillas(){
        boolean blanca = true;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.casillas[i][j] = new Casilla(this, i, j);
                if(blanca){
                    this.casillas[i][j].setBackground(Color.white);
                    blanca = !blanca;
                }else{
                    this.casillas[i][j].setBackground(Color.black);
                    blanca = !blanca;
                }this.add(this.casillas[i][j]);
            }blanca = !blanca;
        }
    }
    
    public void colocarPiezas() throws IOException{
        this.casillas[0][0].colocarPieza(new Torre(true));
        this.casillas[0][1].colocarPieza(new Caballo(true));
        this.casillas[0][2].colocarPieza(new Alfil(true));
        this.casillas[0][3].colocarPieza(new Rey(true));
        this.casillas[0][4].colocarPieza(new Reina(true));
        this.casillas[0][5].colocarPieza(new Alfil(true));
        this.casillas[0][6].colocarPieza(new Caballo(true));
        this.casillas[0][7].colocarPieza(new Torre(true));
        this.casillas[7][0].colocarPieza(new Torre(false));
        this.casillas[7][1].colocarPieza(new Caballo(false));
        this.casillas[7][2].colocarPieza(new Alfil(false));
        this.casillas[7][3].colocarPieza(new Rey(false));
        this.casillas[7][4].colocarPieza(new Reina(false));
        this.casillas[7][5].colocarPieza(new Alfil(false));
        this.casillas[7][6].colocarPieza(new Caballo(false));
        this.casillas[7][7].colocarPieza(new Torre(false));
        
        for(int i=0;i<8;i++){
            this.casillas[1][i].colocarPieza(new Peon(true));
            this.casillas[6][i].colocarPieza(new Peon(false));
        }
    }
    
    
}
