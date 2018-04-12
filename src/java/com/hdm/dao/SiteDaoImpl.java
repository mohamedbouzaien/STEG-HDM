/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Departement;
import com.hdm.beans.Site;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MED
 */
public class SiteDaoImpl implements SiteDao {

    private DaoFactory daoFactory;

    public SiteDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Site> lister() {
        List<Site> sites = new ArrayList<Site>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, nom FROM site;");

            while (resultat.next()) {
                int id = resultat.getInt("id");
                String nom = resultat.getString("nom");

                Site site = new Site(id, nom);

                sites.add(site);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sites;
    }

    @Override
    public boolean ajouter(Site site) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO site(nom) VALUES (?);");
            preparedStatement.setString(1, site.getNom());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void modifier(Site site) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE site SET nom= ? WHERE id=?;");
            preparedStatement.setString(1, site.getNom());
            preparedStatement.setInt(2, site.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void supprimer(Site site) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("Delete from departement WHERE id ="+site.getId()+";");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

}
