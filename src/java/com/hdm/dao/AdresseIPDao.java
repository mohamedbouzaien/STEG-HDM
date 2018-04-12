/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.AdresseIP;
import com.hdm.beans.AttributionAdresseIP;
import com.hdm.beans.Reseau;
import java.util.List;

/**
 *
 * @author MED
 */
public interface AdresseIPDao {
    void ajouter(AdresseIP adresseIP);
    List<AdresseIP> afficherTout(Reseau reseau);
    List<AdresseIP> listerBD(Reseau reseau);
    List<AdresseIP> listerFusionLocalBd(Reseau reseau, List<AttributionAdresseIP> attributionAdresseIPs);
    
}
