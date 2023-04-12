import java.util.Scanner;

/**
 * Agenda terá contato, que por sua vez sera representado por uma array de
 * Contato
 * 
 * @author Ronaldd Matias - 110122574
 *
 */

	public class Agenda {
	
		private static Contato[] contatos;
	
		public Agenda() {
			this.contatos = new Contato[100];
		}
	
		public static void cadastraContato(Scanner sc) {
			System.out.print("\nPosição na agenda> ");
			int posicao  = sc.nextInt();
			System.out.print("\nNome> ");
			String nome = sc.next();
			System.out.print("\nSobrenome> ");
			String sobrenome = sc.next();
			System.out.print("\nTelefone> ");
			String telefone = sc.next();
			Contato contato = new Contato(posicao, nome, sobrenome, telefone);
			contatos[posicao] = contato;
			System.out.println("CONTATO ADICIONADO COM SUCESSO");
	
		}
	public static void listarContatos(Scanner scanner) {
		System.out.println("Lista de Contatos:");
		for(int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				System.out.printf("%d - Nome: %s",i, contatos[i].getNome());
			}
		}
		
	}

	public static void exibirContato() {
		// TODO Auto-generated method stub
	}
}
