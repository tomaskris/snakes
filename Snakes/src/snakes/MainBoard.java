/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Tøída, která pøidává JPanel s hlavní èásti této hry a nastavuje základní
 * vlastnosti okna.
 *
 * @author Fugiczek
 * @version 1.1
 */
public class MainBoard extends JFrame {

    private static final long serialVersionUID = 7959263521913348215L;

    public MainBoard(String title, int width, int height) {
        setTitle(title);
        setSize(new Dimension(width + 3, height + 3));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createBufferStrategy(2);
        add(new GameBoard(width, height, getBufferStrategy()));
    }

}
