package api.componente;

import lombok.Data;


public class Componente {
    private String nome;
    private int quantidade;

    public Componente(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }
}
