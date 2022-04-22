import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarroSomaTest {

    CarroSoma c;

    @BeforeEach
    public void inicializar(){
        c = new CarroSoma("teste", 10, 100);
    }

    @Test
    public void carroParado(){
        inicializar();
        assertEquals(0, c.getVelocidade());
    }

    @Test
    public void acelerar(){
        inicializar();
        c.acelerar();
        assertEquals(10, c.getVelocidade());
    }

    @Test
    public void frear(){
        inicializar();
        c.acelerar();
        c.frear();
        assertEquals(5, c.getVelocidade());
    }

    @Test
    public void frearAteZero(){
        inicializar();
        c.acelerar();
        c.frear();
        c.frear();
        c.frear();
        c.frear();
        assertEquals(0, c.getVelocidade());
    }

    @Test
    public void acelerarAteMaximo(){
        for (int i = 0; i < 14; i++) {
            c.acelerar();
        }

        assertEquals(c.getVelocidade(), c.getVelocidadeMax());
    }
}