package Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HugsAndSmile.Dog;
import HugsAndSmile.DogHost;

class DogHostTest {

	private DogHost dogHost;
	
	@BeforeEach
	void preparaDogHost() {
		dogHost = new DogHost("Julie", 2, 100);
	}
	
	@Test
	void testAddDog() {
		
		
		dogHost.adicionaDog("Max", "Labrador", 5);
		dogHost.adicionaDog("Max", "Retriver", 4);
		dogHost.adicionaDog("Max", "Retriver", 3);
	}

}
