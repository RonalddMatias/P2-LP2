package entities;

import DocuMin.Documento;

import javax.print.Doc;
/**
 * Interface que define os métodos para criar diferentes visões de um documento.
 * @author Ronaldd Matias - 122110574
 */
public interface VisaoI {

    /**
     * Cria uma visão completa do documento.
     *
     * @param documento o documento a ser visualizado
     * @return um array de strings com a visão completa do documento
     */
    String[] criarVisaoCompleta(Documento documento);
    /**
     * Cria uma visão resumida do documento.
     *
     * @param documento o documento a ser visualizado
     * @return um array de strings com a visão resumida do documento
     */
    String[] criarVisaoResumida(Documento documento);
    /**
     * Cria uma visão apenas dos títulos do documento.
     *
     * @param documento o documento a ser visualizado
     * @return um array de strings com a visão dos títulos do documento
     */
    String[] criarVisaoTitulo(Documento documento);
    /**
     * Cria uma visão prioritária do documento, considerando a prioridade especificada.
     *
     * @param documento o documento a ser visualizado
     * @param prioridade a prioridade dos elementos a serem exibidos
     * @return um array de strings com a visão prioritária do documento
     */
    String[] criarVisaoPrioritaria(Documento documento, int prioridade);
}
