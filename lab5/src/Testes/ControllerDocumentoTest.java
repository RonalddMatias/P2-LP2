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
    public void testandoAdicionarDocumento01(){
        assertTrue(controllerDocumento.criarDocumento("LP2"));
    }

    @Test
    @DisplayName("Quando quero criar um Documento com titulo ja existente")
    public void testandoAdicionarDocumento02(){
        controllerDocumento.criarDocumento("LP2");
        assertFalse(controllerDocumento.criarDocumento("LP2"));
    }

    @Test
    @DisplayName("Quando quero criar um Documento com o tamanho definido")
    public void testandoAdicionarDocumento03(){
        assertTrue(controllerDocumento.criarDocumento("LOAC", 5));
    }

    @Test
    @DisplayName("Quando quero criar um documento com um mesmo nome existente, porém, com a quantidade maxima diferente.")
    public void testandoAdicionarDocumento04(){
        assertTrue(controllerDocumento.criarDocumento("LOAC", 5));
        assertFalse(controllerDocumento.criarDocumento("LOAC", 10));
    }


    @Test
    @DisplayName("Quando quero remover Documento com sucesso")
    public void testandoRemoverDocumento01(){
        controllerDocumento.criarDocumento("P2");
        controllerDocumento.removerDocumento("P2");
        assertEquals(0, controllerDocumento.quantidadeDeDocumetos());
    }

    @Test
    @DisplayName("Quando quero remover Documento que não existe")
    public void testandoRemoverDocumento02(){
        controllerDocumento.criarDocumento("P2");
        controllerDocumento.removerDocumento("P2");
        assertEquals(0, controllerDocumento.quantidadeDeDocumetos());
    }

