/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.beans;

import java.util.Objects;

/**
 *
 * @author MED
 */
public class AdresseIP {

    private int id;
    private String adresse;
    private Reseau reseau;
    private String typehote;
    private String categorie;
    private String desription;
    private Utilisateur utilisateur;
    private Composant composant;

    public AdresseIP(int id, String adresse, String typehote, String categorie, String desription, Utilisateur utilisateur) {
        this.id = id;
        this.adresse = adresse;
        this.typehote = typehote;
        this.categorie = categorie;
        this.desription = desription;
        this.utilisateur = utilisateur;
    }

    public AdresseIP(int id, String adresse, String typehote, String categorie, String desription, Composant composant) {
        this.id = id;
        this.adresse = adresse;
        this.typehote = typehote;
        this.categorie = categorie;
        this.desription = desription;
        this.composant = composant;
    }
    

    public AdresseIP(int id, String adresse, String hote, String categorie, String desription) {
        this.id = id;
        this.adresse = adresse;
        this.typehote = hote;
        this.categorie = categorie;
        this.desription = desription;
    }
    public AdresseIP(String adresse, Reseau reseau, String hote, String categorie, String desription) {
        this.adresse = adresse;
        this.reseau = reseau;
        this.typehote = hote;
        this.categorie = categorie;
        this.desription = desription;
    }

    public AdresseIP(String adresse, Reseau reseau) {
        this.adresse = adresse;
        reseau.setId(1);
        this.reseau = reseau;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Reseau getReseau() {
        return reseau;
    }

    public void setReseau(Reseau reseau) {
        this.reseau = reseau;
    }

    public String getTypehote() {
        return typehote;
    }

    public void setTypehote(String typehote) {
        this.typehote = typehote;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public Composant getComposant() {
        return composant;
    }

    public void setComposant(Composant composant) {
        this.composant = composant;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdresseIP other = (AdresseIP) obj;
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        return true;
    }
    

    

}
