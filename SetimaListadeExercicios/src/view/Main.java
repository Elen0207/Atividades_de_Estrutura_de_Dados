package view;

import javax.swing.JOptionPane;
import controller.ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        
        ListaEncadeada lista = new ListaEncadeada();
        int opcao = 0;
        
        while (opcao != 9) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu aluno: \n\n"+
                                                                "1 - Verificar se a lista está vazia \n"+
                                                                "2 - Adicionar um aluno no início da lista \n"+
                                                                "3 - Adicionar um aluno no final da lista \n"+
                                                                "4 - Remover um aluno do início da lista \n"+
                                                                "5 - Remover um aluno do final da lista \n"+
                                                                "6 - Percorrer e apresentar lista \n\n"+
                                                                "9 - Sair do programa\n"));
        }

        switch (opcao) {
            case 1:
                if ( lista.ListaVazia() == true ) {
                    JOptionPane.showMessageDialog(null,"Lista está vazia");
                } else {
                    JOptionPane.showMessageDialog(null, "Lista está não vazia");
                }
            break;

            case 2:
                lista.AdicionarInicio();
            break;

            case 3:
                lista.AdicionarFinal();
            break;

            case 4:
                lista.RemoverInicio();
            break;

            case 5:
                lista.RemoverFinal();
            break;

            case 6:
                lista.PercorrerLista();
            break;

            case 9:
                JOptionPane.showMessageDialog(null, "Saindo do programa");
            break;

            default:
			break;
        }
    }
}