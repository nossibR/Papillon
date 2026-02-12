package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;
/**
 * La classe <code>ControleurModifBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et le bouton de modification
 * de la classe <code>PanelAccueilHeader</code>."
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurModifBtn implements MouseListener {

    /**
     * Lien avec la classe <code>Bouton</code>. 
     */
    private Bouton bouton;

    /**
     * Lien avec la classe <code>PanelAccueilHeader</code>.
     */
    private PanelAccueilHeader panelAccueilHeader;

    /**
     * Les constructeurs de la classe <code>ControleurModifBtn</code> 
     * permettent de faire le lien avec différentes classes.
     * @param bouton reférence au bouton modif
     * @param panelAccueilHeader reférence au panel header de l'accueil
     */
    public ControleurModifBtn(Bouton bouton, PanelAccueilHeader panelAccueilHeader){
        this.bouton = bouton;
        this.panelAccueilHeader = panelAccueilHeader;
    }

    /**
     * Méthode appelée lorsque l'utilisateur clique sur le composant.
     * Elle permet d'activer ou désactiver le mode modification.
     * @param e géré en dehors du code.
     */
    public void mouseClicked(MouseEvent e) {
        boolean nouveauStatut = !panelAccueilHeader.getStatutModifBtn();
        if(panelAccueilHeader.getStatutSupprBtn()){
            panelAccueilHeader.setModeSuppr(!nouveauStatut);
        }
        panelAccueilHeader.setModeModif(nouveauStatut);
    }

    /**
     * Méthode appelée lorsque la souris entre dans le composant.
     * Elle permet de changer la couleur du bouton au survol.
     * @param e géré en dehors du code.
     */
    public void mouseEntered(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelAccueilHeader.getStatutModifBtn()) {
            bouton.setHoverColor(true, new Color(255,184,0), new Color(255,255,255));
        }
    }
    
    /**
     * Méthode appelée lorsque la souris sort du composant.
     * Elle permet de réinitialiser la couleur du bouton.
     * @param e géré en dehors du code.
     */
    public void mouseExited(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelAccueilHeader.getStatutModifBtn()) {
            bouton.setHoverColor(false, new Color(255,184,0), new Color(255,255,255));
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
