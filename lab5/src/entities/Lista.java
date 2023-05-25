package entities;

import java.util.HashMap;

public class Lista extends Elemento {
	 private String separador;
	 private String caractereDeLista;
	public Lista(int prioridade, String valor) {
		super(prioridade, valor);
		this.propriedades.put("separador", separador);
		this.propriedades.put("caracter", caractereDeLista);
		
	}

	@Override
	public String gerarRepresentacaoCompleta() {
		return null;
	}

	@Override
	public String gerarRepresentacaoResumida() {
		return null;
	}


}
