package Testes;

import DocuMin.ControllerDocumento;
import DocuMin.ControllerVisao;
import DocuMin.Documento;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe que representa testes do documentoController
 *
 * @author Ronaldd Matias - 122110574
 */
public class ControllerDocumentoTest {
    private ControllerDocumento controllerDocumento;
    private ControllerVisao controllerVisao;

    @BeforeEach
    public void setUp(){
        this.controllerDocumento = new ControllerDocumento();
        this.controllerVisao = new ControllerVisao();
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
        controllerDocumento.criarTexto("PLP", "Cadeira muito boa", 3);
        controllerDocumento.criarTexto("PLP", "Programacao extra", 2);
        controllerDocumento.criarAtalho("PP", "PLP");
        assertThrows(IllegalArgumentException.class,()-> controllerDocumento.criarAtalho("PP", "PLP"));
    }

    @Test
    @DisplayName("Criando atalho pra um Documento, mas o primeiro documento ja tem tem um atalho")
    public void testandoAtalho03(){
        controllerDocumento.criarDocumento("PP");
        controllerDocumento.criarDocumento("PLP");
        controllerDocumento.criarDocumento("FMCC1");
        controllerDocumento.criarTexto("PLP", "Cadeira muito boa", 3);
        controllerDocumento.criarTexto("PLP", "Programacao extra", 2);
        controllerDocumento.criarTexto("FMCC1", "uma cadeira muito legal", 4);
        controllerDocumento.criarAtalho("PP", "FMCC1");
        assertThrows(IllegalArgumentException.class,()-> controllerDocumento.criarAtalho("PP", "PLP"));
    }

    @Test
    @DisplayName("Criando atalho para um documento que não possui elementos")
    public void testandoAtalho04(){
        controllerDocumento.criarDocumento("PP");
        controllerDocumento.criarDocumento("PLP");
        assertThrows(IllegalArgumentException.class,()-> controllerDocumento.criarAtalho("PP", "PLP"));
    }

    @Test
    @DisplayName("Exibindo um documento com sucesso")
    public void testandoExibirDocumento(){
        controllerDocumento.criarDocumento("Gamer");
        controllerDocumento.criarTexto("Gamer", "valorant é bom", 4);
        String[] exibirDoc = controllerDocumento.exibirDocumento("Gamer");
        assertArrayEquals(exibirDoc, controllerDocumento.exibirDocumento("Gamer"));
    }

    @Test
    @DisplayName("Exibindo um documento, porém o documento não existe")
    public void testandoExibirDocumento02(){
        controllerDocumento.criarDocumento("Gamer");
        controllerDocumento.criarTexto("Gamer", "valorant é bom", 4);
        assertThrows(NoSuchElementException.class,() -> controllerDocumento.exibirDocumento("JLp2"));
    }

    @Test
    @DisplayName("Exibindo com sucesso a representacao resumida de um  elemento texto")
    public void testandoRepresentacaoResumidaTexto(){
        controllerDocumento.criarDocumento("RBD");
        controllerDocumento.criarTexto("RBD", "gosto muito de RBD", 4);
        assertEquals("gosto muito de RBD", controllerDocumento.pegarRepresentacaoResumida("RBD", 1));
    }
    @Test
    @DisplayName("Exibindo a representacao resumida de um elemento texto, porém, a posicao é invalida")
    public void testandoRepresentacaoResumidaTexto02(){
        controllerDocumento.criarDocumento("RBD");
        controllerDocumento.criarTexto("RBD", "gosto muito de RBD", 4);
        String exemplo = controllerDocumento.pegarRepresentacaoResumida("RBD", 1);
        assertThrows(IndexOutOfBoundsException.class,() -> controllerDocumento.pegarRepresentacaoResumida("RBD", 2));
    }

    @Test
    @DisplayName("Exibindo a representacao resumida de um elemento texto, porém, o documento não existe")
    public void testandoRepresentacaoResumidaTexto03(){
        controllerDocumento.criarDocumento("RBD");
        controllerDocumento.criarTexto("RBD", "gosto muito de RBD", 4);
        String exemplo = controllerDocumento.pegarRepresentacaoResumida("RBD", 1);
        assertThrows(NoSuchElementException.class,() -> controllerDocumento.pegarRepresentacaoResumida("Juazeirinho", 2));
    }

