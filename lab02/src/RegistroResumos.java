import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Classe RegistroResumos que tem como utilidade criar objetos do tipo RegistraResumo que vai receber como parâmetros 
 * numeroDeResumos que é um inteiro, meusResumos um array e o index, que é um inteiro.
 * 
 * @author Ronaldd Matias  - 122110574
 *
 */
public class RegistroResumos {
    private int numeroDeResumos;
    private Resumo[] meusResumos;
    private int index;

    /**
     * Construtor que iniciliza o objeto RegistroResumos com o parâmetro do tipo inteiro numeroDeResumos
     * 
     * No construtor é inicializado o parâmetro recebido, os meusResumos e o index
     * 
     * @param numeroDeResumos quantidade de resumo.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        meusResumos = new Resumo[numeroDeResumos];
        index = 0;
    }

    /**
     * O método adiciona recebe os parâmetros tema e conteudo, ambos do tipo String.
     * 
     * O método adiciona tem como função adicionar no array meusResumo um objeto do tipo Resumo, inicializado
     * com o tema e conteudo do resumo. 
     * 
     * @param tema tema do resumo
     * @param conteudo coteudo do resumo
     */
    
    void adiciona(String tema, String conteudo) {
        if(valida()) {
            Resumo resumo = new Resumo(tema, conteudo);
            meusResumos[index] = resumo;
            index++;
        } else {
            index = 0;
            adiciona(tema, conteudo);
        }

    }
    
    /**
     * O método que auxilia na impressão o objeto RegistraResumos
     */
    
    public String toString() {
        return meusResumos[0].toString();
    }

    /**
     * 
     * O método pegaResumo tem como função retornar um array, na qual ele analisa se um é nulo, se nao for, a função
     * adiciona ao array
     * 
     * @return retorno array de String
     * 
     */
    
    public String[] pegaResumo() {
        String[] retorno = new String[numeroDeResumos];
        for (int i = 0; i <= meusResumos.length - 1; i++) {
            Resumo resumo = meusResumos[i];
            if (resumo != null) {
                retorno[i] = pegaResumoEspec(i);
            }
        }
        return retorno;
    }
    
    /**
     * O método conta retorna um inteiro, na qual ele vai verificar se o array meusResumos tem nulo, se não, ele 
     * incrementa a variável local cont
     * 
     * @return int contador
     */
    
    public int conta() {
        int cont = 0;
        for(int j = 0; j <= meusResumos.length - 1; j++) {
            if(meusResumos[j] != null) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * O método imprimeResumos retorna uma String com o numero de resumos que vai ser concatenado com os temas específicos.
     * 
     * @return String numero de resumos e temas especificos
     */
    
    public String impremeResumos(){
        String retorno = "";
        retorno = "- " + conta() + " resumo(s) cadastrado(s)\n";
        String[] temaEspec = pegaTema();
        for(int i = 0; i <= temaEspec.length-1; i++){
            if(i == 0){
                retorno += "- " + temaEspec[i];
            } else {
                retorno += " | " + temaEspec[i];
            }
        }

        return retorno;
    }
    
    /**
    * Verifica se o resumo possui o tema especificado.
	* @param tema o tema a ser verificado.
	* @return true se o resumo possui o tema especificado, caso contrário false.
    */

    public boolean temResumo(String tema){
        boolean condicinal = false;
        String[] temaEspec = pegaTema();
        for (String temas : temaEspec){
            if(temas.equals(tema)){
                condicinal = true;
                break;
            }
        }
        return condicinal;
    }

    private String pegaResumoEspec(int index) {
        Resumo resumo = meusResumos[index];
        String saida = resumo.getTema() + ": " + resumo.getResumo();
        return saida;
    }

    private boolean valida() {
        return index < numeroDeResumos;
    }

    private String[] pegaTema(){
        String[] tema = new String[conta()];
        for(int i = 0; i <= meusResumos.length -1; i++){
            if (meusResumos[i] != null){
                tema[i] = meusResumos[i].getTema(); //acessando o array em determinada posicao
            } else {
                break;
            }
        }
        return tema;
    }
}
