package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControleurValiderBtn</code> permet de gérer 
 * les interactions avec le bouton valider de la fenêtre d'ajout.
 * @author Papillon
 */
public class ControleurValiderBtn implements MouseListener{
	
    /**
     * Le bouton de validation.
     */
    private Bouton bouton;

    /**
     * Le panel d'ajout.
     */
    private PanelAjout panelAjout;

    /**
     * Le constructeur de la classe <code>ControlleurValiderBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     * @param panelAjout variable nécessaire à la référence de la classe <code>PanelAjout</code>.
     */
	public ControleurValiderBtn(Bouton bouton, PanelAjout panelAjout){
        this.bouton=bouton;
        this.panelAjout=panelAjout;
	}

    @Override
	public void mouseClicked(MouseEvent e) {
        panelAjout.addRappel();
        panelAjout.resetAll();
	}

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param e géré en dehors du code.
     */
    @Override
	public void mouseExited(MouseEvent e) {
        bouton.setHoverColor(false, new Color(0,161,67),new Color(255,255,255));
    }

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param e géré en dehors du code.
     */
    @Override
	public void mouseEntered(MouseEvent e) {
        bouton.setHoverColor(true, new Color(0,161,67),new Color(255,255,255));
    }

    @Override
	public void mousePressed(MouseEvent e) {
	}

    @Override
	public void mouseReleased(MouseEvent e) {
	}
}