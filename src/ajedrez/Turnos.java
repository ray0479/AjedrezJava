package ajedrez;
import javax.swing.JLabel;

public class Turnos extends JLabel{
    boolean turnoNegras;
    public Turnos() {
        this.setVisible(true);
        this.setText("Turno de blancas");
    }
    public void cambiarTurno(){
        turnoNegras = !turnoNegras;
        if(turnoNegras) this.setText("Turno de negras");
        else this.setText("Turno de blancas");
    }
}
