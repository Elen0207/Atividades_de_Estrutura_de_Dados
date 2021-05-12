package controller;

import javax.swing.JOptionPane;

public class ListaEncadeada {
    private int id;
    private String nome;
    private String curso;
    private NO inicio;

    public ListaEncadeada(){
        inicio = null;
    }

    public boolean ListaVazia() {
        if (inicio == null) {
			return true;			
		}
		return false;	
    }

    public void AdicionarInicio() {
        Aluno alunos = new Aluno(id, nome, curso);

        id = (int)(Math.random() *1000);
        alunos.setId(id);

        nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
        alunos.setNome(nome);

        curso = JOptionPane.showInputDialog("Digite o curso do aluno: ");
        alunos.setCurso(curso);

		NO no = new NO(alunos);

        if (inicio == null) {							
			no.prox = inicio;
			inicio.anterior = no;									
		}  
		inicio = no;
		
        JOptionPane.showMessageDialog(null,"ID: "+alunos.getId()+
											" - Nome: "+alunos.getNome()+
											" - Curso: "+alunos.getCurso()+
											"\n Foi adicionado com sucesso!");
    }

    public void AdicionarFinal() {
        Aluno alunos = new Aluno(id, nome, curso);

        id = (int)(Math.random()*1000);
        alunos.setId(id);

        nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
        alunos.setNome(nome);

        curso = JOptionPane.showInputDialog("Digite o curso do aluno: ");
        alunos.setCurso(curso);

		NO no = new NO(alunos);
		if (inicio == null){
			inicio = no;
			no.anterior=null;
			no.prox=null;
		}
		else{
			NO aux = inicio;
			while(aux.prox != null){
				aux = aux.prox;
			}
			aux.prox = no;
			no.anterior = aux;
			no.prox=null;
		}
		JOptionPane.showMessageDialog(null,"ID: "+alunos.getId()+
											" - Nome: "+alunos.getNome()+
											" - Curso: "+alunos.getCurso()+
											"\n Foi adicionado com sucesso!");
    }

    public String RemoverInicio() {
        String nome = "", curso = "";
        int id = 0;

        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista está vázia!");
		} 
		else {
			id = inicio.alunos.getId();
			nome = inicio.alunos.getNome();
            curso = inicio.alunos.getCurso();

			inicio = inicio.prox;			
			if (inicio != null) {
				inicio.anterior = null;
			}
		} 
        return "ID: "+id+" - Nome: "+nome+" - Curso: "+curso+"\n Foi removido com sucesso!";
    }

    public String RemoverFinal() {
		String nome = "", curso = "";
        int id = 0;

        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista está vázia!");
		}
		else {
			if (inicio.prox == null) {			
                id = inicio.alunos.getId();
                nome = inicio.alunos.getNome();
                curso = inicio.alunos.getCurso();
				
				inicio = null;					
			} 
			else {
				NO aux1 = inicio;			
				NO aux2 = inicio;
				
				while (aux1.prox != null) {
					aux2 = aux1;
					aux1 = aux1.prox;
				}

				NO aux = LocalizaFim(inicio, inicio);

				id = aux.alunos.getId();
			    nome = aux.alunos.getNome();
                curso = aux.alunos.getCurso();
				
				aux1.anterior = null;
				aux2.prox = null;			
				
			} 
        }
        return "ID: "+id+" - Nome: "+nome+" - Curso: "+curso+"\n Foi removido com sucesso!";
    }

    public NO LocalizaFim(NO aux1, NO aux2) {
		if (aux1.prox != null ) {
			return LocalizaFim(aux1.prox, aux1);
		}
		return aux2;
	}

    public void PercorrerLista() {
        if ( ListaVazia() == true ) {
			JOptionPane.showConfirmDialog(null, "A lista está vázia!");
		} 
		else {
			NO aux = inicio;	
			
			while (aux != null) {
				JOptionPane.showMessageDialog(null, "A lista será mostrada no console");
				System.out.println("\nID: "+aux.alunos.getId()+" - Nome: "+aux.alunos.getNome()+" - Curso: "+aux.alunos.getCurso()); 
				aux = aux.prox;
			} 
		}
    }
}