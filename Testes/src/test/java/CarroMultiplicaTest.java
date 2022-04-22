import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarroMultiplicaTest {
    CarroMultiplica c;

    @BeforeEach
    public void inicializar(){
        c = new CarroMultiplica("teste", 1.5, 100);
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
        assertEquals(15, c.getVelocidade());
    }

    @Test
    public void frear(){
        inicializar();
        c.acelerar();
        c.frear();
        assertEquals(7, c.getVelocidade());
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