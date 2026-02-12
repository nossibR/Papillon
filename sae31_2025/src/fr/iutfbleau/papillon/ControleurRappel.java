package fr.iutfbleau.papillon;

import java.awt.event.*;

/**
 * La classe <code>ControleurRappel</code> est utilisée 
 * pour gérer les interractions entre la souris et les rappels
 * de la classe <code>PanelAccueil</code>."
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class ControleurRappel implements MouseListener {

    /**
     * Lien avec la classe <code>Rappel</code>.
     */
    private Rappel rappel;

    /**
     * Lien avec la classe <code>PanelAccueil</code>.
     */
    private PanelAccueil panelAccueil;

    /**
     * Variables pour stocker le statut du mode modif.
     */
    private boolean nouveauStatutModif;

    /**
     * Variables pour stocker le statut du mode suppr.
     */
    private boolean nouveauStatutSuppr;

    /**
     * Les constructeurs de la classe <code>ControleurRappel</code> 
     * permettent de faire le lien avec différentes classes.
     * @param rappel reférence au rappel
     * @param panelAccueil reférence au panel d'accueil
     */
    public ControleurRappel(Rappel rappel, PanelAccueil panelAccueil){
        this.rappel = rappel;
        this.panelAccueil = panelAccueil;
    }

    /**
     * Interraction lorsque l'utilisateur clique sur le rappel.
     * Appelle la fonction qui permet d'ouvrir la fenêtre du rappel
     * ou de sélectionner le rappel en mode modification/suppression.
     * @param e géré en dehors du code.
     */
    public void mouseClicked(MouseEvent e) {

        if (rappel.getModeModif()) { // mode modif
            nouveauStatutModif = !rappel.isSelectedModif();
            rappel.setSelectedModif(nouveauStatutModif);

            if (nouveauStatutModif) {
                rappel.setColorModifHover(true);
                panelAccueil.addTabRappelModif(rappel);
            } else {
                rappel.setColorModifHover(false);
                panelAccueil.deleteTabRappelModif(rappel);
            }

        } else if(rappel.getModeSuppr()) { // mode suppr
            nouveauStatutSuppr = !rappel.isSelectedSuppr();
            rappel.setSelectedSuppr(nouveauStatutSuppr);

            if (nouveauStatutSuppr) {
                rappel.setColorSupprHover(true);
                panelAccueil.addTabRappelSuppr(rappel);
            } else {
                rappel.setColorSupprHover(false);
                panelAccueil.deleteTabRappelSuppr(rappel);
            }
        } 
        else {
            panelAccueil.setFenetreRappel(rappel);
        }
    }
    /**
     * Interraction lorsque la souris entre du rappel.
     * Appelle la fonction qui change les couleurs du rappel.
     * @param e géré en dehors du code.
     */
    public void mouseEntered(MouseEvent e) {
        if (rappel.getModeModif()) {
            if (!rappel.isSelectedModif()) {
                rappel.setColorModifHover(true);
            }
            return; 
        }

        if (rappel.getModeSuppr()) {
            if (!rappel.isSelectedSuppr()) {
                rappel.setColorSupprHover(true);
            }
            return;
        }
        rappel.setHoverColor(true);
    }

    /**
     * Interraction lorsque la souris sort du rappel.
     * Appelle la fonction qui change les couleurs du rappel.
     * @param e géré en dehors du code.
     */
    public void mouseExited(MouseEvent e) {
        if (rappel.getModeModif()) {
            if (!rappel.isSelectedModif()) {
                rappel.setColorModifHover(false);
            }
            return;
        }
        if (rappel.getModeSuppr()) {
            if (!rappel.isSelectedSuppr()) {
                rappel.setColorSupprHover(false);
            }
            return;
        }
        rappel.setHoverColor(false);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
