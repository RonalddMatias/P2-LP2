package MrBeat;

public class Aposta {
	private Time time;
	private Campeonato campeonato;
	private double valor;
	private int colocacao;
	
	public Aposta(Time time, Campeonato campeonato, double valor, int colocacao) {
		this.time = time;
		this.campeonato = campeonato;
		this.valor = valor;
		this.colocacao = colocacao;
	}

	@Override
	public String toString() {
		return "[" + time.getId() + "] "  + time.getNome() + " / " + time.getMascote()
				+ campeonato.getNome()
				+ "\n" 
				+ campeonato.getIndex() + "/" + campeonato.getQuantidade() + "\n"
				+ "R$ " + this.valor + "\n"; 
	}
	
	
	
	
}
