package MrBeat;

import java.util.ArrayList;
import java.util.Objects;

public class Time {
	
	private String id;
	private String nome;
	private String mascote;
	private ArrayList<Campeonato> campeonatos;
	
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
	
	public void addCampeonato(Campeonato campeonato) {
		campeonatos.add(campeonato);
	}
	
	public String exibirCampeonatos() {
		String retorno = "";
		System.out.println("Campeonato(s) do " + getNome());
		for(int i = 0; i < campeonatos.size(); i++) {
			if(campeonatos.get(i) != null) {
				retorno += campeonatos.get(i).toString();
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
