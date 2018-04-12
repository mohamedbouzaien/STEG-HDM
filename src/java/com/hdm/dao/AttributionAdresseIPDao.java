/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.AttributionAdresseIP;
import com.hdm.beans.Reseau;
import java.util.List;

/**
 *
 * @author MED
 */
public interface AttributionAdresseIPDao {
    boolean ajouter(AttributionAdresseIP attributionAdresseIP);
    List<AttributionAdresseIP> listerParReseau(Reseau reseau);
    
}
