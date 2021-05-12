package exercicio01;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int posicao = 0, opcao = 0,  entrada = 0;	
		ListaTemperatura Lista = new ListaTemperatura();
		
		while ( opcao != 9 ) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" *** MENU *** \n"+
			 "1 - Verificar se a lista está vazia. \n"+
			 "2 - Adicionar uma temperatura no início da lista. \n"+
			 "3 - Adicionar uma temperatura no final da lista. \n"+
			 "4 - Adicionar uma temperatura em determinada posição da lista. \n"+
			 "5 - Remover a temperatura do início da lista. \n"+
			 "6 - Remover a temperatura do final da lista. \n"+
			 "7 - Remover a temperatura de determinada posição da lista. \n"+
			 "8 - Apresentar lista. \n"+
			 "9 - Sair  "));  
			
			switch (opcao) {
				case 1:  
					if ( Lista.ListaVazia() == true ) {
						JOptionPane.showMessageDialog(null,"Lista está vazia");
					} else {
						JOptionPane.showMessageDialog(null, "Lista está não vazia");
					}
				break;
	
				case 2:
					entrada = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
					Lista.AdicionaFinal(entrada);
				break;
				
				case 3:
					entrada = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
					Lista.AdicionaInicio(entrada);
				break;
					
				case 4:
					entrada = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição de inserção: "));
					
					Lista.AdicionarPosicao(entrada, posicao);
				break;
					
				case 5:   
					JOptionPane.showMessageDialog(null,"O elemento removido foi: " +Lista.RemoveFinal());
				break;
					
				case 6:  
					JOptionPane.showMessageDialog(null,"O elemento removido foi: " +Lista.RemoverInicio());
				break;
					
				case 7:  
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição de remoção: "));

					JOptionPane.showMessageDialog(null, "O elemento removido foi: " +Lista.RemoverPosicao(posicao));
				break;
				
				case 8:   
					Lista.MostrarLista();
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