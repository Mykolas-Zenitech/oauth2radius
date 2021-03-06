package com.deathwishsoftware.oauth2radius.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.tinyradius.util.RadiusClient;

@Configuration
@Profile("test")
public class RadiusClientConfig {

    @Value("${oauth2radius.auth-port:0}")
    private int authPort;

    @Value("${oauth2radius.acct-port:0}")
    private int acctPort;

    @Bean
    public RadiusClient getRadiusClient() {
        RadiusClient client = new RadiusClient("localhost", "shared-secret");
        if (authPort > 1 && authPort < 65535) {
            client.setAuthPort(authPort);
        }
        if (acctPort > 1 && acctPort < 65535) {
            client.setAcctPort(acctPort);
        }
        return client;
    }

}
