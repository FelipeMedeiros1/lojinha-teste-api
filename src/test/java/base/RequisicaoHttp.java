package base;

import io.restassured.http.ContentType;

import static api.produto.ProdutoConfig.getUriProduto;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RequisicaoHttp {

    public <T>void cadastrar(String uri, T objeto, String msg, int statusCode){
        given()
                .contentType(ContentType.JSON)
                .header("token",new BaseTest().getToken())
                .body(objeto)
        .when()
                .post(uri)
        .then()
        .   assertThat()
                .body("mensagem:",equalTo(msg)).statusCode(statusCode);
    }

    public void buscarTodos(String uri, String msg) {
        given()
                .contentType(ContentType.JSON)
                .header("token", new BaseTest().getToken())
        .when()
                .get(uri)
        .then()
                .body("mensagem:",equalTo(msg)).statusCode(200);
    }
    public void buscarPorId(String uri, int id, String msg) {
        given()
                .contentType(ContentType.JSON)
                .header("token", new BaseTest().getToken())
        .when()
                .get(uri + "/" + id)
        .then()
                .body("mensagem:",equalTo(msg)).statusCode(200);
    }

    public <T>void atualizar (String uri,T objeto,String msg, int statusCode){
        given()
                .contentType(ContentType.JSON)
                .header("token",new BaseTest().getToken())
                .body(objeto)
        .when()
                .put(getUriProduto())
        .then()
                .assertThat()
                    .body("mensagem:",equalTo(msg)).statusCode(statusCode);
    }
        public void deletarPorId(String uri, String id, int statusCode) {
            given()
                    .contentType(ContentType.JSON)
                    .header("token", new BaseTest().getToken())
             .when()
                    .delete(uri + "/" + id)
            .then()
                .assertThat()
                    .body("mensagem:", equalTo("Ecluido com Sucesso!")).statusCode(statusCode);
        }

    public void login(String uri, String login, String senha) {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"login\": \"" + login + "\", \"senha\": \"" + senha + "\" }")
        .when()
                .post(uri)
        .then()
                .statusCode(200);
    }
}
