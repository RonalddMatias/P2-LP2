import java.util.Objects;

public class Dog {
	private String nome;
	private String tutor;
	private double qtdRacao;
	
	public Dog(String nome, String tutor, double qtdRacao) {
		this.nome = nome;
		this.tutor = tutor;
		this.qtdRacao = qtdRacao;
	}

	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getTutor() {
		return tutor;
	}



	public void setTutor(String tutor) {
		this.tutor = tutor;
	}



	public double getQtdRacao() {
		return qtdRacao;
	}



	public void setQtdRacao(double qtdRacao) {
		this.qtdRacao = qtdRacao;
	}

	@Override
	public String toString() {
		return "Dog [nome=" + nome + ", tutor=" + tutor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, tutor);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Dog))
			return false;
		Dog other = (Dog) obj;
		return this.getNome().equals(other.getNome()) && this.getTutor().equals(other.getTutor());
	}
	
}