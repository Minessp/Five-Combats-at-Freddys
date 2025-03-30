package org.msp.game;

import org.msp.game.model.GameplayPhase;

import javax.swing.JFrame;

public class Container extends JFrame {
    public Container() {
        // Configuração da tela de jogo
        add(new GameplayPhase());
        setTitle("Five Combats at Freddy's Game");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Container();
    }

}
