package exercicio01;

import javax.swing.JOptionPane;

public class FilaDetran {

    private Pessoas [] fila; 	//associações entre classes		
    private Pessoas [] pilha;   //associações entre classes	
    private int tamanhoFila;
    private int tamanhoPilha;
    
    public FilaDetran () {            
        fila = new Pessoas [10];		//associações entre classes	
        pilha = new Pessoas [10];    //associações entre classes	
        tamanhoFila = 0; 	
        tamanhoPilha = 0;			
    }
    
    //Verificar de a fila está cheia.
    public boolean ListaCheia () {
        if ( tamanhoFila == fila.length ) {
            return true;
        }
        return false;
    }

    public int GerarId (int ID) {
        ID = (int)(Math.random()*100);
        return ID;
    }

    //Adicionar uma pessoa na fila.
    public void AdicionaFila (int ID, String nome, int RG, int telefone, String dNascimento) {
        Pessoas pessoas = new Pessoas(ID, nome, RG, telefone, dNascimento);
        fila[tamanhoFila] = pessoas;
        tamanhoFila ++;
    }

    //Remover uma pessoa da fila.
    public Pessoas RemoveFila (Pessoas p) {
        int i;
        String Nome = "";

        if ( fila.length >= 1 && tamanhoFila > 0 ) {
            Nome = fila[0].getNome(); //associações entre classes	
            p = fila[0];

            for ( i = 1; i < tamanhoFila; i++ ) {
                fila[i - 1] = fila[i]; // Realocando as posições
            }  

            tamanhoFila --;
            JOptionPane.showMessageDialog(null, Nome+" removido(a) foi da Fila\n e foi adicionada na Pilha");
        } 
        else {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro, a Fila já está vazia");  
        } 

        AdicionaPilha(p); //associações entre classes	
        return p;
    }

    //Adicionar todas as pessoas removidas em uma pilha.
    public void AdicionaPilha (Pessoas p) {
        if ( tamanhoPilha == pilha.length ) {
            JOptionPane.showMessageDialog(null,"A Pilha está cheia"); 
        } 
        else {
            pilha[tamanhoPilha] = p;
            tamanhoPilha ++;
        }
    }

    //Verificar ordem de espera de uma pessoa.
    public void BuscarPosicao (int ID) {

        try {
            if ( tamanhoFila != 0 ) {
                ID = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa que deseja saber a ordem de espera: "));
                for ( int i = 0; i < fila.length; i++ ) {
                    if ( ID == fila[i].getId() ) { //associações entre classes	
                        JOptionPane.showMessageDialog(null,"Nome: "+ fila[i].getNome() +" está na "+ (i+1) +"ª posição da fila."); 
                        i = fila.length;
                    } 
                } 
            } 
            else {
                JOptionPane.showMessageDialog(null,"A Fila está vazia");  
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O ID "+ ID +" não foi localizado");
        }
    }

    //Exibir Fila.
    public void ExibirFila () {             					     								        
        if ( tamanhoFila != 0) {
            JOptionPane.showMessageDialog(null, "A Fila será exibida no console");
            System.out.println(System.lineSeparator().repeat(3)+"  ** FILA ** "); 
            //associações entre classes	
            for ( int i = 0; i < tamanhoFila; i ++ ) {
                System.out.println( "ID: "+fila[i].getId()+ 
                                    "| Nome:  "+ fila[i].getNome() +
                                    "| RG: "+ fila[i].getRg()+ 
                                    "| Telefone: "+ fila[i].getTelefone()+
                                    "| Data de Nascimento: "+ fila[i].getDNascimento());
            } 
        } 
        else {	
            JOptionPane.showMessageDialog(null,"A Fila está vazia");  
        }  
    }

    //Exibir Pilha
    public void ExibirPilha () {            
        if ( tamanhoPilha != 0 ) {
            JOptionPane.showMessageDialog(null, "A Pilha será exibida no console");
            System.out.println(System.lineSeparator().repeat(3)+"  ** PILHA ** ");  
            //associações entre classes	
            for ( int i = 0; i < tamanhoPilha; i ++ ) {
                System.out.println( "ID: "+pilha[i].getId()+ 
                                    "| Nome:  "+ pilha[i].getNome() +
                                    "| RG: "+ pilha[i].getRg()+ 
                                    "| Telefone: "+ pilha[i].getTelefone()+
                                    "| Data de Nascimento: "+ pilha[i].getDNascimento());
            } 
        } 
        else {	
            JOptionPane.showMessageDialog(null,"A Pilha está vazia");  
        }  
    }
}