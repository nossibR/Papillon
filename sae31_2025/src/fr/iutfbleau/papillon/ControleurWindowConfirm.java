package fr.iutfbleau.papillon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * La classe <code>ControleurWindowConfirm</code> est utilisée 
 * pour gérer les interractions entre la fenêtre principale et la fenêtre de confirmation
 * de la classe <code>PanelConfirmation</code>."
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurWindowConfirm extends WindowAdapter {

    /**
     * Lien avec la classe <code>FenetreMain</code>.
     */
    private FenetreMain fenetreMain;

    /**
     * Les constructeurs de la classe <code>ControleurWindowConfirm</code> 
     * permettent de faire le lien avec différentes classes.
     * @param fenetreMain reférence à la fenêtre principale
     */
    public ControleurWindowConfirm(FenetreMain fenetreMain) {
        this.fenetreMain = fenetreMain;
    }
    
    /**
     * Méthode appelée lorsque l'utilisateur tente de fermer la fenêtre principale.
     * Elle permet d'ouvrir la fenêtre de confirmation avant de quitter l'application.
     */
    @Override
    public void windowClosing(WindowEvent e) {
        new PanelConfirmation(fenetreMain);
    }
}