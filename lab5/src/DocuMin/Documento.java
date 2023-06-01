package DocuMin;

import entities.Elemento;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe que representa um Documento.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class Documento {
	
	private String titulo;
	private int tamanhoMaximo;
	private ArrayList<Elemento> elementos;
	
	public Documento(String titulo) {	
		this.titulo = titulo;
		this.elementos = new ArrayList<>();
		this.tamanhoMaximo = Integer.MAX_VALUE;
	}

	public Documento(String titulo, int tamanhoMaximo) {
		this.titulo = titulo;
		this.tamanhoMaximo = tamanhoMaximo;
		this.elementos = new ArrayList<Elemento>(tamanhoMaximo);
	}

	public int adicionaElementos(Elemento elemento){
		if(elementos.size() <= this.tamanhoMaximo){
			elementos.add(elemento);
		}
		return elementos.size()-1;
	}
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public Elemento getElemento(int posicao){
		return elementos.get(posicao);
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
