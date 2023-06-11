package entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe abstrata Elemento que tem como objetivo criar
 * objetos do tipo elemento. Recendo como parâmetros uma prioridade(int), valor(Stirng) e propriedades(HashMap).
 *
 * @author Ronaldd Matias
 */
public abstract class Elemento  implements  ElementoI{
	protected int prioridade;
	
	protected String valor;

	protected HashMap<String, String> propriedades;

	/**
	 * Construtor que ajuda na criacao de um objeto do tipo elemento
	 * @param prioridade
	 * @param valor
	 */

	public Elemento(int prioridade, String valor) {
		if(prioridade < 1 || prioridade > 5) {
			throw new IllegalArgumentException();
		}
		this.prioridade = prioridade;
		this.valor = valor;
		this.propriedades = new HashMap<String, String>();
	}

	/**
	 * Metodo que pega a prioridade do elemento.
	 * @return a prioridade do elemento
	 */
	public int getPrioridade() {
		return prioridade;
	}

	/**
	 * Método que pega o valor de um elemento, que é uma string.
	 *
	 * @return o valor do elemento
	 */
	public String getValor() {
		return valor;
	}
}
