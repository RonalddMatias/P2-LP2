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
		
		case ".":
			
		case "B":
			
		case "E":
			
		case "T":
			
		case "!":
			sair();
			break;
		default:
			System.out.println("Opção inválida");
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
	

}
