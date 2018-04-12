/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.beans;

import java.time.LocalDate;

/**
 *
 * @author MED
 */
public class Ticket {
    private int id;
    private int type;
    private int statut;
    private int urgence;
    private String peripherique;
    private String titre;
    private String description;
    private String fichier;
    private String token;
    private LocalDate dateAjout;
    private LocalDate dateTraitement;

    public Ticket(int type, int statut, int urgence, String peripherique, String titre, String description, String token, LocalDate dateAjout) {
        this.type = type;
        this.statut = statut;
        this.urgence = urgence;
        this.peripherique = peripherique;
        this.titre = titre;
        this.description = description;
        this.token = token;
        this.dateAjout = dateAjout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getUrgence() {
        return urgence;
    }

    public void setUrgence(int urgence) {
        this.urgence = urgence;
    }

    public String getPeripherique() {
        return peripherique;
    }

    public void setPeripherique(String peripherique) {
        this.peripherique = peripherique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public LocalDate getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(LocalDate dateTraitement) {
        this.dateTraitement = dateTraitement;
    }
    
}
