package DocuMin;

import entities.Elemento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Classe que auxilia a criacao de um objeto do tipo Documento. Recebendo como parâmetros um titulo(String)
 * tamanhoMaximo(int), elementos(ArrayList) e um boolean temAtalho.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class Documento {
	
	private String titulo;
	private int tamanhoMaximo;
	private ArrayList<Elemento> elementos;

	private boolean temAtalho;

	/**
	 * Construtor da classe Documento.
	 *
	 * @param titulo O título do documento.
	 */
	public Documento(String titulo) {	
		this.titulo = titulo;
		this.elementos = new ArrayList<>();
		this.tamanhoMaximo = Integer.MAX_VALUE;
		this.temAtalho = false;
	}

	/**
	 * Construtor da classe Documento.
	 *
	 * @param titulo O título do documento.
	 * @param tamanhoMaximo o tamanho maximo de um documento.
	 */

	public Documento(String titulo, int tamanhoMaximo) {
		this.titulo = titulo;
		this.tamanhoMaximo = tamanhoMaximo;
		this.elementos = new ArrayList<Elemento>(tamanhoMaximo);
	}

	/**
	 * Adiciona um elemento à lista de elementos do documento, desde que não tenha excedido o tamanho máximo.
	 *
	 * @param elemento O elemento a ser adicionado ao documento.
	 * @return A posição do elemento adicionado na lista de elementos.
	 */
	public int adicionaElementos(Elemento elemento){
		if(elementos.size() <= this.tamanhoMaximo){
			elementos.add(elemento);
		}
		return elementos.size()-1;
	}

	/**
	 * Remove o elemento na posição especificada da lista de elementos do documento.
	 *
	 * @param posicao A posição do elemento a ser removido.
	 * @throws NullPointerException caso não exista elemento.
	 */

	public void removerElemento(int posicao){
		if(elementos.get(posicao) != null){
			elementos.remove(posicao);
		}
		throw new NullPointerException("nao existe elemento nessa posicao");
	}

	/**
	 * Método que retorna os elementos
	 * @return o arrayList de elementos.
	 */
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	/**
	 * Método que retorna a exata posicao de um elemento, caso exista;
	 *
	 * @param posicao
	 * @return um elemento
	 */
	public Elemento getElemento(int posicao){
		return elementos.get(posicao);
	}

	/**
	 * Método que retorna o titulo de um documento;
	 * @return o titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Método que seta o parametro setTemAtalho, podendo ser true or false
	 * @param temAtalho
	 */
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
		if(retorno == 0){
			throw new IllegalArgumentException("Não possui nenhum elemento no documento");
		}
		return retorno/elementos.size();
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

	/**
	 * Move o elemento na posição especificada para cima na lista de elementos.
	 *
	 * @param elementoPosicao a posição do elemento a ser movido para cima
	 * @throws IllegalArgumentException se a posição for inválida
	 */
	public void moverParaCima(int elementoPosicao) {
		if(elementoPosicao >= 0 && elementoPosicao < quantidadeElementos()){
			Collections.swap(elementos, elementoPosicao, elementoPosicao - 1);
		} else{
			throw new IllegalArgumentException("Posicao inválida");
		}
	}
	/**
	 * Move o elemento na posição especificada para baixo na lista de elementos.
	 *
	 * @param elementoPosicao a posição do elemento a ser movido para baixo
	 * @throws IllegalArgumentException se a posição for inválida
	 */
	public void moverParaBaixo(int elementoPosicao){
		if(elementoPosicao >= 0 && elementoPosicao < quantidadeElementos()-1){
			Collections.swap(elementos, elementoPosicao, elementoPosicao + 1);
		} else {
			throw new IllegalArgumentException("Posicao Invalida");
		}
	}
}
