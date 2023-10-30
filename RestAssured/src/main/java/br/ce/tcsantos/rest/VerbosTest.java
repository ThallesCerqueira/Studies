package br.ce.tcsantos.rest;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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

    // AULA 26
    @Test
    public void naoDeveSalvarUsarioSemNome() {
        given()
                .log()
                .all()
                .header("Content-type", "application/json")
                .body("{\"age\": 50}")
        .when()
                .post("https://restapi.wcaquino.me/users")
        .then()
                .log()
                .all()
                .statusCode(400)
                .body("id", is(nullValue()))
                .body("error", is("Name é um atributo obrigatório"))
        ;

    }

    // AULA 27
    @Test
    public void salvarUsuarioXML() {

        given()
                .log()
                .all()
                .header("Content-type", "application/xml" )
                .body("<user><name>Jose</name><age>50</age></user>")
        .when()
                .post("https://restapi.wcaquino.me/usersXML")
        .then()
                .log()
                .all()
                .body("user.@id", is(notNullValue()))
                .body("user.name", is("Jose"))
                .body("user.age", is("50"))
                .statusCode(201);

    }

    // AULA 28
    @Test
    public void alterarUsuario() {

        given()
                .log()
                .all()
                .header("Content-type", "application/json" )
                .body("{\"name\": \"Jose Alterado\", \"age\": 80}")
        .when()
                .put("https://restapi.wcaquino.me/users/1")
        .then()
                .log()
                .all()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Jose Alterado"))
                .body("age", is(80))
        ;

    }

    // AULA 29
    @Test
     public void customizarURL () {

        given()
                .log()
                .all()
                .header("Content-type", "application/json" )
                .body("{\"name\": \"Jose Alterado\", \"age\": 80}")
        .when()
                .put("https://restapi.wcaquino.me/{entidade}/{userId}", "users", "1")
        .then()
                .log()
                .all()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Jose Alterado"))
                .body("age", is(80))
        ;

    }

}