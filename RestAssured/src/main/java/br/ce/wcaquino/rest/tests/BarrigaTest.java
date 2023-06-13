package br.ce.wcaquino.rest.tests;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.junit.runners.MethodSorters;
import br.ce.wcaquino.rest.core.BaseTest;
import static io.restassured.RestAssured.*;
import br.ce.wcaquino.rest.utils.DateUtils;
import io.restassured.specification.FilterableRequestSpecification;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class BarrigaTest extends BaseTest {

    private static String CONTA_NAME = "Conta" + System.nanoTime();
    private static Integer CONTA_ID;
    private static Integer MOV_ID;

    @BeforeClass
    public static void login() {

        Map<String, String> login = new HashMap<>();
        login.put( "email", "thallescerqueira.dev@gmail.com" );
        login.put( "senha", "123456" );

        String TOKEN =
                given()
                        .body( login )
                .when()
                        .post( "/signin" )
                .then()
                        .statusCode( 200 )
                        .extract(  ).path( "token" )
                ;
        requestSpecification.header("Authorization", "JWT " + TOKEN);

    }

    @Test
    public void t02deveIncluirContaComSucesso() {

        CONTA_ID = given()
                .body( "{ \"nome\": \""+ CONTA_NAME + "\" }" )
        .when()
                .post( "/contas" )
        .then()
                .statusCode(201)
                .extract().path("id")
        ;

    }

    @Test
    public void t03deveAlterarContaComSucesso() {

        given()
                .body( "{ \"nome\": \""+ CONTA_NAME + "Alterada\" }" )
                .pathParam("id", CONTA_ID)
        .when()
                .put( "/contas/{id}" )
        .then()
                .log().all()
                .statusCode( 200 )
                .body( "nome", is( CONTA_NAME + "Alterada" ))
        ;

    }

    @Test
    public void t04deveAlterarInserirContaComMesmoNome() {

        given()
                .body( "{ \"nome\": \""+ CONTA_NAME + "Alterada\" }" )
        .when()
                .post( "/contas" )
        .then()
                .statusCode( 400 )
                .body( "error", is( "Já existe uma conta com esse nome!" ))
        ;

    }

    @Test
    public void t05deveInserirUmaMovimentacaoComSucesso() {

        Movimentacao mov = getMovimentacao();

        MOV_ID = given()
                .body( mov )
        .when()
                .post( "/transacoes" )
        .then()
                .statusCode( 201 )
                .extract().path("id")
        ;

    }

    @Test
    public void t06deveValidarCamposObrigatoriosNaMovimentacao() {

        given()
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

    @Test
    public void t07naoDeveInserirUmaMovimentacaoComDataFutura() {

        Movimentacao mov = getMovimentacao();
        mov.setData_transacao( DateUtils.getDataDiferencaDias( 2 ) );

        given()
                .body( mov )
                .when()
                .post( "/transacoes" )
                .then()
                .statusCode( 400 )
                .body( "msg", hasItems( "Data da Movimentação deve ser menor ou igual à data atual") )
        ;

    }

    private Movimentacao getMovimentacao() {
        Movimentacao mov = new Movimentacao();

        mov.setConta_id( CONTA_ID );
        mov.setDescricao( "Descrição da movimentação." );
        mov.setEnvolvido( "Envolvido na mov" );
        mov.setTipo( "REC" );
        mov.setData_transacao( DateUtils.getDataDiferencaDias(-1) );
        mov.setData_pagamento( DateUtils.getDataDiferencaDias( 5 ) );
        mov.setValor( 100f );
        mov.setStatus( true );

        return mov;
    }

    @Test
    public void t08naoDeveRemoverContaComMovimentacao() {

        given()
                .pathParam("id", CONTA_ID)
        .when()
                .delete( "/contas/{id}" )
        .then()
                .statusCode( 500 )
                .body( "constraint", is( "transacoes_conta_id_foreign" ) )
        ;

    }

    @Test
    public void t09deveCalcularSaldoContas() {

        given()
        .when()
                .get( "/saldo" )
        .then()
                .statusCode( 200 )
                .body( "find{it.conta_id==" + CONTA_ID +"}.saldo", is( "100.00" ) )
        ;

    }

    @Test
    public void t10deverRemoverMovimentacao() {

        given()
                .pathParam("id", MOV_ID)
        .when()
                .delete( "/transacoes/{id}" )
        .then()
                .statusCode( 204 )
        ;

    }

    @Test
    public void t11naoDeveAcessarAPISemToken() {

        FilterableRequestSpecification req = (FilterableRequestSpecification)requestSpecification;
        req.removeHeader("Authorization");

        given()
                .when()
                .get( "/contas" )
                .then()
                .statusCode( 401 )
        ;

    }

}