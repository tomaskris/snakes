/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import manager.SnakeManager;

/**
 *
 * @author Tomy
 */
public class Keyboard {
    
    private KeyCommand up;
    private KeyCommand down;
    private KeyCommand left;
    private KeyCommand right;

    public Keyboard(int up, int down, int left, int right, SnakeManager snake) {
        this.up = new KeyUp(snake, up);
        this.down = new KeyDown(snake, down);
        this.left = new KeyLeft(snake, left);
        this.right = new KeyRight(snake, right);
    }

    public KeyCommand getDown() {
        return down;
    }

    public KeyCommand getLeft() {
        return left;
    }

    public KeyCommand getRight() {
        return right;
    }

    public KeyCommand getUp() {
        return up;
    }

}
