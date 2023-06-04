package Testes;

import DocuMin.ControllerDocumento;
import DocuMin.Documento;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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
        assertThrows(NoSuchElementException.class, () -> controllerDocumento.removerDocumento("MODELAGEM"));
        controllerDocumento.removerDocumento("P2");
    }

    @Test
    @DisplayName("Adicionando o elemento Titulo ao Documento")
    public void testandoAdicionarTitulo01(){
        controllerDocumento.criarDocumento("Cálculo I");
        assertEquals(0, controllerDocumento.criarTitulo("Cálculo I", "Flamengo até morrer", 4, 3,true));
    }
    @Test
    @DisplayName("Adicionando o elemento Titulo ao Documento inexistente")
    public void testandoAdicionarTitulo02(){
        controllerDocumento.criarDocumento("Cálculo I");
        assertThrows(NoSuchElementException.class,() -> controllerDocumento.criarTitulo("PLP", "Flamengo até morrer", 4, 3,true));
    }

    @Test
    @DisplayName("Adicionando o elemento Titulo a um Documento, porém, com a prioridade acima de 5 e menor que 1")
    public void testandoAdicionarTitulo03(){
        controllerDocumento.criarDocumento("Cálculo I");
        assertThrows(IllegalArgumentException.class,() -> controllerDocumento.criarTitulo("Cálculo I", "Flamengo até morrer", 6, 3,true));
        assertThrows(IllegalArgumentException.class,() -> controllerDocumento.criarTitulo("Cálculo I", "Flamengo até morrer", -1, 3,false));
    }

    @Test
    @DisplayName("Adicionando o elemento Titulo a um Documento, porém, com o nivel acima de 5 e menor que 1")
    public void testandoAdicionarTitulo04(){
        controllerDocumento.criarDocumento("Cálculo I");
        assertThrows(IllegalArgumentException.class,() -> controllerDocumento.criarTitulo("Cálculo I", "Flamengo até morrer", 4, 9,false));
        assertThrows(IllegalArgumentException.class,() -> controllerDocumento.criarTitulo("Cálculo I", "Flamengo até morrer", 3, -2,true));
    }

    @Test
    @DisplayName("Adicionando o elemento Texto ao Documento")
    public void testandoAdicionarTexto01(){
        controllerDocumento.criarDocumento("FMCC2");
        assertEquals(0, controllerDocumento.criarTexto("FMCC2", "P2 é uma boa cadadeira", 2));
    }
    @Test
    @DisplayName("Adicionando o elemento Texto a um Documento inexistente")
    public void testandoAdicionarTexto02(){
        controllerDocumento.criarDocumento("FMCC2");
        assertThrows(NoSuchElementException.class,() -> controllerDocumento.criarTexto("CALCULO II", "P2 é uma boa cadadeira", 2));
    }
    @Test
    @DisplayName("Adicionando o elemento lista ao Documento")
    public void testandoAdicionarlista01(){
        controllerDocumento.criarDocumento("BD");
        assertEquals(0, controllerDocumento.criarLista("BD", "LP2 é uma boa apoteótica", 4, "|", "-"));
    }

    @Test
    @DisplayName("Adicionando o elemento lista a um Documento Inexistente")
    public void testandoAdicionarlista02(){
        controllerDocumento.criarDocumento("BD");
        assertThrows(NoSuchElementException.class,() ->  controllerDocumento.criarLista("BDS", "LP2 é uma boa apoteótica", 4, "|", "-"));
    }

    @Test
    @DisplayName("Adicionando o elemento Termo ao Documento")
    public void testandoAdicionarTermos01(){
        controllerDocumento.criarDocumento("Teoria da Computacao");
        assertEquals(0, controllerDocumento.criarTermo("Teoria da Computacao", "Programar é bom", 2, "/", "ALFABÉTICA"));
    }
    @Test
    @DisplayName("Adicionando o elemento Termo a um Documento inexistente")
    public void testandoAdicionarTermos02(){
        controllerDocumento.criarDocumento("Teoria da Computacao");
        assertThrows(NoSuchElementException.class,() -> controllerDocumento.criarTermo("JDK", "Programar é bom", 2, "/", "ALFABÉTICA"));
    }

    @Test
    @DisplayName("Cotando elementos de um Documento")
    public void testandoContandoTermos(){
        controllerDocumento.criarDocumento("TCC");
        controllerDocumento.criarTermo("TCC", "TCC é ruim de fazer", 3, "/", "ALFABÉTICA");
        controllerDocumento.criarTexto("TCC", "Programacao Basica", 4);
        controllerDocumento.criarTitulo("TCC", "Flamengo é paixão", 4, 3, true);
        assertEquals(3, controllerDocumento.contarElementos("TCC"));
    }

    @Test
    @DisplayName("Criando atalho pra um Documento")
    public void testandoAtalho01(){
        controllerDocumento.criarDocumento("PP");
        controllerDocumento.criarDocumento("PLP");
        controllerDocumento.criarTexto("PLP", "Cadeira muito boa", 3);
        controllerDocumento.criarTexto("PLP", "Programacao extra", 2);
        assertEquals(2, controllerDocumento.criarAtalho("PP", "PLP"));
    }
    @Test
    @DisplayName("Criando atalho pra um Documento, mas o documento referenciado ja tem um atalho")
    public void testandoAtalho02(){
        controllerDocumento.criarDocumento("PP");
        controllerDocumento.criarDocumento("PLP");
        Documento documento = controllerDocumento.pegarDocumentoEspecifico("PLP");
        documento.setTemAtalho(true);
        controllerDocumento.criarTexto("PLP", "Cadeira muito boa", 3);
        controllerDocumento.criarTexto("PLP", "Programacao extra", 2);
        assertThrows(IllegalArgumentException.class,()-> controllerDocumento.criarAtalho("PP", "PLP"));
    }

}

