package entities;

public class Lista extends Elemento {
	 private String separador;
	 private String titulo;
	 private String caractereDeLista;
	public Lista(int prioridade,String titulo, String valor) {
		super(prioridade, valor);
		this.titulo = titulo;
		this.propriedades.put("separador", separador);
		this.propriedades.put("caracter", caractereDeLista);
		
	}

	@Override
	public String gerarRepresentacaoCompleta() {
		String retorno = "";
		String[] conteudoDoElemento = super.valor.split(separador);
		for (int i = 0; i < conteudoDoElemento.length; i++){
			if (conteudoDoElemento[i] != null){
				retorno += "-"  + conteudoDoElemento[i] + "/n";
			}
		}

		return retorno;
	}

	@Override
	public String gerarRepresentacaoResumida() {
		String retorno = "";
		String[] conteudoDoElemento = super.valor.split(separador);

		for (int i = 0; i < conteudoDoElemento.length; i++){
			if (conteudoDoElemento[i] != null) {
				retorno += conteudoDoElemento[i] + "| ";
			}
		}
		return retorno;
	}


}
