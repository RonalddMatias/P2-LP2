package Testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

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
	 * Testando contato sem o parâmetro nome e telefone.
	 */
	
	@Test
	void testaCadastroContato02() {
		assertFalse(agendaTeste.cadastraContato(1, "", "Felipe", "12345678"));
		assertFalse(agendaTeste.cadastraContato(100, "Ronaldd   ", "Felipe", "  "));
	}
	

	/**
	 * Testando contato com posiçao fora do suportado pelo array.
	 */
	
	@Test
	void testaCadastroContato03() {
		assertFalse(agendaTeste.cadastraContato(101, "Gabriel", "Lacerda", "3231242"));
		assertFalse(agendaTeste.cadastraContato(-1, "Kalina", "Julia", "3231242"));
		assertTrue(agendaTeste.cadastraContato(-1, "Kalina", "Julia", "3231242"));
	}

}
