/**
 * A classe RegistraTempoOnline que tem como utilidade criar objetos do tipo RegistroTempoOnline irá receber os parâmetros
 * disciplina que é uma String, metaHorasDaDisciplina um inteiro e por fim, metaHorasOnline também um inteiro.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class RegistroTempoOnline {
    private String disciplina;
    private int metaHorasDaDisciplina;
    private int metaHorasOnline;

    /**
     * Construtor que iniciliza o objeto RegistroTempoOnline com o parâmetro do tipo String disciplina.
     * 
     * No construtor é inicializado o parâmetro recebido e metaHorasDaDisciplina com um valor padrão de 120.
     * 
     * @param disciplina disciplina escolhida
     */
    
    public RegistroTempoOnline(String disciplina) {
        this.disciplina = disciplina;
        this.metaHorasDaDisciplina = 120;
    }
    
    /**
     * Construtor que iniciliza o objeto RegistroTempoOnline com o parâmetro do tipo String disciplina e outro do tipo inteiro metaHorasDaDisciplina.
     * 
     * No construtor é inicializado os dois parâmetros à seu atributo correspondente, nesse caso, disciplina e metaHorasDaDisciplina 
     * 
     * @param disciplina disciplina escolhida.
     * @param metaHorasDaDisciplina um numero inteiro
     */
    
    
    public RegistroTempoOnline(String disciplina, int metaHorasDaDisciplina) {
        this.disciplina = disciplina;
        this.metaHorasDaDisciplina = metaHorasDaDisciplina;
    }

    
    /**
     * O método adicionaTempoOnline tem por funcionalidade incrementar um novo valor, que é recebido como parâmetro, ao atributo metaHorasOnline.
     * 
     * @param tempo um numero inteiro
     */
    public void adicionaTempoOnline(int tempo) {
        this.metaHorasOnline += tempo;
    }
    
    /**
     * O método atingiuMetaOnline tem por objetivo analisar o dobro do atributo metaHorasOnline.
     * 
     * @return boolean true se a metaHorasOnline dobrada for maior ou igual a metaHorasDaDisciplina, se não false.
     */

    public boolean atingiuMetaTempoOnline() {
        boolean condicional = false;
        if (metaHorasOnline * 2 >= metaHorasDaDisciplina) {
            condicional = true;
        }
        return condicional;

    }
    
    /**
     * O método que auxilia na impressão o objeto RegistroTempoOnline
     * 
     * @return String formatada
     */
     
    public String toString() {
        return this.disciplina + " " + Integer.toString(metaHorasOnline) + "/"
                + Integer.toString(metaHorasDaDisciplina);
    }

}
