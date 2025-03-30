package org.msp.game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameplayPhase extends JPanel implements ActionListener {

    private Image background;
    private Player player;
    private Timer timer;

    public GameplayPhase() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon ref = new ImageIcon("src//images//background//background.png");
        background = ref.getImage();

        player = new Player();
        player.load();

        addKeyListener(new KeyboardAdapter());

        timer = new Timer(1, this);
        timer.start();
    }

    // Renderiza os elementos do jogo na tela
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background, 0, 0, null);
        graphics.drawImage(player.getImage(), player.getX(), player.getY(), null);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }

    private class KeyboardAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyRealise(e);
        }
    }
}
