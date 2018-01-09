package gui;

import static constants.Constants.MAX_HEIGHT_WINDOW;
import static constants.Constants.MAX_WIDTH_WINDOW;
import enums.TypeSnake;
import field.Field;
import game_logic.Game;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import keyboard.WASD;
import keyboard.Arrows;
import manager.Manager;
import manager.SnakeManager;
import player.Player;

/**
 *
 * @author Tom�
 */
public class Gui extends javax.swing.JFrame {

    private Game game;

    public Gui() {
        initComponents();
        setLocationRelativeTo(null);
        createBufferStrategy(2);

        fillColorPickers();
    }

    public void startGame() {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "game_board");
        jplGameBoard.requestFocus(); //toto je dolezite
        game = new Game(getBufferStrategy());

        game.addPlayer(new Player(player1Name.getText(), TypeSnakeFromColorPicker(player1ColorPicker), new Arrows()));
        game.addPlayer(new Player(player2Name.getText(), TypeSnakeFromColorPicker(player2ColorPicker), new WASD()));
        game.createNewGame();
    }

    private void backToStartPanel() {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "start_panel");
    }

    private void changePlayerColorPickerBgColor(JComboBox colorPicker) {
        Color color;
        try {
            java.lang.reflect.Field field = Color.class.getField((String) colorPicker.getSelectedItem());
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null;
        }
        colorPicker.setBackground(color);
    }

    private TypeSnake TypeSnakeFromColorPicker(JComboBox colorPicker) {
        return TypeSnake.fromString((String) colorPicker.getSelectedItem());
    }

    private void fillColorPickers() {
        TypeSnake[] snakeColors = TypeSnake.values();
        for (TypeSnake snakeColor : snakeColors) {
            player1ColorPicker.addItem(snakeColor.getName());
            player2ColorPicker.addItem(snakeColor.getName());
        }
        player2ColorPicker.setSelectedIndex(2);
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
        jLabel1 = new javax.swing.JLabel();
        player1Name = new javax.swing.JTextField();
        player1ColorPicker = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        player2ColorPicker = new javax.swing.JComboBox<>();
        player2Name = new javax.swing.JTextField();
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

        jLabel1.setText("Player1 (arrows)");

        player1Name.setText("Tomas1");

        player1ColorPicker.setActionCommand("player1ColorPickerChanged");
        player1ColorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1ColorPickerActionPerformed(evt);
            }
        });

        jLabel2.setText("Player2 (WASD)");

        player2ColorPicker.setActionCommand("player2ColorPickerChanged");
        player2ColorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2ColorPickerActionPerformed(evt);
            }
        });

        player2Name.setText("Tomas2");

        javax.swing.GroupLayout jplStartPanelLayout = new javax.swing.GroupLayout(jplStartPanel);
        jplStartPanel.setLayout(jplStartPanelLayout);
        jplStartPanelLayout.setHorizontalGroup(
            jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplStartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplStartPanelLayout.createSequentialGroup()
                        .addGroup(jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplStartPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(player1ColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jplStartPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(player2ColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(player1Name, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(player2Name)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplStartPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jplStartPanelLayout.setVerticalGroup(
            jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplStartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(player1ColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jplStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(player2ColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player2Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtStartGame)
                .addContainerGap(128, Short.MAX_VALUE))
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
            .addGap(0, 426, Short.MAX_VALUE)
        );
        jplGameBoardLayout.setVerticalGroup(
            jplGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        cards.add(jplGameBoard, "game_board");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jplGameBoardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jplGameBoardKeyPressed
        System.out.println("Key pressed");
        int key = evt.getKeyCode();
        SnakeManager player;
        if (!game.isInGame()) {
            backToStartPanel();

            return;
        }

        for (Manager manager : game.getPlayers()) {
            player = (SnakeManager) manager;
            if (player.getKeyboard().isKeyPressed(key, player)) {
                break;
            }
        }

    }//GEN-LAST:event_jplGameBoardKeyPressed

    private void jbtStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtStartGameActionPerformed
        System.out.println("Start pressed");
        startGame();
    }//GEN-LAST:event_jbtStartGameActionPerformed

    private void player1ColorPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1ColorPickerActionPerformed
        changePlayerColorPickerBgColor(player1ColorPicker);
    }//GEN-LAST:event_player1ColorPickerActionPerformed

    private void player2ColorPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2ColorPickerActionPerformed
        changePlayerColorPickerBgColor(player2ColorPicker);
    }//GEN-LAST:event_player2ColorPickerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cards;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtStartGame;
    private javax.swing.JPanel jplGameBoard;
    private javax.swing.JPanel jplStartPanel;
    private javax.swing.JComboBox<String> player1ColorPicker;
    private javax.swing.JTextField player1Name;
    private javax.swing.JComboBox<String> player2ColorPicker;
    private javax.swing.JTextField player2Name;
    // End of variables declaration//GEN-END:variables
}
