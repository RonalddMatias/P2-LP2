package MrBeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * Classe que tem como objetivo criar objetos do tipo MrBeat, que possue um
 * HashMap com chave sendo uma String e o valor sendo um objeto do tipo Time. Um
 * hashMap do tipo campeonato e também um arrayList do tipo Aposta.
 * 
 * @author Ronaldd Matias - 122110574
 */
public class MrBeat {

	private HashMap<String, Time> times;
	private HashSet<Campeonato> campeonatos;
	private ArrayList<Aposta> apostas;

	/**
	 * Construtor que auxilia na criação do objeto do tipo MrBeat.
	 */
	public MrBeat() {
		this.times = new HashMap<>();
		this.campeonatos = new HashSet<>();
		this.apostas = new ArrayList<>();
	}

	/**
	 * Método que tem por objetivo instaciar um novo time e adiciona-lo no HashMap
	 * caso não tenha um time ja existente.
	 * 
	 * @param id      identificador do time
	 * @param nome    nome do time
	 * @param mascote mascote do time
	 * @return "TIME JÁ EXISTE" se possui uma key igual ou "INCLUSÃO REALIZADA" caso
	 *         não possua nem uma key igual.
	 */
	public String incluirTime(String id, String nome, String mascote) {
		Time time = new Time(id, nome, mascote);

		if (times.containsKey(id)) {
			return "TIME JÁ EXISTE!";
		}
		times.put(id, time);
		return "INCLUSÃO REALIZADA!";
	}

	/**
	 * Recupera os dados de um time com base no seu ID.
	 * 
	 * @param id o ID do time a ser recuperado
	 * @return uma String contendo as informações do time, se o ID existir no mapa
	 *         de times.
	 * @throws IllegalArgumentException se o ID do time não existir no mapa de times
	 */

	public String recuperarTime(String id) {

		if (times.containsKey(id)) {
			return times.get(id).toString();
		}

		throw new IllegalArgumentException("TIME NÃO EXISTE.");
	}

	/**
	 * Adiciona um novo campeonato à lista de campeonatos do sistema.
	 * 
	 * @param nome o nome do novo campeonato a ser adicionado
	 * @param qtd  a quantidade de times que participarão do novo campeonato
	 * @return uma mensagem informando que o campeonato foi adicionado com sucesso
	 * @throws IllegalArgumentException se já existir um campeonato com o mesmo nome
	 *                                  na lista de campeonatos.
	 */

	public String adicionarCampeonato(String nome, int qtd) {
		if (getCampeonato(nome) == null) {
			campeonatos.add(new Campeonato(nome, qtd));
			return "CAMPEONATO ADICIONADO";
		}
		throw new IllegalArgumentException("CAMPEONATO JÁ EXISTE");
	}

	/**
	 * Inclui um time em um campeonato específico.
	 * 
	 * @param id         o identificador do time a ser incluído
	 * @param campeonato o nome do campeonato onde o time será incluído
	 * @return uma mensagem indicando se o time foi incluído no campeonato ou se já
	 *         estava incluso
	 * @throws NoSuchElementException    se o time ou o campeonato não existirem
	 * @throws IndexOutOfBoundsException se todos os times já tiverem sido incluídos
	 *                                   no campeonato
	 */

	public String incluirTime(String id, String campeonato) {

		if (!times.containsKey(id)) {
			throw new NoSuchElementException("TIME NÃO EXISTE");
		}

		if (getCampeonato(campeonato) == null) {
			throw new NoSuchElementException("CAMPEONATO NÃO EXISTE");
		}

		Time timeTemp = times.get(id);
		Campeonato campTemp = getCampeonato(campeonato);

		if (campTemp.verificarTime(timeTemp)) {
			return "TIME INCLUÍDO NO CAMPEONATO"; // não adiciona
		}

		if (!campTemp.adicionaTime(timeTemp)) {
			throw new IndexOutOfBoundsException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUSOS");
		}

		timeTemp.addCampeonato(campTemp);
		return "TIME INCLUÍDO NO CAMPEONATO";
	}

