package exercicio02;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        PilhaProdutos pilha = new PilhaProdutos();	 //associações entre classes	
		int opcao = 0, ID = 0, quantidade = 0; 
        double valor = 0.0;
        String nome = "";
        Produtos p = new Produtos(ID, nome, valor, quantidade); //associações entre classes	
		
		while (opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" *** Loja Virtual *** \n\n"
                +"1 - Verificar se a Pilha está vazia. \n"
                +"2 - Adicionar um produto na Pilha.\n"
                +"3 - Remover um produto na Pilha e adicionar o produto removido em outra Pilha.\n"
                +"4 - Remover uma pesquisa por nome do produto. \n"
                +"5 - Pesquisar a ordem de espera de uma produto na Pilha. \n"
                +"6 - Verificar Pilha. \n"
                +"9 - Finalizar."));
			
            switch(opcao) {
				case 1: 
                    if( pilha.ListaVazia() == true ) {
                        JOptionPane.showMessageDialog(null, "A Pilha está vazia!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "A Pilha não está vazia!");
                    }
				break;
			
				case 2: 
                    ID = (int)(Math.random()*100);
                    nome = JOptionPane.showInputDialog("Digite o nome: ");
                    valor  = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: ")); 
                    quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite o quantidade: ")); 
                       
                    pilha.AdicionaPilhaNovo(ID, nome, valor, quantidade);
                    JOptionPane.showMessageDialog(null, "Novo produto adicionado com sucesso");
				break;
			
				case 3: 
                    pilha.RemoveProduto(p);
				break;
                    
                case 4: 
                    pilha.BuscarNome(nome, p);
				break;

                case 5: 
                    pilha.BuscarPosicao(ID);
				break;

                case 6: 
					pilha.ExibirPilha();
				break;
			
				case 9:
					JOptionPane.showMessageDialog(null,"Saindo");
				break;
				
				default: 
					JOptionPane.showMessageDialog(null,"Opção Inválida");
			}
		}
    }
}