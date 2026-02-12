package fr.iutfbleau.papillon;

import java.awt.event.*;

/**
 * La classe <code>ControleurSupprBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "supprBtn" de la classe <code>Bouton</code>." 
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurSupprBtn implements MouseListener{

    /**
     * Lien avec la classe <code>BoutonSuppr</code>.
     */
	private BoutonSuppr bouton;

    /**
     * Lien avec la classe <code>panelAccueilHeader</code>.
     */
    private PanelAccueilHeader panelAccueilHeader;

    /**
     * Constructeur permettant relier des objets exterieurs avec la classe <code>ControleurSupprBtn</code>
     * @param bouton Objet de la classe <code>BoutonSuppr</code>
     * @param panelAccueilHeader Objet de la classe <code>PanelAccueilHeader</code>
     */
	public ControleurSupprBtn(BoutonSuppr bouton, PanelAccueilHeader panelAccueilHeader){
        this.bouton = bouton;
        this.panelAccueilHeader = panelAccueilHeader;
	}

    /**
     * Interraction lorsque la souris clique sur le bouton.
     * Appelle la fonction qui défini si le mode suppression est activé ou non.
     * @param e géré en dehors du code.
     */
	public void mouseClicked(MouseEvent e) {
        boolean nouveauStatut = !panelAccueilHeader.getStatutSupprBtn();
        if(panelAccueilHeader.getStatutModifBtn()){
            panelAccueilHeader.setModeModif(!nouveauStatut);
        }
        panelAccueilHeader.setModeSuppr(nouveauStatut);
	}

    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param e géré en dehors du code.
     */
	public void mouseExited(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelAccueilHeader.getStatutSupprBtn()) {
            bouton.setHoverColor(false);
        }
    }
    
    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param e géré en dehors du code.
     */
	public void mouseEntered(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelAccueilHeader.getStatutSupprBtn()) {
            bouton.setHoverColor(true);
        }
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
