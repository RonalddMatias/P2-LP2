package MrBeat;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class MrBeat {

	private ArrayList<Time> times;
	private ArrayList<Campeonato> campeonatos;
	private ArrayList<Aposta> aposta;

	public MrBeat() {
		this.times = new ArrayList<>();
		this.campeonatos = new ArrayList<>();
		this.aposta = new ArrayList<>();
	}

	public void incluirTime(String id, String nome, String mascote) {
		Time time = new Time(id, nome, mascote);

		if (existeTime(time)) {
			System.out.println("TIME JÁ EXISTE!");
		} else {
			times.add(time);
			System.out.println("INCLUSÃO REALIZADA!");
		}

	}

	public String recuperarTime(String id) {
		String retorno = "";
		Time timeTemp = new Time(id, null, null);

		if (times.contains(timeTemp)) {
			int index = times.indexOf(timeTemp); // Pegando o objeto que contem o ID
			retorno += times.get(index).toString();

		} else {
			retorno += "TIME NÃO EXISTE";
		}
		return retorno;
	}

	public void adicionarCampeonato(String nome, int qtd) {
		Campeonato campeonato = new Campeonato(nome, qtd);

		if (existeCampeonato(campeonato)) {
			System.out.println("Campeonato já existente");
		} else {
			campeonatos.add(campeonato);
			System.out.println("Campeonato Cadastrado");
		}
	}

	public void incluirTime(String id, String campeonato) {
		Time timeTemp = new Time(id, null, null);
		Campeonato campTemp = new Campeonato(campeonato, 0);

		if (times.contains(timeTemp)) {

			int index = times.indexOf(timeTemp);
			timeTemp = times.get(index); // posição em que o objjeto tem o nome igual

			if (campeonatos.contains(campTemp)) {

				try {
					
					int pos = campeonatos.indexOf(campTemp);
					campTemp = campeonatos.get(pos);
					campTemp.adicionaTime(timeTemp);
					timeTemp.addCampeonato(campTemp);

				} catch (IndexOutOfBoundsException error) {
					System.out.println(error.getMessage());
				}

			} else {
				throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE");
			}

		} else {
			throw new IllegalArgumentException("TIME NÃO EXISTE");
		}
	}

	public void verificarTimeNoCampeonato(String id, String campeonato) {
		Time timeTemporario = new Time(id, null, null);
		Campeonato campTemporario = new Campeonato(campeonato, 0);
		
		if(times.contains(timeTemporario)) {
			int index = times.indexOf(timeTemporario);
			timeTemporario = times.get(index);
			
			if(campeonatos.contains(campTemporario)) {
				try {
					int posicao = campeonatos.indexOf(campTemporario);
					campTemporario = campeonatos.get(posicao);
					campTemporario.verificarTime(timeTemporario);
				} catch(IllegalArgumentException error) {
					System.out.println(error.getMessage());
				}
				
			} else {
				throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE.");
			}
		}
		else {
			throw new IllegalArgumentException("TIME NÃO EXISTE");
		}
	}
	
	public String exibirCampeonatoQueTimeParticipa(String id) {
		Time timeTemporario = new Time(id, null, null);
		
		if(times.contains(timeTemporario)){
			
			int index = times.indexOf(timeTemporario);
			timeTemporario = times.get(index);
			return timeTemporario.exibirCampeonatos();
			
		} else {
			throw new IllegalArgumentException("TIME NÃO EXISTE.");
		}
		
	}
	
	public void apostar(String id, String campeonato,String valor, int colocacao) {
		Time timeTemporario = new Time(id, null, null);
		Campeonato
	}

	private boolean existeCampeonato(Campeonato campeonato) {
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos.get(i) != null
					&& campeonatos.get(i).getNome().toLowerCase().equals(campeonato.getNome().toLowerCase())) {
				return true;
			}
		}

		return false;
	}
	
	private boolean existeTime(Time time) {
		for (int i = 0; i < times.size(); i++) {
			if (times.get(i) != null && times.get(i).equals(time)) {
				return true;
			}
		}
		return false;
	}

	

}
