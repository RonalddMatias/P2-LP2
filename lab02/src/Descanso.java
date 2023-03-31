public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;
    private boolean descansado;

    public Descanso() {
        this.horasDescanso = 0;
        this.descansado = false;
        this.numeroSemanas = 1;
    }

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    public String getStatusGeral() {
        int horasDescansadaPorSemana = horasDescanso / numeroSemanas;
        if (horasDescansadaPorSemana >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}
