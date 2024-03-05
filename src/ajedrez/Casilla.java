package ajedrez;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;


public class Casilla extends JButton implements ActionListener{
    Pieza pieza;
    Tablero tablero;
    int x;
    int y;
    public Casilla(Tablero tablero, int x, int y){
        this.tablero = tablero;
        this.x = x;
        this.y = y;
        this.setText("");
        this.setBorderPainted(false);
        this.setUI(new BasicButtonUI());
        this.addActionListener(this);
    }
    public void colocarPieza(Pieza pieza) throws IOException{
        this.pieza = pieza;
        this.setIcon(this.pieza.img);
    }
    public void moverPieza(){
        this.pieza = null;
        this.setIcon(null);
    }
    
    public boolean sePuedeEliminar(Pieza piezaOriginal, Pieza piezaDestino){
        if(piezaDestino == null){
            return true;
        }
        return piezaOriginal.esNegro != piezaDestino.esNegro;
    }
    public boolean hayPiezasEnMedio(Casilla Origen, Casilla Destino) throws IOException{
             if(Origen.x == Destino.x){
                int inicio = Math.min(Origen.y, Destino.y);
                int fin = Math.max(Origen.y, Destino.y);
                for(int i=inicio+1;i<fin;i++){
                    if(this.tablero.casillas[Origen.x][i].pieza != null) return true;
                }
            }   
            if(Origen.y == Destino.y){
                int inicio = Math.min(Origen.x, Destino.x);
                int fin = Math.max(Origen.x, Destino.x);
                for(int i=inicio+1;i<fin;i++){
                    if(this.tablero.casillas[i][Origen.y].pieza != null) return true;
                }
            }
            if(Origen.y != Destino.y && Origen.x != Destino.x){
                int iniciox = Math.min(Origen.x, Destino.x);
                int finx = Math.max(Origen.x, Destino.x);
                for(int i=iniciox+1;i<finx;i++){
                    int inicioy = Math.min(Origen.y, Destino.y);
                    int finy = Math.max(Origen.y, Destino.y);
                    for(int j=inicioy+1;j<finy;j++){
                        if(this.tablero.casillas[i][j].pieza != null) return true;
                    }
                }
            }
        return false;
    }
    public boolean movimientoValido(Casilla Origen, Casilla Destino) throws IOException{
        return this.sePuedeEliminar(Origen.pieza, Destino.pieza) && this.pieza.movimientoValido(Origen, Destino) && !this.hayPiezasEnMedio(Origen, Destino);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Casilla casilla = (Casilla) e.getSource();
            if(this.tablero.movimientoIniciado){
            try {
                if(this.tablero.aux.movimientoValido(this.tablero.aux, casilla)){
                    try {
                        casilla.colocarPieza(this.tablero.aux.pieza);
                        this.tablero.casillaSeleccionada.moverPieza();
                        this.tablero.turnos.cambiarTurno();
                    }catch (IOException ex) {
                        
                    }
                    this.tablero.movimientoIniciado = !this.tablero.movimientoIniciado;
                }
                else{
                    this.tablero.movimientoIniciado = false;
                }
            } catch (IOException ex) {
                
            }
        }else{
            if(casilla.pieza != null && this.tablero.turnos.turnoNegras == casilla.pieza.esNegro){
                this.tablero.aux = casilla;
                this.tablero.casillaSeleccionada = casilla;
                this.tablero.movimientoIniciado = !this.tablero.movimientoIniciado;
            }
        }
        
    }
}
