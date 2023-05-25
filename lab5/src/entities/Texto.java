package entities;

import java.util.HashMap;

public class Texto extends Elemento {

	public Texto(int prioridade, String valor) {
		super(prioridade, valor);
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
