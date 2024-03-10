package base;

import api.usuario.Usuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import lombok.Getter;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.*;
@Getter
public class BaseTest {
    private String token;

    @BeforeClass
    public void configuracaoAPI(){
        //configurando  os dados da API med
        baseURI = "http://localhost";
        //port = 8080;
        basePath = ":8080";
        RestAssured.defaultParser = Parser.JSON;
    }
    @BeforeEach
    public String getToken(){
        this.token =
            given()
                .contentType(ContentType.JSON)
                    .body(new Usuario("admin","admin"))
            .when()
                .post("/login")
            .then()
                .extract()
                    .path("data.token");
        return token;
    }




}
