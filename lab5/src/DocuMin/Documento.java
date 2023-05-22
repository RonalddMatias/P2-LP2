package DocuMin;

import java.util.Objects;

/**
 * Classe que representa um Documento.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class Documento {
	
	private String titulo;
	private int tamanhoMaximo ;
	
	public Documento(String titulo) {	
		this.titulo = titulo;
	}

	public Documento(String titulo, int tamanhoMaximo) {
		this.titulo = titulo;
		this.tamanhoMaximo = tamanhoMaximo;
	}
	

	public String getTitulo() {
		return titulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Documento))
			return false;
		Documento other = (Documento) obj;
		return getTitulo().equals(other.getTitulo());
	}
	
	
	
	
}
