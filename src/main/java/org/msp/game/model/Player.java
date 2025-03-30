package org.msp.game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y;
    private int dx, dy;
    private Image image;
    private int width, height;

    // Posição inicial do player
    public Player() {
        this.x = 100;
        this.y = 100;
    }

    // Carrega a imagem do personagem
    public void load() {
        ImageIcon ref = new ImageIcon("src//images//character//freddy_right.png");
        image = ref.getImage();
        height = image.getHeight(null);
        width = image.getWidth(null);
    }

    // Atualiza a posição do personagem
    public void update() {
        x += dx;
        y += dy;
    }

    // Recebe tecla apertada e atualiza o valor do personagem
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            dy = -10;
        }

        if (code == KeyEvent.VK_S) {
            dy = 10;
        }

        if (code == KeyEvent.VK_A) {
            dx = -10;
        }

        if (code == KeyEvent.VK_D) {
            dx = 10;
        }
    }

    // Para de atualizar a posição do personagem
    public void keyRealise(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            dy = 0;
        }

        if (code == KeyEvent.VK_S) {
            dy = 0;
        }

        if (code == KeyEvent.VK_A) {
            dx = 0;
        }

        if (code == KeyEvent.VK_D) {
            dx = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}
