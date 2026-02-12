package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>Bouton</code> est utilisée 
 * pour créer un bouton personnalisable. 
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class Bouton extends JComponent {

    /**
     * Largeur du bouton.
     */
    protected int largeur;

    /**
     * Hauteur du bouton.
     */
    protected int hauteur;

    /**
     * Position X du texte à afficher.
     */
    protected int xTexte;

    /**
     * Postion Y du texte à afficher.
     */
    protected int yTexte;

    /** 
     * Dimension, hauteur du texte.
     */
    protected int texteHauteur;

    /**
     * Dimension, largeur du texte.
     */
    protected int texteLargeur;

    /**
     * Couleur du fond par défaut.
     */
    protected Color fond;

    /**
     * Couleur du fond actuel.
     */
    protected Color couleurActuelle;

    /**
     * Couleur du texte actuel.
     */
    protected Color texteCouleurActuelle;

    /**
     * Couleur du texte par défaut.
     */
    protected Color texteCouleur;

    /**
     * Texte à afficher.
     */
    protected String texte;

    /**
     * Outil qui permet de pendre les mesures du texte.
     */
    protected FontMetrics mesureTexte;

    /** Constructeur de la classe <code>Bouton</code>.
     * Defini les paramètres pour créer un objet de la classe.
     * @param l Longeur du bouton.
     * @param h Hauteur du bouton.
     * @param t Texte à afficher.
     * @param f Couleur en en fond du bouton.
     * @param txtCouleur Couleur du texte.
    */
    public Bouton(int l, int h, String t, Color f, Color txtCouleur) {
        this.largeur = l;
        this.hauteur = h;

        this.couleurActuelle = f;
        this.texteCouleurActuelle = txtCouleur;

        this.texte = t;
        this.fond = f;
        this.texteCouleur = txtCouleur;

        this.setPreferredSize(new Dimension(largeur, hauteur));
    }

    /**
     * Change l'état "hover" du bouton et change les couleurs du bouton en fonction de l'état.
     * @param statut Etat du bouton.
     * @param couleurHover Couleur du "hover" à changer.
     * @param texteHover Couleur du texte à changer.
     */
    public void setHoverColor(boolean statut, Color couleurHover, Color texteHover) {
        if (statut) {
            this.couleurActuelle = couleurHover;
            this.texteCouleurActuelle = texteHover;
        } else {
            this.couleurActuelle = fond;
            this.texteCouleurActuelle = texteCouleur;
        }
        repaint();
    }

    /**
     * Dessine le composant.
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

        secondPinceau.setColor(couleurActuelle);
        secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);

        secondPinceau.setColor(texteCouleurActuelle);
        secondPinceau.setFont(new Font("Dialog", Font.BOLD, 18));

        mesureTexte = secondPinceau.getFontMetrics();
        texteLargeur = mesureTexte.stringWidth(texte);
        texteHauteur = mesureTexte.getAscent();

        xTexte = (largeur - texteLargeur) / 2;
        yTexte = (hauteur + texteHauteur) / 2 - 2; // petit ajustement esthetique

        secondPinceau.drawString(texte, xTexte, yTexte);
    }
}
