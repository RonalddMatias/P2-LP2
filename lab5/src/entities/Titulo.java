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
	
	//
	@Override
	public String gerarRepresentacaoCompleta() {
		if(this.propriedades.get("linkável").equals("true")){

		}
		return null;
	}

	@Override
	public String gerarRepresentacaoResumida() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
