/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import actions.ASnakeAction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import manager.SnakeManager;

/**
 *
 * @author Tomy
 */
public abstract class KeyCommand extends ASnakeAction implements KeyListener {

    private int key;

    public KeyCommand(SnakeManager snake, int key) {
        super(snake);
        this.key = key;
    }
    
    @Override
    public void keyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == this.key){
            this.execute();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
