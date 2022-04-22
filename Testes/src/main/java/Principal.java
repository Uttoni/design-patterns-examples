public class Principal {
    public static void main(String[] args) {
        Pessoa p = new Pessoa(3);
        Pessoa.coisa = "Isso aí";

        Corrida corrida = new Corrida(2000);
        corrida.addCarro(new CarroSoma("Carro A", 10, 110));
        corrida.addCarro(new CarroSoma("Carro B", 8, 140));
        corrida.addCarro(new CarroMultiplica("Carro C", 1.4, 110));
        corrida.addCarro(new CarroMultiplica("Carro D", 1.7, 100));

        corrida.iniciarCorrida();
    }
}
