import java.util.Scanner;

public class MainAgenda {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		
		String escolha = "";
		while(true) {
			escolha = ExibirMenu.menu(sc);
			ExibirMenu.verificandoAlternativa(escolha, agenda, sc);
		}
	}

}
