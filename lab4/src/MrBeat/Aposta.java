package MrBeat;

public class Aposta {
	private Time time;
	private Campeonato campeonato;
	private String valor;
	private int colocacao;
	
	public Aposta(Time time, Campeonato campeonato, String valor, int colocacao) {
		this.time = time;
		this.campeonato = campeonato;
		this.valor = valor;
		this.colocacao = colocacao;
	}
	
	
}
