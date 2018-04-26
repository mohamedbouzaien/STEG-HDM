/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Ticket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.temporal.ChronoField;

/**
 *
 * @author MED
 */
public class TicketDaoImpl implements TicketDao{
    private DaoFactory daoFactory;

    public TicketDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean ajouter(Ticket ticket) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO ticket(type,statut, urgence, "
                    + "peripherique, titre, description, token, date_ajout, id_agent) VALUES (?,?,?,?,?,?,?,?,?);");
            preparedStatement.setInt(1, ticket.getType());
            preparedStatement.setInt(2, ticket.getStatut());
            preparedStatement.setInt(3, ticket.getUrgence());
            preparedStatement.setString(4, ticket.getPeripherique());
            preparedStatement.setString(5, ticket.getTitre());
            preparedStatement.setString(6, ticket.getDescription());
            preparedStatement.setString(7, ticket.getToken());
            preparedStatement.setDate(8, Date.valueOf(ticket.getDateAjout()));
            preparedStatement.setInt(9, ticket.getAgent().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }
    return true;
    }
    
}
