package DocuMin;

import entities.*;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ControllerDocumento {
	
	private HashMap<String, Documento> documentos;

	public ControllerDocumento() {
		this.documentos = new HashMap<>();
	}
	
	public boolean criarDocumento(String titulo){
		if(documentos.containsKey(titulo)) {
			return false;
		}
		
		if(verificaTitulo(titulo)) {
			return false;
		}
		
		documentos.put(titulo, new Documento(titulo));
		return true;
	}
	public boolean criarDocumento(String titulo, int qtdMaxima) {
		if(documentos.containsKey(titulo)) {
			return false;
		}
		
		if(qtdMaxima <= 0) {
			throw new IllegalArgumentException();
		}
		
		if(verificaTitulo(titulo)) {
			return false;
		}

		documentos.put(titulo, new Documento(titulo, qtdMaxima));
		return true;
	}
	
	public void removerDocumento(String titulo) {
		if(!documentos.containsKey(titulo)) {
			throw new NoSuchElementException("Documento não cadastrado!");
		}
		documentos.remove(titulo);
	}
	
	// Irá retorna a quantidade de elementos cadastrados dentro de um documento.
	public int contarElementos(String titulo) {
		int cont = 0;
		if(!documentos.containsKey(titulo)){
			throw new NoSuchElementException("Documento não cadastrado");
		}
		Documento documento = documentos.get(titulo);
		for (int i = 0; i < documento.getElementos().size(); i++){
			if (documento.getElementos().get(i) != null){
				cont++;
			}
		}
		return cont;
	}
	
	// Irá retorna uma representação dos elementos que podem ter em um determinado documento.
	public String[] exibirDocumento(String titulo) {
		return null;
	}
	


	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento texto = new Texto(prioridade, valor);
		return documento.adicionaElementos(texto);
	}

	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento titulo = new Titulo(prioridade,valor,nivel, linkavel);
		return documento.adicionaElementos(titulo);
	}

	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento lista = new Lista(prioridade,tituloDoc, valorLista, separador, charLista);
		return documento.adicionaElementos(lista);
	}

	public int criarTermo(String tituloDoc, String valorTermo, int prioridade, String separador, String ordem){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento termo = new Termos(prioridade, valorTermo,separador,ordem);
		return documento.adicionaElementos(termo);
	}

	private Documento pegarDocumentoEspecifico(String titulo){
		Documento documento = documentos.get(titulo);
		if(documento == null) {throw new NoSuchElementException("Elemento não encontrado");}
		return documento;
	}

	private boolean verificaTitulo(String titulo) {
		if(titulo.isEmpty() || titulo.isBlank()) {
			return true;
		}
		return false;
	}

	public String pegaRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		return documento.getElemento(elementoPosicao).gerarRepresentacaoCompleta();
	}

	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		return documento.getElemento(elementoPosicao).gerarRepresentacaoResumida();
	}

	
}