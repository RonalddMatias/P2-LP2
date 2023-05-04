package MrBeat;

import java.util.Scanner;

public class MainMrBeat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MrBeat mrBeat = new MrBeat();
		
		String escolha = "";
		
		while(true) {
			escolha = menu(sc);
			comando(escolha, mrBeat, sc);
		}

	}
	
	private static String menu(Scanner sc) {
		System.out.print("\n" 
				+ "===== Menu =====\n"
				+ "\n"
				+ "(M)Minha inclusão de times\n"
				+ "(R)Recuperar time\n"
				+ "(.)Adicionar campeonato\n"
				+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"
				+ "(E)Exibir campeonatos que o time participa\n"
				+ "(T)Tentar a sorte e status\n"
				+ "(!)Já pode fechar o programa!\n"
				+ "\n"
				+ "Opção> ");
		return sc.next().toUpperCase();
	}
	
	private static void comando(String escolha, MrBeat mrBeat, Scanner sc) {
		switch (escolha) {
		case "M":
			incluirTime(mrBeat, sc);
			break;
		case "R":
			recuperarTime(mrBeat, sc);
			break;
		case ".":
			adicionaCampeonato(mrBeat, sc);
			break;
		case "B":
			incluirOuVerificar(mrBeat, sc);
			break;
		case "E":
			exibirCampeonatoQueTimeParticipa(mrBeat, sc);
			break;
		case "T":
			tentarSorteOuStatus(mrBeat, sc);
		case "!":
			sair();
			break;
		default:
			System.out.println("Opção inválida");
		}
	}
	
	private static void tentarSorteOuStatus(MrBeat mrBeat, Scanner sc) {
		sc.nextLine();
		System.out.print("(A) Apostar"
				+ "\n"
				+ "(S) Status das Apostas"
				+ "\nOpção> ");
		String alternativa = sc.nextLine();
		if(alternativa.toUpperCase().equals("A")) {
			try {
				System.out.print("Código: ");
				String id = sc.nextLine();
				System.out.print("Campeonato: ");
				String campeonato = sc.nextLine();
				System.out.println("Valor: ");
				String valor = sc.nextLine();
				System.out.println("Colocação: ");
				int colocacao = sc.nextInt();
	
				mrBeat.apostar(id, campeonato, valor, colocacao);
				
			} catch (IllegalAccessException error) {
				System.out.println(error.getMessage());
			}
			
		} else if (alternativa.toUpperCase().equals("S")) {
			
		} else {
			System.out.println("OPÇÃO INVÁLIDA");
		}
		
	}

	private static void exibirCampeonatoQueTimeParticipa(MrBeat mrBeat, Scanner sc) {
		try {
			sc.nextLine();
			System.out.print("Time: ");
			String id = sc.nextLine();
			System.out.println(mrBeat.exibirCampeonatoQueTimeParticipa(id));
			
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
		}
		
	}

	private static void sair() {
		System.out.println("Fim do Programa!");
		System.exit(0);
	}
	
	private static void incluirTime(MrBeat mrbeat, Scanner sc) {
		sc.nextLine();
		System.out.print("Código: ");
		String id = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Mascote: ");
		String mascote = sc.nextLine();
		mrbeat.incluirTime(id, nome, mascote);
		
		
	}
	
	private static void recuperarTime(MrBeat mrbeat, Scanner sc) {
		sc.nextLine();
		System.out.println("Código: ");
		String id = sc.nextLine();
		System.out.println(mrbeat.recuperarTime(id));
	}
	
	private static void adicionaCampeonato(MrBeat mrbeat, Scanner sc) {
		sc.nextLine();
		System.out.print("Campeonato: ");
		String nome = sc.nextLine();
		System.out.print("Participantes: ");
		int qtd = sc.nextInt();
		mrbeat.adicionarCampeonato(nome, qtd);
	}
	
	private static void incluirOuVerificar(MrBeat mrbeat, Scanner sc) {
		sc.nextLine();
		System.out.print("(I) Incluir time em campeonato"
				+ "\n"
				+ "(V) Verificar se time está em campeonato"
				+ "\nOpção> ");
		String alternativa = sc.nextLine();
		if(alternativa.toUpperCase().equals("I")) {
			
			try {
				System.out.print("Código: ");
				String id = sc.nextLine();
				System.out.print("Campeonato: ");
				String campeonato = sc.nextLine();
				mrbeat.incluirTime(id, campeonato);
				System.out.println("TIME INCLUÍDO NO CAMPEONATO!");
			} catch(IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
			
		}
		
		else if (alternativa.toUpperCase().equals("V")) {
			
			try {
				System.out.print("Código: ");
				String id = sc.nextLine();
				System.out.print("Campeonato: ");
				String campeonato = sc.nextLine();
				mrbeat.verificarTimeNoCampeonato(id, campeonato);
			} catch(IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
			
		} else {
			System.out.println("OPÇÃO INVÁLIDA");
		}
		
	}
	

}
