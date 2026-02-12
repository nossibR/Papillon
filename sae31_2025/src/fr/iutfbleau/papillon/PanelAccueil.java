package fr.iutfbleau.papillon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * La classe <code>PanelAccueil</code> est utilisée pour l'affichage du panel d'accueil.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class PanelAccueil extends JPanel{

    /**
     * Contraintes pour l'agencement des rappels.
     */
    private GridBagConstraints contraintes;

    /**
     * Lien avec la classe <code>FenetreAccueil</code>.
     */
    private FenetreAccueil fenetreAccueil;

    /**
     * Liste des rappels affichés.
     */
    private List<Rappel> listRappels;

    /**
     * Liste des rappels sélectionnés pour modification.
     */
    private ArrayList<Rappel> listRappelsModif;

    /**
     * Liste des rappels sélectionnés pour suppression.
     */
    private ArrayList<Rappel> listRappelsSuppr;
    
    /**
     * Le constructeur de la classe <code>PanelAccueil</code> initialise tous les composants nécessaire à son affichage 
     * @param fenetreAccueil lien avec la classe <code>FenetreAccueil</code>.
     */
    public PanelAccueil(FenetreAccueil fenetreAccueil){
        this.fenetreAccueil=fenetreAccueil;
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        contraintes = new GridBagConstraints();
        listRappels=new ArrayList<Rappel>();
        listRappelsModif=new ArrayList<Rappel>();
        listRappelsSuppr=new ArrayList<Rappel>();
        listRappels.clear();
        refreshAllRappels();
    }

    /**
     * Méthode pour afficher la fenêtre de rappel.
     * @param rappel le rappel à afficher
     */
    public void setFenetreRappel(Rappel rappel){
        fenetreAccueil.setFenetreRappel(rappel);
    }

    /**
     * Méthode pour retourner à la fenêtre d'accueil.
     */
    public void returnFenetreAccueil(){
        fenetreAccueil.returnFenetreAccueil();
    }

    /**
     * Méthode pour rafraîchir tous les rappels affichés.
     */
    public void refreshAllRappels(){
        this.removeAll();
        this.revalidate();
        this.repaint();
        listRappels = Requete.getAllRappels();
        for(Rappel rap : listRappels){
            this.addRappel(rap);
        }
    }

    /**
     * Méthode pour ajouter un rappel au panel.
     * @param rap le rappel à ajouter
     */
    public void addRappel(Rappel rap){
        contraintes.gridy = rap.getRank();
        contraintes.insets = new Insets(10, 10, 0, 10);
        rap.addMouseListener(new ControleurRappel(rap, this));
        this.add(rap, contraintes); 
    }

    // ============ METHODES MODE MODIF ==============

    /**
     * Méthode pour activer ou désactiver le mode modification.
     * @param statut true pour activer le mode modification, false pour le désactiver
     */
    public void setModeModif(boolean statut){
        if (statut){
            for (Rappel r : listRappels){
                r.setModeModif(true); // indique qu'on passe en mode modifier
                r.setColorModif(true);
            }
        }if (!statut){
            for (Rappel r : listRappels){
                r.setModeModif(false);
                r.setColorModif(false);
                r.setSelectedModif(false);
            }
            listRappelsModif.clear();
        }
    }

    /**
     * Méthode pour ajouter un rappel à la liste des rappels sélectionnés pour modification.
     * @param rappel le rappel à ajouter
     */
    public void addTabRappelModif(Rappel rappel){
        if (listRappelsModif.contains(rappel)){
            return;
        }
        // si on dépasse 2, on enleve le plus ancien
        if (listRappelsModif.size() == 2){
            Rappel supprRappel = listRappelsModif.remove(0);
            supprRappel.setColorModifHover(false);
            supprRappel.setSelectedModif(false);
        }

        // on ajoute la nouvelle sélection
        listRappelsModif.add(rappel);
    }

    /**
     * Méthode pour supprimer un rappel de la liste des rappels sélectionnés pour modification.
     * @param rappel le rappel à supprimer
     */
    public void deleteTabRappelModif(Rappel rappel){
        if (listRappelsModif.contains(rappel)){
            int indexRappel = listRappelsModif.indexOf(rappel);
            if (indexRappel==1){
                listRappelsModif.remove(indexRappel);
            }
            else{ // pour mettre le rappel 1 en position 0
                Rappel rappel1 = listRappelsModif.get(1);
                listRappelsModif.clear();
                listRappelsModif.add(rappel1);

            }
            
        }
    }
    
    /**
     * Méthode pour échanger les deux rappels sélectionnés pour modification dans la base de données.
     */
    public void updateTabRappelModifSQL(){
        if (listRappelsModif.size() != 2){
            JOptionPane.showMessageDialog(this, "Vous devez sélectionner exactement 2 rappels pour les échanger.");
            return;
        } else{
            Requete.swap(listRappelsModif.get(0).getId(), listRappelsModif.get(1).getId());
            refreshAllRappels();
            this.revalidate();
            this.repaint();
        }
        
        
    }
    // ===============================================

    // ============ METHODES MODE SUPPR ==============

    /**
     * Méthode pour activer ou désactiver le mode suppression.
     * @param statut true pour activer le mode suppression, false pour le désactiver
     */
    public void setModeSuppr(boolean statut){
        if (statut){
            for (Rappel r : listRappels){
                r.setModeSuppr(true); // indique qu'on passe en mode Suppr
                r.setColorSuppr(true);
            }
        }if (!statut){
            for (Rappel r : listRappels){
                r.setModeSuppr(false);
                r.setColorSuppr(false);
                r.setSelectedSuppr(false);
            }
            listRappelsSuppr.clear();
        }
    }

    /**
     * Méthode pour ajouter un rappel à la liste des rappels sélectionnés pour suppression.
     * @param rappel le rappel à ajouter
     */
    public void addTabRappelSuppr(Rappel rappel){
        if (listRappelsSuppr.contains(rappel)){
            return;
        }
        listRappelsSuppr.add(rappel);
    }

    /**
     * Méthode pour supprimer un rappel de la liste des rappels sélectionnés pour suppression.
     * @param rappel le rappel à supprimer
     */
    public void deleteTabRappelSuppr(Rappel rappel){
        if (listRappelsSuppr.contains(rappel)){
            int indexRappel = listRappelsSuppr.indexOf(rappel);
            listRappelsSuppr.remove(indexRappel);
        }
    }

    /**
     * Méthode pour supprimer les rappels sélectionnés pour suppression dans la base de données.
     */
    public void deleteTabRappelSupprSQL(){
        if (listRappelsSuppr.size() == 0){
            JOptionPane.showMessageDialog(this, "Vous devez sélectionner au moins un rappel à supprimer.");
            return;
        }else{
            for(Rappel rap : listRappelsSuppr){
                Requete.delete(rap.getId());
            }
            refreshAllRappels();
            this.revalidate();
            this.repaint();
        }
    }
    // ===============================================
}
