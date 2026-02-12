package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>FenetreMain</code> est utilisée pour l'affichage de la fenêtre principale.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class FenetreMain extends JFrame{

	/**
	 * Layout pour gérer les différentes fenêtres.
	 */
	private CardLayout cardLayout;
	
	/**
	 * Conteneur principal pour les différentes fenêtres.
	 */
	private JPanel contenu;
	
	/**
	 * Les différentes fenêtres de l'application.
	 */
	private FenetreAccueil fenetreAccueil;
	
	/**
	 * Les différentes fenêtres de l'application.
	 */
	private FenetreAjout fenetreAjout;
	
	/**
	 * Les différentes fenêtres de l'application.
	 */
	private FenetreRappel fenetreRappel;

	/**
	 * Le constructeur de la classe <code>FenetreMain</code> initialise tous les composants nécessaire à son affichage 
	 */
	public FenetreMain(){
		cardLayout = new CardLayout();
		contenu = new JPanel(cardLayout);

		fenetreAccueil = new FenetreAccueil(this);
		fenetreAjout = new FenetreAjout(this);

		contenu.add(fenetreAccueil,"FENETRE_ACCUEIL");
		contenu.add(fenetreAjout,"FENETRE_AJOUT");

		cardLayout.show(contenu, "FENETRE_ACCUEIL");
		this.setLayout(new BorderLayout());
		this.add(contenu, BorderLayout.CENTER);
		this.pack();
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // On récupère la taile de l'écran utilisateur
    int height = (int)screenSize.getHeight();
    this.setLocation(30, height-370);


    this.addWindowListener(new ControleurWindowConfirm(this));
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.setVisible(true);
	}

	/**
	 * Méthode pour afficher les différentes fenêtres.
	 * @param indexFenetre l'index de la fenêtre à afficher
	 */
	public void setFenetre(int indexFenetre){
		if(indexFenetre == 1){
			cardLayout.show(contenu, "FENETRE_ACCUEIL");
			fenetreAccueil.refreshRappels();
		} else if (indexFenetre == 2) {
			cardLayout.show(contenu, "FENETRE_AJOUT");
		} 
	}

	/**
	 * Méthode pour afficher la fenêtre de rappel.
	 * @param rappel le rappel à afficher
	 */
	public void setFenetreRappel(Rappel rappel){
		fenetreRappel = new FenetreRappel(rappel,fenetreAccueil);
		contenu.add(fenetreRappel,"FENETRE_RAPPEL");
		cardLayout.show(contenu, "FENETRE_RAPPEL");
	}
	/**
	 * Méthode pour revenir à la fenêtre d'accueil.
	 */
	public void returnFenetreAccueil(){
		if(fenetreRappel != null) {
			contenu.remove(fenetreRappel);
		}
		cardLayout.show(contenu, "FENETRE_ACCUEIL");
		contenu.revalidate();
		contenu.repaint();
	}
}
