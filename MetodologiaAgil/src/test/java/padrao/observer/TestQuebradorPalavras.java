package padrao.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuebradorPalavras {

    @Test
    public void quebrarPalavras(){
        String frase = "O rato roeu a roupa do rei";
        QuebradorPalavras quebrador = new QuebradorPalavras();
        String palavras[] = quebrador.quebrar(frase);
        assertEquals(7, palavras.length);
    }

    @Test
    public void contadorSimples(){
        String frase = "O rato roeu a roupa do rei de Roma";
        QuebradorPalavras quebrador = new QuebradorPalavras();
        quebrador.adicionaContador("SIMPLES", new ContadorSimples());
        quebrador.quebrar(frase);
        assertEquals(9, quebrador.getContagem("SIMPLES"));
    }

    @Test
    public void contadorMaiuscula(){
        String frase = "O Rato Roeu a Roupa do Rei de Roma";
        QuebradorPalavras quebrador = new QuebradorPalavras();
        quebrador.adicionaContador("MAIUSCULA", new ContadorMaiuscula());
        quebrador.quebrar(frase);
        assertEquals(6, quebrador.getContagem("MAIUSCULA"));
    }

    @Test
    public void contadorPares(){
        String frase = "O Rato Roeu a Roupa do Rei de Roma";
        QuebradorPalavras quebrador = new QuebradorPalavras();
        quebrador.adicionaContador("PARES", new ContadorPares());
        quebrador.quebrar(frase);
        assertEquals(5, quebrador.getContagem("PARES"));
    }

    @Test
    public void contadorIntegrado(){
        String frase = "O Rato Roeu a Roupa do Rei de Roma";
        QuebradorPalavras quebrador = new QuebradorPalavras();
        quebrador.adicionaContador("SIMPLES", new ContadorSimples());
        quebrador.adicionaContador("MAIUSCULA", new ContadorMaiuscula());
        quebrador.adicionaContador("PARES", new ContadorPares());
        quebrador.quebrar(frase);
        assertEquals(9, quebrador.getContagem("SIMPLES"));
        assertEquals(6, quebrador.getContagem("MAIUSCULA"));
        assertEquals(5, quebrador.getContagem("PARES"));
    }
}
