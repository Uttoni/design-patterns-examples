package padrao.nullobject;

public class DescontoPercentual implements Desconto{

    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double darDesconto(double valorOriginal) {
        return valorOriginal * (100 - percentual) / 100;
    }
}
