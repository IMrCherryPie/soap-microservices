package com.soapclient.config;

import com.soapclient.RequestExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.gen");
        return marshaller;
    }

    @Bean
    public RequestExecutor requestExecutor(Jaxb2Marshaller marshaller) {
        RequestExecutor client = new RequestExecutor();
        client.setDefaultUri("http://localhost:8091/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
