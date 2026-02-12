package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>BoutonSuppr</code> est utilisée 
 * pour créer un bouton personnalisable avec une image à l'intérieur. 
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class BoutonSuppr extends JComponent{

    /**
     * Largeur du bouton.
     */
    private int largeur;

    /**
     * Hauteur du bouton.
     */
    private int hauteur;

    /**
     * Variable qui contient l'image jaune que l'on souhaite afficher.
     */
    private Image imageJaune;

    /**
     * Variable qui contient l'image blanche que l'on souhaite afficher.
     */
    private Image imageBlanche;

    /**
     * Variable qui contient l'image afficher à l'instant présent.
     */
    private Image imageActuelle;

    /**
     * Permet de charger une image à partir d'un chemin donné.
     */
    private ClassLoader loader;

    /**
     * Couleur du fond
     */
    private Color fond;

    /** Constructeur de la classe <code>BoutonSuppr</code>.
     * Defini les paramètres pour créer un objet de la classe.
     * @param l Longeur du bouton.
     * @param h Hauteur du bouton.
     * @param f Couleur en en fond du bouton.
    */
    public BoutonSuppr(int l, int h, Color f) {
        this.largeur = l;
        this.hauteur = h;
        loader = Thread.currentThread().getContextClassLoader();

        this.imageJaune = new ImageIcon(loader.getResource("res/icons8-trash-yellow.png")).getImage();
        this.imageBlanche = new ImageIcon(loader.getResource("res/icons8-trash-white.png")).getImage();

        imageActuelle = imageJaune;
        this.fond = f;

        this.setPreferredSize(new Dimension(largeur, hauteur));
    }

    /**
     * Méthode qui dessine le composant.
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics g = pinceau.create();

        g.setColor(fond);
        g.fillRoundRect(0, 0, largeur, hauteur, 10, 10);
        g.drawImage(imageActuelle, (largeur - 24) / 2, (hauteur - 24) / 2, this);
    
    }

    /**
     * Méthode pour définir la couleur lors du survol.
     * @param statut true pour activer le hover, false pour le désactiver.
     */
    public void setHoverColor(boolean statut) {
        if (statut) {
            this.fond = new Color(255, 184, 0);
            this.imageActuelle = imageBlanche;
        } else {
            this.fond = new Color(255, 255, 255);
            this.imageActuelle= imageJaune;
        }
        repaint();
    }
}
