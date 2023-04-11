import java.util.Scanner;

public class ExibirMenu {
	
	public static String menu(Scanner scanner) {
		System.out.println("\n---"
				+ "\nMENU\n"
				+ "(C)adastrar contato\n"
				+ "(L)listar Contatos\n"
				+ "(E)Exibir Contato\n"
				+ "(S)air"
				+ "\n"
				+ "Opção>" );
		return scanner.next().toUpperCase();
	}
	
	public static void verificandoAlternativa(String escolha,Agenda agenda, Scanner scanner) {
		switch(escolha) {
		case "C":
			Contato.cadastraContato(agenda, scanner);
		}
	}
}
