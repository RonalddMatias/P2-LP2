/**
 * Classe Resumo implementada para criar objetos do tipo Resumo que irão receber atributos do tipo String, tais como 
 * tema e resumo
 * 
 * @author Ronaldd Matias
 *
 */
public class Resumo {
    private String tema;
    private String resumo;
    
    /**
     * Construtor que iniciliza o objeto Resumo com os parâmetros tema e resumo, previamente inicializados
     * dentro do mesmo.
     * 
     * @param tema tema do resumo
     * @param resumo conteúdo do resumo
     */
    
    public Resumo(String tema, String resumo) {
        this.tema = tema;
        this.resumo = resumo;
    }
    
    /**
     * Método que retorna o tema do Resumo.
     * 
     * @return tema do resumo
     */
    
    public String getTema() {
        return tema;
    }

    /**
     * Método que retorna o conteúdo do Resumo.
     * 
     * @return conteúdo do resumo
     */
    public String getResumo() {
        return resumo;
    }
}
