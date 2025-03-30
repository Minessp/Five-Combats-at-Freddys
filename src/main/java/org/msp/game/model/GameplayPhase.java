package org.msp.game.model;

import javax.swing.*;
import java.awt.*;

public class GameplayPhase extends JPanel {
    private Image background;

    public GameplayPhase() {
        ImageIcon ref = new ImageIcon("src//images//background.png");
        background = ref.getImage();
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background, 0, 0, null);
        g.dispose();
    }
}
