package exercicio01;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        
        FilaDetran fila = new FilaDetran();	 //associações entre classes	
		int opcao = 0, ID = 0, RG = 0, telefone = 0; 
        String nome = "", dNascimento = "";
        Pessoas p = new Pessoas(ID, nome, RG, telefone, dNascimento); //associações entre classes	
		
		while (opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("*** DETRAN *** \n\n"
                +"1 - Verificar de a fila está cheia. \n"
                +"2 - Adicionar uma pessoa.\n"
                +"3 - Remover uma pessoa e adicionar todas as pessoas removidas em uma pilha.\n"
                +"4 - Verificar ordem de espera de uma pessoa. \n"
                +"5 - Verificar Fila. \n"
                +"6 - Verificar Pilha. \n"
                +"9 - Finalizar."));
			
            switch(opcao) {
				case 1: 
                    if( fila.ListaCheia() == true ) {
                        JOptionPane.showMessageDialog(null, "A Fila está cheia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "A Fila não está cheia!");
                    }
				break;
			
				case 2: 
                    if ( fila.ListaCheia() == true ) {
                        JOptionPane.showMessageDialog(null, "A Fila está cheia!");
                    } else {
                        ID = fila.GerarId(ID);
                        nome = JOptionPane.showInputDialog("Digite o nome: ");
                        RG  = Integer.parseInt(JOptionPane.showInputDialog("Digite o RG: ")); 
                        telefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone: ")); 
                        dNascimento = JOptionPane.showInputDialog("Digite a data de nascimento: ");
                        fila.AdicionaFila(ID, nome, RG, telefone, dNascimento);
                    }
				break;
			
				case 3: 
                    fila.RemoveFila(p);
				break;

                case 4: 
                    fila.BuscarPosicao(ID);    
				break;

                case 5: 
					fila.ExibirFila();
				break;

                case 6: 
					fila.ExibirPilha();
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