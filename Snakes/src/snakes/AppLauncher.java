/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import javax.swing.SwingUtilities;

/**
 *
 * @author Tomy
 */
public class AppLauncher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainBoard("Snakes", 300, 250);
            }
        });
    }
}
