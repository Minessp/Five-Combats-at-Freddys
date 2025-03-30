package org.msp.game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

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
        graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);

        List<Attack> attack = player.getAttack();

        for (int i = 0; i < attack.size(); i++){
            Attack a = attack.get(i);
            a.load();
            graphics.drawImage(a.getImage(), a.getX(), a.getY(), this);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        List<Attack> attack = player.getAttack();

        for (int i = 0; i < attack.size(); i++){
            Attack a = attack.get(i);
            if(a.isVisible()){
                a.update();
            } else {
                attack.remove(i);
            }
        }

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
