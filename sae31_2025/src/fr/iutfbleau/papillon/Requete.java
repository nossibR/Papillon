package fr.iutfbleau.papillon;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * La classe <code>Requete</code> gère les interactions avec la base de données.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class Requete{

  /**
   * Connection à la base de données.
   */
  private static Connection cnx;

  /**
   * Constructeur par défaut de la classe <code>Requete</code>.
   */
  public Requete(){}

  // On charge la connection
  static{
    try {
      cnx = DriverManager.getConnection(
          "jdbc:mariadb://dwarves.iut-fbleau.fr/bissonr", 
          "bissonr", 
          "ananas");

    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(
          null,
          "Impossible de se connecter à la BDD : " + e1.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
          );
      System.err.println("Problème de connection à la BD : " + e1.getMessage());

    }
  }

  /**
   * Récupère tous les rappels depuis la base de données.
   * @return La liste des rappels.
   */
  public static List<Rappel> getAllRappels(){
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      try (PreparedStatement pst = cnx.prepareStatement(
            "SELECT * FROM DEV31 " +
            "ORDER BY rang ASC"); 
          ResultSet rs = pst.executeQuery()) {

        List<Rappel> results = new ArrayList<>();
        while (rs.next()) {
          Rappel rap = new Rappel(rs.getString("titre"), rs.getString("contenu"), rs.getInt("theme"), rs.getInt("rang"), rs.getInt("id"));
          results.add(rap);
        }

        return results;
      } catch (SQLException e2) {
        JOptionPane.showMessageDialog(
            null,
            "Problème lié à la BD : " + e2.getMessage(),
            "Erreur",
            JOptionPane.ERROR_MESSAGE
            );
        System.err.println("Problème lié à la BD : " + e2.getMessage());
        return new ArrayList<>();
      }
    } catch (ClassNotFoundException e3) {
      JOptionPane.showMessageDialog(
          null,
          "Classe pas trouvée : " + e3.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
          );
      System.err.println("Problème lié à la BD : " + e3.getMessage());
      return new ArrayList<>();
    }
  }

  /**
   * Insère un nouveau rappel dans la base de données.
   * @param titre titre à ajouter
   * @param contenu contenu à ajouter
   * @param theme thème à ajouter
   * @return 1 si l'insertion a réussi, 0 sinon.
   */
  public static int insert(String titre, String contenu, int theme) {
    try (PreparedStatement pst1 = cnx.prepareStatement(
          "SELECT MAX(rang) FROM DEV31");
        ResultSet rs1 = pst1.executeQuery()) {

      int nextRang = 1;
      if (rs1.next()) {
        nextRang = rs1.getInt(1) + 1;
      }

      try (PreparedStatement pst2 = cnx.prepareStatement(
            "INSERT INTO DEV31 (titre, contenu, theme, rang) " + 
            "VALUES(?, ?, ?, ?)")) {

        pst2.setString(1, titre);
        pst2.setString(2, contenu);
        pst2.setInt(3, theme);
        pst2.setInt(4, nextRang);

        pst2.executeQuery();
        return 1;

      } catch (SQLException e4) {
        JOptionPane.showMessageDialog(
            null,
            "Problème lié à la BD : " + e4.getMessage(),
            "Erreur",
            JOptionPane.ERROR_MESSAGE
            );
        System.err.println("Problème lié à la BD : " + e4.getMessage());

        return 0;
      }

    } catch (SQLException e5) {
      JOptionPane.showMessageDialog(
          null,
          "Problème lié à la BD : " + e5.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
          );
      System.err.println("Problème lié à la BD : " + e5.getMessage());

      return 0;
    }
  }

  /**
   * Échange les rangs de deux rappels dans la base de données.
   * @param ida id du premier rappel
   * @param idb id du second rappel
   * @return 1 si l'échange a réussi, 0 sinon.
   */
  public static int swap(int ida, int idb){
    try (PreparedStatement pst = cnx.prepareStatement(
          "UPDATE DEV31 AS t1 " +
          "JOIN DEV31 AS t2 " +
          "SET t1.rang = t2.rang," +
          "t2.rang = t1.rang " +
          "WHERE t1.id = ? AND t2.id = ?"
          )){

      pst.setInt(1, ida);
      pst.setInt(2, idb);
      ResultSet rs = pst.executeQuery();

      return 1;

    } catch (SQLException e6) {
      JOptionPane.showMessageDialog(
          null,
          "Problème lié à la BD : " + e6.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
          );
      System.err.println("Problème lié à la BD : " + e6.getMessage());

      return 0;
    }
  }

  /**
   * Supprime un rappel de la base de données.
   * @param id id du rappel à supprimer
   * @return 1 si la suppression a réussi, 0 sinon.
   */
  public static int delete(int id){
    try (PreparedStatement pst = cnx.prepareStatement(
          "DELETE FROM DEV31 " +
          "WHERE id = ?"
          )){

      pst.setInt(1, id);
      ResultSet rs = pst.executeQuery();

      return 1;
    } catch (SQLException e7) {
      JOptionPane.showMessageDialog(
          null,
          "Problème lié à la BD : " + e7.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
          );
      System.err.println("Problème lié à la BD : " + e7.getMessage());

      return 0;
    }
  }

  /**
   * Met à jour un rappel dans la base de données.
   * @param id id du rappel à modifier
   * @param titre titre à modifier
   * @param contenu contenu à modifier
   * @param theme thème à modifier
   * @return 1 si la mise à jour a réussi, 0 sinon.
   */
  public static int update(int id, String titre, String contenu, int theme){
    try (PreparedStatement pst = cnx.prepareStatement(
          "UPDATE DEV31 " +
          "SET titre = ?, contenu = ?, theme = ? " +
          "WHERE id = ?"
          )){

      pst.setString(1, titre);
      pst.setString(2, contenu);
      pst.setInt(3, theme);
      pst.setInt(4, id);
      ResultSet rs = pst.executeQuery();

      return 1;
    } catch (SQLException e8) {
      JOptionPane.showMessageDialog(
          null,
          "Problème lié à la BD : " + e8.getMessage(),
          "Erreur",
          JOptionPane.ERROR_MESSAGE
          );
      System.err.println("Problème lié à la BD : " + e8.getMessage());
      return 0;
    }
  }
}
