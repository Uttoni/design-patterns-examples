package projeto.pilha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.pilha.Pilha;
import projeto.pilha.exceptions.PilhaCheiaException;
import projeto.pilha.exceptions.PilhaVaziaException;

import static org.junit.jupiter.api.Assertions.*;

public class TestePilha {

    Pilha p;

    public final PilhaVaziaException exception = new PilhaVaziaException("");

    @BeforeEach
    public void criaPilha(){
        p = new Pilha(10);
    }

    @Test
    public void pilhaVazia(){
        assertTrue(p.estaVazia());
        assertEquals(0, p.tamanho());
    }

    @Test
    public void empilhaUmElemento(){
        p.empilha("primeiro");
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
    }

    @Test
    public void empilhaEDesempilha(){
        p.empilha("primeiro");
        p.empilha("segundo");
        assertEquals(2, p.tamanho());
        assertEquals("segundo", p.topo());
        Object desempilhado = p.desempilha();
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
        assertEquals("segundo", desempilhado);
    }

    @Test
    public void removerDaPilhaVazia(){
        assertThrows(PilhaVaziaException.class,
            ()->{
                p.desempilha();
            });
    }

    @Test
    public void adicionarEmPilhaCheia(){
        assertThrows(PilhaCheiaException.class,
            ()->{
                for(int i=0; i<10; i++){
                    p.empilha("Elemento: " + i);
                }
                p.empilha("Ultimo elemento");
            });
    }
}
