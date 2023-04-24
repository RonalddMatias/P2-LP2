package Testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import HugsAndSmile.Dog;
import HugsAndSmile.DogHost;

class DogHostTest {

	private DogHost dh1;

	@BeforeEach
	void preparaDogHost() {
		dh1 = new DogHost("dh1", 3, 500);
	}

	@Test
	@DisplayName("Adicionando cachorro a um DogHost")
	void testAddDog01() {
		dh1.adicionaDog("Julie", "André", 100);
		dh1.adicionaDog("toto", "Maty", 100);
	}

	@Test
	@DisplayName("Calculando Hospedagem de um cachorro")
	void testHospedagem01() {
		dh1.adicionaDog("julie", "André", 100);
		assertEquals(120.0, dh1.consultaValorHospedagem(dh1.getDogs()[0], 3));
	}

	@Test
	@DisplayName("Calculando Hospedagem de um cachorro com dias = 0")
	void testHospedagem02() {
		dh1.adicionaDog("julie", "André", 100);
		assertEquals(0.0, dh1.consultaValorHospedagem(dh1.getDog(1), 0));
	}

	@Test
	@DisplayName("Calculando Hospedagem para um cachorro inválido")
	void testHospedagem03() {
		dh1.adicionaDog("julie", "André", 100);
		dh1.adicionaDog("toto", "maty", 100);
		Dog d1 = new Dog("Neca", "Andre", 100);

		assertThrows(IllegalArgumentException.class, () -> dh1.consultaValorHospedagem(d1, 0));
	}
	
	@Test
	@DisplayName("Adicionando cachorro além da conta")
	void testAddDog05() {
		dh1.adicionaDog("julie", "André", 100);
		dh1.adicionaDog("toto", "maty", 100);
		dh1.adicionaDog("julie", "André", 100);
		assertFalse(dh1.adicionaDog("toto", "maty", 100));
	}
	
	@Test
	@DisplayName("Adicionando cachorro com nome e tutor igual")
	void testAddDog06() {
		dh1.adicionaDog("julie", "André", 100);
		assertFalse(dh1.adicionaDog("julie", "André", 33));
		
	}
	
	@Test
	@DisplayName("Cachorro com ração acima da suportada")
	void testAddDog07() {
		assertFalse(dh1.adicionaDog("julie", "André", 505));
		
		
	}
	
	@Test
	@DisplayName("Listando cachorros dos dog host")
	void listarDogs() {
		Dog dog = new Dog("xauxau", "henrique", 2);
		dh1.adicionaDog("xauxau", "henrique", 2);
		assertEquals(dog, dh1.getDog(1));
	}

}
