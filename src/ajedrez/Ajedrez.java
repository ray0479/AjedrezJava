package ajedrez;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Ajedrez {

    public static void main(String[] args) throws IOException {
        JFrame Ajedrez = new JFrame();
        Ajedrez.setVisible(true);
        Ajedrez.setTitle("Ajedrez");
        Ajedrez.setSize(800, 540);
        Ajedrez.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ajedrez.setLayout(new BorderLayout());
        Turnos turnos = new Turnos();
        Ajedrez.add(new Tablero(turnos), BorderLayout.SOUTH);
        Ajedrez.add(turnos, BorderLayout.NORTH);
    }
    
}
