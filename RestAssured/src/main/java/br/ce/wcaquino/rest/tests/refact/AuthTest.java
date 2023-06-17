package br.ce.wcaquino.rest.tests.refact;

import br.ce.wcaquino.rest.core.BaseTest;
import io.restassured.specification.FilterableRequestSpecification;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class AuthTest extends BaseTest {

    @Test
    public void naoDeveAcessarAPISemToken() {

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
