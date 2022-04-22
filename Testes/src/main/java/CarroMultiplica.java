public class CarroMultiplica extends CarroDeCorrida{

    private double potencia;

    public CarroMultiplica(String nome, double potencia, int velocidadeMax) {
        super(velocidadeMax, nome);
        if(potencia >= 1 && potencia <= 2){
            this.potencia = potencia;
        }else{
            this.potencia = 1.5;
        }
    }

    @Override
    public void acelerar() {
        if(velocidade==0)
            velocidade=10;

        velocidade *= potencia;
        if(velocidade>velocidadeMax){
            velocidade = velocidadeMax;
        }
    }
}
