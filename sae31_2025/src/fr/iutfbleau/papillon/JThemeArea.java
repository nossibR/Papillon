package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>JThemeArea</code> est utilisée pour l'affichage des thèmes.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class JThemeArea extends JPanel{
    
    /**
     * Tableau des couleurs pour les thèmes.
     */
    private Color[][] tabColors; // Color[numero du theme][statut] numero de theme : 0 à 4, statut : 0=defaut 1=hover 
    
    /**
     * Tableau des thèmes.
     */
    private Theme[] tabThemes;
    
    /**
     * Tableau des statuts de clic des thèmes.
     */
    private boolean[] tabStatutCliqueThemes;
    
    /**
     * Contraintes pour GridBadLayout.
     */
    private GridBagConstraints contraintes;

    /**
     * Le constructeur de la classe <code>JThemeArea</code> initialise tous les composants nécessaire à son affichage 
     */
    public JThemeArea(){
        this.tabThemes=new Theme[5];
        this.tabStatutCliqueThemes=new boolean[5];
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        contraintes = new GridBagConstraints();
        contraintes.gridy=0;
        contraintes.insets = new Insets(0,2,0,2);
        contraintes.fill = GridBagConstraints.NONE;
        contraintes.anchor = GridBagConstraints.CENTER;
        
        tabColors = new Color[][]{
            {new Color(227, 212, 255),new Color(139, 92, 246)}, // violet
            {new Color(207, 225, 255),new Color(26, 115, 234)}, // bleu
            {new Color(191, 255, 208),new Color(0, 168, 107)}, // vert
            {new Color(255, 207, 203),new Color(255, 59, 48)}, // rouge
            {new Color(255, 209, 164),new Color(255, 127, 0)} // orange
        };

        for (int i=0 ; i<5 ;i++){
            tabThemes[i]=new Theme(tabColors[i][0],i);
            tabThemes[i].addMouseListener(new ControleurThemes(tabThemes[i],this));
            contraintes.gridx=i;
            this.add(tabThemes[i],contraintes);
        }
    }

    /**
     * Méthode pour gérer le survol des thèmes.
     * @param statut statut du survol
     * @param numTheme numéro du thème
     */
    public void setHover(boolean statut, int numTheme) {
        if (statut){
            tabThemes[numTheme].setColorTheme(tabColors[numTheme][1]);
        } else {
            tabThemes[numTheme].setColorTheme(tabColors[numTheme][0]);
        }
        repaint();
    }
    /**
     * Méthode pour gérer le clic des thèmes.
     * @param statutClique statut du clic
     * @param numTheme numéro du thème
     */
    public void setClick(int statutClique, int numTheme) {
        if (statutClique== 0){
            tabStatutCliqueThemes[numTheme] = false;
            tabThemes[numTheme].setColorTheme(tabColors[numTheme][0]);
        }
        if(statutClique== 1){
            for (int i=0 ; i<5 ;i++){
                tabStatutCliqueThemes[i]= false;
                tabThemes[i].setColorTheme(tabColors[i][0]);
                repaint();
            }
            tabStatutCliqueThemes[numTheme] = true;
            tabThemes[numTheme].setColorTheme(tabColors[numTheme][1]);
        }
        repaint();
    }

    /**
     * Méthode pour réinitialiser les thèmes.
     */
    public void resetThemes(){
        for (int i=0 ; i< tabStatutCliqueThemes.length ; i++){
            tabStatutCliqueThemes[i]=false;
            tabThemes[i].setColorTheme(tabColors[i][0]);
        }
    }
    
    /**
     * Méthode pour obtenir le statut d'un thème.
     * @param numTheme numéro du thème
     * @return le statut du thème
     */
    public boolean getStatut(int numTheme) {
        return tabStatutCliqueThemes[numTheme];
    }
    /**
     * Méthode pour obtenir le thème sélectionné.
     * @return le thème sélectionné
     */
    public int getTheme() {
        for (int i = 0; i < tabStatutCliqueThemes.length; i++) {
            if (tabStatutCliqueThemes[i]) {
                return i;
            }
        }
        return -1;
    }
}