    @Test
    @DisplayName("Exibindo com sucesso a representacao resumida de um  elemento termo")
    public void testandoRepresentacaoResumidaTermo(){
        controllerDocumento.criarDocumento("DRX");
        controllerDocumento.criarTermo("DRX", "banana/uva/abacaxi", 4, "/", "ALFABÉTICA");
        String exemplo = controllerDocumento.pegarRepresentacaoResumida("DRX", 1);
        assertEquals(exemplo, controllerDocumento.pegarRepresentacaoResumida("DRX", 1));
    }

    @Test
    @DisplayName("Exibindo com sucesso a representacao resumida de um  elemento termo")
    public void testandoRepresentacaoResumidaTermo02(){
        controllerDocumento.criarDocumento("DRX");
        controllerDocumento.criarTermo("DRX", "teste/termos/aleatorios", 4, "/", "ALFABÉTICA");
        String exemplo = controllerDocumento.pegarRepresentacaoResumida("DRX", 1);
        assertEquals("aleatorios / termos / teste", controllerDocumento.pegarRepresentacaoResumida("DRX", 1));
    }

    @Test
    @DisplayName("Exibindo com sucesso a representacao resumida de um  elemento Lista")
    public void testandoRepresentacaoResumidaLista(){
        controllerDocumento.criarDocumento("JOAO");
        controllerDocumento.criarLista("JOAO", "exemplo|de uma lista|de 3 termos", 3,"|","-");
        assertEquals("exemplo | de uma lista | de 3 termos", controllerDocumento.pegarRepresentacaoResumida("JOAO", 1));
    }

    @Test
    @DisplayName("Exibindo com sucesso a representacao resumida de um  elemento atalho")
    public void testandoRepresentacaoResumidaAtalho(){
        controllerDocumento.criarDocumento("JOAO");
        controllerDocumento.criarDocumento("HENRIQUE");
        controllerDocumento.criarTexto("HENRIQUE", "joao é legal", 5);
        controllerDocumento.criarTexto("JOAO", "Joseana é uma otima professora", 2);
        controllerDocumento.criarTexto("HENRIQUE", "Ta comendo bolo de nutela", 4);
        controllerDocumento.criarAtalho("JOAO", "HENRIQUE");
        assertEquals("Ta comendo bolo de nutela", controllerDocumento.pegarRepresentacaoResumida("HENRIQUE", 2));
    }

    @Test
    @DisplayName("Exibindo com sucesso a representacao resumida de um elemento titulo")
    public void testandoRepresentacaoResumidaTitulo(){
        controllerDocumento.criarDocumento("FLAMENGO");
        controllerDocumento.criarTitulo("FLAMENGO", "Elementos Simples", 3,3,false);
        assertEquals("1. Elementos Simples", controllerDocumento.pegarRepresentacaoResumida("FLAMENGO", 1));
    }

    @Test
    @DisplayName("Exibindo com Sucesso a representacao completa de um Elemento titulo")
    public void testandoRepresentacaoCompletaTexto(){
        controllerDocumento.criarDocumento("Champions");
        controllerDocumento.criarTexto("Champions", "city vai ganhar", 4);
        assertEquals("city vai ganhar", controllerDocumento.pegaRepresentacaoCompleta("Champions", 1));
    }

    @Test
    @DisplayName("Exibindo com Sucesso a representacao completa de um Elemento termo em ordem ALFABETICA")
    public void testandoRepresentacaoCompletaTermo01(){
        controllerDocumento.criarDocumento("Champions");
        controllerDocumento.criarTermo("Champions", "Teste/termos/Aleatórios", 5, "/", "ALFABÉTICA");
        assertEquals("Total de termos: 3\n- Aleatórios, termos, Teste", controllerDocumento.pegaRepresentacaoCompleta("Champions", 1));
    }

    @Test
    @DisplayName("Exibindo com Sucesso a representacao completa de um Elemento termo em ordem TAMANHO")
    public void testandoRepresentacaoCompletaTermo02(){
        controllerDocumento.criarDocumento("Champions");
        controllerDocumento.criarTermo("Champions", "Teste/termos/Aleatórios", 5, "/", "TAMANHO");
        assertEquals("Total de termos: 3\n- Aleatórios, termos, Teste", controllerDocumento.pegaRepresentacaoCompleta("Champions", 1));
    }

