package MrBeat;

import java.util.Objects;

public class Time {
	
	private String id;
	private String nome;
	private String mascota;
	
	public Time(String id, String nome, String mascota) {
		this.id = id;
		this.nome = nome;
		this.mascota = mascota;
	}

	
	
	public String getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}



	public String getMascota() {
		return mascota;
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
	
	
	
	
	
	
}
