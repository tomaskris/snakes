/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static constants.Constants.MAX_HEIGHT_GAME_BOARD;
import static constants.Constants.MAX_HEIGHT_WINDOW;
import static constants.Constants.MAX_WIDTH_GAME_BOARD;
import static constants.Constants.MAX_WIDTH_WINDOW;
import game_logic.GameManager;
import java.awt.CardLayout;
import java.awt.Dimension;
import manager.Manager;
import manager.SnakeManager;

/**
 *
 * @author Tomy
 */
public class Gui extends javax.swing.JFrame {
    
    private GameManager manager;

    public Gui() {
        initComponents();
        setLocationRelativeTo(null);
        createBufferStrategy(2);
        this.manager = new GameManager(getBufferStrategy());
    }

    public void startGame() {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "game_board");
        jplGameBoard.requestFocus(); //toto je dolezite
        manager.createNewGame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cards = new javax.swing.JPanel();
        jplStartPanel = new javax.swing.JPanel();
        jbtStartGame = new javax.swing.JButton();
        jbtAboutSnakes = new javax.swing.JButton();
        jbtExitSnakes = new javax.swing.JButton();
        jplGameBoard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snakes");
        setPreferredSize(new Dimension(MAX_WIDTH_WINDOW, MAX_HEIGHT_WINDOW));

        cards.setPreferredSize(new Dimension(MAX_WIDTH_WINDOW, MAX_HEIGHT_WINDOW));
        cards.setLayout(new java.awt.CardLayout());

        jbtStartGame.setText("Start Game");
        jbtStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtStartGameActionPerformed(evt);
            }
        });

        jbtAboutSnakes.setText("About Snakes");

        jbtExitSnakes.setText("Exit Snakes");

        javax.swing.GroupLayout jplStartPanelLayout = new javax.swing.GroupLayout(jplStartPanel);
        jplStartPanel.setLayout(jplStartPanelLayout);
        jplStartPanelLayout.setHorizontalGroup(
            jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplStartPanelLayout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtAboutSnakes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtExitSnakes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        jplStartPanelLayout.setVerticalGroup(
            jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplStartPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jbtStartGame)
                .addGap(18, 18, 18)
                .addComponent(jbtAboutSnakes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExitSnakes)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        cards.add(jplStartPanel, "start_panel");

        jplGameBoard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jplGameBoardKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jplGameBoardLayout = new javax.swing.GroupLayout(jplGameBoard);
        jplGameBoard.setLayout(jplGameBoardLayout);
        jplGameBoardLayout.setHorizontalGroup(
            jplGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jplGameBoardLayout.setVerticalGroup(
            jplGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        cards.add(jplGameBoard, "game_board");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jplGameBoardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jplGameBoardKeyPressed
        System.out.println("Key pressed");
        int key = evt.getKeyCode();
        for (Manager player : manager.getPlayers()) {
            if(((SnakeManager)player).getKeyboard().isKeyPressed(key, player)){
                break;
            }
        }
    }//GEN-LAST:event_jplGameBoardKeyPressed

    private void jbtStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtStartGameActionPerformed
        System.out.println("Start pressed");
        startGame();
    }//GEN-LAST:event_jbtStartGameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cards;
    private javax.swing.JButton jbtAboutSnakes;
    private javax.swing.JButton jbtExitSnakes;
    private javax.swing.JButton jbtStartGame;
    private javax.swing.JPanel jplGameBoard;
    private javax.swing.JPanel jplStartPanel;
    // End of variables declaration//GEN-END:variables
}
