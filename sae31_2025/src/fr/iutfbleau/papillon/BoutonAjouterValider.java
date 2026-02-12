package fr.iutfbleau.papillon;

import java.awt.*;



/**
 * La classe <code>BoutonAjouterValider</code> est hérite de la classe <code>Bouton</code>
 * elle permet d'afficher un bouton différent en fonction de son controleur. 
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class BoutonAjouterValider extends Bouton {
    /**
     * Boolean qui permet de savoir quel bouton afficher, true pour afficher le bouton "Ajouter".
     */
    private boolean dessineAjouter;

    /** Constructeur de la classe <code>BoutonAjouterValider</code>.
     * Defini les paramètres pour créer un objet de la classe.
     * @param l Longeur du bouton.
     * @param h Hauteur du bouton.
     * @param t Texte à afficher.
     * @param f Couleur en en fond du bouton.
     * @param txtCouleur Couleur du texte.
    */
    public BoutonAjouterValider(int l, int h, String t, Color f, Color txtCouleur){
        super(l, h, t, f, txtCouleur);
        dessineAjouter=true;
    }
    /**
     * Dessine le composant.
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        
        Graphics secondPinceau = pinceau.create();
        if (dessineAjouter){
            secondPinceau.setColor(couleurActuelle);
            secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);

            secondPinceau.setColor(texteCouleurActuelle);
            secondPinceau.setFont(new Font("Dialog", Font.BOLD, 18));

            mesureTexte = secondPinceau.getFontMetrics();
            texteLargeur = mesureTexte.stringWidth("Ajouter");
            texteHauteur = mesureTexte.getAscent();

            xTexte = (largeur - texteLargeur) / 2;
            yTexte = (hauteur + texteHauteur) / 2 - 2; // petit ajustement esthetique

            secondPinceau.drawString("Ajouter", xTexte, yTexte);
        }
        if (!dessineAjouter){
            secondPinceau.setColor(couleurActuelle);
            secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);

            secondPinceau.setColor(texteCouleurActuelle);
            secondPinceau.setFont(new Font("Dialog", Font.BOLD, 18));

            mesureTexte = secondPinceau.getFontMetrics();
            texteLargeur = mesureTexte.stringWidth("Valider");
            texteHauteur = mesureTexte.getAscent();

            xTexte = (largeur - texteLargeur) / 2;
            yTexte = (hauteur + texteHauteur) / 2 - 2; // petit ajustement esthetique

            secondPinceau.drawString("Valider", xTexte, yTexte);
        }
    }

    /**
     * Méthode pour définir la couleur lors du survol.
     * @param statut true pour activer le hover, false pour le désactiver.
     * @param couleurHover couleur du hover.
     * @param texteHover couleur du texte lors du hover.
     */
    @Override
    public void setHoverColor(boolean statut, Color couleurHover, Color texteHover) {

        if (dessineAjouter){
            if (statut){
                this.couleurActuelle = new Color(255, 184, 0);
                this.texteCouleurActuelle = Color.WHITE;
            }else{
                this.couleurActuelle = Color.WHITE;
                this.texteCouleurActuelle = new Color(255, 184, 0);
            }
        } else if(!dessineAjouter){
            if (statut){
                this.couleurActuelle = new Color(0,161,67);
                this.texteCouleurActuelle = Color.WHITE;
            }else{
                this.couleurActuelle = new Color(0, 200, 83);
                this.texteCouleurActuelle = Color.WHITE;
            }
        }
        repaint();
    }
    /**
     * Méthode qui permet de d'affichier le bouton "Ajouter" ou non.
     * @param statut true pour afficher le bouton "Ajouter", false pour afficher le bouton "Valider".
     */
    public void setVisibleDessinAjouter(Boolean statut){
        if (statut){
            couleurActuelle=Color.WHITE;
            texteCouleurActuelle=new Color(255, 184, 0);
        }else{
            couleurActuelle=new Color(0, 200, 83);
            texteCouleurActuelle=Color.WHITE;
        }
        this.dessineAjouter=statut;
        repaint();
    }
}
