package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>PanelConfirmation</code> est utilisée pour l'affichage du panel de confirmation de fermeture de l'application.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class PanelConfirmation extends JDialog{

	/**
	 * Lien avec la classe <code>FenetreMain</code>.
	 */
	private FenetreMain fenetreMain;

	/**	 
	 * Label pour le titre du panel de confirmation.
	 */
    private JLabel titre;

	/**	 
	 * Bouton pour quitter l'application.
	 */
    private Bouton btnQuitter;

	/**	 
	 * Bouton pour annuler la fermeture de l'application.
	 */
    private Bouton btnAnnuler;

	/**
	 * Couleur de fond du panel.
	 */
    private Color fondPanel;

	/**	 
	 * Contraintes pour l'agencement des composants.
	 */
    private GridBagConstraints contraintes;

	/**	 
	 * Le constructeur de la classe <code>PanelConfirmation</code> initialise tous les composants nécessaire à son affichage 
	 * @param fenetreMain lien avec la classe <code>FenetreMain</code>.
	 */
	public PanelConfirmation(FenetreMain fenetreMain) {
		super(fenetreMain,"Confirmation", true);
		this.fenetreMain = fenetreMain;
		this.contraintes = new GridBagConstraints();

		this.fondPanel = new Color(255,249,227);
		this.setBackground(fondPanel);
		this.setLayout(new GridBagLayout());

		this.titre = new JLabel("Voulez-vous vraiment quitter l'application ?");
		this.titre.setFont(new Font("Dialog", Font.BOLD, 18));
		this.titre.setHorizontalAlignment(SwingConstants.CENTER);

		this.btnQuitter = new Bouton(180,40,"Oui", new Color(220,53,69), Color.WHITE);
		this.btnQuitter.setName("QUITTER");

		this.btnAnnuler = new Bouton(180,40,"Non", new Color(108,117,125), Color.WHITE);
		this.btnAnnuler.setName("ANNULER");

		ControleurBoutonConfirm ctrlBouton = new ControleurBoutonConfirm(btnAnnuler, btnQuitter,this);

		btnQuitter.addMouseListener(ctrlBouton);
		btnAnnuler.addMouseListener(ctrlBouton);

		// Le texte
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
		contraintes.insets = new Insets(0,0,40,0);
		contraintes.anchor = GridBagConstraints.CENTER;
		this.add(titre, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.insets = new Insets(0,10,0,10);
		this.add(btnQuitter,contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.insets = new Insets(0,10,0,10);
		this.add(btnAnnuler, contraintes);

		this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(fenetreMain);
        this.setVisible(true);
	}
}