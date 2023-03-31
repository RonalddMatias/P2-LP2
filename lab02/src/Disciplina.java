import java.util.Arrays;

public class Disciplina {
    private String nomeDaDisciplina;
    private double[] notasDaDisciplina;
    private int horasDeEstudo;

    public Disciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.notasDaDisciplina = new double[4];
    }

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
