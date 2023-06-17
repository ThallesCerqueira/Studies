package br.ce.wcaquino.rest.tests.refact;

import br.ce.wcaquino.rest.core.BaseTest;
import br.ce.wcaquino.rest.utils.BarrigaUtils;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class ContasTest extends BaseTest {

    @Test
    public void deveIncluirContaComSucesso() {

        given()
                .body( "{ \"nome\": \"Conta\" }" )
        .when()
                .post( "/contas" )
        .then()
                .statusCode(201)
                .extract().path("id")
        ;

    }

    @Test
    public void deveAlterarContaComSucesso() {

        Integer CONTA_ID = BarrigaUtils.getIdDaContaPeloNome( "Conta para alterar" );

        given()
                .body( "{ \"nome\": \"Conta Alterada\" }" )
                .pathParam("id", CONTA_ID)
        .when()
                .put( "/contas/{id}" )
        .then()
                .log().all()
                .statusCode( 200 )
                .body( "nome", is( "Conta Alterada" ))
        ;

    }

    @Test
    public void deveAlterarInserirContaComMesmoNome() {

        given()
                .body( "{ \"nome\": \"Conta mesmo nome\" }" )
                .when()
                .post( "/contas" )
                .then()
                .statusCode( 400 )
                .body( "error", is( "Já existe uma conta com esse nome!" ))
        ;

    }

}
