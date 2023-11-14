package br.ce.tcsantos.rest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class EnvioDadosTest {

    @Test
    public void enviarValorViaQuery() {
        given()
                .log()
                .all()
        .when()
                .get("https://restapi.wcaquino.me/v2/users?format=xml")
        .then()
                .log()
                .all()
                .statusCode(200)
                .contentType(ContentType.XML)
        ;
    }

    @Test
    public void enviarValorViaQueryViaParam() {
        given()
                .log()
                .all()
                .queryParam("format", "xml")
        .when()
                .get("https://restapi.wcaquino.me/v2/users  ")
        .then()
                .log()
                .all()
                .statusCode(200)
                .contentType(ContentType.XML)
        ;
    }
}
