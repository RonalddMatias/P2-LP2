package agenda;

import java.util.Objects;

/**
 * Classe Contato que tem como objetivo criar objetos do tipo Contato vai
 * receber parâmetros nome, sobrenome, telefone, todos do tipo String e também
 * receberá favorito do tipo booleano.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	private boolean favorito;

	/**
	 * Construtor que auxilia na iniciliazação do objeto contato.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */

	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.favorito = false;
	}

	/**
	 * Método que retorna o nome
	 * 
	 * @return nome do contato
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * Método que retorna o sobrenome
	 * 
	 * @return sobrenome do contato
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Método que retorna telefone
	 * 
	 * @return telefone do contato
	 */

	public String getTelefone() {
		return telefone;
	}

	/**
	 * 
	 * Verifica se o objeto atual é um favorito.
	 * 
	 * @return true se o objeto é um favorito, false caso contrário.
	 */
	public boolean isFavorito() {
		return favorito;
	}

	/**
	 * 
	 * Define se o objeto atual é um favorito.
	 * 
	 * @param favorito true para definir o objeto como favorito, false caso
	 *                 contrário.
	 */

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	@Override
	public String toString() {
		String retorno = "";

		if (isFavorito()) {
			retorno += "❤️ ";
		}
		return retorno += getNome() + " " + getSobrenome() + "\n" + getTelefone();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Contato)) { // vendo o obj é instância de Contato
			return false;
		}

		Contato other = (Contato) obj;
		return this.getNome().equals(other.getNome()) && this.getSobrenome().equals(other.getSobrenome()); 
	}

}
