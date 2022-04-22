package padrao.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeradorNomeTest {

    @Test
    public void gerarNomeBase(){
        GeradorNome gerador = new GeradorNomeBuilder()
                .criarPessoa().gerar();
        String nomeGerado = gerador.gerarNome("Eduardo");
        assertEquals("Eduardo", nomeGerado);
    }

    @Test
    public void gerarMestre(){
        GeradorNome gerador = new GeradorNomeBuilder()
                .criarMestre().gerar();
        String nomeGerado = gerador.gerarNome("Eduardo");
        assertEquals("Mestre Eduardo", nomeGerado);
    }

    @Test
    public void gerarDoutor(){
        GeradorNome gerador = new GeradorNomeBuilder()
                .criarDoutor().gerar();
        String nomeGerado = gerador.gerarNome("Eduardo");
        assertEquals("Doutor Eduardo", nomeGerado);
    }

    @Test
    public void gerarExcelentissimoDoutor(){
        GeradorNome gerador = new GeradorNomeBuilder()
                .criarDoutor().excelentissimo().gerar();
        String nomeGerado = gerador.gerarNome("Eduardo");
        assertEquals("Excelentíssimo Doutor Eduardo", nomeGerado);
    }

    @Test
    public void gerarMagnificoMestre(){
        GeradorNome gerador = new GeradorNomeBuilder()
                .criarMestre().magnifico().gerar();
        String nomeGerado = gerador.gerarNome("Eduardo");
        assertEquals("Magnífico Mestre Eduardo", nomeGerado);
    }

    @Test
    public void gerarExcelentissimoMagnificoMestre(){
        GeradorNome gerador = new GeradorNomeBuilder()
                .criarMestre().excelentissimo().magnifico().gerar();
        String nomeGerado = gerador.gerarNome("Eduardo");
        assertEquals("Excelentíssimo Magnífico Mestre Eduardo", nomeGerado);
    }

    @Test
    public void gerarPessoaDe(){
        GeradorNome gerador = new GeradorNomeBuilder()
                .criarPessoa().de("Pouso Alegre").gerar();
        String nomeGerado = gerador.gerarNome("Eduardo");
        assertEquals("Eduardo de Pouso Alegre", nomeGerado);
    }

    @Test
    public void gerarExcelentissimoMagnificoDoutorDe(){
        GeradorNome gerador = new GeradorNomeBuilder()
                .criarDoutor().excelentissimo().magnifico().de("São José").gerar();
        String nomeGerado = gerador.gerarNome("Eduardo");
        assertEquals("Excelentíssimo Magnífico Doutor Eduardo de São José", nomeGerado);
    }
}