package entities;
/**
 * Interface que define os métodos para geração de representações completas e resumidas de um elemento.
 * @author Ronaldd Matias - 122110574
 */
public interface ElementoI {
    /**
     * Gera a representação completa do elemento.
     *
     * @return a representação completa do elemento como uma string
     */
    public String gerarRepresentacaoCompleta();
    /**
     * Gera a representação resumida do elemento.
     *
     * @return a representação resumida do elemento como uma string
     */
    public String gerarRepresentacaoResumida();

}
