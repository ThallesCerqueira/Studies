package br.ce.realguard.rest;

import groovy.util.XmlParser;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AuthTest {

    @Test
    public void deveAcessarASwAPI() {

        given()
                .log().all()
        .when()
                .get("https://swapi.dev/api/people/1")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Luke Skywalker"))

        ;

    }

    @Test
    public void deveObterClima() {

        given()
                .log().all()
                .queryParam("q", "Fortaleza,BR")
                .queryParam("appid", "e7e6bfb2fe0b7677fd8392b5fdcddc06")
                .queryParam("units", "metric")
        .when()
                .get("https://api.openweathermap.org/data/2.5/weather")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Fortaleza"))
                .body("coord.lon", is(-38.5247f))
                .body("main.temp", greaterThan(25f))
        ;

    }

    @Test
    public void naoDeveAcessarSemSenha() {

        given()
                .log().all()

        .when()
                .get("https://restapi.wcaquino.me/basicauth")
        .then()
                .log().all()
                .statusCode(401)

        ;

    }

    @Test
    public void deveFazerAutenticacaoBasica() {

        given()
                .log().all()

                .when()
                .get("https://admin:senha@restapi.wcaquino.me/basicauth")
                .then()
                .log().all()
                .statusCode(200)
                .body("status", is("logado"))

        ;

    }

    @Test
    public void deveFazerAutenticacaoBasica2() {

        given()
                .log().all()
                .auth().basic("admin", "senha")
        .when()
                .get("https://restapi.wcaquino.me/basicauth")
        .then()
                .log().all()
                .statusCode(200)
                .body("status", is("logado"))

        ;

    }

    @Test
    public void deveFazerAutenticacaoBasicaChallenge() {

        given()
                .log().all()
                .auth().basic("admin", "senha")
        .when()
                .get("https://restapi.wcaquino.me/basicauth")
        .then()
                .log().all()
                .statusCode(200)
                .body("status", is("logado"))

        ;

    }

    @Test
    public void deveFazerAutenticacaoComToken() {

        Map<String, String> login = new HashMap<String, String>();
        login.put("email", "thallescerqueira.dev@gmail.com");
        login.put("senha", "123456");


        //login na API
        //receber o token
        String token = given()
                .log().all()
                .body(login).contentType(ContentType.JSON)
        .when()
                .post("https://barrigarest.wcaquino.me/signin")
        .then()
                .log().all()
                .statusCode(200)
                .extract().path("token")

        ;

        //obter as contas
        given()
                .log().all()
                .header("Authorization", "JWT " + token)
        .when()
                .get("https://barrigarest.wcaquino.me/contas")
        .then()
                .log().all()
                .body("nome", hasItem("ContaDeTeste"))

       ;

    }

    @Test
    public void deveAcessarAplicacaoWeb() {

        //login

        String cookie = given()
                .log().all()
                .formParam("email", "thallescerqueira.dev@gmail.com")
                .formParam("senha", "123456")
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
        .when()
                .post("https://seubarriga.wcaquino.me/logar")
        .then()
                .log().all()
                .statusCode(200)
                .extract().header("set-cookie")

        ;

        cookie = cookie.split("=")[1].split(";")[0];
        System.out.println(cookie);

        //obter conta

        String body = given()
                .log().all()
                .cookie("connect.sid", cookie)
        .when()
                .get("https://seubarriga.wcaquino.me/contas")
        .then()
                .log().all()
                .statusCode(200)
                .body("html.body.table.tbody.tr[0].td[0]", is("ContaDeTeste"))
                .extract().body().toString()

        ;

        System.out.println("==============");
        XmlPath xmlPath = new XmlPath(XmlPath.CompatibilityMode.HTML, body);

        System.out.println(xmlPath.getString("html.body.table.tbody.tr[0].td[0]"));



        //https://seubarriga.wcaquino.me/contas


    }



}

