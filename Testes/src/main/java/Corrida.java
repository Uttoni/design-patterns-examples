import java.util.HashMap;

public class Corrida {

    private int pista;
    HashMap<CarroDeCorrida, Integer> carros = new HashMap<>();
    
    public Corrida(int pista){
        this.pista = pista;
    }

    public void addCarro(CarroDeCorrida carro){
        carros.put(carro, 0);
    }
    
    private boolean terminou(){
        for (Integer posicao: carros.values()) {
            if(posicao>=pista)
                return true;
        }

        return false;
    }

    public void iniciarCorrida(){
        while(!terminou()) {
            for (CarroDeCorrida carro : carros.keySet()) {
                carro.acelerar();
                int distancia = carros.get(carro);
                distancia += carro.getVelocidade();
                carros.put(carro, distancia);
            }
        }

        for (CarroDeCorrida carro: carros.keySet()) {
            System.out.println(carro.getNome() + " - " + carros.get(carro));
        }
    }
}
