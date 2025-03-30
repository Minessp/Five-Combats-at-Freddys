package org.msp.game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GameplayPhase extends JPanel implements ActionListener {

    private Image background;
    private Player player;
    private Timer timer;
    private List<Enemies> enemies;
    private boolean inGame;

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

        enimiesInicialize();
        inGame = true;
    }
    // Cria inimigos em posições de altura e largura randomicas
    public void enimiesInicialize() {
        int coordenades[] = new int[60];
        enemies = new ArrayList<Enemies>();

        for (int i = 0; i < coordenades.length; i++) {
            int x = (int)(Math.random() * 8000+1600);
            int y = (int)(Math.random() * 650+30);
            enemies.add(new Enemies(x, y));
        }
    }

    // Renderiza os elementos do jogo na tela
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        if (inGame) {
            graphics.drawImage(background, 0, 0, null);
            graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);

            List<Attack> attack = player.getAttack();

            for (int i = 0; i < attack.size(); i++){
                Attack a = attack.get(i);
                a.load();
                graphics.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }

            for (int i = 0; i < enemies.size(); i++){
                Enemies in = enemies.get(i);
                in.load();
                graphics.drawImage(in.getImage(), in.getX(), in.getY(), this);
            }
        } else {
            ImageIcon ref = new ImageIcon("src//images//gameover//GameOver.jpg");
            graphics.drawImage(ref.getImage(), 0, 0, null);
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

        for (int j = 0; j < enemies.size(); j++){
            Enemies in = enemies.get(j);
            if(in.isVisible()){
                in.update();
            } else {
                enemies.remove(j);
            }
        }
        checkColisions();
        repaint();
    }

    public void checkColisions() {
        Rectangle animatronicFormat = player.getBounds();
        Rectangle enemiesFormat;
        Rectangle attackFormat;

        // Checa colisões entre o player e o inimigo
        for(int i = 0; i < enemies.size(); i++){
            Enemies temporarilyEnemy = enemies.get(i);
            enemiesFormat = temporarilyEnemy.getBounds();
            if(animatronicFormat.intersects(enemiesFormat)){
                player.setVisible(false);
                temporarilyEnemy.setVisible(false);
                inGame = false;
            }
        }

        // Checa colisões entre o ataque e o inimigo
        List<Attack> attacks = player.getAttack();
        for (int i = 0; i < attacks.size(); i++){
            Attack temporarilyAttack = attacks.get(i);
            attackFormat = temporarilyAttack.getBounds();
            for(int j = 0; j < enemies.size(); j++){
                Enemies temporarilyEnemy = enemies.get(j);
                enemiesFormat = temporarilyEnemy.getBounds();
                if(attackFormat.intersects(enemiesFormat)){
                    temporarilyEnemy.setVisible(false);
                    temporarilyAttack.setVisible(false);
                }
            }
        }
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
