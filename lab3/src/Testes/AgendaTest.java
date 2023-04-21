package Testes;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

/**
 * Classe AgendaTest tem o objetivo de criar testes da classe Agenda.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */

class AgendaTest {

	private Agenda agendaTeste;

	@BeforeEach
	void preparaAgenda() {
		Agenda agenda = new Agenda();
		this.agendaTeste = agenda;

	}

	/**
	 * Testando com todos os parâmetros.
	 */

	@Test
	void testaCadastroContato01() {
		assertTrue(agendaTeste.cadastraContato(1, "João", "Henrique", "12345678"));
		assertTrue(agendaTeste.cadastraContato(100, "João", "Gabriel", "12345623"));
	}

	/**
	 * Testando contato sem o parâmetro nome.
	 */

	@Test
	void testaCadastroContato03() {
		assertFalse(agendaTeste.cadastraContato(100, "  ", "Felipe", "4377432883"));
	}

	/**
	 * Testando contato sem o parâmetro sobrenome.
	 */

	@Test
	void testaCadastroContato04() {
		assertTrue(agendaTeste.cadastraContato(100, "Ronaldd   ", "", "32323"));
	}

	/**
	 * Testando contato sem o parâmetro telefone.
	 */

	@Test
	void testaCadastroContato05() {
		assertFalse(agendaTeste.cadastraContato(100, "Adonias", "Costa", ""));
	}

	/**
	 * Testando contato acima da posiçao suportada pelo array.
	 */

	@Test
	void testaCadastroContato06() {
		try {
			agendaTeste.cadastraContato(101, "Ronaldd", "Matias", "993233321");
		} catch (IndexOutOfBoundsException error) {
			assertEquals("POSIÇÃO INVÁLIDA", error.getMessage());
		}
	}

	/**
	 * Testando contato abaixo da posiçao suportada pelo array.
	 */

	@Test
	void testaCadastroContato07() {
		try {
			agendaTeste.cadastraContato(-2, "Feliph", "da Silva", "2332823772");
		} catch (IndexOutOfBoundsException error) {
			assertEquals("POSICAO INVÁLIDA", error.getMessage());
		}
	}

	/**
	 * Testando contato já existente
	 */

	@Test
	void testaCadastroContato08() {
		agendaTeste.cadastraContato(3, "Ronaldd", "Feliph", "12345678");
		try {
			agendaTeste.cadastraContato(2, "Ronaldd", "Feliph", "21342662");
		} catch (IllegalArgumentException error) {
			assertEquals("Contato ja cadastrado", null);
		}
		assertFalse(agendaTeste.cadastraContato(2, "Ronaldd", "Feliph", "21342662"));
	}

	/**
	 * exibindo contato cadastrado	
	 */

	@Test
	void testaExibirContatao01() {
		agendaTeste.cadastraContato(4, "joao", "da costa", "32318237");
		assertTrue(agendaTeste.exibirContato(4));
	}

	/**
	 * exibindo contato que ainda não foi cadastrado em uma certa posição
	 */

	@Test
	void testaExibirContatao02() {
		try {
			agendaTeste.cadastraContato(4, "joao", "da costa", "32318237");
			assertFalse(agendaTeste.exibirContato(3));
		} catch (IllegalArgumentException error) {
			assertEquals("NENHUM NOME CADASTRADO NESSA POSIÇÃO", null);
		}

	}

	/**
	 * exibindo contato que acima do limite permitido
	 */

	@Test
	void testaExibirContatao03() {
		try {
			agendaTeste.cadastraContato(13, "joao", "da costa", "32318237");
			assertFalse(agendaTeste.exibirContato(101));
		} catch (IndexOutOfBoundsException error) {
			assertEquals("POSIÇÃO NÃO EXISTENTE", null);
		}

	}

	/**
	 * exibindo contato que abaixo do limite permitido
	 */

	@Test
	void testaExibirContatao04() {
		try {
			agendaTeste.cadastraContato(20, "ROnas", "MOnteiro", "3713982783");
			assertFalse(agendaTeste.exibirContato(-3));
		} catch (IndexOutOfBoundsException error) {
			assertEquals("POSIÇÃO NÃO EXISTENTE", null);
		}

	}

	/**
	 * Testando quando favoritar um contato
	 */

	@Test
	void testaContatoFavorito01() {
		agendaTeste.cadastraContato(1, "Matias", "Costa", "83 92230012");
		assertTrue(agendaTeste.adicionaFavorito(1, 4));
	}

	/**
	 * Tentando favoritar um contado que não existe
	 */

	@Test
	void testaContatoFavorito02() {
		agendaTeste.cadastraContato(1, "Matias", "Costa", "83 92230012");
		assertFalse(agendaTeste.adicionaFavorito(3, 4));
	}

	/**
	 * Testando quando favoritar em uma posição acima do limite
	 */

	@Test
	void testaContatoFavorito03() {
		try {
			agendaTeste.cadastraContato(1, "Matias", "Costa", "83 92230012");
			agendaTeste.adicionaFavorito(1, 11);
		} catch (IndexOutOfBoundsException error) {
			assertEquals("POSIÇÃO INVÁLIDA", error.getMessage());
		}
	}

	/**
	 * Testando favoritar um contato que ja esta favoritado
	 */

	@Test
	void testaContatoFavorito04() {
		agendaTeste.cadastraContato(1, "Matias", "Costa", "83 92230012");
		agendaTeste.adicionaFavorito(1, 1);
		assertFalse(agendaTeste.adicionaFavorito(1, 3));
	}

	/**
	 * exibindo um contato favoritado OBS: O contato deve aparecer com um coração
	 */
	@Test
	void testaContatoFavorito05() {
		agendaTeste.cadastraContato(1, "JUliu", "Ferreira", "83 9123124");
		agendaTeste.adicionaFavorito(1, 1);
		assertTrue(agendaTeste.exibirContato(1));
	}

	/**
	 * Testando remoção de um contato favorito
	 */
	@Test
	void testeRemoveContatoFavoritado01() {
		agendaTeste.cadastraContato(1, "Mateus", "da Costa", "23212123");
		agendaTeste.adicionaFavorito(1, 1);
		assertTrue(agendaTeste.removerFavorito(1));
	}

	/**
	 * Testando a exibição de um contato depois dele ser removido OBS: O contato não
	 * deve mais estar como um "coração" no inicio.
	 */
	@Test
	void testeRemoveContatoFavoritado02() {
		agendaTeste.cadastraContato(1, "Odaize", "Trajano", "239432931");
		agendaTeste.adicionaFavorito(1, 1);
		agendaTeste.removerFavorito(1);
		assertTrue(agendaTeste.exibirContato(1));
	}

	/**
	 * Tentando remover favorito acima do limite permitido
	 */

	@Test
	void testeRemoveContatoFavoritado03() {

		try {
			agendaTeste.cadastraContato(1, "José", "Robério", "239432931");
			agendaTeste.adicionaFavorito(1, 1);
			agendaTeste.removerFavorito(11);
		} catch (IndexOutOfBoundsException error) {
			assertEquals("Posição Inválida", null);
		}
	}

	/**
	 * Tentando remover favorito abaixo do limite permitido
	 */

	@Test
	void testeRemoveContatoFavoritado04() {

		try {
			agendaTeste.cadastraContato(1, "SaoJoao", "do cariri", "83 922222777");
			agendaTeste.adicionaFavorito(1, 1);
			agendaTeste.removerFavorito(-1);
		} catch (IndexOutOfBoundsException error) {
			assertEquals("Posição Inválida", null);
		}

	}

}