    @Test
    @DisplayName("Exibindo com Sucesso a representacao completa de um Elemento termo em ordem NENHUM")
    public void testandoRepresentacaoCompletaTermo03(){
        controllerDocumento.criarDocumento("Champions");
        controllerDocumento.criarTermo("Champions", "Teste/termos/Aleatórios", 5, "/", "NENHUM");
        assertEquals("Total de termos: 3\n- Teste, termos, Aleatórios", controllerDocumento.pegaRepresentacaoCompleta("Champions", 1));
    }

    @Test
    @DisplayName("Exibindo com Sucesso a representacao completa de um elemento Termo com o linkavel true")
    public void testandoRepresentacaoCompletaTitulo01(){
        controllerDocumento.criarDocumento("Liberdade");
        controllerDocumento.criarTitulo("Liberdade", "Documentos Texto", 4, 1, true);
        assertEquals("0. Documentos Texto -- \n0-DOCUMENTOSTEXTO", controllerDocumento.pegaRepresentacaoCompleta("Liberdade", 1));
    }

    @Test
    @DisplayName("Exibindo com Sucesso a representacao completa de um elemento Termo com o linkavel false")
    public void testandoRepresentacaoCompletaTitulo02(){
        controllerDocumento.criarDocumento("Liberdade");
        controllerDocumento.criarTitulo("Liberdade", "Documentos Texto", 4, 1, false);
        assertEquals("1.Documentos Texto", controllerDocumento.pegaRepresentacaoCompleta("Liberdade", 1));
    }

    @Test
    @DisplayName("Exibindo com Sucesso a representacao completa de um elemento Lista")
    public void testandoRepresentacaoCompletaLista01(){
        controllerDocumento.criarDocumento("FLAMENGO");
        controllerDocumento.criarLista("FLAMENGO", "Exemplo|de uma lista|de 3 termos", 3,"|", "-");
        assertEquals("-Exemplo\n-de uma lista\n-de 3 termos\n", controllerDocumento.pegaRepresentacaoCompleta("FLAMENGO", 1));
    }

    @Test
    @DisplayName("Testando mover para cima")
    public void moverParaCima(){
        controllerDocumento.criarDocumento("Juazeirinho");
        controllerDocumento.criarTexto("Juazeirinho", "Terra Boa", 4);
        controllerDocumento.criarTexto("Juazeirinho", "terra maravilhosa", 5);
        controllerDocumento.moverParaCima("Juazeirinho", 1);
        assertEquals("terra maravilhosa", controllerDocumento.pegaRepresentacaoCompleta("Juazeirinho", 1));
    }

    @Test
    @DisplayName("Testando mover para cima com posicao invalida")
    public void moverParaCima02(){
        controllerDocumento.criarDocumento("Juazeirinho");
        controllerDocumento.criarTexto("Juazeirinho", "Terra Boa", 4);
        controllerDocumento.criarTexto("Juazeirinho", "terra maravilhosa", 5);
        assertThrows(IllegalArgumentException.class,() -> controllerDocumento.moverParaCima("Juazeirinho", 4));
    }

    @Test
    @DisplayName("Testando mover para baixo")
    public void moverParaBaixo(){
        controllerDocumento.criarDocumento("Juazeirinho");
        controllerDocumento.criarTexto("Juazeirinho", "Terra Boa", 4);
        controllerDocumento.criarTexto("Juazeirinho", "terra maravilhosa", 5);
        controllerDocumento.criarTexto("Juazeirinho", "eu te amo jua", 4);
        controllerDocumento.criarTexto("Juazeirinho", "chover chover", 3);
        controllerDocumento.moverParaBaixo("Juazeirinho", 2);
        assertEquals("chover chover", controllerDocumento.pegaRepresentacaoCompleta("Juazeirinho", 3));
    }

