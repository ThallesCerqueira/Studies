package br.ce.tcsantos.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class OlaMundoTest {

    @Test
    public void testOlaMundo() {

        Response response = RestAssured.request( Method.GET, "https://restapi.wcaquino.me/ola" );
        Assert.assertEquals("Ola Mundo!", response.getBody().asString());
        Assert.assertEquals(200, response.statusCode());

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

    }

    @Test
    public void devoConhecerOutrasFormasRestAssured() {

        Response response = RestAssured.request( Method.GET, "https://restapi.wcaquino.me/ola" );

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

        get("https://restapi.wcaquino.me/ola").then().statusCode(200);

        given()
        .when()
                .get("https://restapi.wcaquino.me/ola")
        .then()
                .statusCode(200)
        ;

    }

    @Test
    public void devoConhecerMatchersHamcrest() {

        assertThat("Maria", is("Maria"));

    }

    @Test
    public void devoValidarBody() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/ola")
        .then()
                .statusCode(200)
                .body(is("Ola Mundo!"))
                .body(containsString("Mundo"))
                .body(is(not(nullValue())))
        ;

    }

}
