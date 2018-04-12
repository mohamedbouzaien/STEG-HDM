/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.Departement;
import java.util.List;

/**
 *
 * @author MED
 */
public interface DepartementDao {
    List<Departement> lister(int idSite);
    List<Departement> lister();
    boolean ajouter(Departement departement);
    void modifier(Departement departement);
    void supprimer(Departement departement);
}
