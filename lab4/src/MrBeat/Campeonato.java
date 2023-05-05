package MrBeat;

import java.util.Objects;

public class Campeonato {
	private String nome;
	private int quantidade;
	private Time[] times;
	private int index;
	
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

	public boolean adicionaTime(Time time) {
		
		if(index == quantidade) {
			throw new IndexOutOfBoundsException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUSOS");
		}
		
		times[index] = time;
		index++;
		return true;
	}
	
	public boolean verificarTime(Time time) {
		
		for(int i = 0; i < times.length; i++) {
			if(times[i] != null && times[i].equals(time)) {
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
		return "* " + nome + " - " + index + "/" + quantidade + "\n";
	}
	
	
	
	
	
	
}
