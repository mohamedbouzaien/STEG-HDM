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
public class Utilisateur {
    
    private String matricule;
    private String motdepasse;
    private String nom;
    private String prenom;
    private String adresse_physique;
    private String departement;
    private String adresse_logique;
    private String role;
    private String groupe;
    private String photo;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse_physique() {
        return adresse_physique;
    }

    public void setAdresse_physique(String adresse_physique) {
        this.adresse_physique = adresse_physique;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getAdresse_logique() {
        return adresse_logique;
    }

    public void setAdresse_logique(String adresse_logique) {
        this.adresse_logique = adresse_logique;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    

    public Utilisateur(String matricule, String motdepasse, String nom, String prenom, String adresse_physique, String departement, String role, String photo) {
        this.matricule = matricule;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_physique = adresse_physique;
        this.departement = departement;
        this.role = role;
        this.photo = photo;
    }

    public Utilisateur(String matricule, String prenom, String nom) {
        this.matricule = matricule;
        this.prenom = prenom;
        this.nom = nom;
    }
    

    

    @Override
    public String toString() {
        return "Utilisateur{" + "matricule=" + matricule + ", motdepasse=" + motdepasse + ", nom=" + nom + ", prenom=" + prenom + ", adresse_physique=" + adresse_physique + ", departement=" + departement + ", adresse_logique=" + adresse_logique + ", role=" + role + ", groupe=" + groupe + ", photo=" + photo + '}';
    }
    
    
    
    
    
    
    
    
}
