/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Utilisateur;
import java.util.List;

/**
 *
 * @author MED
 */
public interface UtilisateurDao {
    boolean ajouter( Utilisateur utilisateur );
    List<Utilisateur> lister();
    Utilisateur seConnecter(String matricule,String motDePasse);
    
}
