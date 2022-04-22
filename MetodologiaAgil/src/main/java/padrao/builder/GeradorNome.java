package padrao.builder;

public class GeradorNome {

    private Tratamento tratamento = new TratamentoNull();

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    public String gerarNome(String nomeBase){
        return tratamento.tratar() + getTratamento() + nomeBase;
    }

    protected Tratamento getTratamentoStrategy(){
        return tratamento;
    }

    protected String getTratamento(){
        return "";
    }
}
