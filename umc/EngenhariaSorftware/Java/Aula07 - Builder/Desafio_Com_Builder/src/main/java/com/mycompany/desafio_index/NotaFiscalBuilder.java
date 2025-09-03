package com.mycompany.desafio_index;

import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {

    private String razaoSocial;
    private String cnpj;
    private Calendar dataEmissao;
    private double valorBruto;
    private double impostos;
    private List<ItemDaNotaBuilder> itens;
    private String observacoes;

    private NotaFiscalBuilder() {
    }

    public static NotaFiscalComBuilder getBuilder() {
        return new NotaFiscalComBuilder();
    }

    public static class NotaFiscalComBuilder {
         NotaFiscalBuilder notaFiscal;

        public NotaFiscalComBuilder() {
            this.notaFiscal = new NotaFiscalBuilder();
        }

        public NotaFiscalComBuilder comRazaoSocial(String razaoSocial) {
            notaFiscal.razaoSocial = razaoSocial;
            return this;
        }

        public NotaFiscalComBuilder comCnpj(String cnpj) {
            notaFiscal.cnpj = cnpj;
            return this;
        }

        public NotaFiscalComBuilder comDataEmissao(Calendar dataEmissao) {
            notaFiscal.dataEmissao = dataEmissao;
            return this;
        }

        public NotaFiscalComBuilder comValorBruto(double valorBruto) {
            notaFiscal.valorBruto = valorBruto;
            return this;
        }

        public NotaFiscalComBuilder comImpostos(double impostos) {
            notaFiscal.impostos = impostos;
            return this;
        }

        public NotaFiscalComBuilder comItens(List<ItemDaNotaBuilder> itens) {
            notaFiscal.itens = itens;
            return this;
        }

        public NotaFiscalComBuilder comObservacoes(String observacoes) {
            notaFiscal.observacoes = observacoes;
            return this;
        }
        
        public NotaFiscalBuilder constroi() {
            return notaFiscal;
        }


    }
}
