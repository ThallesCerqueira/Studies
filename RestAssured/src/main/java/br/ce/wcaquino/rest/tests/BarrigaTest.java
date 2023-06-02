package br.ce.wcaquino.rest.tests;

import br.ce.wcaquino.rest.core.BaseTest;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BarrigaTest extends BaseTest {

    private String TOKEN;

    @Before
    public void login() {

        Map<String, String> login = new HashMap<>();
        login.put( "email", "thallescerqueira.dev@gmail.com" );
        login.put( "senha", "123456" );

        TOKEN =
                given()
                        .body( login )
                        .when()
                        .post( "/signin" )
                        .then()
                        .statusCode( 200 )
                        .extract(  ).path( "token" )
                ;

    }

    @Test
    public void naoDeveAcessarAPISemToken() {

        given()
        .when()
                .get( "/contas" )
        .then()
                .statusCode( 401 )

        ;

    }

    @Test
    public void deveIncluirContaComSucesso() {

        given()
                .header( "Authorization", "JWT " + TOKEN )
                .body( "{ \"nome\": \"conta qualquer\" }" )
        .when()
                .post( "/contas" )
        .then()
        ;

    }

    @Test
    public void deveAlterarContaComSucesso() {

        given()
                .header( "Authorization", "JWT " + TOKEN )
                .body( "{ \"nome\": \"ContaAlterada\" }" )
        .when()
                .put( "/contas/1740434" )
        .then()
                .log().all()
                .statusCode( 200 )
                .body( "nome", is( "ContaAlterada" ))
        ;

    }

    @Test
    public void deveAlterarInserirContaComMesmoNome() {

        given()
                .header( "Authorization", "JWT " + TOKEN )
                .body( "{ \"nome\": \"ContaAlterada\" }" )
        .when()
                .post( "/contas" )
        .then()
                .statusCode( 400 )
                .body( "error", is( "Já existe uma conta com esse nome!" ))
        ;

    }

    @Test
    public void deveInserirUmaMovimentacaoComSucesso() {

        Movimentacao mov = new Movimentacao();

        mov.setConta_id( 1740434 );
        //mov.setUsuario_id(  );
        mov.setDescricao( "Descrição da movimentação." );
        mov.setEnvolvido( "Envolvido na mov" );
        mov.setTipo( "REC" );
        mov.setData_transacao( "01/01/2000" );
        mov.setData_pagamento( "01/01/2010" );
        mov.setValor( 100f );
        mov.setStatus( true );

        given()
                .header( "Authorization", "JWT " + TOKEN )
                .body( mov )
        .when()
                .post( "/transacoes" )
        .then()
                .statusCode( 201 )

        ;

    }

    @Test
    public void deveValidarCamposObrigatoriosNaMovimentacao() {

        given()
                .header( "Authorization", "JWT " + TOKEN )
                .body( "{}" )
        .when()
                .post( "/transacoes" )
        .then()
                .statusCode( 400 )
                .body( "$", hasSize( 8 ) )
                .body( "msg", hasItems( "Data da Movimentação é obrigatório",
                        "Data do pagamento é obrigatório",
                        "Descrição é obrigatório",
                        "Interessado é obrigatório",
                        "Valor é obrigatório",
                        "Valor deve ser um número",
                        "Conta é obrigatório",
                        "Situação é obrigatório") )

        ;

    }

}