package projeto.comprasmock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockObservadorCarrinho implements ObservadorCarrinho{

    private String nomeRecebido;
    private int valorRecebido;
    private boolean daErro = false;

    @Override
    public void produtoAdicionado(String nome, int valor) {
        if(daErro)
            throw new RuntimeException("Problema simulado no mock");
        nomeRecebido = nome;
        valorRecebido = valor;
    }

    public void verificarRecebimentoProduto(String nomeEsperado, int valorEsperado) {
        assertEquals(nomeEsperado, nomeRecebido);
        assertEquals(valorEsperado, valorRecebido);
    }

    public void darErro() {
        daErro = true;
    }
}
