/**
 * Classe Descanso que tem como utilidade criar objetos do tipo Descanso vai receber como parâmetros 
 * horasDescanso que é um inteiro, numeroSemana um inteiro e por fim, descansado, que é um boolean.
 * 
 * @author Ronaldd Matias - 122110574
 *
 */
public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;
    private boolean descansado;

    /**
	 * Construtor que iniciliza o objeto Descanso
     * 
     * No construtor é inicializado horasDescanso, descansado e numeroSemanas
     * 
     
     */
    
    public Descanso() {
        this.horasDescanso = 0;
        this.descansado = false;
        this.numeroSemanas = 1;
    }
    
    /**
     * O método defineHorasDescanso tem por funcionalidade atribuir um novo valor, que é recebido como parâmetro, ao atributo horasDescanso.
     * 
     * @param valor um valor inteiro
     */
    
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }
    
    /**
     * O método defineNumeroSemanas tem por funcionalidade atribuir um novo valor, que é recebido como parâmetro, ao atributo numeroSemanas.
     * 
     * @param valor um valor inteiro
     */
    
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }
    
    /**
     * O método getStatusGeral tem por funcionalidade analisar se horasDescansadaPorSemana é maior igual a 26.
     * 
     * @return String descansado ou cansado
     */
    
    public String getStatusGeral() {
        int horasDescansadaPorSemana = horasDescanso / numeroSemanas;
        if (horasDescansadaPorSemana >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}
