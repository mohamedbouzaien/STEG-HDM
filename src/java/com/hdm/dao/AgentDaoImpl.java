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
    public Agent rechercherParMatricule(String matricule) {
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("SELECT id, matricule, nom, prenom, adresse FROM agent WHERE matricule = ?");
            statement.setInt(1, Integer.parseInt(matricule));
            resultat = statement.executeQuery();
            if (resultat.first())
            {
               Agent agent = new Agent(resultat.getInt("id"), 
                       resultat.getString("matricule"),
                       resultat.getString("nom"),
                       resultat.getString("prenom"),
                       resultat.getString("adresse"));
               return agent;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Agent ajouter(Agent agent) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO agent(matricule, code_unique, nom, prenom, adresse) VALUES (?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, agent.getMatricule());
            preparedStatement.setString(2, agent.getCode());
            preparedStatement.setString(3, agent.getNom());
            preparedStatement.setString(4, agent.getPrenom());
            preparedStatement.setString(5, agent.getAdresse());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                agent.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return agent;

        }
    return agent;
    }

}
