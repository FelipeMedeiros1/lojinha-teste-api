package api.componente;

import base.BaseTest;
import base.RequisicaoHttp;
import io.restassured.http.ContentType;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static api.componente.ComponenteConfig.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Teste de API Rest do módulo de Componente")
public class ComponenteTest extends BaseTest {
    @Test
    @DisplayName("Adicionar um novo Componente ao Produto")
    public void testAdicionarComponente() {

        given()
                .contentType(ContentType.JSON)
                .header("token", getToken())
                .body(new Componente("novoComponente", 1))
                .when()
                .post(getUriComponente(), getProdutoId())
                .then()
                .assertThat()
                .body("message", equalTo(getMensagemComponenteCadastradoComSucesso()))
                .statusCode(201);
    }

    @Test
    @DisplayName("Buscar todos Compnentes do Produto")
    public void testBuscarDadosComponente() {
        new RequisicaoHttp().buscarTodos(getUriBuscarComponente(), getMensagemBuscaComponenteSucesso());
    }

    @Test
    @DisplayName("Buscar Componente por Id")
    public void testBuscarComponentePorId() {
        new RequisicaoHttp().buscarPorId(getUriBuscarComponentePorId(), 219383, getMensagemBuscaComponentePorIdSucesso());
    }
}
