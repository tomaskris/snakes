/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * 
 */
public class MainBoard extends JFrame {

    public MainBoard(String title, int width, int height) {
        setTitle(title);
//        setSize(new Dimension(width + 3, height + 3));
        setSize(new Dimension(width + 20, height + 40));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createBufferStrategy(2);
        add(new GameBoard(width, height, getBufferStrategy()));
    }

}
