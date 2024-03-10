package api.produto;

public class ProdutoConfig {

    public static String getUriProduto() {
        return "/v2/produtos";
    }

    public static String getUriDeletarProduto() {
        return "/v2/produtos/{produtoId }";
    }

    public static String getUriProdutoId() {
        return "/v2/produtos/{produtoId}";
    }

    public static String getMensagemProdutoErro() {
        return "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00";
    }

    public static String getMensagemProdutoSucesso() {
        return "Produto adicionado com sucesso";
    }

    public static String getMensagemDeBusca() {
        return "Listagem de produtos realizada com sucesso";
    }

}
