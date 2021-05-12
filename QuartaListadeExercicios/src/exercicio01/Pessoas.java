package exercicio01;

public class Pessoas {
    //Criação dos endereços de memória
    private int ID;
    private String nome;
    private int RG;
    private int telefone;
    private String dNascimento;
        
    public Pessoas (int ID, String nome, int RG, int telefone, String dNascimento) {
        this.ID = ID;
        this.nome = nome;
        this.RG = RG;
        this.telefone = telefone;
        this.dNascimento = dNascimento;      
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

    public int getRg () {
        return RG;
    }

    public void setRg (int RG) {
        this.RG = RG;
    }

    public int getTelefone () {
        return telefone;
    }

    public void setTelefone (int telefone) {
        this.telefone = telefone;
    }

    public String getDNascimento () {
        return dNascimento;
    }

    public void setDNascimento (String dNascimento) {
        this.dNascimento = dNascimento;
    }
}