package br.ce.tcsantos.rest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

    // AULA 14
    @Test
    public void deveRetornarErroUsuarioInexistente() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/users/4")
        .then()
                .statusCode(404)
                .body("error", is("Usuário inexistente"))
        ;
    }

    // AULA 15
    @Test
    public void deveVerificarListaNaRaiz() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/users")
        .then()
                .statusCode(200)
                .body("$", hasSize(3)) // Valida tamanho do array raiz
                .body("name", hasItems("João da Silva", "Maria Joaquina", "Ana Júlia")) // Verifica nas chaves name os nomes listados
                .body("age[1]", is(25)) // Verifica a idade da chave age para o elemento de posicao 1 no array raiz
                .body("filhos.name", hasItem(Arrays.asList("Zezinho", "Luizinho"))) // Verifica se tem os nomes listados nas chave filhos.name do array raiz
                .body("salary", contains(1234.5678f, 2500, null)) // Verifica os salarios listados, para a chave salary do array raiz
         ;

    }

    // AULA 16
    @Test
    public void verificacoesAvancadas() {

        given()
        .when()
                .get("https://restapi.wcaquino.me/users")
        .then()
                .statusCode(200)
                .body("$", hasSize(3)) // Valida tamanho do array raiz
                .body("age.findAll{it <= 25}.size()", is(2)) // Validando qtd de users com idade <= 25
                .body("age.findAll{it > 20 && it <= 25}.size()", is(1)) // Validando qtd de users com idade > 20 e idade <= 25
                .body("findAll{it.age > 20 && it.age <= 25}.name", hasItem("Maria Joaquina")) // Verificando existencia do item x nos usarios que tem idade restrita
                .body("findAll{it.name.contains('n')}.name", hasItems("Maria Joaquina", "Ana Júlia")) // Validando nomes com letra 'n'
                .body("findAll{it.name.length() > 10}.name", hasItems( "João da Silva","Maria Joaquina")) // Validando nomes com tamanho > 10
        ;

    }

    // AULA 17
    @Test
    public void unirJsonPathComJava() {

        // Fazendo requisição e extraindo os elementos que começam com Maria
        ArrayList<String> names = given()
                                .when()
                                .get("https://restapi.wcaquino.me/users")
                                .then()
                                        .statusCode(200)
                                        .extract().path("name.findAll{it.startsWith('Maria')}")
                                ;

        // Validando tamanho do arralist names
        Assert.assertEquals(1, names.size());

        // Validando o nome da primeira posição, ignorando case sensitive.
        Assert.assertTrue(names.get(0).equalsIgnoreCase("Maria Joaquina"));

    }

}
