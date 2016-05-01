/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.services.impl;

import com.core.engines.Engine1;
import com.core.engines.Engine2;
import com.core.engines.Engine3;
import com.core.services.ServiceBank;
import com.core.util.UtilGeneral;
import javax.jws.WebService;

@WebService(
        endpointInterface = "com.core.services.ServiceBank",
        serviceName = "ServiceBank"
)
public class ServiceBankImpl implements ServiceBank {

    @Override
    public String bankTransaction(Integer noSimulasi, String nama, String noKartuKredit, String idValidasi) {
        String result = "FAILED";
        UtilGeneral ug = new UtilGeneral();

        if (noSimulasi.equals(1)) {
            Engine1 e1 = new Engine1();
            // cek kartu kredit
            String isKartuKreditValid = ug.checkKartuKredit(nama, noKartuKredit);
            // selesai cek kartu kredit

            if (isKartuKreditValid.equals("1")) {
                result = e1.process(noKartuKredit, idValidasi, "SUCCESS");
            } else {
                result = e1.process(noKartuKredit, idValidasi, "FAILED_KARTU_KREDIT");
            }
        } else if (noSimulasi.equals(2)) {
            Engine2 e2 = new Engine2();
            // cek kartu kredit
            String isKartuKreditValid = ug.checkKartuKredit(nama, noKartuKredit);
            // selesai cek kartu kredit

            if (isKartuKreditValid.equals("1")) {
//                result = e1.process(noKartuKredit, idValidasi, "SUCCESS");
                result = e2.process(noKartuKredit, idValidasi, "SUCCESS");
            } else {
                result = e2.process(noKartuKredit, idValidasi, "FAILED_KARTU_KREDIT");
            }
        } else if (noSimulasi.equals(3)) {
            Engine3 e3 = new Engine3();
            // cek kartu kredit
            String isKartuKreditValid = ug.checkKartuKredit(nama, noKartuKredit);
            // selesai cek kartu kredit

            if (isKartuKreditValid.equals("1")) {
                result = e3.process(noKartuKredit, idValidasi, "SUCCESS");
            } else {
                result = e3.process(noKartuKredit, idValidasi, "FAILED_KARTU_KREDIT");
            }
        }
        return result;
    }

    public static void main(String args[]) {
        ServiceBankImpl sbi = new ServiceBankImpl();
//        sbi.bankTransaction(1, "NAMA_1", "123456789_1", "UNIT_TESTING_1");
//        sbi.bankTransaction(2, "NAMA_1", "123456789", "UNIT_TESTING_2");
        sbi.bankTransaction(3, "NAMA_1", "123456789_1", "UNIT_TESTING_3");
    }
}
