package Entidades;

public class Orcamento {
    private int id;
    private double valor;
    private int qtdItens;
    private double desconto;

    public Orcamento(int id, double valor, int qtdItens, double desconto) {
        this.id = id;
        this.valor = valor;
        this.qtdItens = qtdItens;
        this.desconto = desconto;
    }

    public Orcamento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
}
