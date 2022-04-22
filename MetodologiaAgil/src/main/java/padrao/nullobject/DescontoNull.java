package padrao.nullobject;

public class DescontoNull implements Desconto{
    @Override
    public double darDesconto(double valorOriginal) {
        return valorOriginal;
    }
}
