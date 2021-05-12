package exercicio02;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        ListaEncadeada lista = new ListaEncadeada();	 	
		int opcao = 0, RA = 0, posicao = 0; 
        String nome = "", turma = "", semestre = "";
		
		while (opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("*** ALUNO *** \n\n"
                +"1 - Adicione um aluno no final da lista. \n"
                +"2 - Adicione um  aluno no início da lista.\n"
                +"3 - Adicione um aluno no meio da lista.\n"
                +"4 - Remova um aluno no final da lista. \n"
                +"5 - Remova um aluno no início da lista. \n"
                +"6 - Remova um aluno no meio da lista. \n"
                +"7 - Apresente cada um dos elementos da lista. \n"
                +"9 - Finalizar."));
			
            switch(opcao) {
				case 1: 
					RA = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA: "));
					nome = JOptionPane.showInputDialog("Digite o nome: ");
					turma = JOptionPane.showInputDialog("Digite a turma: ");
					semestre = JOptionPane.showInputDialog("Digite o semestre: ");

					lista.AdicionaFinal(RA, nome, turma, semestre);
					JOptionPane.showMessageDialog(null, "Novo aluno foi adicionado com sucesso");
				break;
			
				case 2: 
					RA = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA: "));
					nome = JOptionPane.showInputDialog("Digite o nome: ");
					turma = JOptionPane.showInputDialog("Digite a turma: ");
					semestre = JOptionPane.showInputDialog("Digite o semestre: ");

					lista.AdicionaInicio(RA, nome, turma, semestre);
					JOptionPane.showMessageDialog(null, "Novo aluno foi adicionado com sucesso");
				break;
			
				case 3: 
					RA = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA: "));
					nome = JOptionPane.showInputDialog("Digite o nome: ");
					turma = JOptionPane.showInputDialog("Digite a turma: ");
					semestre = JOptionPane.showInputDialog("Digite o semestre: ");

					posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja inserir esse aluno: "));

					lista.AdicionarPosicao(RA, nome, turma, semestre, posicao);
					JOptionPane.showMessageDialog(null, "Novo aluno foi adicionado com sucesso");
				break;

                case 4: 
					lista.RemoverFinal();
				break;

                case 5: 
					lista.RemoverInicio();
				break;

                case 6: 
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição de remoção: "));
					lista.RemoverPosicao(posicao);
				break;

                case 7: 
					lista.MostrarLista();
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