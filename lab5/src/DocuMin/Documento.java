package DocuMin;

import entities.Elemento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

	private boolean temAtalho;
	
	public Documento(String titulo) {	
		this.titulo = titulo;
		this.elementos = new ArrayList<>();
		this.tamanhoMaximo = Integer.MAX_VALUE;
		this.temAtalho = false;
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

	public boolean removerElemento(int posicao){
		if(elementos.get(posicao) != null){
			elementos.remove(posicao);
			return true;
		}
		return false;
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

	public void setTemAtalho(boolean temAtalho) {
		this.temAtalho = temAtalho;
	}

	public boolean isTemAtalho() {
		return temAtalho;
	}

	public int calculaMediaElementos(){
		int retorno = 0;
		for (int i = 0; i < elementos.size(); i++){
			retorno += elementos.get(i).getPrioridade();
		}
		return retorno;
	}

	public int quantidadeElementos(){
		return elementos.size();
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


	public void moverParaCima(int elementoPosicao) {
		if(elementoPosicao >= 0 && elementoPosicao < quantidadeElementos()){
			Collections.swap(elementos, elementoPosicao, elementoPosicao - 1);
		} else{
			throw new IllegalArgumentException("Posicao inválida");
		}
	}

	public void moverParaBaixo(int elementoPosicao){
		if(elementoPosicao >= 0 && elementoPosicao < quantidadeElementos()-1){
			Collections.swap(elementos, elementoPosicao, elementoPosicao + 1);
		}
	}
}
