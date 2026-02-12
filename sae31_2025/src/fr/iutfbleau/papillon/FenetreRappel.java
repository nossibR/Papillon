package fr.iutfbleau.papillon;
import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>FenetreRappel</code> est utilisée pour l'affichage de la fenêtre de rappel.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class FenetreRappel extends JPanel{
    
    /**
     * Rappel à afficher.
     */
    private Rappel rappel;

    /**
     * Lien avec la classe <code>FenetreAccueil</code>.
     */
    private FenetreAccueil fenetreAccueil;
    
    /**
     * Composants de la fenêtre de rappel.
     */
    private PanelRappelHeader header;
    
    /**
     * Composants de la fenêtre de rappel.
     */
    private PanelRappel content;
    
    /**
     * Panel qui permet de rajouter une marge à l'objet de la classe <code>PanelRappel</code>.
     */
    private JPanel marges;
    
    /**
     * Le constructeur de la classe <code>FenetreRappel</code> initialise tous les composants nécessaire à son affichage 
     * @param rappel le rappel à afficher
     * @param fenetreAccueil lien avec la classe <code>FenetreAccueil</code>
     */
    public FenetreRappel(Rappel rappel, FenetreAccueil fenetreAccueil){
        this.rappel=rappel;
        this.fenetreAccueil=fenetreAccueil;
        header=new PanelRappelHeader(this);
        content=new PanelRappel(rappel,this);
        marges = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        marges.setBackground(Color.WHITE);
        marges.add(content);
        this.add(marges, BorderLayout.CENTER);
    }
    /**
     * Méthode pour retourner à la fenêtre d'accueil.
     */
    public void returnFenetreAccueil(){
        fenetreAccueil.returnFenetreAccueil();
    }

    /**
     * Méthode pour mettre à jour un rappel.
     * @param id id du rappel
     * @param theme thème du rappel
     * @param title titre du rappel
     * @param context contexte du rappel
     */
    public void updateRappel(int id, int theme, String title, String context){
        Requete.update(id, title, context, theme);
        this.returnFenetreAccueil();
    }
}
