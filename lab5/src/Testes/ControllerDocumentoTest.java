package Testes;

import DocuMin.ControllerDocumento;
import DocuMin.Documento;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerDocumentoTest {
    private ControllerDocumento controllerDocumento;

    @BeforeEach
    public void setUp(){
        this.controllerDocumento = new ControllerDocumento();
    }

    @Test
    @DisplayName("Quando quero criar um Documento com sucesso")
    public void testandoAdicionarDocumento(){
        assertTrue(controllerDocumento.criarDocumento("LP2"));
    }

    @Test
    @DisplayName("Quando quero criar um Documento com titulo ja existene")
    public void testandoAdicionarDocumento02(){
        assertTrue(controllerDocumento.criarDocumento("LP2"));
        assertFalse(controllerDocumento.criarDocumento("LP2"));
    }
}
