/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Departement;
import com.hdm.technical.IpEnParties;
import com.hdm.beans.Reseau;
import com.hdm.beans.Site;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MED
 */
public class ReseauDaoImpl implements ReseauDao {

    private DaoFactory daoFactory;

    public ReseauDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean ajouter(Reseau reseau) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO reseau(adresse, masque, description, commentaire, iddepartement) VALUES (?,?,?,?,?);");
            preparedStatement.setString(1, reseau.getAdresse());
            preparedStatement.setString(2, reseau.getMasque());
            preparedStatement.setString(3, reseau.getDescription());
            preparedStatement.setString(4, reseau.getCommentaire());
            preparedStatement.setInt(5, reseau.getDepartement().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }
        return true;

    }

    @Override
    public List<Reseau> lister() {
        List<Reseau> reseaux = new ArrayList<Reseau>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT reseau.id, adresse, masque, description, commentaire, departement.id, departement.nom, site.id, site.nom FROM reseau, departement, site WHERE iddepartement=departement.id AND departement.idsite=site.id;");

            while (resultat.next()) {
                int id = resultat.getInt("reseau.id");
                String adresse = resultat.getString("adresse");
                String masque = resultat.getString("masque");
                String description = resultat.getString("description");
                String commentaire = resultat.getString("commentaire");
                Departement departement = new Departement(resultat.getInt("departement.id"), resultat.getString("departement.nom"), new Site(resultat.getInt("site.id"), resultat.getString("site.nom")));

                Reseau reseau = new Reseau(id, adresse, masque, description, commentaire, departement);
                reseaux.add(reseau);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reseaux;

    }

    @Override
    public void supprimer(Reseau reseau) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("Delete from reseau WHERE id =" + reseau.getId() + ";");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void modifier(Reseau reseau) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE reseau SET adresse= ?,masque= ?,description= ?,commentaire= ?,iddepartement= ? WHERE id=?;");
            preparedStatement.setString(1, reseau.getAdresse());
            preparedStatement.setString(2, reseau.getMasque());
            preparedStatement.setString(3, reseau.getDescription());
            preparedStatement.setString(4, reseau.getCommentaire());
            preparedStatement.setInt(5, reseau.getDepartement().getId());
            preparedStatement.setInt(6, reseau.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    @Override
    public Reseau RechercherUnParId(int id) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT reseau.id, adresse, masque, description, commentaire, departement.id, departement.nom, site.id, site.nom FROM reseau, departement, site WHERE iddepartement=departement.id AND departement.idsite=site.id AND reseau.id="+id+";");

                resultat.first();
                int idr = resultat.getInt("reseau.id");
                String adresse = resultat.getString("adresse");
                String masque = resultat.getString("masque");
                String description = resultat.getString("description");
                String commentaire = resultat.getString("commentaire");
                Departement departement = new Departement(resultat.getInt("departement.id"), resultat.getString("departement.nom"), new Site(resultat.getInt("site.id"), resultat.getString("site.nom")));
                Reseau reseau = new Reseau(idr, adresse, masque, description, commentaire, departement);
                return reseau;
            } catch (SQLException ex) {
            Logger.getLogger(ReseauDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
