package fr.iutfbleau.papillon;
import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>PanelRappel</code> est utilisée pour l'affichage du panel de modification de rappel.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class PanelRappel extends JPanel{

    /**
     * Labels et champs de texte pour le rappel.
     */
    private JLabel titre;

    /**
     * Labels et champs de texte pour le rappel.
     */
    private JLabel theme;

    /**
     * Labels et champs de texte pour le rappel.
     */
    private JLabel contexte; 

    /**
     * Champs de texte pour le rappel.
     */
    private JTextField champTitre;

    /**
     * Zone de sélection pour le thème du rappel.
     */
    private JThemeArea zoneThemes;

    /**
     * Champs de texte pour le rappel.
     */
    private JTextArea champContenu;

    /**
     * Bouton "Modifier", pour valider les modifications du rappel.
     */
    private Bouton modifBtn;

    /**
     * Couleur de fond du panel.
     */
    private Color fondPanel;

    /**
     * Contraintes pour l'agencement des composants.
     */
    private GridBagConstraints contraintes;

    /**
     * Lien avec la classe <code>Rappel</code>.
     */
    private Rappel rappel;

    /**
     * Lien avec la classe <code>FenetreRappel</code>.
     */
    private FenetreRappel fenetreRappel;

    /**
     * Le constructeur de la classe <code>PanelRappel</code> initialise tous les composants nécessaire à son affichage 
     * @param rappel le rappel à afficher
     * @param fenetreRappel lien avec la classe <code>FenetreRappel</code>.
     */
    public PanelRappel(Rappel rappel, FenetreRappel fenetreRappel){
        this.rappel=rappel;
        this.fenetreRappel=fenetreRappel;
        this.contraintes = new GridBagConstraints();

        this.titre=new JLabel("Titre (50 caractères maximum) :");
        titre.setFont(new Font("Dialog", Font.BOLD, 12));
        this.theme=new JLabel("Thème :");
        theme.setFont(new Font("Dialog", Font.BOLD, 12));
        this.contexte=new JLabel("Contenu (Optionnel, 200 caractères maximum) :");
        contexte.setFont(new Font("Dialog", Font.BOLD, 12));
        
        this.zoneThemes=new JThemeArea();
        zoneThemes.setClick(1, rappel.getTheme());
        this.champTitre= new JTextField(rappel.getTitle());
        this.champContenu= new JTextArea(4,0);
        champContenu.setText(rappel.getContent());
        champContenu.setLineWrap(true);
        champContenu.setWrapStyleWord(true);

        this.modifBtn= new Bouton(340,33,"Modifier", new Color(26, 115, 234), Color.WHITE);
        modifBtn.addMouseListener(new ControleurModifierRappelBtn(modifBtn,this));
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
        this.add(modifBtn,contraintes);
        
    }

    /**
     * Méthode pour mettre à jour le rappel dans la base de données.
     */
    public void updateRappel(){
      if(VerifRappel.isTitleOk(champTitre.getText()) && 
            VerifRappel.isTextOk(champContenu.getText())){
            fenetreRappel.updateRappel(rappel.getId(),zoneThemes.getTheme(),champTitre.getText(),champContenu.getText());
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
     * getter de type int pour le theme
     *
     * @return le choix actuel de theme sous forme d'un int
     */ 
    public int getTheme(){
      return zoneThemes.getTheme();
    }

    /**
     * getter de type Bouton pour le bouton Valider et obtenir ses parametres
     * 
     * @return le bouton de validation
     */
    public Bouton getModifBtn() {
    	return this.modifBtn;
    }
}
