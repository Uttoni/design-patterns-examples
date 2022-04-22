package padrao.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestProxySeguranca {

    @Test
    public void testAutorizaAcesso(){
        Usuario u = new Usuario("uttoni");
        u.autorizaAcesso("InterfaceNegocio", "executaTransacao");
        NegocioMock mock = new NegocioMock();
        InterfaceNegocio negocio = new SegurancaNegocio(mock, u);
        negocio.executaTransacao();
        assertTrue(mock.foiAcessado());
    }

    @Test
    public void testNaoAutorizaAcesso(){
        Usuario u = new Usuario("uttoni");
        u.autorizaAcesso("InterfaceNegocio", "executaTransacao");
        NegocioMock mock = new NegocioMock();
        InterfaceNegocio negocio = new SegurancaNegocio(mock, u);
        try{
            negocio.cancelaTransacao();
            fail();
        }catch (Exception e){
            assertFalse(mock.foiAcessado());
        }
    }
}
