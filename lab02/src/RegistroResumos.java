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

    private String pegaResumoEspec(int index) {
        Resumo resumo = meusResumos[index];
        String saida = resumo.getTema() + ": " + resumo.getResumo();
        return saida;
    }

    private boolean valida() {
        return index < numeroDeResumos;


    }
}
