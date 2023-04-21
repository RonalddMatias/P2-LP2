package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;
/**
 * Classe ContatoTest tem o objetivo de criar testes da classe Contato.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */

class ContatoTest {

	private Contato contatoTeste;
	
	@BeforeEach
	void preparaContato() {
		this.contatoTeste = new Contato("Ronaldd", "Matias", "8398199-2718");

	}
	
	@Test
	void testEquals() {
		assertEquals(contatoTeste, new Contato("Ronaldd", "Matias", "8398199-2718"));
		assertEquals(contatoTeste, new Contato("Ronaldd     ", "Matias", "8398199-2718"));
		assertNotEquals(contatoTeste, new Contato("Ronaldd", "Feliph", "8398"));
		assertNotEquals(contatoTeste, new Contato("Mateus", "Ramos", "83982323"));
	}

}
