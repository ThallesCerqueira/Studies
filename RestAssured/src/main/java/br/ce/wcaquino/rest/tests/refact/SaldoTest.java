package br.ce.wcaquino.rest.tests.refact;

import br.ce.wcaquino.rest.core.BaseTest;
import br.ce.wcaquino.rest.utils.BarrigaUtils;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class SaldoTest extends BaseTest {

    @Test
    public void deveCalcularSaldoContas() {

        Integer CONTA_ID = BarrigaUtils.getIdDaContaPeloNome( "Conta para saldo" );

        given()
                .when()
                .get( "/saldo" )
                .then()
                .statusCode( 200 )
                .body( "find{it.conta_id==" + CONTA_ID +"}.saldo", is( "534.00" ) )
        ;

    }
}
