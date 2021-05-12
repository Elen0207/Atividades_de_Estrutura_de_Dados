package exercicio02;

import javax.swing.JOptionPane;
public class PilhaProdutos {

    private Produtos [] pilhaAdicionada; 	//associações entre classes		
    private Produtos [] pilhaRemovida;   //associações entre classes	
    private int tamanhoAdicionada;
    private int tamanhoRemovida;
    
    public PilhaProdutos () {            
        pilhaAdicionada = new Produtos [10];		//associações entre classes	
        pilhaRemovida = new Produtos [10];    //associações entre classes	
        tamanhoAdicionada = 0; 	
        tamanhoRemovida = 0;			
    }

    //Verificar se a Pilha está vazia. 
    public boolean ListaVazia () {
        if ( tamanhoAdicionada == 0 ) {
            return true;
        }
        return false;
    }

    //Adicionar um produto na Pilha Novo.
    public void AdicionaPilhaNovo (int ID, String nome, double valor, int quantidade) {
        Produtos produtos = new Produtos(ID, nome, valor, quantidade);

        if ( tamanhoAdicionada == pilhaAdicionada.length ) {
            JOptionPane.showMessageDialog(null,"A Pilha está cheia"); 
        } 
        else {
            pilhaAdicionada[tamanhoAdicionada] = produtos;
            tamanhoAdicionada ++;
        }
    }

    //Remover um produto na Pilha e adicionar o produto removido em outra Pilha.
    public void RemoveProduto (Produtos p) {

        if (pilhaAdicionada.length >= 1 && tamanhoAdicionada > 0) {
            JOptionPane.showMessageDialog(null,"Livro removido do final da Pilha: "  + pilhaAdicionada[tamanhoAdicionada-1].getNome()); 
            pilhaAdicionada[tamanhoAdicionada-1] = p;
            tamanhoAdicionada --;
            AdicionaPilhaRemovido(p);
        } 
        else {
            JOptionPane.showMessageDialog(null,"A Pilha de Produtos está vazia");  
        }
    }

    //Adicionar um produto na Pilha Removido.
    public void AdicionaPilhaRemovido (Produtos p) {

        if ( tamanhoRemovida == pilhaRemovida.length ) {
            JOptionPane.showMessageDialog(null,"A Pilha está cheia"); 
        } 
        else {
            pilhaRemovida[tamanhoRemovida] = p;
            tamanhoRemovida ++;
        }
    }

    //Remover um produto pelo nome
    public void BuscarNome (String nome, Produtos p) {
    	int cont = 0;
    	
        if ( tamanhoAdicionada != 0 ) {
            nome = JOptionPane.showInputDialog("Digite o nome Produto que deseja remover: ");

            for ( int i = 0; i <= pilhaAdicionada.length; i++ ) {
                if ( nome.equalsIgnoreCase(pilhaAdicionada[i].getNome()) ) { //associações entre classes	
                    p = pilhaAdicionada[i];
                        
                    JOptionPane.showMessageDialog(null,"O Produto: "+ pilhaAdicionada[i].getNome() +" foi removido!"); 
                        
                    pilhaAdicionada[i] = pilhaAdicionada[i+1];         
                    AdicionaPilhaRemovido(p);
                    i = pilhaAdicionada.length;
                        
                    cont = 1;
                }
                tamanhoAdicionada --;
            } 
               
            if ( cont == 0 ) {
                JOptionPane.showMessageDialog(null, "O produto: "+ nome +" não foi localizado!");
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Pilha vazia!");  
        }
    }

    //Pesquisar a ordem de espera de uma produto na Pilha.
    public void BuscarPosicao (int ID) {

        try {
            if ( tamanhoAdicionada != 0 ) {
                ID = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa que deseja saber a ordem de espera: "));
                for ( int i = 0; i < pilhaAdicionada.length; i++ ) {
                    if ( ID == pilhaAdicionada[i].getId() ) { //associações entre classes	
                        JOptionPane.showMessageDialog(null,"Nome: "+ pilhaAdicionada[i].getNome() +" está na "+ (i+1) +"ª posição da fila."); 
                        i = pilhaAdicionada.length;
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

    //Verificar Pilha.
    public void ExibirPilha () {            
        if ( tamanhoAdicionada != 0 ) {
            JOptionPane.showMessageDialog(null, "A Pilha será exibida no console");
            System.out.println(System.lineSeparator().repeat(3)+"  ** PILHA ** ");  
            //associações entre classes	
            for ( int i = 0; i < tamanhoAdicionada; i ++ ) {
                System.out.println( "ID: "+pilhaAdicionada[i].getId()+ 
                                    "| Nome:  "+ pilhaAdicionada[i].getNome() +
                                    "| Valor: R$"+ pilhaAdicionada[i].getValor()+ 
                                    "| Quantidade: "+ pilhaAdicionada[i].getQuantidade());
            } 
        } 
        else {	
            JOptionPane.showMessageDialog(null,"A Pilha está vazia");  
        }  
    }
}