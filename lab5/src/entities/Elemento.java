package entities;

import java.util.HashMap;

public abstract class Elemento {
	
	protected int prioridade;
	
	protected String valor;
	
	public Elemento(int prioridade, String valor) {
		if(prioridade < 1 || prioridade > 5) {
			throw new IllegalArgumentException();
		}
		this.prioridade = prioridade;
		this.valor = valor;
	}
	
	public abstract String gerarRepresentacaoCompleta();
	
	public abstract String gerarRepresentacaoResumida();
	
	
}
