package br.ce.realguard.rest;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {

        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        assertTrue( response.getBody().asString().equals( "Ola Mundo!" ) );
        assertTrue( "O status code deveria ser 200.",response.statusCode() == 200 );
        assertEquals( 200, response.statusCode() );

        ValidatableResponse validacao = response.then();
        validacao.statusCode( 200 );

    }

    @Test
    public void devoConhecerOutrasFormasRestAssured() {

        Response response = request(Method.GET, "https://restapi.wcaquino.me/ola");

        ValidatableResponse validacao = response.then();
        validacao.statusCode( 200 );

        get( "https://restapi.wcaquino.me/ola" ).then().statusCode( 200 );

        given()// Pré-Condições
                .when().get( "https://restapi.wcaquino.me/ola" ) // Ação de fato
                .then().statusCode( 200 ); // O que se espera, a assertiva.

    }

    @Test
    public void devoConhecerMatchersHamcrest() {

        assertThat( "Maria", Matchers.is( "Maria" ));

        List<Integer> impares = Arrays.asList( 1,3,5,7,9 );

        assertThat( impares, Matchers.hasSize( 5 ) );

        assertThat( impares, contains(1,3,5,7,9) );
        assertThat( impares, containsInAnyOrder(1,3,7,5, 9) );
        assertThat( impares, hasItem(1) );

        assertThat( "Maria", is(not("Joao")) );
        assertThat( "Maria", anyOf(is("Maria"), is("Joaquina")) );

        assertThat( "Joaquina", allOf(startsWith("Joa"), endsWith("ina"), containsString("qui")) );

    }

    @Test
    public void devoValidarBody() {

        given()
                .when().get( "https://restapi.wcaquino.me/ola" ) // Ação de fato
                .then().statusCode( 200 ).body( is("Ola Mundo!") ).body(containsString("Mundo"));


    }


}
