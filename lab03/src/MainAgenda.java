import java.util.Scanner;

public class MainAgenda {

	public static void main(String[] args) throws NullPointerException{
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		
		String escolha = "";
		while(true) {
			try{
				escolha = ExibirMenu.menu(sc);
				ExibirMenu.verificandoAlternativa(escolha, agenda, sc);
			} catch(NullPointerException error) {
				System.out.println(error.getMessage());
			}
		}
		
	}

}
