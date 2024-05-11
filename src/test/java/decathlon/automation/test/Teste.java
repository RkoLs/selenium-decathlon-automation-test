package decathlon.automation.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import decathlon.automation.executa.Executa;
import decathlon.automation.metodos.Metodos;

public class Teste {

    @BeforeEach
    public void setUp() {
        Executa.inicarTeste();
    }

    @AfterEach
    public void tearDown() {
        Executa.finalizarTeste();
    }

    @Test
    public void comprarProduto() {
        Metodos.pesquisarProduto();
        Metodos.aceitarCookies();
        Metodos.selecionarProduto();
        Metodos.selecionarTamanho();
        Metodos.adicionarAoCarrinho();
        Metodos.preencherCEP();
        Metodos.consultarCarrinho();
    }
}
