/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.technical;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MED
 */
public class IpEnParties {
    public int part1;
    public int part2;
    public int part3;
    public int part4;

    public IpEnParties(int part1, int part2, int part3, int part4) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }
    public static IpEnParties adresseToInts(String adresse) {
        IpEnParties ipEnParties = new IpEnParties(0,0, 0, 0);
        int end1 = adresse.indexOf(".");
        ipEnParties.part1 = Integer.parseInt(adresse.substring(0, end1));
        int end2 =adresse.substring(end1+1,adresse.length()).indexOf(".")+end1+1;

        ipEnParties.part2 = Integer.parseInt(adresse.substring(end1+1, end2));
        int end3 =adresse.substring(end2+1, adresse.length()).indexOf(".")+end2+1;
        ipEnParties.part3 = Integer.parseInt(adresse.substring(end2+1, end3));
        ipEnParties.part4 = Integer.parseInt(adresse.substring(end3+1,adresse.length()));
        return ipEnParties;
    }

    @Override
    public String toString() {
        return part1 + "." + part2 + "." + part3 + "." + part4;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final IpEnParties other = (IpEnParties) obj;
        if (this.part1 != other.part1) {
            return false;
        }
        if (this.part2 != other.part2) {
            return false;
        }
        if (this.part3 != other.part3) {
            return false;
        }
        if (this.part4 != other.part4) {
            return false;
        }
        return true;
    }
    public static List<String> listerEnParties(String ipDebut, String ipFin)
    {
        List<String> ipEnPartiess = new ArrayList<String>();
        IpEnParties ipEnPartiesDebut = IpEnParties.adresseToInts(ipDebut);
        IpEnParties ipEnPartiesFin = IpEnParties.adresseToInts(ipFin);
        ipEnPartiess.add(ipEnPartiesDebut.toString());
        while(!(ipEnPartiesDebut.equals(ipEnPartiesFin))) {

            if (ipEnPartiesDebut.part4 < 255) {
                ipEnPartiesDebut.part4 += 1;
                ipEnPartiess.add(ipEnPartiesDebut.toString());
            } else {
                if (ipEnPartiesDebut.part3 < 255) {
                    ipEnPartiesDebut.part3 += 1;
                    ipEnPartiesDebut.part4 = 0;
                    ipEnPartiess.add(ipEnPartiesDebut.toString());
                } else {
                    if (ipEnPartiesDebut.part2 < 255) {
                        ipEnPartiesDebut.part2 += 1;
                        ipEnPartiesDebut.part3 = 0;
                        ipEnPartiesDebut.part4 = 0;
                        ipEnPartiess.add(ipEnPartiesDebut.toString());
                    } else if (ipEnPartiesDebut.part1 < 255) {
                        ipEnPartiesDebut.part1 += 1;
                        ipEnPartiesDebut.part2 = 0;
                        ipEnPartiesDebut.part3 = 0;
                        ipEnPartiesDebut.part4 = 0;
                        ipEnPartiess.add(ipEnPartiesDebut.toString());
                    }
                }
            }
        }
        return ipEnPartiess;
    }
}
