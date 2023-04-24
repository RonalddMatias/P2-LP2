package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HugsAndSmile.Dog;

class DogTest {

	private Dog dogsTeste;
	private Dog dogsTesteRestricao;

	@BeforeEach
	void preparaDog() {
		
		Dog dog = new Dog("Teo", "Leonardo", 100);
		Dog dogRe = new Dog("Bob", "Leo", 50, "Diabete");
		this.dogsTeste = dog;
		this.dogsTesteRestricao = dogRe;
	}
	
	@Test 
	void preparaDog01(){
		assertEquals(dogsTeste, new Dog("Teo", "Leonardo", 100));
		assertEquals(dogsTesteRestricao, new Dog("Bob", "Leo", 50, "Diabetes"));
	}
}
