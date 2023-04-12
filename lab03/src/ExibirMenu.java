import java.util.Scanner;

public class ExibirMenu {
	
	public static String menu(Scanner scanner) {
		System.out.print("\n---"
				+ "\nMENU\n"
				+ "(C)adastrar contato\n"
				+ "(L)listar Contatos\n"
				+ "(E)Exibir Contato\n"
				+ "(S)air"
				+ "\n"
				+ "Opção> " );
		return scanner.next().toUpperCase();
	}
	
	public static void verificandoAlternativa(String escolha,Agenda agenda, Scanner sc) {
		switch(escolha) {
		case "C":
			Agenda.cadastraContato(sc);
			break;
		case "L":
			Agenda.listarContatos(sc);
			break;
		case "E": 
			Agenda.exibirContato();
			break;
		case "S":
			sair();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA");
		}
	}
	
	public static void sair() {
		System.out.println("Até a próxima! 😎");
		System.exit(0);
	}
}
