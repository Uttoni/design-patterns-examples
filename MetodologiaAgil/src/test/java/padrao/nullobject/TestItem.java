package padrao.nullobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestItem {
    
    @Test
    public void testSemDesconto(){
        Item i = new Item("tênis", 150);
        assertEquals(300, i.precoQuantidade(2), 0.001);
        assertEquals("tênis R$150.0", i.toString());
    }

    @Test
    public void testDescontoPercentual(){
        Item i = new Item("tênis", 150, new DescontoPercentual(10));
        assertEquals(270, i.precoQuantidade(2), 0.001);
        assertEquals("tênis R$135.0", i.toString());
    }

    @Test
    public void testDescontoAbsoluto(){
        Item i = new Item("tênis", 150, new DescontoAbsoluto(10));
        assertEquals(280, i.precoQuantidade(2), 0.001);
        assertEquals("tênis R$140.0", i.toString());
    }
}
