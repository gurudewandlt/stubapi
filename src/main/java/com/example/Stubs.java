package com.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.example.utils.JsonUtil;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class Stubs {
    private JsonUtil jsonUtil;
    public WireMockServer wireMockServer;

    public Stubs setUp() {
        wireMockServer = new WireMockServer(8080);
        wireMockServer.start();
        jsonUtil = new JsonUtil();
        return this;
    }

    public Stubs resetServer() {
        wireMockServer.resetAll();
        return this;
    }

    public Stubs stubForAddProduct(String requestFileName, String responseFileName) {
        jsonUtil.setJSON("/__files/json/".concat(requestFileName));
        wireMockServer.stubFor(post("/carts/klms2f4c-8129-4a4b-b32d-550b7fc3cfb2")
            .withRequestBody(equalToJson(jsonUtil.getJSON().toString(), true, true))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBodyFile("json/" + responseFileName)));
        return this;
    }

    public Stubs stubForPutProduct(String requestFileName, String responseFileName) {
        jsonUtil.setJSON("/__files/json/".concat(requestFileName));
        wireMockServer.stubFor(post("/carts/klms2f4c-8129-4a4b-b32d-550b7fc3cfb2/products/93b55282-334c-48b0-a8f7-a9d5eef9c4b9")
            .withRequestBody(equalToJson(jsonUtil.getJSON().toString(), true, true))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBodyFile("json/" + responseFileName)));
        return this;
    }

    public Stubs stubForDeleteProduct() {
        wireMockServer.stubFor(delete("/carts/klms2f4c-8129-4a4b-b32d-550b7fc3cfb2/products/93b55282-334c-48b0-a8f7-a9d5eef9c4b9")
            .willReturn(aResponse()
                .withStatus(204)));
        return this;
    }

    public Stubs status() {
        System.out.println("Stubs Started!");
        return this;
    }
}