    @Test
    @DisplayName("Testando mover para baixo com posicao inválida")
    public void moverParaBaixo02(){
        controllerDocumento.criarDocumento("Juazeirinho");
        controllerDocumento.criarTexto("Juazeirinho", "Terra Boa", 4);
        controllerDocumento.criarTexto("Juazeirinho", "terra maravilhosa", 5);
        controllerDocumento.criarTexto("Juazeirinho", "eu te amo jua", 4);
        controllerDocumento.criarTexto("Juazeirinho", "chover chover", 3);
        assertThrows(IllegalArgumentException.class,() -> controllerDocumento.moverParaBaixo("Juazeirinho", 4));
    }

    @Test
    @DisplayName("Testando criar visao completa")
    public void VisaoCompleta01(){
        controllerDocumento.criarDocumento("JP");
        controllerDocumento.criarTexto("JP", "JP é gente boa", 3);
        assertEquals(0, controllerDocumento.criarVisaoCompleta("JP"));

    }
    @Test
    @DisplayName("Testando exibir visao Completa")
    public void VisaoCompleta02(){
        controllerDocumento.criarDocumento("JP");
        controllerDocumento.criarTexto("JP", "JP é gente boa", 3);
        controllerDocumento.criarVisaoCompleta("JP");
        assertArrayEquals(new String[]{"JP é gente boa"}, controllerDocumento.exibirVisao(0));
    }

    @Test
    @DisplayName("Testando criar visao resumida")
    public void VisaoResumida01(){
        controllerDocumento.criarDocumento("Pamonha");
        controllerDocumento.criarTexto("Pamonha", "Pamonha é meu gymbro eterno", 4);
        assertEquals(0, controllerDocumento.criarVisaoResumida("Pamonha"));
    }

    @Test
    @DisplayName("Testando exibir visao resumida")
    public void VisaoResumida02(){
        controllerDocumento.criarDocumento("Pamonha");
        controllerDocumento.criarTexto("Pamonha", "Pamonha é meu gymbro eterno", 4);
        controllerDocumento.criarVisaoResumida("Pamonha");
        assertArrayEquals(new String[]{"Pamonha é meu gymbro eterno"}, controllerDocumento.exibirVisao(0));
    }

    @Test
    @DisplayName("Testando criar visao prioritaria")
    public void visaoPrioritaria01(){
        controllerDocumento.criarDocumento("UFCG");
        controllerDocumento.criarTexto("UFCG", "acaba o semestre porfavor", 4);
        assertEquals(0, controllerDocumento.criarVisaoPrioritaria("UFCG", 4));
    }

    //como a lista não esta dentro da prioridade
    @Test
    @DisplayName("Testando exibir visao prioritaria")
    public void visaoPrioritaria02(){
        controllerDocumento.criarDocumento("UFCG");
        controllerDocumento.criarTexto("UFCG", "acaba o semestre porfavor", 4);
        controllerDocumento.criarLista("UFCG", "Ola|meu|amigo", 2, "|", "-");
        controllerDocumento.criarVisaoPrioritaria("UFCG", 4);
        assertArrayEquals(new String[]{"acaba o semestre porfavor"}, controllerDocumento.exibirVisao(0));

    }

    @Test
    @DisplayName("Testando criar visao titulo")
    public void visaoTitulo(){
        controllerDocumento.criarDocumento("VALORANTE");
        controllerDocumento.criarTexto("VALORANTE", "gabriel joga valorant", 3);
        assertEquals(0, controllerDocumento.criarVisaoTitulo("VALORANTE"));
    }

    @Test
    @DisplayName("Testando exibir visao titulo")
    public void visaoTitulo01(){
        controllerDocumento.criarDocumento("VALORANTE");
        controllerDocumento.criarTexto("VALORANTE", "gabriel joga valorant", 3);
        assertEquals(0, controllerDocumento.criarVisaoTitulo("VALORANTE"));
    }
    @Test
    @DisplayName("Testando exibir visao titulo")
    public void visaoTitulo02(){
        controllerDocumento.criarDocumento("VALORANTE");
        controllerDocumento.criarTexto("VALORANTE", "gabriel joga valorant", 3);
        controllerDocumento.criarVisaoTitulo("VALORANTE");
        assertArrayEquals(new String[]{"gabriel joga valorant"}, controllerDocumento.exibirVisao(0));
    }


}

