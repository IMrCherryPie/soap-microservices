package com.example.fluxclient.repo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomWebClient {

    public final WebClient flux_server_app;

    public CustomWebClient() {
        this.flux_server_app =  WebClient.create("http://localhost:8086");;
    }
}
