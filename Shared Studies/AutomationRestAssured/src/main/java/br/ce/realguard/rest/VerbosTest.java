package br.ce.realguard.rest;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VerbosTest {

    @Test
    public void deveSalvarUsuario() {

        given()
                .log().all()
                .contentType("application/json")
                .body("{ \"name\": \"Jose\", \"age\": 50}").
        when()
            .post("https://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(201)
                .body("id", is( notNullValue()))
                .body("name", is("Jose"))
                .body("age", is(50))

        ;

    }

    @Test
    public void deveSalvarUsuarioObjetoMap() {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Usuario via Map");
        params.put("age", 20);

        given()
                .log().all()
                .contentType("application/json")
                .body( params ).
                when()
                .post("https://restapi.wcaquino.me/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", is( notNullValue()))
                .body("name", is("Usuario via Map"))
                .body("age", is(20))

        ;

    }

    @Test
    public void deveSalvarUsuarioObjeto() {
        User user = new User( "Usuário via Objeto", 35 );

        given()
                .log().all()
                .contentType("application/json")
                .body( user ).
                when()
                .post("https://restapi.wcaquino.me/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", is( notNullValue()))
                .body("name", is("Usuário via Objeto"))
                .body("age", is(35))

        ;

    }

    @Test
    public void deveDeserializarObjetoAoSalvarUsuario() {
        User user = new User( "Usuário deserializado ", 35 );

        User usuarioInserido = given()
                .log().all()
                .contentType("application/json")
                .body( user ).
                when()
                .post("https://restapi.wcaquino.me/users")
                .then()
                .log().all()
                .extract().body().as(User.class)

        ;


        System.out.println(usuarioInserido);

        Assert.assertThat( usuarioInserido.getId(), notNullValue() );
        //Assert.assertEquals( "Usuário deserializado", usuarioInserido.getName() );
        Assert.assertThat( usuarioInserido.getAge(), is(35) );



    }

    @Test
    public void naoDeveSalvarUsuarioSemNome() {

        given()
                .log().all()
                .contentType("application/json")
                .body("{ \"age\": 50}").
       when()
                .post("https://restapi.wcaquino.me/users")
       .then()
                .log().all()
                .statusCode(400)
                .body("id", is( nullValue()))
                .body("error", is("Name é um atributo obrigatório"))

                ;

    }

    @Test
    public void deveSalvarUsuarioViaXML() {

        given()
                .log().all()
                .contentType( ContentType.XML )
                .body("<user><name>Jose</name><age>50</age></user>").
        when()
                .post("https://restapi.wcaquino.me/usersXML")
        .then()
                .log().all()
                .statusCode(201)
                .body("user.@id", is( notNullValue()))
                .body("user.name", is("Jose"))
                .body("user.age", is("50"))

        ;

    }

    @Test
    public void deveSalvarUsuarioViaXMLUsandoObjeto() {

        User user = new User( "Usuario XML", 40 );

        given()
                .log().all()
                .contentType( ContentType.XML )
                .body(user).
                when()
                .post("https://restapi.wcaquino.me/usersXML")
                .then()
                .log().all()
                .statusCode(201)
                .body("user.@id", is( notNullValue()))
                .body("user.name", is("Usuario XML"))
                .body("user.age", is("40"))

        ;

    }

    @Test
    public void deveDeserializarXMLAoSalvarUsuario() {

        User user = new User( "Usuario XML", 40 );

        User usuarioInserido = given()
                .log().all()
                .contentType( ContentType.XML )
                .body(user).
                when()
                .post("https://restapi.wcaquino.me/usersXML")
                .then()
                .log().all()
                //.statusCode(201)
                .extract().body().as(User.class)
        ;

        //Assert.assertThat(usuarioInserido.getId(), notNullValue());
        Assert.assertThat( usuarioInserido.getName(), is("Usuario XML") );
        Assert.assertThat( usuarioInserido.getAge(), is(40) );

    }

    @Test
    public void deveAlterarUsuario() {

        given()
                .log().all()
                .contentType("application/json")
                .body("{ \"name\": \"Usuário Alterado\", \"age\": 80}").
        when()
                .put("https://restapi.wcaquino.me/users/1")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Usuário Alterado"))
                .body("age", is(80))

        ;

    }

    @Test
    public void devoCustomizarUrl() {

        given()
                .log().all()
                .contentType("application/json")
                .body("{ \"name\": \"Usuário Alterado\", \"age\": 80}")

        .when()
                .put("https://restapi.wcaquino.me/{entidade}/{userId}", "users", "1")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Usuário Alterado"))
                .body("age", is(80))

        ;

    }

    @Test
    public void devoCustomizarUrlParte_2() {

        given()
                .log().all()
                .contentType("application/json")
                .body("{ \"name\": \"Usuário Alterado\", \"age\": 80}")
                .pathParam("entidade", "users")
                .pathParam("userId", "1")
        .when()
                .put("https://restapi.wcaquino.me/{entidade}/{userId}")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Usuário Alterado"))
                .body("age", is(80))

        ;

    }

    @Test
    public void devoRemoverUsuario() {


        given()
                .log().all()
        .when()
                .delete("https://restapi.wcaquino.me/users/1")
        .then()
                .log().all()
                .statusCode(204)

                ;

    }

    @Test
    public void naoDevoRemoverUsuario() {


        given()
                .log().all()
                .when()
                .delete("https://restapi.wcaquino.me/users/8")
                .then()
                .log().all()
                .statusCode(400)
                .body("error", is("Registro inexistente"))

        ;

    }

}
