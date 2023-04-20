package Testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

class AgendaTest {

	private Agenda agendaTeste;

	@BeforeEach
	void preparaContatos() {
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
		assertFalse(agendaTeste.cadastraContato(100, "Ronaldd   ", "", "32323"));
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
		assertFalse(agendaTeste.cadastraContato(101, "Gabriel", "Lacerda", "3231242"));
	}

	/**
	 * Testando contato abaixo da posiçao suportada pelo array.
	 */

	@Test
	void testaCadastroContato07() {
		assertFalse(agendaTeste.cadastraContato(-1, "Kalina", "Julia", "3231242"));
	}

	/**
	 * Testando contato já existente
	 */

	@Test
	void testaCadastroContato08() {
		agendaTeste.cadastraContato(3, "Ronaldd", "Feliph", "12345678");
		assertFalse(agendaTeste.cadastraContato(2, "Ronaldd", "Feliph", "21342662"));
	}
	
	/**
	 * Testando quando favoritar um contato
	 */
	
	@Test 
	void testaCadastraContato() {
		agendaTeste.cadastraContato(1, "Matias", "Costa", "83 92230012");
		assertTrue(agendaTeste.adicionaFavorito(1, 4));
	}

}
