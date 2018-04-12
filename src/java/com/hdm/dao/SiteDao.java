/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;


import com.hdm.beans.Site;
import java.util.List;

/**
 *
 * @author MED
 */
public interface SiteDao {
    List<Site> lister();
    boolean ajouter(Site site);
    void modifier(Site site);
    void supprimer(Site site);
    
}
