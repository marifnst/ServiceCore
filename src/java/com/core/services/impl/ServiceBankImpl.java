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
import javax.jws.WebService;

@WebService(
        endpointInterface = "com.core.services.ServiceBank",
        serviceName = "ServiceBank"
)
public class ServiceBankImpl implements ServiceBank {

    @Override
    public String bankTransaction(Integer noSimulasi, String noKartuKredit, String idValidasi) {
        String result = "FAILED";
        if (noSimulasi.equals(1)) {
            Engine1 e1 = new Engine1();
            result = e1.process(noKartuKredit, idValidasi);
        } else if (noSimulasi.equals(2)) {
            Engine2 e2 = new Engine2();
            result = e2.process(noKartuKredit, idValidasi);
        } else if (noSimulasi.equals(3)) {
            Engine3 e3 = new Engine3();
            result = e3.process(noKartuKredit, idValidasi);
        }
        return result;
    }

}
