import java.util.Scanner;

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Construtor que auxilia na iniciliazação do objeto contato.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	public Contato(int posicao, String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Método que retorna o nome 
	 * 
	 * @return nome do contato 
	 */
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;	
	}
	
	public String getTelefone() {
		return telefone;
	}
	
}
