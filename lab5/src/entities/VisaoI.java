package entities;

import DocuMin.Documento;

import javax.print.Doc;

public interface VisaoI {


    String[] criarVisaoCompleta(Documento documento);

    String[] criarVisaoResumida(Documento documento);
    String[] criarVisaoTitulo(Documento documento);

    String[] criarVisaoPrioritaria(Documento documento, int prioridade);
}
