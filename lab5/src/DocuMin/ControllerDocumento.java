package DocuMin;

import entities.*;

import javax.print.Doc;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Classe responsável por controlar varias operacões
 */
public class ControllerDocumento {
	
	private HashMap<String, Documento> documentos;
	private ControllerVisao visaoController;

	/**
	 * Construtor da classe ControllerDocumento.
	 * Inicializa a estrutura de dados para armazenar os documentos.
	 */
	public ControllerDocumento() {
		this.documentos = new HashMap<>();
		this.visaoController = new ControllerVisao();
	}
	/**
	 * Retorna a quantidade de documentos cadastrados.
	 *
	 * @return A quantidade de documentos cadastrados.
	 */
	public int quantidadeDeDocumetos(){
		return documentos.size();
	}
	/**
	 * Cria um novo documento com o título especificado.
	 *
	 * @param titulo O título do documento a ser criado.
	 * @return true se o documento foi criado com sucesso, false caso contrário.
	 */
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
	/**
	 * Cria um novo documento com o título e a quantidade máxima especificados.
	 *
	 * @param titulo     O título do documento a ser criado.
	 * @param qtdMaxima  A quantidade máxima de elementos que o documento pode ter.
	 * @return true se o documento foi criado com sucesso, false caso contrário.
	 * @throws IllegalArgumentException Se a quantidade máxima for menor ou igual a zero.
	 */
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
	/**
	 * Remove um documento com o título especificado.
	 *
	 * @param titulo O título do documento a ser removido.
	 * @throws NoSuchElementException Se o documento com o título especificado não estiver cadastrado.
	 */
	public void removerDocumento(String titulo) {
		if(!documentos.containsKey(titulo)) {
			throw new NoSuchElementException("Documento não cadastrado!");
		}
		documentos.remove(titulo);
	}

	/**
	 * Conta a quantidade de elementos em um documento específico.
	 *
	 * @param titulo O título do documento.
	 * @return A quantidade de elementos no documento.
	 */
	public int contarElementos(String titulo) {
		Documento documento = pegarDocumentoEspecifico(titulo);
		return documento.quantidadeElementos();
	}

	/**
	 * Retorna uma representação dos elementos em um documento específico.
	 *
	 * @param titulo O título do documento.
	 * @return Um array de strings contendo as representações dos elementos do documento.
	 */

	public String[] exibirDocumento(String titulo) {
		Documento documento = pegarDocumentoEspecifico(titulo);
		String[] retorno = new String[documento.quantidadeElementos()];
		for (int i = 0; i < retorno.length; i++){
			retorno[i] = documento.getElemento(i).gerarRepresentacaoCompleta();
		}
		return retorno;
	}

