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
public class Composant {
    private int id;
    private String matriculeInventaire;
    private String type;
    private String nom;
    private String description;
    private String photo;

    public Composant(String matriculeInventaire, String nom) {
        this.matriculeInventaire = matriculeInventaire;
        this.nom = nom;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatriculeInventaire() {
        return matriculeInventaire;
    }

    public void setMatriculeInventaire(String matriculeInventaire) {
        this.matriculeInventaire = matriculeInventaire;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
