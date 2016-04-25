/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.services.impl;

import com.core.engines.Engine1;
import com.core.engines.Engine3;
import com.core.services.ServiceKurir;
import javax.jws.WebService;

/**
 *
 * @author Emerio
 */
@WebService(
	endpointInterface = "com.core.services.ServiceKurir",
	serviceName = "ServiceKurir"
	)
public class ServiceKurirImpl implements ServiceKurir{

    @Override
    public String kurirTransaction(Integer noSimulasi, String idTransaksiBank) {
        String result = "FAILED";
        if (noSimulasi.equals(1)) {
            Engine1 e1 = new Engine1();
            e1.process(idTransaksiBank);
            result = "SUCCESS";
        } else if (noSimulasi.equals(3)) {
            Engine3 e3 = new Engine3();
            result = e3.process(idTransaksiBank);
        } 
        return result;
    }
    
}
