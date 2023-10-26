package br.ce.tcsantos.rest;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class VerbosTest {

    // AULA 25
    @Test
    public void salvarUsuario() {

        given()
                .log()
                .all()
                .header("Content-type", "application/json" )
                .body("{\"name\": \"Jose\", \"age\": 50}")
        .when()
                .post("https://restapi.wcaquino.me/users")
        .then()
                .log()
                .all()
                .statusCode(201)
                .body("id", is(notNullValue()))
                .body("name", is("Jose"))
                .body("age", is(50))
        ;

    }


}