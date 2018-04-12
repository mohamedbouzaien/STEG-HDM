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
public class Departement {
    private int id;
    private String nom;
    private Site site;

    public Departement(int id) {
        this.id = id;
    }
    public Departement(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Departement(String nom, Site site) {
        this.nom = nom;
        this.site = site;
    }
    

    public Departement(int id, String nom, Site site) {
        this.id = id;
        this.nom = nom;
        this.site = site;
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Site getSite() {
        return site;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
    
    
}
