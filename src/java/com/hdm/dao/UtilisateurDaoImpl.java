/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Utilisateur;
import com.hdm.technical.BCrypt;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MED
 */
public class UtilisateurDaoImpl implements UtilisateurDao{
    private DaoFactory daoFactory;

    public UtilisateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    

    @Override
    public boolean ajouter(Utilisateur utilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(matricule, motdepasse, nom, prenom, adresse_physique, departement, role, photo) VALUES (?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, utilisateur.getMatricule());
            preparedStatement.setString(2, utilisateur.getMotdepasse());
            preparedStatement.setString(3, utilisateur.getNom());
            preparedStatement.setString(4, utilisateur.getPrenom());
            preparedStatement.setString(5, utilisateur.getAdresse_physique());
            preparedStatement.setString(6, utilisateur.getDepartement());
            preparedStatement.setString(7, utilisateur.getRole());
            preparedStatement.setString(8, utilisateur.getPhoto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }
    return true;
            
    }

    @Override
    public List<Utilisateur> lister() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur seConnecter(String matricule, String motDePasse) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT matricule, motdepasse, nom, prenom, adresse_physique, departement, role, photo FROM utilisateur WHERE matricule='"+matricule+"';");
            if (resultat.first())
            {
                if (BCrypt.checkpw(motDePasse, resultat.getString("motdepasse")))
                {
                    //BCrypt.hashpw(resultat.getString("motdepasse"), BCrypt.gensalt())
                    Utilisateur utilisateur = new Utilisateur(resultat.getString("matricule"),
                            resultat.getString("motdepasse"), 
                            resultat.getString("nom"), 
                            resultat.getString("prenom"), 
                            resultat.getString("adresse_physique"),
                            resultat.getString("departement") , 
                            resultat.getString("role"), 
                            resultat.getString("photo"));
                    return utilisateur;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
