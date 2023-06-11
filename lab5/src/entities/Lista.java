package entities;

import java.util.regex.Pattern;
/**
 * Classe que representa uma lista em um documento.
 * @author Ronaldd Matias - 122110574
 */
public class Lista extends Elemento {
	 private String separador;
	 private String caractereDeLista;

	/**
	 * Construtor da classe Lista.
	 *
	 * @param prioridade a prioridade da lista
	 * @param titulo o título da lista
	 * @param valor o valor da lista
	 * @param separador o separador utilizado para dividir os elementos da lista
	 * @param caractereDeLista o caractere utilizado para representar cada item da lista
	 */
	public Lista(int prioridade,String titulo, String valor, String separador, String caractereDeLista) {
		super(prioridade, valor);
		this.propriedades.put("separador", separador);
		this.propriedades.put("caracter", caractereDeLista);
		this.separador = separador;
		this.caractereDeLista = caractereDeLista;
	}

	@Override
	public String gerarRepresentacaoCompleta() {
		String retorno = "";
		String[] conteudoDoElemento = super.valor.split(Pattern.quote(separador).trim());
		for (int i = 0; i < conteudoDoElemento.length; i++){
			if (conteudoDoElemento[i] != null){
				retorno += "-"  + conteudoDoElemento[i] + "\n";
			}
		}

		return retorno;
	}

	@Override
	public String gerarRepresentacaoResumida() {
		String retorno = "";
		String[] conteudoDoElemento = super.valor.split(Pattern.quote(separador).trim());

		for (int i = 0; i < conteudoDoElemento.length; i++){
			if (i == conteudoDoElemento.length-1) {
				retorno += conteudoDoElemento[i];
			} else {
				retorno += conteudoDoElemento[i] + " | ";
			}

		}
		return retorno;
	}


}
