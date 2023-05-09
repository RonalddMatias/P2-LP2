package MrBeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class MrBeat {

	private HashMap<String, Time> times;
	private HashSet<Campeonato> campeonatos;
	private ArrayList<Aposta> apostas;

	public MrBeat() {
		this.times = new HashMap<>();
		this.campeonatos = new HashSet<>();
		this.apostas = new ArrayList<>();
	}

	public String incluirTime(String id, String nome, String mascote) {
		Time time = new Time(id, nome, mascote);
		
		if (times.containsKey(id)) {
			return "TIME JÁ EXISTE!";
		} 
		times.put(id, time);
		return "INCLUSÃO REALIZADA!";
	}

	public String recuperarTime(String id) {
		
		if (times.containsKey(id)) {
			return times.get(id).toString();
		}
		
		throw new IllegalArgumentException("TIME NÃO EXISTE.");
	}

	public String adicionarCampeonato(String nome, int qtd) {
		if (existeCampeonato(nome) == null) {
			campeonatos.add(new Campeonato(nome, qtd));
			return "CAMPEONATO ADICINADO";
		}
		throw new IllegalArgumentException("CAMPEONATO JÁ EXISTE");
	}

	public boolean incluirTime(String id, String campeonato) {
		
		if(!times.containsKey(id)){
			throw new NoSuchElementException("TIME NÃO EXISTE");
		}
		
		if(existeCampeonato(campeonato) == null) {
			throw new NoSuchElementException("CAMPEONATO NÃO EXISTE")
		}
		
		Time timeTemp = new Time(id, null, null);
		Campeonato campTemp = new Campeonato(campeonato, 0);

		if (times.contains(timeTemp)) {

			int index = times.indexOf(timeTemp);
			timeTemp = times.get(index); // posição em que o objjeto tem o nome igual

			if (campeonatos.contains(campTemp)) {

				try {

					int pos = campeonatos.indexOf(campTemp);
					campTemp = campeonatos.get(pos);
					
					if(campTemp.verificarTime(timeTemp)) {
						return false;
					}
					campTemp.adicionaTime(timeTemp);
					timeTemp.addCampeonato(campTemp);
					return true;

				} catch (IndexOutOfBoundsException error) {
					System.out.println(error.getMessage());
				}

			} else {
				throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE");
			}

		} else {
			throw new IllegalArgumentException("TIME NÃO EXISTE");
		}
		return false;
	}

	public boolean verificarTimeNoCampeonato(String id, String campeonato) {
		Time timeTemporario = new Time(id, null, null);
		Campeonato campTemporario = new Campeonato(campeonato, 0);

		if (times.contains(timeTemporario)) {
			int index = times.indexOf(timeTemporario);
			timeTemporario = times.get(index);

			if (campeonatos.contains(campTemporario)) {
				try {
					int posicao = campeonatos.indexOf(campTemporario);
					campTemporario = campeonatos.get(posicao);
					
					if(campTemporario.verificarTime(timeTemporario)) {
						return true;
					} else {
						return false;
					}
					
				} catch (IllegalArgumentException error) {
					System.out.println(error.getMessage());
				}

			} else {
				throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE.");
			}
		} else {
			throw new IllegalArgumentException("TIME NÃO EXISTE");
		}
		return false;
	}

	public String exibirCampeonatoQueTimeParticipa(String id) {
		Time timeTemporario = new Time(id, null, null);

		if (times.contains(timeTemporario)) {

			int index = times.indexOf(timeTemporario);
			timeTemporario = times.get(index);
			return timeTemporario.exibirCampeonatos();

		} else {
			throw new IllegalArgumentException("TIME NÃO EXISTE.");
		}

	}

	public void apostar(String id, String campeonato, double valor, int colocacao) {
		Time timeTemporario = new Time(id, null, null);
		Campeonato campeonatoTemporario = new Campeonato(campeonato, 0);

		if (times.contains(timeTemporario)) {
			int index = times.indexOf(timeTemporario);
			timeTemporario = times.get(index);
			if (campeonatos.contains(campeonatoTemporario)) {
				int posicao = campeonatos.indexOf(campeonatoTemporario);
				campeonatoTemporario = campeonatos.get(posicao);
				
				if(colocacao < campeonatoTemporario.getQuantidade()) {
					Aposta aposta = new Aposta(timeTemporario, campeonatoTemporario, valor, colocacao);
					apostas.add(aposta);
				} else {throw new IllegalArgumentException("APOSTA NÃO REGISTRADA");}
				
			} else {throw new IllegalArgumentException("CAMPEONATO NÃO EXISTENTE");}
		} else {throw new IllegalArgumentException("TIME NÃO EXISTE");}
	}
	
	public String statusDaAposta() {
		String retorno = "";
		for(int i = 0; i < apostas.size(); i++) {
			if(apostas.get(i) != null) {
				retorno += apostas.get(i).toString();
			}
		}
		return retorno;
	}

	
	// vendo se existe um campeonato ja existente
	private Campeonato existeCampeonato(String nome) {
		
		Campeonato retorno = null;
		Campeonato campTemporario =  new Campeonato(nome, 0);
		for (Campeonato campeonato : campeonatos) {
			if(campeonato.equals(campTemporario)) {
				retorno = campeonato;
				break;
			}
		}
		return retorno;
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
