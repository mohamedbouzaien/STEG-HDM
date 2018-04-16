/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Agent;

/**
 *
 * @author MED
 */
public interface AgentDao {
    public boolean rechercherParMatricule(String matricule);
    public void ajouter(Agent agent);
    
}
