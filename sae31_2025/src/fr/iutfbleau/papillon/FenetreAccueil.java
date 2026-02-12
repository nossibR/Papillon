package fr.iutfbleau.papillon;
import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>FenetreAccueil</code> est utilisée pour l'affichage de la fenêtre d'accueil.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class FenetreAccueil extends JPanel{

	/**
	 * Lien avec la classe <code>FenetreMain</code>.
	 */
	private FenetreMain fenetreMain;
	
	/**
	 * Composants de la fenêtre d'accueil.
	 */
	private PanelAccueilHeader header;

	/**
	 * Composants de la fenêtre d'accueil.
	 */
	private PanelAccueil rappels;

	/**
	 * Composants de la fenêtre d'accueil.
	 */
	private JScrollPane scrollPanel;

	/**
	 * Le constructeur de la classe <code>FenetreAccueil</code> initialise tous les composants nécessaire à son affichage 
	 * @param fenetreMain lien avec la classe <code>FenetreMain</code>.
	 */
	public FenetreAccueil(FenetreMain fenetreMain){
		this.fenetreMain = fenetreMain;
		rappels = new PanelAccueil(this);
		header = new PanelAccueilHeader(this,rappels);
		scrollPanel = new JScrollPane(rappels);

		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.getVerticalScrollBar().setUnitIncrement(7);
		scrollPanel.setPreferredSize(new Dimension(400,100));

		this.setLayout(new BorderLayout());
		this.add(header, BorderLayout.NORTH);
		this.add(scrollPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	/**
	 * Méthode pour afficher la fenêtre d'ajout.
	 */
	public void setFenetreAjoutVisible(){
		fenetreMain.setFenetre(2);
	}
	
	/**
	 * Méthode pour afficher la fenêtre de rappel.
	 * @param rappel le rappel à afficher
	 */
	public void setFenetreRappel(Rappel rappel){
		fenetreMain.setFenetreRappel(rappel);
	}

	/**
	 * Méthode pour revenir à la fenêtre d'accueil.
	 */
	public void returnFenetreAccueil(){
		rappels.refreshAllRappels();
		fenetreMain.returnFenetreAccueil();
	}

	/**
	 * Méthode pour rafraîchir les rappels.
	 */
	public void refreshRappels(){
		rappels.refreshAllRappels();
	}
}
