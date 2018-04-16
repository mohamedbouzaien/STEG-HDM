/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author MED
 */
public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/hdm", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }
    public SiteDao getSiteDao() {
        return new SiteDaoImpl(this);
    }
    public DepartementDao getDepartementDao() {
        return new DepartementDaoImpl(this);
        
    }
    public ReseauDao getReseauDao() {
        return new ReseauDaoImpl(this);
    }
    public TicketDao getTicketDao() {
        return new TicketDaoImpl(this);
    }
    public AdresseIPDao getAdresseIPDao(){
        return new AdresseIPDaoImpl(this);
    }
    public AttributionAdresseIPDao getAttributionAdresseIPDao(){
        return new AttributionAdresseIPDaoImpl(this);
    }
    public AgentDao getaAgentDao(){
        return new AgentDaoImpl(this);
    }
}
