package HugsAndSmile;
import java.util.Objects;

public class Dog {
	private String nome;
	private String tutor;
	private double qtdRacao;
	private String restricoes;
	
	// construtor sem restrições
	public Dog(String nome, String tutor, double qtdRacao) {
		this.nome = nome;
		this.tutor = tutor;
		this.qtdRacao = qtdRacao;
	}
	
	// Construtor com restriões
	public Dog(String nome, String tutor, double qtdRacao, String restricao) {
		this.nome = nome;
		this.tutor = tutor;
		this.qtdRacao = qtdRacao;
		this.restricoes = restricao;
	}
	
	public double dobraRacao() {
		if(getRestricoes().equals("")) {
			return getQtdRacao();
		} else { // Se não for vazio significa que tem algo (restrição)
			return getQtdRacao() * 2;
		}
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

	

	public String getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
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
		return "Dog [nome=" + nome + ", tutor=" + tutor + "] \n";
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