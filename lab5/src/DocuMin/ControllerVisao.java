package DocuMin;

import entities.Elemento;
import entities.VisaoI;

import java.util.ArrayList;
/**
 * Classe que controla as operações relacionadas às visões de um documento.
 * @author Ronaldd Matias - 122110574
 */
public class ControllerVisao implements VisaoI {

    private ArrayList visoes;

    /**
     * Construtor da classe ControllerVisao.
     *
     */
    public ControllerVisao() {
        this.visoes = new ArrayList<>();
    }
    /**
     * Obtém a lista de visões existentes.
     * @return a lista de visões
     */
    public ArrayList getVisoes(){
        return (ArrayList) visoes.clone();
    }

    /**
     * Obtém uma visão pelo seu ID.
     * @param visaoId o ID da visão
     * @return a visão correspondente ao ID
     * @throws IllegalArgumentException se a visão não existir
     */
    public String[] pegandoVisaoPeloId(int visaoId) {

        if(existePosicao(visaoId)){
            throw new IllegalArgumentException("Visao não existente.");
        }
        return (String[]) visoes.get(visaoId);
    }
    /**
     * Adiciona uma nova visão à lista de visões.
     * @param visaoCompleta a visão a ser adicionada
     */
    public void adicionaVisao(String[] visaoCompleta) {
        visoes.add(visaoCompleta);
    }

    /**
     * Cria uma visão completa de um documento.
     * A visão completa inclui a representação completa de todos os elementos do documento.
     * @param documento o documento a ser visualizado
     * @return a visão completa do documento
     */
    @Override
    public String[] criarVisaoCompleta(Documento documento) {
        ArrayList<String> visaoCompleta =  new ArrayList<>();
        for (Elemento elemento : documento.getElementos()){
            visaoCompleta.add(elemento.gerarRepresentacaoCompleta());
        }
        return visaoCompleta.toArray(new String[visoes.size()]);
    }

    /**
     * Cria uma visão resumida de um documento.
     * A visão resumida inclui a representação completa de todos os elementos do documento.
     * @param documento o documento a ser visualizado
     * @return a visão resumida do documento
     */
    @Override
    public String[] criarVisaoResumida(Documento documento) {
        ArrayList<String> visaoResumida = new ArrayList<>();
        for(Elemento elemento: documento.getElementos()){
            visaoResumida.add(elemento.gerarRepresentacaoCompleta());
        }
        return visaoResumida.toArray(new String[visoes.size()]);
    }
    /**
     * Cria uma visão prioritária de um documento com base em uma determinada prioridade.
     * A visão prioritária inclui a representação completa de todos os elementos do documento
     * cuja prioridade seja igual ou superior à prioridade fornecida.
     * @param documento o documento a ser visualizado
     * @param prioridade a prioridade mínima dos elementos a serem incluídos na visão
     * @return a visão prioritária do documento
     */
    @Override
    public String[] criarVisaoPrioritaria(Documento documento, int prioridade) {
        ArrayList<String> visaoPrioritaria = new ArrayList<>();
        for (Elemento elemento : documento.getElementos()){
            if (elemento.getPrioridade() >= prioridade){
                visaoPrioritaria.add(elemento.gerarRepresentacaoCompleta());
            }
        }
        return visaoPrioritaria.toArray(new String[visoes.size()]);
    }
    /**
     * Cria uma visão de título de um documento.
     * A visão de título inclui a representação resumida de todos os elementos do documento.
     * @param documento o documento a ser visualizado
     * @return a visão de título do documento
     */
    public String[] criarVisaoTitulo(Documento documento) {
        ArrayList<String> visaoTitulo = new ArrayList<>();
        for (Elemento elemento : documento.getElementos()){
            visaoTitulo.add(elemento.gerarRepresentacaoResumida());
        }
        return visaoTitulo.toArray(new String[visoes.size()]);
    }

    private boolean existePosicao(int visaoId) {
        if (visoes.get(visaoId) == null){
            return true;
        }
        return false;
    }

    
}
