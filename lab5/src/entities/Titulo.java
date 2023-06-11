package entities;
/**
 * Classe que representa um título em um documento.
 * @author Ronaldd Matias - 122110574
 */
public class Titulo extends Elemento{
	
	private int nivel;
	private boolean linkavel;

	/**
	 * Construtor da classe Titulo.
	 *
	 * @param prioridade a prioridade do título
	 * @param valor o valor do título
	 * @param nivel o nível do título (de 1 a 5)
	 * @param linkavel indica se o título é linkável
	 * @throws IllegalArgumentException se o nível estiver fora da faixa válida (1 a 5)
	 */
	public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
		super(prioridade, valor);
		if(nivel < 1 || nivel > 5) {
			throw new IllegalArgumentException();
		}
		this.propriedades.put("nivel", String.valueOf(nivel));
		this.propriedades.put("linkável", String.valueOf(linkavel));
	}
	/**
	 * Obtém o nível do título.
	 *
	 * @return o nível do título
	 */
	public int getNivel() {
		return nivel;
	}

	@Override
	public String gerarRepresentacaoCompleta() {
		String retorno = "";

		if(this.propriedades.get("linkável").equals("true")){
			retorno += formatacao();
		} else if (this.propriedades.get("linkável").equals("false")) {
			retorno += getNivel()+1 + "." + getValor();
		}

		return retorno;
	}

	@Override
	public String gerarRepresentacaoResumida() {
		return getNivel()+1 + ". " + getValor();
	}


	// trocando os espacos por espacos em branco e dando um UPPERCASE;
	private String formatacao(){
		return getNivel() + ". " + getValor() + " -- " + "\n" + getNivel() + "-" + getValor().replaceAll(" ", "").toUpperCase();
	}
	
}
