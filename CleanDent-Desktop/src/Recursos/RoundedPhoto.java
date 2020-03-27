/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Samuel Barberena
 */
public class RoundedPhoto extends JPanel {

    private Image fondo = null;

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0, 0, getWidth(), getHeight() - 1, 100, 100);
        g2.clip(r2d);
    }

    public void setImage(String image) {
        if (image != null) {
            fondo = new ImageIcon(getClass().getResource(image)).getImage();
        }
    }
}