	/**
	 * Cria um novo elemento do tipo Texto e adiciona ao documento específico.
	 *
	 * @param tituloDoc O título do documento.
	 * @param valor     O valor do texto.
	 * @param prioridade A prioridade do elemento.
	 * @return A posição do elemento no documento.
	 */

	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento texto = new Texto(prioridade, valor);
		return documento.adicionaElementos(texto);
	}
	/**
	 * Cria um novo elemento do tipo Título e adiciona ao documento específico.
	 *
	 * @param tituloDoc O título do documento.
	 * @param valor     O valor do título.
	 * @param prioridade A prioridade do elemento.
	 * @param nivel     O nível do título.
	 * @param linkavel  Indica se o título é linkável.
	 * @return A posição do elemento no documento.
	 */

	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento titulo = new Titulo(prioridade,valor,nivel, linkavel);
		return documento.adicionaElementos(titulo);
	}
	/**
	 * Cria um novo elemento do tipo Lista e adiciona ao documento específico.
	 *
	 * @param tituloDoc   O título do documento.
	 * @param valorLista  O valor da lista.
	 * @param prioridade  A prioridade do elemento.
	 * @param separador   O separador dos itens da lista.
	 * @param charLista   O caractere de início e fim da lista.
	 * @return A posição do elemento no documento.
	 */
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento lista = new Lista(prioridade,tituloDoc, valorLista, separador, charLista);
		return documento.adicionaElementos(lista);
	}
	/**
	 * Cria um novo elemento do tipo Termo e adiciona ao documento específico.
	 *
	 * @param tituloDoc    O título do documento.
	 * @param valorTermo   O valor do termo.
	 * @param prioridade   A prioridade do elemento.
	 * @param separador    O separador dos termos.
	 * @param ordem        A ordem dos termos.
	 * @return A posição do elemento no documento.
	 */
	public int criarTermo(String tituloDoc, String valorTermo, int prioridade, String separador, String ordem){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento termo = new Termos(prioridade, valorTermo,separador,ordem);
		return documento.adicionaElementos(termo);
	}
	/**
	 * Obtém o documento específico com base no título.
	 *
	 * @param titulo O título do documento.
	 * @return O documento correspondente ao título.
	 * @throws NoSuchElementException se o documento não for encontrado.
	 */

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
	/**
	 * Obtém a representação completa de um elemento em um documento específico.
	 *
	 * @param tituloDoc       O título do documento.
	 * @param elementoPosicao A posição do elemento no documento.
	 * @return A representação completa do elemento.
	 */
	public String pegaRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		return documento.getElemento(elementoPosicao-1).gerarRepresentacaoCompleta();
	}
	/**
	 * Obtém a representação resumida de um elemento em um documento específico.
	 *
	 * @param tituloDoc       O título do documento.
	 * @param elementoPosicao A posição do elemento no documento.
	 * @return A representação resumida do elemento.
	 */
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		return documento.getElemento(elementoPosicao-1).gerarRepresentacaoResumida();
	}

	/**
	 * Remove um elemento de um documento específico com base na posição do elemento.
	 *
	 * @param tituloDoc       O título do documento.
	 * @param elementoPosicao A posição do elemento a ser removido.
	 */

	public void apagarElemento(String tituloDoc, int elementoPosicao){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		documento.removerElemento(elementoPosicao);
	}
	/**
	 * Move um elemento para cima em um documento específico com base na posição do elemento.
	 *
	 * @param tituloDoc       O título do documento.
	 * @param elementoPosicao A posição do elemento a ser movido para cima.
	 */
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		documento.moverParaCima(elementoPosicao);
	}
	/**
	 * Move um elemento para baixo em um documento específico com base na posição do elemento.
	 *
	 * @param tituloDoc       O título do documento.
	 * @param elementoPosicao A posição do elemento a ser movido para baixo.
	 */
	public void moverParaBaixo(String tituloDoc, int elementoPosicao){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		documento.moverParaBaixo(elementoPosicao);

	}
	/**
	 * Cria um atalho entre dois documentos específicos.
	 *
	 * @param tituloDoc            O título do documento que terá o atalho.
	 * @param tituloDocReferenciado O título do documento que será referenciado pelo atalho.
	 * @return A posição do atalho no documento referenciado.
	 * @throws IllegalArgumentException se algum dos documentos já possuir um atalho.
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		if(verificaAtalhoExistente(tituloDoc) || verificaAtalhoExistente(tituloDocReferenciado)){
			throw new IllegalArgumentException("Documento ja possui um atalho");
		}
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Documento documentoReferenciado = pegarDocumentoEspecifico(tituloDocReferenciado);
		Atalho atalho = new Atalho(documentoReferenciado.calculaMediaElementos(), tituloDocReferenciado, documentoReferenciado.getElementos());
		documentoReferenciado.adicionaElementos(atalho);
		documento.setTemAtalho(true);
		documentoReferenciado.setTemAtalho(true);

		return documentoReferenciado.getElementos().indexOf(atalho); // retornar o indexof
	}
	/**
	 * Cria uma visão completa de um documento específico.
	 *
	 * @param tituloDoc O título do documento.
	 * @return A posição da visão completa na lista de visões.
	 */
	public int criarVisaoCompleta(String tituloDoc){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		String[] visaoCompleta = visaoController.criarVisaoCompleta(documento);
		visaoController.adicionaVisao(visaoCompleta);
		return visaoController.getVisoes().indexOf(visaoCompleta);
	}

	/**
	 * Cria uma visão resumida de um documento específico.
	 *
	 * @param tituloDoc O título do documento.
	 * @return A posição da visão resumida na lista de visões.
	 */
	public int criarVisaoResumida(String tituloDoc) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		String[] visaoCompleta = visaoController.criarVisaoResumida(documento);
		visaoController.adicionaVisao(visaoCompleta);
		return visaoController.getVisoes().indexOf(visaoCompleta);
	}
	/**
	 * Cria uma visão prioritária de um documento específico, com base na prioridade informada.
	 *
	 * @param tituloDoc  O título do documento.
	 * @param prioridade A prioridade da visão prioritária.
	 * @return A posição da visão prioritária na lista de visões.
	 */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		String[] visaoPrioritaria = visaoController.criarVisaoPrioritaria(documento, prioridade);
		visaoController.adicionaVisao(visaoPrioritaria);
		return visaoController.getVisoes().indexOf(visaoPrioritaria);
	}
	/**
	 * Cria uma visão de título de um documento específico.
	 *
	 * @param tituloDoc O título do documento.
	 * @return A posição da visão de título na lista de visões.
	 */
	public int criarVisaoTitulo(String tituloDoc) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		String[] visaoTitulo = visaoController.criarVisaoTitulo(documento);
		visaoController.adicionaVisao(visaoTitulo);
		return visaoController.getVisoes().indexOf(visaoTitulo);
	}
	private boolean verificaAtalhoExistente(String titulo){
		Documento documento = pegarDocumentoEspecifico(titulo);
		if (documento.isTemAtalho()){
			return true;
		}
		return false;
	}
	/**
	 * Retorna a representação da visão com o ID especificado.
	 *
	 * @param visaoId O ID da visão.
	 * @return Um array de strings contendo a representação da visão.
	 */
	public String[] exibirVisao(int visaoId) {
		return visaoController.pegandoVisaoPeloId(visaoId);
	}


}