package br.ce.wcaquino.rest.tests.refact.suite;

import java.util.Map;
import java.util.HashMap;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import br.ce.wcaquino.rest.core.BaseTest;
import static io.restassured.RestAssured.*;
import br.ce.wcaquino.rest.tests.refact.AuthTest;
import br.ce.wcaquino.rest.tests.refact.SaldoTest;
import br.ce.wcaquino.rest.tests.refact.ContasTest;
import br.ce.wcaquino.rest.tests.refact.MovimentacaoTest;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({
        ContasTest.class,
        MovimentacaoTest.class,
        SaldoTest.class,
        AuthTest.class

})

public class Suite extends BaseTest {

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
        get( "/reset" ).then().statusCode( 200 );


    }

}