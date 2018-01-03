/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import manager.Manager;

/**
 *
 * @author Tomy
 */
public interface IKeyboard {
    
    public boolean isKeyPressed(int key, Manager manager);
    
}
