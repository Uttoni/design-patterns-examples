public abstract class CarroDeCorrida{


    protected int velocidadeMax;
    protected String nome;
    protected int velocidade;

    public CarroDeCorrida(int velocidadeMax, String nome) {
        this.velocidadeMax = velocidadeMax;
        this.nome = nome;
    }

    public abstract void acelerar();

    public void frear(){
        velocidade = velocidade/2;
    }

    public void imprimir() {
        System.out.println("O carro  " + nome + " está a " + velocidade + " km por hr");
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setVelocidadeMax(int velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
