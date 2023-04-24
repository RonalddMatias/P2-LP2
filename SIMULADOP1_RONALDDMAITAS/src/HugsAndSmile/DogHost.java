package HugsAndSmile;
public class DogHost {
	private String nome; 
	private int qtdMaxDog;
	private double qtdMaxRacao;
	private double[] valorTotalHospedagem;
	private Dog[] dogs;
	
	public DogHost(String nome, int qtdMaxDog, double qtdMaxRacao) {
		this.nome = nome;
		this.qtdMaxDog = qtdMaxDog;
		this.qtdMaxRacao = qtdMaxRacao;
		this.dogs = new Dog[qtdMaxDog];
		this.valorTotalHospedagem = new double[qtdMaxDog];
	}
	
	//Retornar a posicão de um dog
	public Dog getDog(int posicao) {
		return dogs[posicao -1];
	}
	
	//Retornar o array de dogs
	public Dog[] getDogs() {
		return this.dogs.clone();
	}
	
	public boolean adicionaDog(String nome, String tutor, int qtdRacao) {
		Dog dog = new Dog(nome, tutor, qtdRacao);
		if(qtdRacao > this.qtdMaxRacao) {
			return false;
		}
		
		if(existeDog(dog)) {
			return false;
		}
		
		for(int i = 0; i < dogs.length; i++) {
			if(dogs[i] == null) {
				dogs[i] = dog;
				return true;
			}
		}
		return false;
	}
	
	public boolean adicionaDogComRestricao(String nome, String tutor, int qtdRacao, String restricao) {
		Dog dog = new Dog(nome, tutor, qtdRacao, restricao);
		
		if(qtdRacao > this.qtdMaxRacao) {
			return false;
		}
		
		if(existeDog(dog)) {
			return false;
		}
		
		for(int i = 0; i < dogs.length; i++) {
			if(dogs[i] == null) {
				dogs[i] = dog;
				return true;
			}
		}
		return false;
	}
	
	public String listarDogs() {
		String retorno = "";
		retorno += this.nome + ": \n";
		Dog[] dogs = getDogs();
		for(Dog cachorros : dogs) {
			if(cachorros != null) {
				retorno += "-> " + cachorros.toString();
			}
		}
		return retorno;
	}
	
	public double consultaValorHospedagem(Dog toto, int dias) {
		double hospedagem = 0.0;
		Dog[] dogs = getDogs();
		for(Dog cachorros : dogs) {
			if(cachorros != null && cachorros.equals(toto)) {
				hospedagem = cachorros.getQtdRacao() * 0.4 * dias;
				return hospedagem;
			} else {
				throw new IllegalArgumentException();
			}
		}
		return hospedagem;
	}
	
	public double totalDiarioDeRacao() {
		double totalDeRacao = 0.0;
		Dog[] dogs = getDogs();
		
		for(Dog cachorro : dogs) {
			if(cachorro != null) {
				totalDeRacao += cachorro.getQtdRacao();
			}
		}
		return totalDeRacao;
		
	}
	
	private boolean existeDog(Dog dog) {
		Dog[] dogs = getDogs();
		for(int i = 0; i < dogs.length; i++) {
			if(dogs[i] != null && dogs[i].equals(dog)) {
				return true;
			}
		}
		return false;
	}
			
}
