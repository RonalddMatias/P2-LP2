package entities;

public class Titulo extends Elemento{
	
	private int nivel;
	private boolean linkavel;

	public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
		super(prioridade, valor);
		if(nivel < 1 || nivel > 5) {
			throw new IllegalArgumentException();
		}
		this.propriedades.put("nivel", String.valueOf(nivel));
		this.propriedades.put("linkável", String.valueOf(linkavel));
	}

	public int getNivel() {
		return nivel;
	}

	@Override
	public String gerarRepresentacaoCompleta() {
		if(this.propriedades.get("linkável").equals("true")){
			return formatacao();
		}

		return getNivel() + ". " + getValor();
	}

	@Override
	public String gerarRepresentacaoResumida() {
		return getNivel() + ". " + getValor();
	}


	// trocando os espacos por espacos em branco e dando um UPPERCASE;
	private String formatacao(){
		return getNivel() + ". " + getValor() + " -- " + getNivel() + "-" + getValor().replaceAll(" ", "").toUpperCase();
	}
	
}
