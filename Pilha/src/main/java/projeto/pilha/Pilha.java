package projeto.pilha;

import projeto.pilha.exceptions.PilhaCheiaException;
import projeto.pilha.exceptions.PilhaVaziaException;

public class Pilha {
    

    private Object elementos[];
    private int quantidade;

    public Pilha(int tamanho) {
        elementos = new Object[tamanho];
    }

    public boolean estaVazia() {
        return (quantidade == 0);
    }

    public Object tamanho() {
        return quantidade;
    }

    public void empilha(Object elemento) {
        if(quantidade == elementos.length)
            throw new PilhaCheiaException("projeto.pilha.Pilha cheia, impossível empilhar novo elemento");

        elementos[quantidade] = elemento;
        quantidade++;
    }

    public Object topo() {
        return elementos[quantidade-1];
    }

    public Object desempilha() {
        if(quantidade == 0)
            throw new PilhaVaziaException("Não é possível desempilhar uma pilha vazia");

        Object topo = topo();
        quantidade--;
        return topo;
    }
}
