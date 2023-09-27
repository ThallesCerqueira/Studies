package br.ce.tcsantos.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class OlaMundoTest {

    @Test
    public void testOlaMundo() {

        Response response = RestAssured.request( Method.GET, "https://restapi.wcaquino.me/ola" );

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

    }

}
