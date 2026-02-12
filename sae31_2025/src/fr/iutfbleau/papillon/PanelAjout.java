package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>PanelAjout</code> est utilisée pour l'affichage du panel d'ajout de rappel.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class PanelAjout extends JPanel{

    /**
     * Label pour le titre du rappel.
     */
    private JLabel titre;

    /**
     * Label pour le thème du rappel.
     */
    private JLabel theme;

    /**
     * Label pour le contenu du rappel.
     */
    private JLabel contexte;

    /**
     * Champ de texte pour le titre du rappel.
     */
    private JTextField champTitre;

    /**
     * Zone de sélection pour le thème du rappel.
     */
    private JThemeArea zoneThemes;

    /**
     * Champ de texte pour le contenu du rappel.
     */
    private JTextArea champContenu;

    /**
     * Bouton pour valider l'ajout du rappel.
     */
    private Bouton validerBtn;

    /**
     * Couleur de fond du panel.
     */
    private Color fondPanel;

    /**
     * Contraintes pour l'agencement des composants.
     */
    private GridBagConstraints contraintes;

    /**
     * Lien avec la classe <code>FenetreAjout</code>.
     */
    private FenetreAjout fenetreAjout;

    /**
     * Le constructeur de la classe <code>PanelAjout</code> initialise tous les composants nécessaire à son affichage 
     * @param fenetreAjout lien avec la classe <code>FenetreAjout</code>.
     */
    public PanelAjout(FenetreAjout fenetreAjout){
        this.fenetreAjout=fenetreAjout;
        this.contraintes = new GridBagConstraints();

        this.titre=new JLabel("Titre (50 caractères maximum) :");
        titre.setFont(new Font("Dialog", Font.BOLD, 12));
        this.theme=new JLabel("Thème :");
        theme.setFont(new Font("Dialog", Font.BOLD, 12));
        this.contexte=new JLabel("Contenu (Optionnel, 200 caractères maximum) :");
        contexte.setFont(new Font("Dialog", Font.BOLD, 12));
        
        this.zoneThemes=new JThemeArea();

        this.champTitre= new JTextField();
        this.champContenu= new JTextArea(4,0);
        champContenu.setLineWrap(true);
        champContenu.setWrapStyleWord(true);

        this.validerBtn= new Bouton(340,33,"Valider", new Color(0, 200, 83), Color.WHITE);
        validerBtn.addMouseListener(new ControleurValiderBtn(validerBtn,this));
        this.fondPanel= new Color(255, 249, 227);

        this.setLayout(new GridBagLayout());
        this.setBackground(fondPanel);

        //Titre
        contraintes.gridx=0;
        contraintes.gridy=0;
        contraintes.weightx=1.0;
        contraintes.anchor = GridBagConstraints.WEST;
        contraintes.insets = new Insets(10, 10, 0, 10); 
        this.add(titre,contraintes);
        
        //Theme
        contraintes.gridx=1;
        contraintes.insets = new Insets(10, 5, 0, 10); 
        this.add(theme,contraintes);
        
        //Champs titre
        contraintes.gridx=0;
        contraintes.gridy=1;
        contraintes.insets = new Insets(0, 10, 5, 10); 
        contraintes.fill = GridBagConstraints.BOTH;

        this.add(champTitre,contraintes);

        //Champs theme
        contraintes.gridx=1;
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.insets = new Insets(0, 5, 5, 10); 
        this.add(zoneThemes,contraintes);
        
        //Contexte
        contraintes.gridx=0;
        contraintes.gridy=2;
        contraintes.gridwidth=2;
        contraintes.insets = new Insets(0, 10, 5, 10); 
        this.add(contexte,contraintes);

        //Champs contexte
        contraintes.gridy=3;
        contraintes.fill = GridBagConstraints.BOTH;
        this.add(champContenu,contraintes);

        //Valider
        contraintes.gridy=4;
        contraintes.fill = GridBagConstraints.NONE;
        contraintes.anchor = GridBagConstraints.CENTER;
        contraintes.insets = new Insets(5, 0, 10, 0); 
        this.add(validerBtn,contraintes);
        
    }

    /**
     * Méthode pour réinitialiser tous les champs du panel d'ajout.
     */
    public void resetAll(){
        zoneThemes.resetThemes();
        champTitre.setText("");
        champContenu.setText("");
    }

    /**
     * Méthode pour afficher la fenêtre d'accueil.
     */
    public void setFenetreAccueilVisible(){
        fenetreAjout.setFenetreAccueilVisible();
    }

    /**
     * Méthode pour ajouter un rappel à la base de données.
     */
    public void addRappel(){
        if(VerifRappel.isTitleOk(champTitre.getText()) && 
            VerifRappel.isTextOk(champContenu.getText()) &&
            VerifRappel.isThemeOk(zoneThemes.getTheme())){
            Requete.insert(champTitre.getText(), champContenu.getText(), zoneThemes.getTheme());
            this.setFenetreAccueilVisible();
        }else{
            return; // cas où erreur
        }
    }

    /**
     * getter de type String pour le titre
     * 
     * @return le titre du rappel sous forme de chaine de characteres
     */
    public String getTitre() {
    	return champTitre.getText();
    }

    /**
     * getter de type String pour le contenu
     * 
     * @return le contenu du rappel sous forme de chaine de caracteres
     */
    public String getContenu() {
    	return champContenu.getText();
    }

    /**
     * getter de type Bouton pour le bouton Valider et obtenir ses parametres
     * 
     * @return le bouton de validation
     */
    public Bouton getvaliderBtn() {
    	return this.validerBtn;
    }
}
