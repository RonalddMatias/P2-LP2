package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MrBeat.MrBeat;
import MrBeat.Time;

class MrBeatTest {

	private MrBeat mrbeatTeste;
	
	@BeforeEach
	void test() {
		MrBeat mrbeat = new MrBeat();
		this.mrbeatTeste = mrbeat;
	}
	
	@Test
	@DisplayName("Quando quero adicionar um time")
	void adicionaTime01(){
		assertEquals("INCLUSÃO REALIZADA!", mrbeatTeste.incluirTime("PB_250", "Nacional De Patos" , "Canário"));
		assertEquals("INCLUSÃO REALIZADA!", mrbeatTeste.incluirTime("PB_200", "Clube de Regatas do Flamengo" , "Canário"));
	}
	
	@Test
	@DisplayName("Quando quero adicionar um time já existente")
	void adicionaTime02() {
		mrbeatTeste.incluirTime("PB_250", "Nacional De Patos", "Canário");
		assertEquals("TIME JÁ EXISTE!", mrbeatTeste.incluirTime("PB_250", "Nacional De Patos" , "Canário"));
	}
	
	@Test
	@DisplayName("Quando quero adicionar um time já existente com o nome diferente.")
	void adicionaTime03() {
		mrbeatTeste.incluirTime("PB_250", "Nacional De Patos", "Canário");
		assertEquals("TIME JÁ EXISTE!", mrbeatTeste.incluirTime("PB_250", "Marotos" , "Canário"));
	}
	
	@Test
	@DisplayName("Quando quero adicionar um time já existente com o mascote diferente.")
	void adicionaTime04() {
		mrbeatTeste.incluirTime("PB_250", "Nacional De Patos", "Canário");
		assertEquals("TIME JÁ EXISTE!", mrbeatTeste.incluirTime("PB_250", "Nacional De Patos" , "Urubu"));
	}
	
	@Test
	@DisplayName("Quando quero adicionar um time já existente com o mascote diferente.")
	void adicionaCampeonato() {
		assertEquals("INCLUSÃO REALIZADA!", mrbeatTeste.adicionarCampeonato("Brasileirão série A 2023", 20));
	}

}
