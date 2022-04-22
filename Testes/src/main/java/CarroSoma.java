public class CarroSoma extends CarroDeCorrida{

    private int potencia;

    public CarroSoma(String nome, int potencia, int velocidadeMax) {
        super(velocidadeMax, nome);
        this.potencia = potencia;
    }

    @Override
    public void acelerar(){
        velocidade += potencia;
        if(velocidade>velocidadeMax){
            velocidade = velocidadeMax;
        }
    }


    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
}
