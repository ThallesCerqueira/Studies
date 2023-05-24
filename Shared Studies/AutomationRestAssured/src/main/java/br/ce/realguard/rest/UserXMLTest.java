package br.ce.realguard.rest;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import org.junit.BeforeClass;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import io.restassured.filter.log.LogDetail;
import static io.restassured.RestAssured.given;
import io.restassured.internal.path.xml.NodeImpl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UserXMLTest {

    public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://restapi.wcaquino.me";
        //RestAssured.port = 443;
        //RestAssured.basePath = "";

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.log(LogDetail.ALL);
        reqSpec =  reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectStatusCode( 200 );
        resSpec =  resBuilder.build();

        RestAssured.requestSpecification = reqSpec;
        RestAssured.responseSpecification = resSpec;

    }

    @Test
    public void devoTrabalharComXML() {

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.log(LogDetail.ALL);
        RequestSpecification requestSpecification =  reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectStatusCode( 200 );
        ResponseSpecification responseSpecification=  resBuilder.build();

        given()
        .when()
                .get( "/usersXML/3" )
        .then()
//                .statusCode( 200 )
                .rootPath( "user" )
                .body( "name", is( "Ana Julia" ) )
                .body( "@id", is("3") )
                .rootPath( "user.filhos" )
                .body("name.size()", is(2))
                .detachRootPath( "filhos" )
                .body( "filhos.name[0]", is("Zezinho") )
                .body( "filhos.name[1]", is("Luizinho") )
                .appendRootPath( "filhos" )
                .body( "name", hasItems("Luizinho", "Zezinho") )

        ;


    }

    @Test
    public void devoFazerPesquisasAvancadasXML() {

        given()
        .when()
                .get( "/usersXML" )
        .then()
                .body( "users.user.size()", is(3) )
                .body( "users.user.findAll{ it.age.toInteger() <= 25}.size()", is(2)  )
                .body( "users.user.@id", hasItems("1", "2", "3") )
                .body( "users.user.find{ it.age == 25 }.name", is("Maria Joaquina") )
                //.body( "users.user.findAll{ it.name.toString().contains('a')}.nome", hasItem("Maria Joaquina") )
                .body( "users.user.salary.find{it != null}.toDouble()", is(1234.5678d))
                .body( "users.user.age.collect{it.toInteger() * 2}", hasItems(40, 50, 60) )
                .body( "users.user.name.findAll{it.toString().startsWith('Maria')}.collect{it.toString().toUpperCase()}", is("MARIA JOAQUINA")  )
                ;

    }

    @Test
    public void devoFazerPesquisasAvancadasXMLJava() {

        ArrayList<NodeImpl> path = given()
                .when()
                .get( "/usersXML" )
                .then()
                .statusCode( 200 )
                .extract().path( "users.user.name.findAll{it.toString().contains('n')}")

                ;

        Assert.assertEquals(2, path.size() );
        Assert.assertEquals( "Maria Joaquina".toUpperCase(), path.get(0).toString().toUpperCase() );
        Assert.assertTrue( "Ana Julia".equalsIgnoreCase(path.get(1).toString()) );

        System.out.println( path.toString() );
    }

    @Test
    public void devoFazerPesquisasAvancadasComXpath() {

        given()
        .when()
                .get( "/usersXML" )
        .then().statusCode( 200 ).body( hasXPath( "count(/users/user)", is("3")))
                .body( hasXPath( "//user[@id = '1']" ) )
                .body( hasXPath( "//name[text() = 'Luizinho']/../../name", is("Ana Julia") ) )
                .body( hasXPath( "//name[text() = 'Ana Julia']/following-sibling::filhos", allOf( containsString( "Zezinho"), containsString("Luizinho" ) ) ) )
                .body( hasXPath( "/users/user/name", is("João da Silva")) )
                .body( hasXPath( "//name", is("João da Silva") ) )
                .body( hasXPath( "/users/user/name", is( "João da Silva" ) ) )
                .body( hasXPath( "/users/user[2]/name", is("Maria Joaquina") ) )
                //.body( hasXPath( "count(users/user/name[contains(.,'n')])", is("2") ) )
                .body( hasXPath( "//user[age < 24]/name", is( "Ana Julia" ) ) )
                .body( hasXPath( "//user[age > 20 and age < 30]/name", is( "Maria Joaquina" ) ) )


        ;
    }

}
