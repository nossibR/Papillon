package fr.iutfbleau.papillon;
import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>PanelRappelHeader</code> est utilisée pour l'affichage du header du panel de rappel.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class PanelRappelHeader extends JPanel{

    /**
     * Bouton "Retour", pour ajouter un rappel.
     */
    private Bouton retourBtn;

    /**
     * Lien avec la classe <code>FenetreRappel</code>.
     */
    private FenetreRappel fenetreRappel;

    /**
     * Le constructeur de la classe <code>PanelAjoutHeader</code> initialise tous les composants nécessaire à son affichage 
     * @param fenetreRappel lien avec la classe <code>FenetreRappel</code>.
     */
    public PanelRappelHeader(FenetreRappel fenetreRappel){
        this.fenetreRappel=fenetreRappel;

        retourBtn = new Bouton(380, 33, "Retour", Color.WHITE, new Color(255, 184, 0));

        retourBtn.addMouseListener(new ControleurRetourRappelBtn(retourBtn,fenetreRappel));

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
}
