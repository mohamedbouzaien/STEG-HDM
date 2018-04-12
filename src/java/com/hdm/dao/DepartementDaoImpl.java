/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Departement;
import com.hdm.beans.Site;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MED
 */
public class DepartementDaoImpl implements DepartementDao{
    private DaoFactory daoFactory;

    public DepartementDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public List<Departement> lister(int idSite) {
                List<Departement> depts = new ArrayList<Departement>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, nom FROM departement WHERE idsite="+idSite+";");
            
            while (resultat.next()) {
                int id = resultat.getInt("id");
                String nom = resultat.getString("nom");
                
                Departement departement = new Departement(id,nom);
                

                depts.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
        
    }

    @Override
    public boolean ajouter(Departement departement) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO departement(nom, idsite) VALUES (?,?);");
            preparedStatement.setString(1, departement.getNom());
            preparedStatement.setInt(2, departement.getSite().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }
    return true;
    }

    @Override
    public List<Departement> lister() {
                        List<Departement> depts = new ArrayList<Departement>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT departement.id, departement.nom, site.id, site.nom FROM departement, site WHERE site.id=idsite;");
            
            while (resultat.next()) {
                int id = resultat.getInt("departement.id");
                String nom = resultat.getString("departement.nom");
                int idSite = resultat.getInt("site.id");
                String nomSite = resultat.getString("site.nom");
                
                Departement departement = new Departement(id,nom,new Site(idSite,nomSite));
                

                depts.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    }

    @Override
    public void modifier(Departement departement) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE departement SET nom= ?,idsite= ? WHERE id=?;");
            preparedStatement.setString(1, departement.getNom());
            preparedStatement.setInt(2, departement.getSite().getId());
            preparedStatement.setInt(3, departement.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void supprimer(Departement departement) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("Delete from departement WHERE id ="+departement.getId()+";");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
}
