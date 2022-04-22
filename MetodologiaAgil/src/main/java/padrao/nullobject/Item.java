package padrao.nullobject;

public class Item {

    private String nome;
    private double valor;
    private Desconto desconto = new DescontoNull();

    public Item(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Item(String nome, double valor, Desconto desconto) {
        this.nome = nome;
        this.valor = valor;
        this.desconto = desconto;
    }

    @Override
    public String toString(){
        return nome + " R$" + desconto.darDesconto(valor);
    }

    public double precoQuantidade(int qtd) {
        if(desconto != null)
            return desconto.darDesconto(valor) * qtd;
        else
            return valor * qtd;
    }
}