	/**
	 * Verifica se um time está cadastrado em um determinado campeonato.
	 * 
	 * @param id         o identificador do time a ser verificado
	 * 
	 * @param campeonato o nome do campeonato a ser verificado
	 * 
	 * @return true se o time estiver cadastrado no campeonato, false caso contrário
	 * 
	 * @throws NoSuchElementException se o time não estiver cadastrado no sistema ou
	 *                                se o campeonato não existir
	 */

	public boolean verificarTimeNoCampeonato(String id, String campeonato) {

		if (!times.containsKey(id)) {
			throw new NoSuchElementException("TIME NÃO EXISTE");
		}

		if (getCampeonato(campeonato) == null) {
			throw new NoSuchElementException("TIME NÃO ENCONTRADO");
		}

		Time timeTemporario = times.get(id);
		Campeonato campTemporario = getCampeonato(campeonato);

		if (campTemporario.verificarTime(timeTemporario)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Retorna uma String com o nome dos campeonatos que o time com o id informado
	 * está participando.
	 * 
	 * @param id o id do time cujos campeonatos devem ser exibidos.
	 * @return uma String com o nome dos campeonatos que o time com o id informado
	 *         está participando.
	 * @throws NoSuchElementException se não houver um time com o id informado.
	 */

	public String exibirCampeonatoQueTimeParticipa(String id) {

		if (!times.containsKey(id)) {
			throw new NoSuchElementException("TIME NÃO EXISTE.");
		}

		Time timeTemporario = times.get(id);
		return timeTemporario.exibirCampeonatos();

	}

	/**
	 * 
	 * Realiza uma aposta em um campeonato para um determinado time.
	 * 
	 * @param id         o identificador do time que realizará a aposta
	 * @param campeonato o nome do campeonato em que a aposta será realizada
	 * @param valor      o valor apostado
	 * @param colocacao  a colocação prevista para o time na competição
	 * @return uma mensagem de confirmação da aposta
	 * @throws NoSuchElementException   se o time ou o campeonato não existirem
	 * @throws IllegalArgumentException se a colocação prevista for maior que a
	 *                                  quantidade de times no campeonato
	 */
	public String apostar(String id, String campeonato, double valor, int colocacao) {

		if (!times.containsKey(id)) {
			throw new NoSuchElementException("TIME NÃO EXISTE");
		}

		if (getCampeonato(campeonato) == null) {
			throw new NoSuchElementException("CAMPEONATO NÃO EXISTE");
		}

		Time timeTemporario = times.get(id);
		Campeonato campeonatoTemporario = getCampeonato(campeonato);

		if (colocacao > campeonatoTemporario.getQuantidade()) {
			throw new IllegalArgumentException("APOSTA NÃO REGISTRADA");
		}

		Aposta aposta = new Aposta(timeTemporario, campeonatoTemporario, valor, colocacao);
		apostas.add(aposta);
		return "APOSTA REALIZADA!";

	}

	/**
	 * 
	 * Retorna o status atual de todas as apostas registradas no sistema.
	 * 
	 * @return uma string contendo informações sobre todas as apostas registradas.
	 */
	
	public String statusDaAposta() {
		String retorno = "";
		for (int i = 0; i < apostas.size(); i++) {
			if (apostas.get(i) != null) {
				retorno += apostas.get(i).toString();
			}
		}
		return retorno;
	}

	private Campeonato getCampeonato(String nome) {

		Campeonato retorno = null;
		Campeonato campTemporario = new Campeonato(nome, 0);
		for (Campeonato campeonato : campeonatos) {
			if (campeonato.equals(campTemporario)) {
				retorno = campeonato;
				break;
			}
		}
		return retorno;
	}
}
