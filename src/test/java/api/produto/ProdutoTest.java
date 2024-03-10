package api.produto;

import api.componente.Componente;
import base.BaseTest;
import base.RequisicaoHttp;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static api.produto.ProdutoConfig.getMensagemDeBusca;
import static api.produto.ProdutoConfig.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Teste de API Rest do módulo de Produto")
public class ProdutoTest extends BaseTest {

    @Test
    @DisplayName("Validar que o valor 0.00 não é permitido")
    public void cenario01() {
        var produto = new Produto(
                "produtoTeste", 0, new String[]{"Branco,Preto"}, "", new Componente("bateria",1));
        new RequisicaoHttp().cadastrar(getUriProduto(), produto, getMensagemProdutoErro(), 422);
    }

    @Test
    @DisplayName("Validar que o valor 7000.01 não é permitido ")
    public void cenario02() {
        var produto = new Produto("produtoTeste", 7000.01, new String[]{"Branco,Preto"}, "", new Componente("bateria",1));
        new RequisicaoHttp().cadastrar(getUriProduto(), produto, getMensagemProdutoErro(), 422);
    }

    @Test
    @DisplayName("Cadastrar Produto")
    public void cenario03() {

        var produto = new Produto("Notebook 2024", 7000, new String[]{"Branco,Preto"}, "", new Componente("bateria",1));
        new RequisicaoHttp().cadastrar(getUriProduto(), produto, getMensagemProdutoSucesso(), 201);
    }
    @Test
    @DisplayName("Buscar todos os Produtoos cadastrados")
    public void cenario04() {
        new RequisicaoHttp().buscarTodos(getUriProduto(), getMensagemDeBusca());
    }

    @Test
    @DisplayName("Buscar Produto por Id")
    public void cenario05() {
        new RequisicaoHttp().buscarPorId(getUriProdutoId(), 200466, getMensagemDeBusca());
    }

    @Test
    @DisplayName("Remover um Produto por Id")
    public void cenario06() {
        new RequisicaoHttp().deletarPorId(getUriDeletarProduto(), "165557", 404);
    }


}
