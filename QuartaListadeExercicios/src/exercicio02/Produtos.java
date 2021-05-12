package exercicio02;

public class Produtos {
    //Criação dos endereços de memória
    private int ID;
    private String nome;
    private double valor;
    private int quantidade;
        
    public Produtos (int ID, String nome, double valor, int quantidade) {
        this.ID = ID;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;     
    }

    public int getId () {
        return ID;
    }

    public void setId (int ID) {
        this.ID = ID;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public double getValor () {
        return valor;
    }

    public void setValor (double valor) {
        this.valor = valor;
    }

    public int getQuantidade () {
        return quantidade;
    }

    public void setQuantidade (int quantidade) {
        this.quantidade = quantidade;
    }
}