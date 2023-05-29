package entities;

import java.util.HashMap;

public class Texto extends Elemento {
	private String titulo;
	public Texto(int prioridade, String valor, String titulo) {
		super(prioridade, valor);
		this.titulo = titulo;
	}
	
	@Override
	public String gerarRepresentacaoCompleta() {
		return getValor();
	}
	
	@Override
	public String gerarRepresentacaoResumida() {
		return getValor();
	}
}
