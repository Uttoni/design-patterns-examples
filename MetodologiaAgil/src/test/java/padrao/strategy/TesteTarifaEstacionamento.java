package padrao.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteTarifaEstacionamento {
    @Test
    public void tarifaFixaPorHora(){
        TarifaEstacionamento te = new TarifaEstacionamento(3, new CalculoHora(4));
        int valor = te.valor();
        assertEquals(12, valor);
    }

    @Test
    public void tarifaComValorInicialDentroDoLimite(){
        TarifaEstacionamento te =
                new TarifaEstacionamento(2, new CalculoHoraValorInicial(5, 3, 2));
        int valor = te.valor();
        assertEquals(5, valor);
    }

    @Test
    public void tarifaDiaria(){
        TarifaEstacionamento te =
                new TarifaEstacionamento(50, new CalculoDiaria(20));
        int valor = te.valor();
        assertEquals(60, valor);
    }

    @Test
    public void tarifaDiariaMenorQueUmDia(){
        TarifaEstacionamento te =
                new TarifaEstacionamento(10, new CalculoDiaria(20));
        int valor = te.valor();
        assertEquals(20, valor);
    }
}
