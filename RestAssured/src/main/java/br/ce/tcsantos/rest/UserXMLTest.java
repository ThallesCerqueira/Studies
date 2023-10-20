package br.ce.tcsantos.rest;

import io.restassured.internal.path.xml.NodeImpl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class UserXMLTest {

    // AULA 18
    @Test
    public void trabalharComXML() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/usersXML/3")
        .then()
                .statusCode(200)
                .rootPath("user") // define o rootPath, a raiz, como sendo user
                .body("name", is("Ana Julia"))
                .body("@id", is("3"))
                .body("filhos.name.size()", is(2))
                .body("filhos.name[0]", is("Zezinho"))
                .body("users.user.salary.find{it.salary != null}", is(1234.5678))
                .body("users.user.age.collect{it.toInteger() * 2}", hasItems(40, 50, 60))
        ;

    }

    @Test
    public void fazerPesquisasAvancadasXML() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/usersXML")
        .then()
                .statusCode(200)
                .body("users.user.size()", is(3)) // Valida tamanho do "array" users
                .body("users.user.findAll{it.age.toInteger() <= 25 }.size()", is(2)) // Verifica usuarios com idade <= 25
                .body("users.user.@id", hasItems("1", "2", "3")) // Valida os id' de users
                .body("users.user.findAll{it.age.toInteger() > 25}.name", is("João da Silva")) //
                .body("users.user.find{it.age == 25}.name", is("Maria Joaquina"))
                .body("users.user.findAll{it.name.toString().contains('n')}.name", hasItems("Maria Joaquina", "Ana Julia"))
        ;

    }

    @Test
    public void fazerPesquisasAvancadasXMLEJava() {

        ArrayList<NodeImpl> names = given()
                .when()
                .get("https://restapi.wcaquino.me/usersXML")
                .then()
                .statusCode(200)
                .extract().path("users.user.name.findAll{it.toString().contains('n')}")
        ;

        Assert.assertEquals(2, names.size());
        Assert.assertEquals("Maria Joaquina".toUpperCase(), names.get(0).toString().toUpperCase());
        Assert.assertTrue("Ana Julia".equalsIgnoreCase(names.get(1).toString()));
        //Assert.assertEquals("Maria Joaquina".toUpperCase(), name.toString().toUpperCase());

    }


}
