package agenda;

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
	 */

	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		try {

			if (posicao < 1 || posicao > TAMANHO_AGENDA) {
				throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
			} else if (nome.trim().equals("") || telefone.trim().equals("")) { // o trim() tira os espaços
				throw new IllegalArgumentException("Entrada inválida");
			} else if (existeContato(nome, sobrenome)) {
				throw new Exception("Nome já cadastrado!");
			} else {
				Contato contato = new Contato(nome, sobrenome, telefone);
				contatos[posicao - 1] = contato;
				System.out.println("Contato Cadastrado");
				return true;
			}
		} catch (IllegalArgumentException error) {
			System.out.println("Error: " + error.getMessage());
		} catch (IndexOutOfBoundsException error) {
			System.out.println("Error: " + error.getMessage());
		} catch (Exception error) {
			System.out.println("Error: " + error.getMessage());
		}
		return false;
	}

	/**
	 * Exibe as informações do contato na posição especificada.
	 * 
	 * @param posicao do contato que será apresentado.
	 * @return true se a operação for bem-sucedida ou false caso contrário
	 * @throws IndexOutOfBoundsException se a posição for inválida ou se não houver
	 *                                   nome cadastrado na posição especificada
	 */

	public boolean exibirContato(int posicao) {
		try {

			if (getContato(posicao) != null) {
				System.out.println(getContato(posicao).toString());
				return true;
			} else if (getContato(posicao) == null) {
				throw new IndexOutOfBoundsException("NENHUM NOME CADASTRADO NESSA POSIÇÃO");
			} else {
				throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
			}

		} catch (IndexOutOfBoundsException error) {
			System.out.println();
			System.out.println("Error: " + error.getMessage());
		}
		return false;
	}

	/**
	 * Método que consegue favoritar um contato ja cadastrado na agenda.
	 * 
	 * @param contato Posição pega no array de Contatos
	 * @param posicao Posição na qual o contato pego vai ser adicionado no array de
	 *                favoritos
	 * @return true se o contato foi adicionado com sucesso ou false caso contrário.
	 * @throws IndexOutOfBoundsException caso a posição deja
	 */

	public boolean adicionaFavorito(int contato, int posicao) {

		try {

			if (contato < 1 || contato > TAMANHO_AGENDA) {
				throw new IndexOutOfBoundsException("POSICAO INVÁLIDA");
			} else if (posicao < 1 || posicao > 10) {
				throw new IndexOutOfBoundsException("POSICAO INVÁLIDA");
			}

			Contato contatoNaAgenda = getContato(contato);

			if (contatoNaAgenda == null) {
				System.out.println("O contato não existe na posição " + contato);
				return false;
			} else if (contatoNaAgenda.isFavorito()) { // vendo se ele já é um favorito
				System.out.println("Esse contato já foi adicionado como favorito");
				return false;
			}

			favoritos[posicao - 1] = contatoNaAgenda;
			contatoNaAgenda.setFavorito(true);
			System.out.println("CONTATO fAVORITADO NA POSIÇÃO " + posicao);
			return true;

		} catch (IndexOutOfBoundsException error) {
			System.out.println("Error: " + error.getMessage());
		} catch (NullPointerException err) {
			System.out.println("Error: " + err.getMessage()); // REMOVER ESSA EXCEÇÃO
		}
		return false;

	}

	/**
	 * Método que remove um contato favoritado na posição passada pelo parâmetro do
	 * tipo inteiro.
	 * 
	 * @param posicao do contato a ser removido
	 * @return true se o contato foi removido com sucesso ou false caso contrário.
	 * @throws IndexOutOfBoundsException se a posição for inválida
	 */

	public boolean removerFavorito(int posicao) {
		try {
			if (posicao < 1 || posicao > TAMANHO_FAVORITOS) {
				throw new IndexOutOfBoundsException("Posição Inválida");
			}

			Contato contato = getContato(posicao);

			favoritos[posicao - 1] = null;
			contato.setFavorito(false); // setando novamente para false para tirar o coração.
			System.out.println("Contato na Posição " + posicao + " foi removido");
			return true;
		} catch (IndexOutOfBoundsException error) {
			System.out.println("Error " + error.getMessage());
		}
		return false;

	}

	private boolean existeContato(String nome, String sobrenome) {
		boolean condicional = false;
		for (Contato contato : contatos) {
			if (contato != null && contato.getNome().equals(nome) && contato.getSobrenome().equals(sobrenome)) {
				condicional = true;
			}
		}
		return condicional;
	}

}
