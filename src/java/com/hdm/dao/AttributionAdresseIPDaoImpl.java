/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.AttributionAdresseIP;
import com.hdm.beans.Reseau;
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
public class AttributionAdresseIPDaoImpl implements AttributionAdresseIPDao{

    private DaoFactory daoFactory;

    public AttributionAdresseIPDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    @Override
    public boolean ajouter(AttributionAdresseIP attributionAdresseIP) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO attribution_adresse_ip(adresse_ip_debut, adresse_ip_fin, type, idreseau) VALUES (?,?,?,?);");
            preparedStatement.setString(1, attributionAdresseIP.getAdresseIPDebut());
            preparedStatement.setString(2, attributionAdresseIP.getAdresseIPFin());
            preparedStatement.setString(3, attributionAdresseIP.getType());
            preparedStatement.setInt(4, attributionAdresseIP.getReseau().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally{
        if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException logOrIgnore) {}
        if (connexion != null) try { connexion.close(); } catch (SQLException logOrIgnore) {}
    }
        return true;
    }

    @Override
    public List<AttributionAdresseIP> listerParReseau(Reseau reseau) {
        List<AttributionAdresseIP> attributionAdresseIPs = new ArrayList<AttributionAdresseIP>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, adresse_ip_debut, adresse_ip_fin, type FROM attribution_adresse_ip WHERE idreseau="+reseau.getId());
            while (resultat.next()) {
                int id = resultat.getInt("id");
                String adresse_ip_debut = resultat.getString("adresse_ip_debut");
                String adresse_ip_fin = resultat.getString("adresse_ip_fin");
                String type = resultat.getString("type");
                

                AttributionAdresseIP attributionAdresseIP = new AttributionAdresseIP(id, adresse_ip_debut, adresse_ip_fin, type, reseau);
                attributionAdresseIPs.add(attributionAdresseIP);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attributionAdresseIPs;
    }
    
    
}
