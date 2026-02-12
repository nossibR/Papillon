package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;


/**
 * La classe <code>PanelAjoutHeader</code> est utilisée pour l'affichage du header du panel d'ajout de rappel.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class PanelAjoutHeader extends JPanel{

    /**
     * Bouton "Retour", pour revenir au panel d'accueil.
     */
    private Bouton retourBtn;

    /**
     * Lien avec la classe <code>FenetreAjout</code>.
     */
    private FenetreAjout fenetreAjout;

    /**
     * Le constructeur de la classe <code>PanelAjoutHeader</code> initialise tous les composants nécessaire à son affichage 
     * @param fenetreAjout lien avec la classe <code>FenetreAjout</code>.
     */
    public PanelAjoutHeader(FenetreAjout fenetreAjout){

        this.fenetreAjout=fenetreAjout;

        retourBtn = new Bouton(380, 33, "Retour", Color.WHITE, new Color(255, 184, 0));

        retourBtn.addMouseListener(new ControleurRetourBtn(retourBtn,this));

        this.add(retourBtn);
        this.setBackground(new Color(255, 235, 153));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    }

    /**
     * getter de type Bouton pour le bouton Retour et obtenir ses parametres
     * 
     * @return le bouton de retour
     */
    public Bouton getBtnRetour() {
    	return this.retourBtn;
    }
    /**
     * Méthode pour afficher la fenêtre d'accueil.
     */
    public void setFenetreAccueilVisible(){
        fenetreAjout.setFenetreAccueilVisible();
    }
}
