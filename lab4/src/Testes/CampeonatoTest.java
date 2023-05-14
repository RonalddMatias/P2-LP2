package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MrBeat.Campeonato;
import MrBeat.Time;
/**
 * Classe de testes destinados a classe Campeonato.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
class CampeonatoTest {
	
	private Campeonato campeonatoTest;
	
	@BeforeEach
	void setUp() {
		campeonatoTest = new Campeonato("Brasileirão Série A 2023", 3);
		campeonatoTest.adicionaTime(new Time("PB_250", "Flamengo", "Urubu"));
		campeonatoTest.adicionaTime(new Time("PB_244", "Bahia", "Baleira"));
		campeonatoTest.adicionaTime(new Time("PB_555", "Barcelona", "Âncora"));
	}
	
	@Test
	@DisplayName("Verificando se existe time com o id igual, mas com os outros parâmetros diferentes.")
	void existeTime01() {
		Time time = new Time("PB_244", "Palmeiras", "Porco");
		assertTrue(campeonatoTest.verificarTime(time));
	}
	
	@Test
	@DisplayName("Verificando se existe time com o id diferente")
	void existeTime02() {
		Time time = new Time("PB_333", "Santos", "Peixe");
		assertFalse(campeonatoTest.verificarTime(time));
	}
	
	@Test
	@DisplayName("adicionando time acima do limite")
	void adicionando() {
		Time time = new Time("PB_333", "Santos", "Peixe");
		assertFalse(campeonatoTest.adicionaTime(time));
	}

}
