import java.util.Arrays;
/**
 * Classe Disciplina que tem como utilidade criar objetos do tipo Disciplina vai receber como parâmetros 
 * nomeDaDisciplina que é uma String, notasDaDisciplina um array do tipo double e por fim, horasDeEstudo do tipo inteiro.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class Disciplina {
    private String nomeDaDisciplina;
    private double[] notasDaDisciplina;
    private int horasDeEstudo;
    /**
     * Construtor que iniciliza o objeto Disciplina com o parâmetro do tipo String nomeDaDisciplina
     * 
     * No construtor é inicializado nomeDaDisciplina com o parâmetro recebido e o array notasDaDisciplina com tamanho 4
     * 
     * @param nomeDaDisciplina o nome de determinada disciplina
     */
    public Disciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.notasDaDisciplina = new double[4];
    }
    
    /**
     * O método cadastraHoras tem por objetivo incrementar ao atributo horasDeEstudo o valor recebido no parâmetro.
     * 
     * @param horas quantidade de horas
     */

    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        notasDaDisciplina[nota-1] = valorNota;
    }

    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    public String toString() {
        return nomeDaDisciplina + " " + calculaMedia() + " " + Arrays.toString(notasDaDisciplina);
    }

    private double calculaMedia() {
        double media = 0;
        if (notasDaDisciplina.length != 0) {
            double valores = 0;
            for (Double numeros : notasDaDisciplina) {
                valores += numeros;
            }
            media = valores / notasDaDisciplina.length;
        }
        return media;
    }
}
