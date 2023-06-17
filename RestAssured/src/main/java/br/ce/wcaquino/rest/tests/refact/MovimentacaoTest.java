package br.ce.wcaquino.rest.tests.refact;

import br.ce.wcaquino.rest.core.BaseTest;
import br.ce.wcaquino.rest.tests.Movimentacao;
import br.ce.wcaquino.rest.utils.BarrigaUtils;
import br.ce.wcaquino.rest.utils.DateUtils;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MovimentacaoTest extends BaseTest {

    @Test
    public void deveInserirUmaMovimentacaoComSucesso() {

        Movimentacao mov = getMovimentacao();

        given()
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
    public void naoDeveInserirUmaMovimentacaoComDataFutura() {

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

    @Test
    public void naoDeveRemoverContaComMovimentacao() {

        Integer CONTA_ID = BarrigaUtils.getIdDaContaPeloNome( "Conta com movimentacao" );
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
    public void deverRemoverMovimentacao() {

        Integer MOV_ID = BarrigaUtils.getIdMovimentacaoPeloNome( "Movimentacao para exclusao" );

        given()
                .pathParam("id", MOV_ID)
        .when()
                .delete( "/transacoes/{id}" )
        .then()
                .statusCode( 204 )
        ;

    }

    private Movimentacao getMovimentacao() {
        Movimentacao mov = new Movimentacao();

        mov.setConta_id( BarrigaUtils.getIdDaContaPeloNome("Conta para movimentacoes") );
        mov.setDescricao( "Descrição da movimentação." );
        mov.setEnvolvido( "Envolvido na mov" );
        mov.setTipo( "REC" );
        mov.setData_transacao( DateUtils.getDataDiferencaDias(-1) );
        mov.setData_pagamento( DateUtils.getDataDiferencaDias( 5 ) );
        mov.setValor( 100f );
        mov.setStatus( true );

        return mov;
    }


}
