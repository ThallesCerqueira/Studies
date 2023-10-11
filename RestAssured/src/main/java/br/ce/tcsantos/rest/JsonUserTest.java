package br.ce.tcsantos.rest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class JsonUserTest {

    @Test
    public void deveVerificarPrimeiroNivel() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/users/1")
        .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", containsString("Silva"))
                .body("age", greaterThan(18))
        ;

    }

    @Test
    public void deveVerificarPrimeiroNivelOutrasFormas() {

        Response response = RestAssured.request( Method.GET, "https://restapi.wcaquino.me/users/1" );

        // Path
        assertEquals(new Integer(1), response.path("id"));

        // Json Path
        JsonPath jsonPath = new JsonPath(response.asString());
        assertEquals(1, jsonPath.getInt("id"));

        // From
        int id = JsonPath.from(response.asString()).getInt("id");
        assertEquals(1, id);

    }

    @Test
    public void deveVerificarSegundoNivel() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/users/2")
        .then()
                .statusCode(200)
                .body("name", containsString("Joaquina"))
                .body("endereco.rua", is("Rua dos bobos"))
        ;

    }

    @Test
    public void deveVerificarLista() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/users/3")
        .then()
                .statusCode(200)
                .body("name", containsString("Ana"))
                .body("filhos", hasSize(2))
                .body("filhos[0].name", containsString("Zezinho"))
                .body("filhos[1].name", containsString("Luizinho"))
                .body("filhos.name", hasSize(2))
                .body("filhos.name", hasItem("Zezinho"))
                .body("filhos.name", hasItems("Zezinho", "Luizinho"))

        ;
    }
}
