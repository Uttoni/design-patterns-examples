package projeto.tradutor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteTradutor {

    Tradutor t;

    @BeforeEach
    public void criarTradutor(){
        t = new Tradutor();
    }

    @Test
    public void traduzirSemPalavras(){
        assertTrue(t.estaVazio());
    }

    @Test
    public void fazerUmaTraducao(){
        t.adicionarTraducao("bom", "good");
        assertFalse(t.estaVazio());
        assertEquals("good", t.traduzir("bom"));
    }

    @Test
    public void fazerDuasTraducoes(){
        t.adicionarTraducao("bom", "good");
        t.adicionarTraducao("ruim", "bad");
        assertFalse(t.estaVazio());
        assertEquals("good", t.traduzir("bom"));
        assertEquals("bad", t.traduzir("ruim"));
    }

    @Test
    public void fazerDuasTraducoesIguais(){
        t.adicionarTraducao("bom", "good");
        t.adicionarTraducao("bom", "nice");
        assertFalse(t.estaVazio());
        assertEquals("good, nice", t.traduzir("bom"));
    }

    @Test
    public void traduzirFrase(){
        t.adicionarTraducao("guerra", "war");
        t.adicionarTraducao("é", "is");
        t.adicionarTraducao("ruim", "bad");
        assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
    }

    @Test
    public void traduzirFraseComDuasTraducoesMesmaPalavra(){
        t.adicionarTraducao("paz", "peace");
        t.adicionarTraducao("é", "is");
        t.adicionarTraducao("bom", "good");
        t.adicionarTraducao("bom", "nice");
        assertEquals("peace is good", t.traduzirFrase("paz é bom"));
    }
}
