import java.lang.reflect.Array;
import java.util.Arrays;

public class RegistroResumos {
    private int numeroDeResumos;
    private Resumo[] meusResumos;
    private int index;

    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        meusResumos = new Resumo[numeroDeResumos];
        index = 0;
    }

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

    public String toString() {
        return meusResumos[0].toString();
    }

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

    public int conta() {
        int cont = 0;
        for(int j = 0; j <= meusResumos.length - 1; j++) {
            if(meusResumos[j] != null) {
                cont++;
            }
        }
        return cont;
    }
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
