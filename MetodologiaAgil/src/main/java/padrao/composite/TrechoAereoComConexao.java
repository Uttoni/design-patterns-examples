package padrao.composite;

public class TrechoAereoComConexao extends TrechoAereoComEscala {

    private int custoConexao;

    public TrechoAereoComConexao(TrechoAereo t1, TrechoAereo t2, int custoConexao) {
        super(t1, t2);
        this.custoConexao = custoConexao;
    }

    @Override
    public int getCusto() {
        return t1.getCusto() + t2.getCusto() + custoConexao;
    }
}
