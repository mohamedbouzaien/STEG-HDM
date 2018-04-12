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
public class Reseau {
    private int id;
    private String adresse;
    private String masque;
    private String description;
    private String commentaire;
    private Departement departement;

    public Reseau(int id) {
        this.id = id;
    }

    public Reseau(int id, String adresse, String masque, String description, String commentaire, Departement departement) {
        this.id = id;
        this.adresse = adresse;
        this.masque = masque;
        this.description = description;
        this.commentaire = commentaire;
        this.departement = departement;
    }

    public Reseau(String adresse, String masque, String description, String commentaire, Departement departement) {
        this.adresse = adresse;
        this.masque = masque;
        this.description = description;
        this.commentaire = commentaire;
        this.departement = departement;
    }

    public int getId() {
        return id;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMasque() {
        return masque;
    }

    public String getDescription() {
        return description;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMasque(String masque) {
        this.masque = masque;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "Reseau{" + "id=" + id + ", adresse=" + adresse + ", masque=" + masque + ", description=" + description + ", commentaire=" + commentaire + '}';
    }
}
