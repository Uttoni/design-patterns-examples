package padrao.builder;

public class GeradorNomeBuilder {

    private GeradorNome geradorNome;

    public GeradorNomeBuilder criarPessoa() {
        geradorNome = new GeradorNome();
        return this;
    }

    public GeradorNome gerar() {
        return geradorNome;
    }

    public GeradorNomeBuilder criarMestre() {
        geradorNome = new GeradorMestre();
        return this;
    }

    public GeradorNomeBuilder criarDoutor() {
        geradorNome = new GeradorDoutor();
        return this;
    }

    public GeradorNomeBuilder excelentissimo() {
        inserirNovoTratamento(new Excelentissimo());
        return this;
    }

    public GeradorNomeBuilder magnifico() {
        inserirNovoTratamento(new Maginifico());
        return this;
    }

    private void inserirNovoTratamento(Tratamento t) {
        if(geradorNome.getTratamentoStrategy() instanceof  TratamentoNull)
            geradorNome.setTratamento(t);
        else
            geradorNome.setTratamento(new TratamentoComposite(
                    geradorNome.getTratamentoStrategy(), t));
    }

    public GeradorNomeBuilder de(String origem) {
        geradorNome = new GeradorNomeProxyLocal(geradorNome, origem);
        return this;
    }
}
