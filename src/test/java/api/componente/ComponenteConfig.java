package api.componente;

public class ComponenteConfig {

    public static String getProdutoId() {
        return "200603";
    }

    public static String getUriComponente() {
        return "/v2/produtos/{produtoId}/componentes";
    }

    public static String getUriDeletarComponente() {
        return "/v2/produtos/{produtoId}/componentes/{componenteId}";
    }

    public static String getUriBuscarComponente() {
        return "/v2/produtos/{produtoId}/componentes";
    }

    public static String getUriBuscarComponentePorId() {
        return "/v2/produtos/{produtoId}/componentes/{componenteId}";
    }

    public static String getMensagemComponenteCadastradoComSucesso() {
        return "Componente de produto adicionado com sucesso";
    }

    public static String getMensagemBuscaComponenteSucesso() {
        return "Listagem de componentes de produto realizada com sucesso";
    }

    public static String getMensagemBuscaComponentePorIdSucesso() {
        return "Detalhando dados do componente de produto";
    }

    public static String getMensagemDeletarComponente() {
        return "Detalhando dados do componente de produto";
    }

}
