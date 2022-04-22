package projeto.comprasmock;

public class MockObservadorCarrinhoComProblema implements ObservadorCarrinho{

    @Override
    public void produtoAdicionado(String nome, int valor) {
        throw new RuntimeException("Problema simulado no mock classe separada pra erro");
    }
}
