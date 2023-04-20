
public class DogHost {
	private String nome; 
	private int qtdMaxDog;
	private double qtdMaxRacao;
	private Dog[] dogs;
	
	public DogHost(String nome, int qtdMaxDog, double qtdMaxRacao) {
		this.nome = nome;
		this.qtdMaxDog = qtdMaxDog;
		this.qtdMaxRacao = qtdMaxRacao;
		this.dogs = new Dog[qtdMaxDog];
	}
	
	public Dog[] getDogs() {
		return this.dogs.clone();
	}
	
	public boolean adicionaDog(String nome, String tutor, int qtdRacao) {
		return false;
	}
	
	private boolean existeDog() {
		return false;
	}
			
}
