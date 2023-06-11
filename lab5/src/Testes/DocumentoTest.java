package Testes;

import DocuMin.ControllerDocumento;
import DocuMin.Documento;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentoTest {
    private Documento documento;
    private ControllerDocumento controllerDocumento;

    @BeforeEach
    public void setUp(){
        this.documento = new Documento("Documento1");
        this.controllerDocumento = new ControllerDocumento();
    }

    @Test
    public void calcularMediaPrioridade(){
        controllerDocumento.criarDocumento("doc2");
        controllerDocumento.criarTexto("doc2", "doc2 é dificil", 4);
        controllerDocumento.criarTexto("doc2", "doc2 é facil", 4);
        assertEquals(4, documento.calculaMediaElementos());

    }
}
