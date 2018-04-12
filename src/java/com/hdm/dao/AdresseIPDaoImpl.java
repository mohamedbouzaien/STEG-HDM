/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.dao;

import com.hdm.beans.AdresseIP;
import com.hdm.beans.AttributionAdresseIP;
import com.hdm.beans.Composant;
import com.hdm.technical.IpEnParties;
import com.hdm.beans.Reseau;
import com.hdm.beans.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MED
 */
public class AdresseIPDaoImpl implements AdresseIPDao {

    private DaoFactory daoFactory;

    public AdresseIPDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(AdresseIP adresseIP) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO adresse_ip( adresse, id_reseau, type_hote, categorie, description) VALUES (?,?,?,?,?);");
            preparedStatement.setString(1, adresseIP.getAdresse());
            preparedStatement.setInt(2, adresseIP.getReseau().getId());
            preparedStatement.setString(3, adresseIP.getTypehote());
            preparedStatement.setString(4, adresseIP.getCategorie());
            preparedStatement.setString(5, adresseIP.getDesription());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }
    }

    @Override
    public List<AdresseIP> afficherTout(Reseau reseau) {
        List<AdresseIP> adressesIP = new ArrayList<AdresseIP>();
        int nombreHotesMax = (int) (Math.pow(2, 32 - Integer.parseInt(reseau.getMasque()))) - 2;
        IpEnParties ipEnParties = IpEnParties.adresseToInts(reseau.getAdresse());
        for (int i = 0; i < nombreHotesMax; i++) {

            if (ipEnParties.part4 < 255) {
                ipEnParties.part4 += 1;
                AdresseIP adresseIP = new AdresseIP(ipEnParties.toString(), reseau);
                adressesIP.add(adresseIP);
            } else {
                if (ipEnParties.part3 < 255) {
                    ipEnParties.part3 += 1;
                    ipEnParties.part4 = 0;
                    AdresseIP adresseIP = new AdresseIP(ipEnParties.toString(), reseau);
                    adressesIP.add(adresseIP);
                } else {
                    if (ipEnParties.part2 < 255) {
                        ipEnParties.part2 += 1;
                        ipEnParties.part3 = 0;
                        ipEnParties.part4 = 0;
                        AdresseIP adresseIP = new AdresseIP(ipEnParties.toString(), reseau);
                        adressesIP.add(adresseIP);
                    } else if (ipEnParties.part1 < 255) {
                        ipEnParties.part1 += 1;
                        ipEnParties.part2 = 0;
                        ipEnParties.part3 = 0;
                        ipEnParties.part4 = 0;
                        AdresseIP adresseIP = new AdresseIP(ipEnParties.toString(), reseau);
                        adressesIP.add(adresseIP);
                    }
                }
            }
        }
        return adressesIP;
    }

    @Override
    public List<AdresseIP> listerBD(Reseau reseau) {
        List<AdresseIP> adresseIPs = new ArrayList<AdresseIP>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT adresse_ip.id, adresse, type_hote, categorie, adresse_ip.description,"
                    + " utilisateur.matricule, utilisateur.nom, utilisateur.prenom, "
                    + "composant.matricule_inventaire, composant.nom "
                    + "FROM adresse_ip "
                    + "LEFT JOIN utilisateur ON utilisateur.matricule = id_utilisateur "
                    + "LEFT JOIN composant ON composant.id = id_composant "
                    + "WHERE id_reseau=" + reseau.getId());

            while (resultat.next()) {
                int id = resultat.getInt("id");
                String adresse = resultat.getString("adresse");
                String hote = resultat.getString("type_hote");
                String categorie = resultat.getString("categorie");
                String description = resultat.getString("description");
                if (resultat.getString("utilisateur.matricule")!=null &&!(resultat.getString("utilisateur.matricule").isEmpty())) {
                    Utilisateur utilisateur = new Utilisateur(resultat.getString("utilisateur.matricule"),
                            resultat.getString("utilisateur.nom"), resultat.getString("utilisateur.prenom"));
                    AdresseIP adresseIP = new AdresseIP(id, adresse, hote, categorie, description, utilisateur);
                    adresseIPs.add(adresseIP);
                }
                else if (!resultat.getString("composant.matricule_inventaire").equals(""))
                {
                    Composant composant = new Composant(resultat.getString("composant.matricule_inventaire"),
                    resultat.getString("composant.nom"));
                    AdresseIP adresseIP = new AdresseIP(id, adresse, hote, categorie, description, composant);
                    adresseIPs.add(adresseIP);
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adresseIPs;
    }

    @Override
    public List<AdresseIP> listerFusionLocalBd(Reseau reseau, List<AttributionAdresseIP> attributionAdresseIPs) {
        List<AdresseIP> adressesBD = listerBD(reseau);
        List<AdresseIP> adressesLocal = afficherTout(reseau);
        for (AdresseIP adresseBD : adressesBD) {
            if (adressesLocal.contains(adresseBD)) {
                adressesLocal.set(adressesLocal.indexOf(adresseBD), adresseBD);
            }
        }
        for (AttributionAdresseIP attributionAdresseIP : attributionAdresseIPs) {

            List<String> ipEnPartiess = IpEnParties.listerEnParties(attributionAdresseIP.getAdresseIPDebut(), attributionAdresseIP.getAdresseIPFin());
            for (String ipEnParties : ipEnPartiess) {
                AdresseIP adresseIP = new AdresseIP(ipEnParties, reseau);
                if (adressesLocal.contains(adresseIP)) {
                    AdresseIP adresseIPtemp = adressesLocal.get(adressesLocal.indexOf(adresseIP));
                    adresseIPtemp.setCategorie(attributionAdresseIP.getType());
                    adressesLocal.set(adressesLocal.indexOf(adresseIP), adresseIPtemp);
                }
            }
        }
        return adressesLocal;
    }

}
