package fr.iutfbleau.papillon;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControleurRetourRappelBtn</code> permet de gérer 
 * les interactions avec le bouton retour de la fenêtre de rappel.
 * @author Papillon
 */
public class ControleurRetourRappelBtn implements MouseListener{
	
    /**
     * Le bouton de retour.
     */
    private Bouton bouton;

    /**
     * La fenêtre de rappel.
     */
    private FenetreRappel fenetreRappel;

    /**
     * Le constructeur de la classe <code>ControlleurRetourBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     * @param fenetreRappel variable nécessaire à la référence de la classe <code>FenetreRappel</code>.
     */
	public ControleurRetourRappelBtn(Bouton bouton, FenetreRappel fenetreRappel){
        this.bouton=bouton;
        this.fenetreRappel=fenetreRappel;
	}

    /**
     * Appelle une fonction pour afficher la fenetre rappel.
     * @param e géré en dehors du code.
     */
	public void mouseClicked(MouseEvent e) {
        fenetreRappel.returnFenetreAccueil();
	}

    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param e géré en dehors du code.
     */
	public void mouseExited(MouseEvent e) {
        bouton.setHoverColor(false, new Color(255,184,0),new Color(255,255,255));
    }

    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param e géré en dehors du code.
     */
	public void mouseEntered(MouseEvent e) {
        bouton.setHoverColor(true, new Color(255,184,0),new Color(255,255,255));
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
