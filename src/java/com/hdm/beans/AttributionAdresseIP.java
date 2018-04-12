/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.beans;

/**
 *
 * @author MED
 */
public class AttributionAdresseIP {
    private int id;
    private String AdresseIPDebut;
    private String AdresseIPFin;
    private String Type;
    private Reseau reseau;

    public AttributionAdresseIP(int id, String AdresseIPDebut, String AdresseIPFin, String Type, Reseau reseau) {
        this.id = id;
        this.AdresseIPDebut = AdresseIPDebut;
        this.AdresseIPFin = AdresseIPFin;
        this.Type = Type;
        this.reseau = reseau;
    }

    
    public AttributionAdresseIP(String AdresseIPDebut, String AdresseIPFin, String Type, Reseau reseau) {
        this.AdresseIPDebut = AdresseIPDebut;
        this.AdresseIPFin = AdresseIPFin;
        this.Type = Type;
        this.reseau = reseau;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresseIPDebut() {
        return AdresseIPDebut;
    }

    public void setAdresseIPDebut(String AdresseIPDebut) {
        this.AdresseIPDebut = AdresseIPDebut;
    }

    public String getAdresseIPFin() {
        return AdresseIPFin;
    }

    public void setAdresseIPFin(String AdresseIPFin) {
        this.AdresseIPFin = AdresseIPFin;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Reseau getReseau() {
        return reseau;
    }

    public void setReseau(Reseau reseau) {
        this.reseau = reseau;
    }
    
    
}
