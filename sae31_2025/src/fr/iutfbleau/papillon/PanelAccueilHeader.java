package fr.iutfbleau.papillon;
import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>PanelAccueilHeader</code> est utilisée pour l'affichage de l'en-tête du panel d'accueil.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class PanelAccueilHeader extends JPanel{

    /**
     * Panneau qui contient les éléments à droite.
     */
    private JPanel panelDroite;

    /**
     * Panneau qui contient les éléments à gauche.
     */
    private JPanel panelGauche;

    /**
     * Bouton "Ajouter"/"Valider", pour ajouter un rappel ou valider les modifications/suppressions.
     */
    private BoutonAjouterValider ajouterValiderBtn;

    /**
     * Bouton "⇄", pour échanger des rappels.
     */
    private Bouton modifBtn ;

    /**
     * Bouton "🗑", pour supprimer des rappels.
     */
    private BoutonSuppr supprBtn;

    /**
     * Controlleur qui permet de gérer le bouton "Ajouter" et "Valider".
     */
    private ControleurAjouterValiderBtn ctrlAjouterValider;

    /**
     * Controlleur qui permet de gérer le bouton pour échanger les rappels.
     */
    private ControleurModifBtn ctrlModif;


    /**
     * Controlleur qui permet de gérer le bouton pour supprimer les rappels.
     */
    private ControleurSupprBtn ctrlSuppr;

    /**
     * Lien avec la classe <code>FenetreAccueil</code>.
     */
    private FenetreAccueil fenetreAccueil;

    /**
     * Lien avec la classe <code>PanelAccueil</code>.
     */
    private PanelAccueil panelAccueil;

    /**
     * Variables pour stocker le statut du mode modif.
     */
    private boolean statutModifBtn;

    /**
     * Variables pour stocker le statut du mode suppr.
     */
    private boolean statutSupprBtn;

    /**
     * Le constructeur de la classe <code>PanelAccueilHeader</code> initialise tous les composants nécessaire à son affichage 
     * @param fenetreAccueil lien avec la classe <code>FenetreAccueil</code>.
     * @param panelAccueil lien avec la classe <code>PanelAccueil</code>.
     */
    public PanelAccueilHeader(FenetreAccueil fenetreAccueil, PanelAccueil panelAccueil){
        this.fenetreAccueil=fenetreAccueil;
        this.panelAccueil=panelAccueil;
        statutModifBtn=false;

        //JPanel
        panelDroite= new JPanel();
        panelGauche= new JPanel();

        // Boutons
        ajouterValiderBtn = new BoutonAjouterValider(124,33, "Ajouter",Color.WHITE, new Color(255, 184, 0));
        modifBtn = new Bouton(33,33, "⇄",Color.WHITE, new Color(255, 184, 0));
        supprBtn = new BoutonSuppr(33,33,Color.WHITE);

        // Controlleurs
        ctrlAjouterValider = new ControleurAjouterValiderBtn(ajouterValiderBtn,this,panelAccueil);
        ctrlModif = new ControleurModifBtn(modifBtn, this);
        ctrlSuppr = new ControleurSupprBtn(supprBtn,this );
        
        // Panels
        panelDroite = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelGauche = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        // Affectation des controlleurs
        ajouterValiderBtn.addMouseListener(ctrlAjouterValider);
        modifBtn.addMouseListener(ctrlModif);
        supprBtn.addMouseListener(ctrlSuppr);

        panelDroite.add(modifBtn);
        panelDroite.add(supprBtn);
        panelDroite.setBackground(new Color(255, 235, 153));

        panelGauche.add(ajouterValiderBtn);
        panelGauche.setBackground(new Color(255, 235, 153));

        this.setBackground(new Color(255, 235, 153));
        this.setLayout(new BorderLayout());
        this.add(panelGauche,BorderLayout.WEST);
        this.add(panelDroite,BorderLayout.EAST);
    }

    /**
     * Méthode pour afficher la fenêtre d'ajout.
     */
    public void setFenetreAjoutVisible(){
        fenetreAccueil.setFenetreAjoutVisible();
    }

    /**
     * Méthode pour activer ou désactiver le mode modification.
     * @param statut true pour activer le mode modification, false pour le désactiver
     */
    public void setModeModif(Boolean statut){
        this.statutModifBtn=statut;
        if (statut){
            ajouterValiderBtn.setVisibleDessinAjouter(false); // afficher le bouton "valider"
            modifBtn.setHoverColor(true, new Color(255,184,0), new Color(255,255,255));
            panelAccueil.setModeModif(true);
        }
        if (!statut){
            ajouterValiderBtn.setVisibleDessinAjouter(true); // afficher le bouton "ajouter"
            modifBtn.setHoverColor(false, new Color(255,184,0), new Color(255,255,255));
            panelAccueil.setModeModif(false);
        }
        repaint();
    }

    /**
     * Méthode pour obtenir le statut du mode modification.
     * @return le statut du mode modification
     */
    public boolean getStatutModifBtn(){
        return this.statutModifBtn;
    }

    /**
     * Méthode pour activer ou désactiver le mode suppression.
     * @param statut true pour activer le mode suppression, false pour le désactiver
     */
    public void setModeSuppr(Boolean statut){
        this.statutSupprBtn=statut;
        if (statut){
            ajouterValiderBtn.setVisibleDessinAjouter(false); // afficher le bouton "valider"
            supprBtn.setHoverColor(true);
            panelAccueil.setModeSuppr(true);
        }
        if (!statut){
            ajouterValiderBtn.setVisibleDessinAjouter(true); // afficher le bouton "ajouter"
            supprBtn.setHoverColor(false);
            panelAccueil.setModeSuppr(false);
        }
        repaint();
    }

    /**
     * Méthode pour obtenir le statut du mode suppression.
     * @return le statut du mode suppression
     */
    public boolean getStatutSupprBtn(){
        return this.statutSupprBtn;
    }
}
