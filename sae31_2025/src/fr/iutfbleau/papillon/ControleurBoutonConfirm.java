package fr.iutfbleau.papillon;

import java.awt.event.*;

/**
 * La classe <code>ControleurBoutonConfirm</code> est utilisée 
 * pour gérer les interractions entre la souris et les boutons de la classe <code>PanelConfirmation</code>."
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurBoutonConfirm extends MouseAdapter {
	
    /**
     * Lien avec la classe <code>PanelConfirmation</code>.
     */
    private PanelConfirmation panelConfirmation;
    
    /**
     * Boutons de la classe <code>PanelConfirmation</code>.
     */
    private Bouton btnAnnuler;
    
    /**
     * Boutons de la classe <code>PanelConfirmation</code>.
     */
    private Bouton btnQuitter;

    /**
     * Les constructeurs de la classe <code>ControleurBoutonConfirm</code> 
     * permettent de faire le lien avec différentes classes.
     * @param btnAnnuler reférence au bouton annuler
     * @param btnQuitter reférence au bouton quitter
     * @param panelConfirmation reférence au panel de confirmation
     */
	public ControleurBoutonConfirm(Bouton btnAnnuler, Bouton btnQuitter, PanelConfirmation panelConfirmation) {
        this.panelConfirmation=panelConfirmation;
        this.btnAnnuler = btnAnnuler;
        this.btnQuitter = btnQuitter;
	}
    /**
     * Méthode appelée lorsque l'utilisateur clique sur le composant.
     * Elle permet de quitter l'application ou d'annuler la fermeture.
     * @param e géré en dehors du code.
     */
	@Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == btnQuitter) {
            this.quitterApplication();
        } else if (e.getSource() == btnAnnuler) {
            this.annulerFermeture();
        }
    }

    /**
     * Méthode pour quitter l'application.
     */
    public void quitterApplication() {
        System.exit(0);
    }
    
    /**
     * Méthode pour annuler la fermeture de l'application.
     */
    public void annulerFermeture() {
        panelConfirmation.dispose();
    }
}