package controller;

public class NO {
    public Aluno alunos;
    public NO prox;
	public NO anterior;
	
	public NO (Aluno alunos) {
		this.alunos = alunos;
		prox = null;
		anterior = null;
	}
}