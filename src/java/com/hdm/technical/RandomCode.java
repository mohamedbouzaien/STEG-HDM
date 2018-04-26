/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.technical;

import java.util.Random;

/**
 *
 * @author MED
 */
public class RandomCode {

    public static String calculCode() {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 8; i++) {
            sb.append(chars[rnd.nextInt(chars.length)]);
        }

        return sb.toString();
    }

}
