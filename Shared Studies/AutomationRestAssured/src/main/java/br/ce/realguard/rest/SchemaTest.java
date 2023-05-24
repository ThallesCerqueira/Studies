package br.ce.realguard.rest;

import io.restassured.matcher.RestAssuredMatchers;
import org.junit.Test;
import org.xml.sax.SAXParseException;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.given;

public class SchemaTest {

    @Test
    public void deveValidarSchemaXML() {

        given()
                .log().all()
        .when()
                .get("https://restapi.wcaquino.me/usersXML")
        .then()
                .log().all()
                .statusCode(200)
                .body(RestAssuredMatchers.matchesXsdInClasspath("users.xsd"))

        ;

    }

    @Test(expected = SAXParseException.class)
    public void naoDeveValidarSchemaXML() {

        given()
                .log().all()
                .when()
                .get("https://restapi.wcaquino.me/invalidUsersXML")
                .then()
                .log().all()
                .statusCode(200)
                .body(RestAssuredMatchers.matchesXsdInClasspath("users.xsd"))

        ;

    }

    @Test
    public void deveValidarSchemaJson() {

        given()
                .log().all()
        .when()
                .get("https://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("users.json"))

        ;

    }

}
