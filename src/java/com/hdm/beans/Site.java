/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.beans;

import java.util.List;

/**
 *
 * @author MED
 */
public class Site {
    private int id;
    private String nom;

    public Site(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Site(int id) {
        this.id = id;
    }

    public Site(String nom) {
        this.nom = nom;
    }

    



    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
