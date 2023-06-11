package DocuMin;
/**
 * Classe de fachada (Facade) que fornece uma interface simplificada para interagir com a classe ControllerDocumento.
 * @author Ronaldd Matias - 122110574
 */
public class Facade {

    private ControllerDocumento controllerDocumento;

    /**
     * Construtor da classe Facade.
     *
     * @param controllerDocumento O objeto ControllerDocumento responsável por gerenciar os documentos.
     */
    public Facade(ControllerDocumento controllerDocumento) {
        this.controllerDocumento = new ControllerDocumento();
    }
    /**
     * Cria um novo documento com o título especificado.
     *
     * @param Titulo título do documento a ser criado.
     * @return true se o documento foi criado com sucesso, false caso contrário.
     */

    public boolean addDocumento(String Titulo){
        return controllerDocumento.criarDocumento(Titulo);
    }

    /**
     * Cria um novo documento com o título e quantidade especificados.
     *
     * @param titulo O título do documento a ser criado.
     * @param qtd    A quantidade de elementos iniciais a serem adicionados ao documento.
     * @return true se o documento foi criado com sucesso, false caso contrário.
     */
    public boolean addDocumento(String titulo, int qtd){
        return controllerDocumento.criarDocumento(titulo, qtd);
    }
    /**
     * Remove um documento com o título especificado.
     *
     * @param titulo O título do documento a ser removido.
     */
    public void removerDocumento(String titulo){
        controllerDocumento.removerDocumento(titulo);
    }

    /**
     * Conta o número de elementos em um documento com o título especificado.
     *
     * @param titulo O título do documento.
     * @return O número de elementos no documento.
     */
    public int contarElementos(String titulo){
        return controllerDocumento.contarElementos(titulo);
    }
    /**
     * Retorna a representação em forma de array de strings de um documento com o título especificado.
     *
     * @param titulo O título do documento.
     * @return A representação do documento como um array de strings.
     */
    public String[] exibirDocumento(String titulo ){
        return controllerDocumento.exibirDocumento(titulo);
    }
    /**
     * Cria um novo elemento do tipo texto no documento com o título especificado.
     *
     * @param tituloDoc  O título do documento onde o elemento será adicionado.
     * @param valor      O valor do texto.
     * @param prioridade A prioridade do elemento.
     * @return A posição do novo elemento na lista de elementos do documento.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade){
        return controllerDocumento.criarTexto(tituloDoc,valor,prioridade);
    }
    /**
     * Cria um novo elemento do tipo título no documento com o título especificado.
     *
     * @param tituloDoc  O título do documento onde o elemento será adicionado.
     * @param valor      O valor do título.
     * @param prioridade A prioridade do elemento.
     * @param nivel      O nível do título.
     * @param linkavel   Indica se o título é linkável.
     * @return A posição do novo elemento na lista de elementos do documento.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
        return controllerDocumento.criarTitulo(tituloDoc,valor,prioridade,nivel,linkavel);
    }
    /**
     * Cria um novo elemento do tipo lista no documento com o título especificado.
     *
     * @param tituloDoc    O título do documento onde o elemento será adicionado.
     * @param valorLista   O valor da lista.
     * @param prioridade   A prioridade do elemento.
     * @param separador    O separador dos elementos da lista.
     * @param charLista    O caractere utilizado para representar a lista.
     * @return A posição do novo elemento na lista de elementos do documento.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
        return controllerDocumento.criarLista(tituloDoc,valorLista,prioridade,separador,charLista);
    }
    /**
     * Cria um novo elemento do tipo termo no documento com o título especificado.
     *
     * @param tituloDoc   O título do documento onde o elemento será adicionado.
     * @param valorTermo  O valor do termo.
     * @param prioridade  A prioridade do elemento.
     * @param separador   O separador dos elementos do termo.
     * @param ordem       A ordem dos elementos do termo.
     * @return A posição do novo elemento na lista de elementos do documento.
     */
    public int criarTermo(String tituloDoc, String valorTermo, int prioridade, String separador, String ordem){
        return controllerDocumento.criarTermo(tituloDoc,valorTermo, prioridade,separador,ordem);
    }
    /**
     * Retorna a representação completa de um elemento específico em um documento.
     *
     * @param tituloDoc        O título do documento.
     * @param elementoPosicao  A posição do elemento no documento.
     * @return A representação completa do elemento.
     */
    public String PegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        return controllerDocumento.pegaRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    /**
     * Retorna a representação resumida de um elemento específico em um documento.
     *
     * @param tituloDoc        O título do documento.
     * @param elementoPosicao  A posição do elemento no documento.
     * @return A representação resumida do elemento.
     */
    public String PegarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
        return controllerDocumento.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }
    /**
     * Apaga um elemento específico de um documento.
     *
     * @param tituloDoc        O título do documento.
     * @param elementoPosicao  A posição do elemento no documento a ser apagado.
     */
    public void apagarElemento(String tituloDoc, int elementoPosicao){
        controllerDocumento.apagarElemento(tituloDoc, elementoPosicao);
    }
    /**
     * Move um elemento para cima na ordem dentro de um documento.
     *
     * @param tituloDoc        O título do documento.
     * @param elementoPosicao  A posição do elemento no documento.
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao){
        controllerDocumento.moverParaCima(tituloDoc, elementoPosicao);
    }
    /**
     * Move um elemento para baixo na ordem dentro de um documento.
     *
     * @param tituloDoc        O título do documento.
     * @param elementoPosicao  A posição do elemento no documento.
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao){
    }

    /**
     * Cria um atalho para um documento especificado dentro de outro documento.
     *
     * @param tituloDoc            O título do documento onde o atalho será criado.
     * @param tituloDocReferenciado O título do documento referenciado pelo atalho.
     * @return A posição do novo elemento atalho na lista de elementos do documento.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado){
        return controllerDocumento.criarAtalho(tituloDoc, tituloDocReferenciado);
    }
    /**
     * Cria uma visão completa de um documento especificado.
     *
     * @param tituloDoc O título do documento para o qual a visão completa será criada.
     * @return O identificador da visão completa criada.
     */
    public int criarVisaoCompleta(String tituloDoc){
        return controllerDocumento.criarVisaoCompleta(tituloDoc);
    }

    /**
     * Cria uma visão resumida de um documento especificado.
     *
     * @param tituloDoc O título do documento para o qual a visão resumida será criada.
     * @return O identificador da visão resumida criada.
     */
    public int criarVisaoResumida(String tituloDoc){
        return controllerDocumento.criarVisaoResumida(tituloDoc);
    }
    /**
     * Cria uma visão prioritária de um documento especificado com base em uma determinada prioridade.
     *
     * @param tituloDoc   O título do documento para o qual a visão prioritária será criada.
     * @param prioridade  A prioridade mínima dos elementos a serem incluídos na visão.
     * @return O identificador da visão prioritária criada.
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade){
        return controllerDocumento.criarVisaoPrioritaria(tituloDoc, prioridade);
    }
    /**
     * Cria uma visão do tipo título de um documento especificado.
     *
     * @param tituloDoc O título do documento para o qual a visão será criada.
     * @return O identificador da visão criada.
     */

    public int criarVisaoTitulo(String tituloDoc){
        return controllerDocumento.criarVisaoTitulo(tituloDoc);
    }
    /**
     * Exibe o conteúdo de uma visão específica.
     *
     * @param visaoId O identificador da visão.
     * @return O conteúdo da visão como um array de strings.
     */
    public String[] exibirVisao(int visaoId){
        return controllerDocumento.exibirVisao(visaoId);
    }





}
