package fr.iutfbleau.papillon;
import java.awt.event.*;


/**
 * La classe <code>ControleurThemes</code> est utilisée 
 * pour gérer les interractions entre la souris et un objet de la classe <code>Theme</code>." 
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurThemes implements MouseListener{

    /**
     * Variable pour contenir l'objet de la classe <code>Theme</code> avec qui intéragir
     */
    private Theme theme;

    /**
     * Variable contenant l'identifiant du thème
     */
    private int numTheme;

    /**
     * Variable pour contenir l'objet de la classe <code>JThemeArea</code> avec qui intéragir
     */
    private JThemeArea panelThemes;

    /**
     * Constructeur permettant relier des objets exterieurs avec la classe <code>ControleurThemes</code>
     * @param t Objet de la classe <code>Theme</code>
     * @param panel Objet de la classe <code>JThemeArea</code>
     */
	public ControleurThemes(Theme t, JThemeArea panel){
        this.theme=t;
        this.numTheme=theme.getNumTheme();
        this.panelThemes=panel;
	}

    /**
     * Interraction lorsque la souris clique sur l'objet Theme.
     * Appelle la fonction qui défini si un thème est cliquer.
     * @param e géré en dehors du code.
     */
    @Override
	public void mouseClicked(MouseEvent e) {
        panelThemes.setClick(1, numTheme);
	}

    /**
     * Interraction lorsque la souris sort du l'objet Theme.
     * Appelle la fonction qui change les couleurs du theme.
     * @param e géré en dehors du code.
     */
    @Override
	public void mouseExited(MouseEvent e) {
        if (!panelThemes.getStatut(numTheme)) {
            panelThemes.setHover(false, numTheme);
        }
    }

    /**
     * Interraction lorsque la souris sort de l'objet Theme.
     * Appelle la fonction qui change les couleurs du theme.
     * @param e géré en dehors du code.
     */
    @Override
	public void mouseEntered(MouseEvent e) {
        if (!panelThemes.getStatut(numTheme)) {
            panelThemes.setHover(true, numTheme);
        }
    }

    @Override
	public void mousePressed(MouseEvent e) {
	}

    @Override
	public void mouseReleased(MouseEvent e) {
	}
}