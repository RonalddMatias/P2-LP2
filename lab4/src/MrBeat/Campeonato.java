package MrBeat;

import java.util.Objects;

/**
 * Classe que tem por objetivo criar objetos do tipo Campeonato, tendo como
 * parâmetros um nome (String), quantidade (int) e index(int). Como também um
 * array de Time.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class Campeonato {
	private String nome;
	private int quantidade;
	private Time[] times;
	private int index;

	/**
	 * Contrutor que auxilia na criação de um objeto do tipo Campeonato.
	 * 
	 * @param nome
	 * @param quantidade
	 */

	public Campeonato(String nome, int quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.times = new Time[quantidade];
		this.index = 0;
	}

	public String getNome() {
		return nome;
	}

	public int getIndex() {
		return index;
	}

	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * 
	 * Adiciona um time ao vetor de times do campeonato, desde que haja espaço
	 * disponível.
	 * 
	 * @param time o Time a ser adicionado ao vetor de times do campeonato.
	 * @return true se o time foi adicionado com sucesso, false caso contrário.
	 */

	public boolean adicionaTime(Time time) {

		if (index == quantidade) {
			return false;
		}

		times[index] = time;
		index++;
		return true;
	}

	/**
	 * 
	 * Verifica se o time está presente na lista de times do campeonato.
	 * 
	 * @param time Time a ser verificado.
	 * @return Retorna true se o time estiver presente na lista de times, false caso
	 *         contrário.
	 */
	public boolean verificarTime(Time time) {

		for (int i = 0; i < times.length; i++) {
			if (times[i] != null && times[i].equals(time)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Campeonato))
			return false;
		Campeonato other = (Campeonato) obj;
		return this.getNome().toLowerCase().equals(other.getNome().toLowerCase());
	}

	@Override
	public String toString() {
		return "* " + nome + " - " + index + "/" + quantidade;
	}

}
