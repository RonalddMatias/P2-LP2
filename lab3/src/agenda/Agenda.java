package agenda;

import java.util.InputMismatchException;

/**
 * A classe Agenda possui alguns atributos, como as constantes TAMANHO_AGENDA e
 * TAMANHO_FAVORITOS, que definem o tamanho máximo da agenda e da lista de
 * favoritos, respectivamente. Além disso, existem dois arrays: contatos e
 * favoritos, que armazenam objetos do tipo Contato.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */

public class Agenda {

	private static final int TAMANHO_AGENDA = 100;

	private static final int TAMANHO_FAVORITOS = 10;

	private Contato[] contatos;

	private Contato[] favoritos;

	/**
	 * Construtor que auxilia na criação do objeto do tipo Agenda.
	 */

	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}

	/**
	 * Acessa a lista de favoritos mantida.
	 * 
	 * @return O array de favoritos.
	 */

	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Acessa a lista de contatos mantida.
	 * 
	 * @return O array de contatos.
	 */

	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */

	public Contato getContato(int posicao) {
		return contatos[posicao - 1];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe
	 * sobrescreve o anterior.
	 * 
	 * @param posicao   Posição do contato.
	 * @param nome      Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone  Telefone do contato.
	 * 
	 * @throws IndexOutOfBoundsException caso a entrada seja inválida
	 * @throws IllegalArgumentException o usuario não digite nem nome ou telefone
	 * @throws InputMismatchException caso ja exista um contato com o mesmo nome e sobrenome
	 */

	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
			Contato contato = new Contato(nome, sobrenome, telefone);

			if (posicao < 1 || posicao > 100) {
				throw new IndexOutOfBoundsException(); // é para adicionar sem sobrenome
				
			} else if (nome.trim().equals("") || telefone.trim().equals("")) { // o trim() tira os espaços
				throw new IllegalArgumentException();
				
			} else if (existeContato(contato)) {
				throw new InputMismatchException();
			} else {
				contatos[posicao - 1] = contato;
			}
	}

	/**
	 * Exibe as informações do contato na posição especificada.
	 * 
	 * @param posicao do contato que será apresentado.
	 * @return String do contado especificado
	 * @throws IndexOutOfBoundsException se a posição for inválida ou se não houver
	 *                                   nome cadastrado na posição especificada
	 */

	public String exibirContato(int posicao) {
		
		if (posicao < 1 || posicao > 100) {
			throw new IndexOutOfBoundsException();
		}
		if (getContato(posicao) != null) {

			return (getContato(posicao).toString());
			
		} else if (getContato(posicao) == null) {
			throw new IllegalArgumentException();
		}

		return null;
	}

	/**
	 * Método que consegue favoritar um contato ja cadastrado na agenda.
	 * 
	 * @param contato Posição pega no array de Contatos
	 * @param posicao Posição na qual o contato pego vai ser adicionado no array de
	 *                favoritos
	 * @throws IndexOutOfBoundsException caso a posição seja inválidad
	 * @throws NullPointerException se o usuario digitou um contato que ainda não existe
	 * @throws InputMismatchException caso o usuário digite um contato que ja esta na lista de favorito
	 */

	public void adicionaFavorito(int contato, int posicao) {

			if (contato < 1 || contato > TAMANHO_AGENDA) {
				throw new IndexOutOfBoundsException();
			} else if (posicao < 1 || posicao > 10) {
				throw new IndexOutOfBoundsException();
			}

			Contato contatoNaAgenda = getContato(contato);

			if (contatoNaAgenda == null) {
				System.out.println("O contato não existe na posição " + contato);
				throw new NullPointerException();
			} else if (contatoNaAgenda.isFavorito()) { // vendo se ele já é um favorito
				throw new InputMismatchException();
			} else {
				favoritos[posicao - 1] = contatoNaAgenda;
				contatoNaAgenda.setFavorito(true);
			}
	}

	/**
	 * Método que remove um contato favoritado na posição passada pelo parâmetro do
	 * tipo inteiro.
	 * 
	 * @param posicao do contato a ser removido
	 * @throws IndexOutOfBoundsException se a posição for inválida
	 */

	public void removerFavorito(int posicao) {
			if (posicao < 1 || posicao > TAMANHO_FAVORITOS) {
				throw new IndexOutOfBoundsException();
			}

			Contato contato = getContato(posicao);
			
			if (contato == null) {
				throw new NullPointerException();
			}
			
			favoritos[posicao - 1] = null;
			contato.setFavorito(false); // setando novamente para false para tirar o coração.
			System.out.println("Contato na Posição " + posicao + " foi removido");
	}

	private boolean existeContato(Contato novoContato) {
		boolean condicional = false;
		for (Contato contato : contatos) {
			if (contato != null && contato.equals(novoContato)) {
				condicional = true;
			}
		}
		return condicional;
	}

}
