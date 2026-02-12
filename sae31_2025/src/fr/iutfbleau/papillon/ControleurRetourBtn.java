package fr.iutfbleau.papillon;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControleurRetourBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et le bouton de retour
 * de la classe <code>PanelAjoutHeader</code>."
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurRetourBtn implements MouseListener{
	
    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
    private Bouton bouton;

    /**
     * Lien avec la classe <code>panelAjoutHeader</code>.S
     */
    private PanelAjoutHeader panelAjoutHeader;

    /**
     * Le constructeur de la classe <code>ControleurRetourBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     * @param panelAjoutHeader variable nécessaire à la référence de la classe <code>PanelAjoutHeader</code>.
     */
	public ControleurRetourBtn(Bouton bouton, PanelAjoutHeader panelAjoutHeader){
        this.bouton=bouton;
        this.panelAjoutHeader=panelAjoutHeader;
	}

    /**
     * Appelle une fonction pour afficher la fenetre rappel.
     * @param e géré en dehors du code.
     */
	public void mouseClicked(MouseEvent e) {
        panelAjoutHeader.setFenetreAccueilVisible();
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
