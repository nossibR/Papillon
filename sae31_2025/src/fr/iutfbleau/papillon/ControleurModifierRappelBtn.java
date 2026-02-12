package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControleurModifierRappelBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et le bouton de modification
 * de la classe <code>PanelRappel</code>."
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurModifierRappelBtn implements MouseListener{

    /**
     * Lien avec la classe <code>Bouton</code>.
     */
    private Bouton bouton;

    /**
     * Lien avec la classe <code>PanelRappel</code>.
     */
    private PanelRappel panelRappel;

    /**
     * Les constructeurs de la classe <code>ControleurModifierRappelBtn</code> 
     * permettent de faire le lien avec différentes classes.
     * @param bouton reférence au bouton modif
     * @param panelRappel reférence au panel rappel
     */
	public ControleurModifierRappelBtn(Bouton bouton, PanelRappel panelRappel){
        this.bouton=bouton;
        this.panelRappel=panelRappel;
	}

    /**
     * Interraction lorsque l'utilisateur clique sur le bouton.
     * Appelle la fonction qui permet de modifier le rappel.
     * @param e géré en dehors du code.
     */
    @Override
	public void mouseClicked(MouseEvent e) {
        panelRappel.updateRappel();
	}

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param e géré en dehors du code.
     */
    @Override
	public void mouseExited(MouseEvent e) {
        bouton.setHoverColor(false, new Color(255,255,255),new Color(26, 115, 234));
    }

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param e géré en dehors du code.
     */
    @Override
	public void mouseEntered(MouseEvent e) {
        bouton.setHoverColor(true, new Color(27,102,202),new Color(255,255,255));
    }

    @Override
	public void mousePressed(MouseEvent e) {
	}

    @Override
	public void mouseReleased(MouseEvent e) {
	}
}