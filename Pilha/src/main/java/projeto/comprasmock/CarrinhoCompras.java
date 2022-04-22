package projeto.comprasmock;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

    private List<Produto> produtos = new ArrayList<>();
    private List<ObservadorCarrinho> observadores = new ArrayList<>();

    public void addProduto(Produto p){
        produtos.add(p);
        for(ObservadorCarrinho observador: observadores)
            try {
                observador.produtoAdicionado(p.getNome(), p.getValor());
            }catch(Exception e){
                System.out.println(e);
            }
    }

    public int total(){
        int total = 0;
        for (Produto p: produtos)
            total += p.getValor();

        return total;
    }

    public void adicionarObservador(ObservadorCarrinho observador) {
        observadores.add(observador);
    }
}
