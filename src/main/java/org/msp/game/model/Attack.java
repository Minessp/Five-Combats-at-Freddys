package org.msp.game.model;

import javax.swing.*;
import java.awt.*;

public class Attack {
    private Image image;
    private int x, y;
    private int height, width;
    private boolean isVisible;

    private static final int LARGURA = 1558;
    private static int VELOCIDADE = 22;

    public Attack(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    // Recebe a imagem do attack
    public void load() {
        ImageIcon ref = new ImageIcon("src//images//attack//hat_attack.png");
        image = ref.getImage();

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    // Define a retirada do objeto da tela
    public void update() {
        this.x += VELOCIDADE;
        if (this.x > LARGURA) {
            isVisible = false;
        }
    }

    // Define o retângulo de colisão
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
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

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        Attack.VELOCIDADE = VELOCIDADE;
    }
}
