package Testes;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

/**
 * Classe AgendaTest tem o objetivo de criar testes da classe Agenda.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */

class AgendaTest {

	private Agenda agendaTeste;

	@BeforeEach
	void preparaAgenda() {
		Agenda agenda = new Agenda();
		this.agendaTeste = agenda;

	}

	@Test
	@DisplayName("Testando com todos os parâmetros.")
	void testaCadastroContato01() {
		agendaTeste.cadastraContato(1, "João", "Henrique", "12345678");
		agendaTeste.cadastraContato(100, "João", "Gabriel", "12345623");
	}

	@Test
	@DisplayName("Testando contato sem o parâmetro nome")
	void testaCadastroContato03() {
		assertThrows(IllegalArgumentException.class,
				() -> agendaTeste.cadastraContato(100, " ", "Felipe", "4377432883"));
	}

	@Test
	@DisplayName("Testando contato sem o parâmetro sobrenome")
	void testaCadastroContato04() {
		agendaTeste.cadastraContato(2, "Joazquiem", "", "23232123");
	}

	@Test
	@DisplayName("Testando contato sem o parâmetro telefone.")
	void testaCadastroContato05() {
		assertThrows(IllegalArgumentException.class, () -> agendaTeste.cadastraContato(100, "Matias", "Felipe", ""));
	}

	@Test
	@DisplayName("Testando acima da posição suportada pelo array")
	void testaCadastroContato06() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> agendaTeste.cadastraContato(101, "juazeirinho", "Felipe", "32323232"));
	}

	@Test
	@DisplayName("Testando contato abaixo da posiçao suportada pelo array.")
	void testaCadastroContato07() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> agendaTeste.cadastraContato(-1, "juazeirinho", "Felipe", "123142232"));
	}

	@Test
	@DisplayName("Adicionando um contato ja existente")
	void testaCadastroContato08() {
		agendaTeste.cadastraContato(3, "Ronaldd", "Feliph", "12345678");
		assertThrows(InputMismatchException.class,
				() -> agendaTeste.cadastraContato(22, "Ronaldd", "Feliph", "21763761273"));
	}

	@Test
	@DisplayName("Exibindo Contato cadastrado")
	void testaExibirContatao01() {
		agendaTeste.cadastraContato(4, "joao", "da costa", "32318237");
		assertEquals("joao da costa\n32318237", agendaTeste.exibirContato(4));
	}

	@Test
	@DisplayName("Exibindo contato que ainda não foi cadastrado em uma certa posição")
	void testaExibirContatao02() {
		System.out.println("===========");
		agendaTeste.cadastraContato(4, "joao", "da costa", "32318237");

		assertThrows(IllegalArgumentException.class, () -> agendaTeste.exibirContato(5));

	}

	@Test
	@DisplayName("exibindo contato que acima do limite permitido")
	void testaExibirContatao03() {

		agendaTeste.cadastraContato(13, "joao", "da costa", "32318237");

		assertThrows(IndexOutOfBoundsException.class, () -> agendaTeste.exibirContato(101));
	}

	@Test
	@DisplayName("exibindo contato que abaixo do limite permitido")
	void testaExibirContatao04() {
		agendaTeste.cadastraContato(13, "joao", "da costa", "32318237");

		assertThrows(IndexOutOfBoundsException.class, () -> agendaTeste.exibirContato(-1));

	}

	@Test
	@DisplayName("Testando quando favoritar um contato")
	void testaContatoFavorito01() {
		agendaTeste.cadastraContato(1, "Matias", "Costa", "83 92230012");
		agendaTeste.adicionaFavorito(1, 4);
	}

	@Test
	@DisplayName("Tentando favoritar um contado que não existe")
	void testaContatoFavorito02() {
		agendaTeste.cadastraContato(1, "Matias", "Costa", "83 92230012");
		assertThrows(NullPointerException.class, () -> agendaTeste.adicionaFavorito(2, 1));
	}

	@Test
	@DisplayName("Testando quando favoritar em uma posição acima do limite")
	void testaContatoFavorito03() {
		agendaTeste.cadastraContato(5, "Odaize", "Trajano", "24184728361789");
		assertThrows(IndexOutOfBoundsException.class, () -> agendaTeste.adicionaFavorito(5, 11));
	}

	@Test
	@DisplayName("Testando quando favoritar em uma posição abaixo do limite")
	void testaContatoFavorito04() {
		agendaTeste.cadastraContato(5, "Odaize", "Trajano", "24184728361789");
		assertThrows(IndexOutOfBoundsException.class, () -> agendaTeste.adicionaFavorito(5, -1));
	}

	@Test
	@DisplayName("Testando favoritar um contato que ja esta favoritado")
	void testaContatoFavorito05() {
		agendaTeste.cadastraContato(1, "Matias", "Costa", "83 92230012");
		agendaTeste.adicionaFavorito(1, 1);
		assertThrows(InputMismatchException.class, () -> agendaTeste.adicionaFavorito(1, 3));
	}

	@Test
	@DisplayName("exibindo um contato favoritado OBS: O contato deve aparecer com um coração")
	void testaContatoFavorito06() {
		agendaTeste.cadastraContato(1, "Julia", "Ferreira", "83 9123124");
		agendaTeste.adicionaFavorito(1, 1);
		assertEquals("❤️ Julia Ferreira\n83 9123124", agendaTeste.exibirContato(1));
	}

	@Test
	@DisplayName("Testando remoção de um contato favoritado")
	void testeRemoveContatoFavoritado01() {
		agendaTeste.cadastraContato(1, "Mateus", "da Costa", "23212123");
		agendaTeste.adicionaFavorito(1, 1);
		agendaTeste.removerFavorito(1);
	}

	@Test
	@DisplayName("Testando a exibição de um contato depois dele ser removido")
	void testeRemoveContatoFavoritado02() {
		agendaTeste.cadastraContato(1, "Odaize", "Trajano", "239432931");
		agendaTeste.adicionaFavorito(1, 1);
		agendaTeste.removerFavorito(1);
		assertEquals("Odaize Trajano\n239432931", agendaTeste.exibirContato(1));
	}

	@Test
	@DisplayName("Tentando remover favorito acima do limite permitido")
	void testeRemoveContatoFavoritado03() {

		agendaTeste.cadastraContato(1, "José", "Robério", "239432931");
		agendaTeste.adicionaFavorito(1, 1);
		assertThrows(IndexOutOfBoundsException.class, () -> agendaTeste.removerFavorito(11));
	}


	@Test
	@DisplayName("Tentando remover favorito abaixo do limite permitido")
	void testeRemoveContatoFavoritado04() {
		agendaTeste.cadastraContato(1, "José", "Robério", "239432931");
		agendaTeste.adicionaFavorito(1, 1);
		assertThrows(IndexOutOfBoundsException.class, () -> agendaTeste.removerFavorito(-1));

	}
	
	@Test
	@DisplayName("Tentando remover um favorito que não foi favoritado")
	void testeRemoveContatoFavoritado05() {
		agendaTeste.cadastraContato(1, "Karlos", "Alberto", "2312135");
		agendaTeste.adicionaFavorito(1, 1);
		assertThrows(NullPointerException.class, () -> agendaTeste.removerFavorito(2));

	}

}
