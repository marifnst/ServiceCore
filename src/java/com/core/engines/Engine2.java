/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.engines;

import com.core.entities.TblTransaksiBank;
import com.core.entities.TblTransaksiKurir;
import com.core.util.UtilDatabase;
import java.util.Date;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Emerio
 */
public class Engine2 {

    private UtilDatabase localUtilDatabase;

    public String process(String noKartuKredit, String idValidasi, String statusTransaksi) {
        localUtilDatabase = new UtilDatabase();
        return insertTransaksiBank(noKartuKredit, idValidasi, statusTransaksi);
    }

    public String insertTransaksiBank(String noKartuKredit, String idValidasi, String statusTransaksi) {
        String idTransaksi = UUID.randomUUID().toString();

        TblTransaksiBank tblTransaksiBank = new TblTransaksiBank();

        tblTransaksiBank.setIdValidasi(idValidasi);
        tblTransaksiBank.setIdTransaksi(idTransaksi);
        tblTransaksiBank.setNoKartuKredit(noKartuKredit);
        tblTransaksiBank.setStatusTransaksi(statusTransaksi);
        tblTransaksiBank.setCreatedDate(new Date());

        localUtilDatabase.openConnection();
        EntityManager em = localUtilDatabase.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(tblTransaksiBank);
        et.commit();
        localUtilDatabase.getEntityManager().close();

        return idTransaksi;
    }

}
