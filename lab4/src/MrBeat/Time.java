package MrBeat;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe que tem o objetivo de criar objetos do tipo Time, tendo como
 * parâmetros um id (String), nome (String), mascote (String) e um arraylist do
 * tipo Campeonato.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class Time {

	private String id;
	private String nome;
	private String mascote;
	private ArrayList<Campeonato> campeonatos;

	/**
	 * Construtor que auxilia na criação de um objeto do tipo time.
	 * 
	 * @param id
	 * @param nome
	 * @param mascote
	 */
	public Time(String id, String nome, String mascote) {
		this.id = id;
		this.nome = nome;
		this.mascote = mascote;
		this.campeonatos = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getMascote() {
		return mascote;
	}

	/**
	 * Método que adiciona um campeonato no arraylist de campeonatos.
	 * 
	 * @param campeonato que será adicionado
	 */
	public void addCampeonato(Campeonato campeonato) {
		campeonatos.add(campeonato);
	}

	/**
	 * 
	 * Retorna uma String com os nomes dos campeonatos que o time participa.
	 * 
	 * @return String com os nomes dos campeonatos que o time participa.
	 * @throws NoSuchElementException se o time não estiver em nenhum campeonato.
	 */
	
	public String exibirCampeonatos() {
		String retorno = "";
		System.out.println("Campeonato(s) do " + getNome());
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos.get(i) != null) {
				retorno += campeonatos.get(i).toString() + "\n";
			}
		}
		return retorno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (!(obj instanceof Time))
			return false;

		Time other = (Time) obj;
		return this.getId().equals(other.getId());
	}

	@Override
	public String toString() {
		return "[" + id + "] " + nome + " / " + mascote;
	}

}
