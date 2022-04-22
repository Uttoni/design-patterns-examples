package projeto.comprasmock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteCarrinhoCompras {

    CarrinhoCompras carrinho;

    @BeforeEach
    public void iniciarCarrinho(){
         carrinho = new CarrinhoCompras();
    }

    @Test
    public void totalCarrinho(){

        carrinho.addProduto(new Produto("tênis", 100));
        carrinho.addProduto(new Produto("camiseta", 50));
        carrinho.addProduto(new Produto("bermuda", 70));
        assertEquals(220, carrinho.total());
    }

    @Test
    public void escutaAdicaoDeProduto(){
        MockObservadorCarrinho mock = new MockObservadorCarrinho();
        carrinho.adicionarObservador(mock);
        carrinho.addProduto(new Produto("tênis", 100));
        mock.verificarRecebimentoProduto("tênis", 100);
    }

    @Test
    public void adicionarDoisObservadores(){
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
        carrinho.adicionarObservador(mock1);
        carrinho.adicionarObservador(mock2);
        carrinho.addProduto(new Produto("tênis", 100));
        mock1.verificarRecebimentoProduto("tênis", 100);
        mock2.verificarRecebimentoProduto("tênis", 100);
    }

    @Test
    public void continuaNotificandoComErroEmObservador(){
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
        mock2.darErro();
        ObservadorCarrinho mock3 = new MockObservadorCarrinhoComProblema();
        carrinho.adicionarObservador(mock1);
        carrinho.adicionarObservador(mock2);
        carrinho.adicionarObservador(mock3);
        carrinho.addProduto(new Produto("tênis", 100));
        mock1.verificarRecebimentoProduto("tênis", 100);
    }
}
