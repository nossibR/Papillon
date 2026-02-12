package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>FenetreAjout</code> est utilisée pour l'affichage de la fenêtre d'ajout de rappel.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class FenetreAjout extends JPanel{
    /**
     * Panel header de la fenetre, qui contient le boutou "Retour".
     */
    private PanelAjoutHeader header;

    /** 
     * Panel qui contient le formulaire pour ajouter un rappel. 
     */
    private PanelAjout ajout;

    /**
     * Panel qui permet de rajouter une marge à l'objet de la classe <code>PanelAjout</code>.
     */
    private JPanel marges;

    /**
     * Variable pour contenir l'objet de la classe <code>FenetreMain</code> avec qui intéragir
     */
    private FenetreMain fenetreMain;

    /**
     * Contructeur qui crée les objets nécéssaire, les agencent et les affichent.
     * @param fenetreMain lien avec la classe <code>FenetreMain</code>.
     */

    public FenetreAjout(FenetreMain fenetreMain){
        this.fenetreMain=fenetreMain;
        header = new PanelAjoutHeader(this);
        ajout = new PanelAjout(this);
        marges = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        marges.setBackground(Color.WHITE);
        marges.add(ajout);
        this.add(marges, BorderLayout.CENTER);
    }

    /**
     * Méthode pour afficher la fenêtre d'accueil.
     */
    public void setFenetreAccueilVisible(){
        fenetreMain.setFenetre(1);
    }
}
