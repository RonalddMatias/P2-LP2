package Testes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MrBeat.MrBeat;
import MrBeat.Time;
/**
 * 
 * Classe de testes destinada a classe MrBeat
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
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
	@DisplayName("Quando quero adicionar um campeonato")
	void adicionaCampeonato01() {
		assertEquals("CAMPEONATO ADICIONADO", mrbeatTeste.adicionarCampeonato("Brasileirão série A 2023", 20));
	}
	
	@Test
	@DisplayName("Quando quero adicionar um campeonato ja existente")
	void adicionaCampeonato02() {
		mrbeatTeste.adicionarCampeonato("Brasileirão série A 2023", 20);
		assertThrows(IllegalArgumentException.class, () -> mrbeatTeste.adicionarCampeonato("Brasileirão série A 2023", 20));
	}
	
	@Test
	@DisplayName("Quando quero adicionar um campeonato ja existente mas com as letra diferentes")
	void adicionaCampeonato03() {
		mrbeatTeste.adicionarCampeonato("Brasileirão série A 2023", 20);
		assertThrows(IllegalArgumentException.class, () -> mrbeatTeste.adicionarCampeonato("bRasIleirãO sÉrie a 2023", 20));
	}
	
	@Test
	@DisplayName("Quando quero recuperar um time")
	void recuperaTime01() {
		mrbeatTeste.incluirTime("PB_244", "Santos", "Peixe");
		assertEquals("[PB_244] Santos / Peixe", mrbeatTeste.recuperarTime("PB_244"));
	}
	
	@Test
	@DisplayName("Quando quero recuperar um time não existente")
	void recuperaTime02() {
		mrbeatTeste.incluirTime("PB_244", "Santos", "Peixe");
		assertThrows(IllegalArgumentException.class, () -> mrbeatTeste.recuperarTime("PB_323"));
	}
	
	@Test
	@DisplayName("Quando quero incluir um time em um campeonato")
	void incluirTime01() {
		mrbeatTeste.incluirTime("PB_244", "Santos", "Peixe");
		mrbeatTeste.adicionarCampeonato("BRA", 2);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO", mrbeatTeste.incluirTime("PB_244", "BRA"));
	}
	
	@Test
	@DisplayName("Quando quero incluir um time, mas o camponato não existe")
	void incluirTime02() {
		mrbeatTeste.incluirTime("PB_244", "Santos", "Peixe");
		assertThrows(NoSuchElementException.class,() ->  mrbeatTeste.incluirTime("PB_244", "CHAMPIONS"));
	}
	
	@Test
	@DisplayName("Quando quero incluir um time, mas o time não existe")
	void incluirTime03() {
		mrbeatTeste.adicionarCampeonato("BRA", 2);
		assertThrows(NoSuchElementException.class,() ->  mrbeatTeste.incluirTime("PB_244", "BRA"));
	}
	
	@Test
	@DisplayName("Quando quero incluir um time, mas ultrapassou a quantidade maxima de participantes em um campeonato")
	void incluirTime04() {
		mrbeatTeste.incluirTime("PB_244", "Santos", "Peixe");
		mrbeatTeste.incluirTime("PB_40", "Barcelona", "Ancora");
		mrbeatTeste.adicionarCampeonato("BRA", 1);
		mrbeatTeste.incluirTime("PB_244", "BRA");
		assertThrows(IndexOutOfBoundsException.class,() ->  mrbeatTeste.incluirTime("PB_40", "BRA"));
	}
	
	@Test
	@DisplayName("Quando quero incluir um time, mas ele ja está contido no campeonato. Aparece a mensagem mas não inclui.")
	void incluirTime05() {
		mrbeatTeste.incluirTime("PB_66", "Santos", "Peixe");
		mrbeatTeste.adicionarCampeonato("SERIE B", 1);
		mrbeatTeste.incluirTime("PB_66", "serie b");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO", mrbeatTeste.incluirTime("PB_66", "SERIE B"));
	}
	
	@Test
	@DisplayName("Quando quero verificar um time em um campeonato")
	void verificaTimeNoCampeonato05() {
		mrbeatTeste.incluirTime("PB_66", "Santos", "Peixe");
		mrbeatTeste.adicionarCampeonato("SERIE B", 1);
		mrbeatTeste.incluirTime("PB_66", "serie b");
		assertTrue(mrbeatTeste.verificarTimeNoCampeonato("PB_66", "Serie B"));
	}
	
	@Test
	@DisplayName("Quando quero exibir os campeonatos que o time participa")
	void exibirCampeonatoQueTimeParticipa() {
		mrbeatTeste.incluirTime("PB_333", "Palmeiras", "Porco");
		mrbeatTeste.adicionarCampeonato("BRA", 5);
		mrbeatTeste.incluirTime("PB_333", "BRA");
		assertEquals("* BRA - 1/5" + "\n",mrbeatTeste.exibirCampeonatoQueTimeParticipa("PB_333"));
	}
	
	@Test
	@DisplayName("Quando quero exibir os campeonatos de um time não existente")
	void exibirCampeonatoQueTimeParticipa01() {
		mrbeatTeste.incluirTime("PB_333", "Palmeiras", "Porco");
		mrbeatTeste.adicionarCampeonato("BRA", 5);
		mrbeatTeste.incluirTime("PB_333", "BRA");
		assertThrows(NoSuchElementException.class, () -> mrbeatTeste.exibirCampeonatoQueTimeParticipa("PB_055"));
	}
	
	@Test
	@DisplayName("Quando eu quero fazer uma aposta")
	void apostar01() {
		mrbeatTeste.incluirTime("PB_066", "Real Madri", "Alien");
		mrbeatTeste.adicionarCampeonato("NFL 2023", 5);
		mrbeatTeste.incluirTime("PB_066", "NFL 2023");
		assertEquals("APOSTA REALIZADA!", mrbeatTeste.apostar("PB_066", "NFL 2023", 500, 1));
	}
	
	@Test
	@DisplayName("Quando eu quero fazer uma aposta porém o time não existe")
	void apostar02() {
		mrbeatTeste.incluirTime("PB_066", "Real Madri", "Alien");
		mrbeatTeste.adicionarCampeonato("NFL 2023", 5);
		mrbeatTeste.incluirTime("PB_066", "NFL 2023");
		assertThrows(NoSuchElementException.class, () ->  mrbeatTeste.apostar("PB_043", "NFL 2023", 500, 1));
	}
	
	@Test
	@DisplayName("Quando quero fazer uma aposta porém o campeonato não existe")
	void apostar03() {
		mrbeatTeste.incluirTime("PB_077", "Juazeririnho Futebol Club", "Fenix");
		mrbeatTeste.adicionarCampeonato("Copa Cariri", 5);
		mrbeatTeste.incluirTime("PB_077", "Copa Cariri");
		assertThrows(NoSuchElementException.class, () ->  mrbeatTeste.apostar("PB_077", "NFL 2023", 500, 1));
	}
	
	@Test
	@DisplayName("Quando quero fazer uma aposta porém a colocação é maior que o limite de participantes de um campeonato")
	void apostar04() {
		mrbeatTeste.incluirTime("PB_077", "Juazeririnho Futebol Club", "Fenix");
		mrbeatTeste.adicionarCampeonato("Copa Cariri", 5);
		mrbeatTeste.incluirTime("PB_077", "Copa Cariri");
		assertThrows(IllegalArgumentException.class, () ->  mrbeatTeste.apostar("PB_077", "Copa Cariri", 500, 6));
	}
	
	@Test
	@DisplayName("Quando quero exibir apostas")
	void exibirApostas01() {
		mrbeatTeste.incluirTime("PB_077", "Juazeirinho", "Fenix");
		mrbeatTeste.adicionarCampeonato("Copa Cariri", 5);
		mrbeatTeste.incluirTime("PB_077", "Copa Cariri");
		mrbeatTeste.apostar("PB_077", "Copa Cariri", 500, 1);
		assertEquals("[PB_077] Juazeirinho / Fenix Copa Cariri\n1/5\nR$ 500.0" + "\n", mrbeatTeste.statusDaAposta());
	}
	
	@Test
	@DisplayName("Quando quero exibir apostas, porém não foi feita nenhuma;")
	void exibirApostas02() {
		mrbeatTeste.incluirTime("PB_077", "Juazeirinho", "Fenix");
		mrbeatTeste.adicionarCampeonato("Copa Cariri", 5);
		mrbeatTeste.incluirTime("PB_077", "Copa Cariri");
		assertEquals("", mrbeatTeste.statusDaAposta());
	}
	
}
