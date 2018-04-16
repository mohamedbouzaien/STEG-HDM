/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Agent;
import com.hdm.beans.Utilisateur;
import com.hdm.technical.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MED
 */
public class AgentDaoImpl implements AgentDao {

    private DaoFactory daoFactory;

    public AgentDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean rechercherParMatricule(String matricule) {
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("SELECT * FROM agent WHERE matricule = ?");
            statement.setInt(1, Integer.parseInt(matricule));
            resultat = statement.executeQuery();
            if (resultat.first())
            {
               return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void ajouter(Agent agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
