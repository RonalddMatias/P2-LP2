package MrBeat;

/**
 * Classe que tem o objetivo de criar obejtos do tipo Aposta. Recebendo
 * parâmetros do tipo Time e Campeonato, como também, o valor de determinada
 * aposta e a colocação (int).
 * 
 * @author Ronaldd Matias - 122110574
 */

public class Aposta {
	
	private Time time;
	private Campeonato campeonato;
	private double valor;
	private int colocacao;
	
	/*
	 * Construtor que auxilia na criação de um objeto do Aposta.
	 */
	
	public Aposta(Time time, Campeonato campeonato, double valor, int colocacao) {
		this.time = time;
		this.campeonato = campeonato;
		this.valor = valor;
		this.colocacao = colocacao;
	}

	@Override
	public String toString() {
		return "[" + time.getId() + "] " + time.getNome() + " / " + time.getMascote() + " " + campeonato.getNome()
				+ "\n" + campeonato.getIndex() + "/" + campeonato.getQuantidade() + "\n" + "R$ " + this.valor + "\n";
	}

}
