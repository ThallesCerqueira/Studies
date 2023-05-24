package br.ce.realguard.rest;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

public class FileTest {

    @Test
    public void deveObrigarEnvioArquivo() {

        given()
                .log().all()
                .multiPart("arquivo", new File("src/main/resources/users.pdf"))
        .when()
                .post("http://restapi.wcaquino.me/upload")
        .then()
                .log().all()
                .statusCode(200)

                ;

    }

    @Test
    public void NaoDeveEnviarArquivo() {

        given()
                .log().all()
                .multiPart("arquivo", new File("src/main/resources/arquivoAcima1Mega.pdf"))
                .when()
                .post("http://restapi.wcaquino.me/upload")
                .then()
                .log().all()
                .time(lessThan(5000L))
                .statusCode(413)

        ;

    }

    @Test
    public void deveBaixarArquivo() throws IOException {

        byte[] image = given()
                .log().all()
        .when()
                .get("http://restapi.wcaquino.me/download")
        .then()
                .statusCode(200)
                .extract().asByteArray()

                ;

        File imagem = new File("src/main/resources/file.jpeg");
        OutputStream out = new FileOutputStream(imagem);
        out.write(image);
        out.close();

        System.out.println(imagem.length());

        Assert.assertThat(imagem.length(), lessThan(100000L));
    }


}
