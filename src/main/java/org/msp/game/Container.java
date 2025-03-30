package org.msp.game;

import javax.swing.JFrame;

public class Container extends JFrame {
    public Container() {
        // Configuração da tela de jogo
        setTitle("Five Combats at Freddy's Game");
        setSize(getMaximumSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Container();
    }

}
