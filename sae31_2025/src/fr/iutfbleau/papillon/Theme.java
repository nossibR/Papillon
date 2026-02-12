package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>Theme</code> représente un thème avec sa couleur associée.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class Theme extends JComponent{

    /**
     * Couleur du thème.
     */
    private Color couleurTheme;

    /**
     * Largeur du thème.
     */
    private int largeur;

    /**
     * Hauteur du thème.
     */
    private int hauteur;

    /**
     * Numéro du thème.
     */
    public int num;
    
    /**
     * Le constructeur de la classe <code>Theme</code> initialise les attributs du thème.
     * 
     * @param couleur La couleur du thème.
     * @param n Le numéro du thème.
     */
    public Theme(Color couleur,int n){
        this.couleurTheme=couleur;
        this.num=n;
        this.largeur=20;
        this.hauteur=largeur;
        this.setPreferredSize(new Dimension(largeur, hauteur));
    }

    /**
     * Dessine le thème.
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();
        secondPinceau.setColor(couleurTheme);
        secondPinceau.fillOval(0,0,largeur,hauteur);
    }

    /**
     * Getter pour le numéro du thème.
     * 
     * @return Le numéro du thème.
     */
    public int getNumTheme(){
        return this.num;
    }

    /**
     * Setter pour la couleur du thème.
     * 
     * @param nvColor La nouvelle couleur du thème.
     */
    public void setColorTheme(Color nvColor){
        this.couleurTheme=nvColor;
        repaint();
    }
}
