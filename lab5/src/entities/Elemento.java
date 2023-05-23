package entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe abstrata Elemento
 *
 * @author Ronaldd Matias
 */
public abstract class Elemento {
	
	protected int prioridade;
	
	protected String valor;

	protected HashMap<String, String> propriedades;
	
	public Elemento(int prioridade, String valor) {
		if(prioridade < 1 || prioridade > 5) {
			throw new IllegalArgumentException();
		}
		this.prioridade = prioridade;
		this.valor = valor;
		this.propriedades = new HashMap<String, String>();
	}

	public int getPrioridade() {
		return prioridade;
	}

	public String getValor() {
		return valor;
	}

	public abstract String gerarRepresentacaoCompleta();
	
	public abstract String gerarRepresentacaoResumida();
	
	
}
