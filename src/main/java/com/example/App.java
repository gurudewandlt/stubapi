package com.example;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import com.github.tomakehurst.wiremock.client.WireMock.*;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import com.github.tomakehurst.wiremock.WireMockServer;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080)); // No-args constructor will
                                                                                         // start on port 8080, no HTTPS
        wireMockServer.start();
        // stub in code, then stub in json files
        
        // TODO replace this with json file
        
        // mock response
        ResponseDefinitionBuilder respDefBuilder = new ResponseDefinitionBuilder();
        respDefBuilder.withStatus(200);
        //respDefBuilder.withStatusMessage("hi world");
        respDefBuilder.withBody("hi this is the body");
        
        // mock request
        WireMock.stubFor(WireMock.get("/api/users").willReturn(respDefBuilder));
        //WireMock.stubFor(WireMock.get("/api/admins").willReturn(respDefBuilder2));
        
    }
}
