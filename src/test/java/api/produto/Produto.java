package api.produto;

import lombok.Data;
import api.componente.Componente;

import java.util.List;
@Data
public class Produto {
    private String nome;
    private double valor;
    private String[] cores;
    private String urlMock;
    private Componente componente;

    public Produto(String nome, double valor, String[] cores, String urlMock, Componente componente) {
        this.nome = nome;
        this.valor = valor;
        this.cores = cores;
        this.urlMock = urlMock;
        this.componente = componente;
    }
}

