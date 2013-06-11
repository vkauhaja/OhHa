/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author vkauhaja
 */
public class Grafiikka implements Runnable {
    private JFrame frame;
    
   
    @Override
    public void run(){
        frame = new JFrame("Mastermind");
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    private void luoKomponentit(Container container) {
    }

    public JFrame getFrame() {
        return frame;
    }
}
