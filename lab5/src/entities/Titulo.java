package entities;

public class Titulo extends Elemento{
	
	private int nivel;
	private boolean linkavel;

	public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
		super(prioridade, valor);
		if(nivel < 1 || nivel > 5) {
			throw new IllegalArgumentException();
		}
		this.nivel = nivel;
		this.linkavel = linkavel;
	}
	
	//
	@Override
	public String gerarRepresentacaoCompleta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gerarRepresentacaoResumida() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
