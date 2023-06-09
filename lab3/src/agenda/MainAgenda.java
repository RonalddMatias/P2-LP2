package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade + Ronaldd Matias
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		
		System.out.println("Carregando agenda inicial");
		try {
			
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(F)avoritos\n" + 
						"(A)diciona Favorito\n" +
						"(R)emover Favorito\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionarFavorito(agenda, scanner);
			break;
		case "R":
			removerFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	private static void listaFavoritos(Agenda agenda) {
		System.out.println("Lista de Favoritos: ");
		Contato[] favorito = agenda.getFavoritos();
		for(int i = 0; i < favorito.length; i++) {
			if(favorito[i] != null) {
				System.out.println(i + " - " + favorito[i].getNome() + " " + favorito[i].getSobrenome());
			}
		}
		
	}

	private static void removerFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Posiçao> ");
		int posicao = scanner.nextInt();
		try {
			agenda.removerFavorito(posicao);
		} catch (IndexOutOfBoundsException error) {
			System.out.println("Posição Inválida");
		} catch (NullPointerException error) {
			System.out.println("Essa posição não existe nenhum contato para ser removido");
		}
		
	}

	private static void adicionarFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int contato = scanner.nextInt();
		System.out.print("Posiçao> ");
		int posicao = scanner.nextInt();
		
		try {
			agenda.adicionaFavorito(contato, posicao);
			System.out.println("CONTATO fAVORITADO NA POSIÇÃO " + posicao);
			
		} catch (IndexOutOfBoundsException error){
			System.out.println("POSICAO INVÁLIDA");
		} catch (NullPointerException error) {
		} catch (InputMismatchException error) {
			System.out.println("Esse contato já foi adicionado como favorito");
		}
		
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for(int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				System.out.println(i + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome());
			}
			
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		try {
			
			System.out.println(agenda.exibirContato(posicao));
			
		} catch (IllegalArgumentException error) {
			System.out.println("NENHUM CONTATO CADASTRADO NESSA POSIÇÃO" );
		} catch (IndexOutOfBoundsException error) {
			System.out.println("POSIÇÃO INVÁLIDA");
		}
		
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		try {
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
			System.out.println("Contato Cadastrado com sucesso");
			
		} catch(IllegalArgumentException error) {
			System.out.println("Entrada Inválida");
		} catch(InputMismatchException error) {
			System.out.println("CONTATO JÁ CADASTRADO");
		} catch(IndexOutOfBoundsException error) {
			System.out.println("POSIÇÃO INVÁLIDA");
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("Fim do Programa.");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
