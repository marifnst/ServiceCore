/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.util;

/**
 *
 * @author Emerio
 */
public class UtilGeneral {
    public String checkKartuKredit(String nama, String noKartuKredit) {
        String query = "SELECT COUNT(1) IS_AVAILABLE FROM TBL_USER WHERE NAMA = '" + nama + "' AND NO_KARTU_KREDIT = '" + noKartuKredit + "'";
        UtilDatabase ud = new UtilDatabase();
        ud.openConnectionNative();
        String result = ud.executeQuery(query);
        ud.closeConnection();
        return result;
    }
    
    public static void main(String args[]) {
        UtilGeneral ug = new UtilGeneral();
        System.out.println(ug.checkKartuKredit("NAMA_1", "123456789_1"));
        System.out.println(ug.checkKartuKredit("NAMA_1", "123456789"));
    }
}
