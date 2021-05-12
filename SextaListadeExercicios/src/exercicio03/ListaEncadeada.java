package exercicio03;
import javax.swing.JOptionPane;

public class ListaEncadeada {  
    
    private Aluno inicio;
    int RA = 0, posicao = 0; 
    String nome = "", turma = "", semestre = "";
    Aluno aluno = new Aluno(RA, nome, turma, semestre); 

    public ListaEncadeada() {    
        inicio = null;
    }

    //Função auxiliar para recursividade
    public Aluno BuscarUltimo(Aluno aux) {
        if ( aux.proximo != null ) {
                return BuscarUltimo(aux.proximo);
        }
        return aux;
    }

    //Adicione um aluno no final da lista.
    public void AdicionaFinal(int RA, String nome, String turma, String semestre) { 
        Aluno aluno = new Aluno(RA, nome, turma, semestre); 		
		if (inicio == null) {						
			inicio = aluno;	
            aluno.proximo = null;				
		}  
		else {
			Aluno aux = BuscarUltimo(inicio);	
            aux.proximo = aluno;								
		}  
	} 

    //Adicione um  aluno no início da lista.
    public void AdicionaInicio(int RA, String nome, String turma, String semestre) {			
        Aluno aluno = new Aluno(RA, nome, turma, semestre); 						      
        aluno.proximo = inicio;						
        inicio = aluno;							
    }

    //Adicione um aluno no meio da lista.
    public void AdicionarPosicao(int RA, String nome, String turma, String semestre, int posicao) {
        Aluno novo = new Aluno(RA, nome, turma, semestre);		
        
        if ( posicao == 1 ) {
            AdicionaInicio(RA, nome, turma, semestre);
        } 
        else {
            Aluno aux = inicio;			
            int cont = 1;				
            
            while (aux.proximo != null && cont < posicao--) {  
                aux = aux.proximo;		
                cont ++;
            } 
            
            if ( cont == posicao-- ) {  		
                novo.proximo = aux.proximo;	
                aux.proximo = novo;		
            } 
            else {
                JOptionPane.showConfirmDialog(null, "Posição Inválida!");
            } 
        } 
    } 

    //Remova um aluno no final da lista. 
    public void RemoverFinal() {													
        if (inicio == null ) {
            JOptionPane.showConfirmDialog(null, "A Lista está vazia");
        }
        else {
            if (inicio.proximo == null) {	
                	
                JOptionPane.showMessageDialog(null, "O aluno removido foi: " + inicio.getNome());	
                inicio = null;					
            } 
            else {
                Aluno aux1 = inicio;			
                Aluno aux2 = inicio;
                
                while (aux1.proximo != null) {  
                    aux2 = aux1;			
                    aux1 = aux1.proximo;		
                } 

                JOptionPane.showMessageDialog(null, "O aluno removido foi: " + aux1.getNome());
                aux2.proximo = null;			
            } 
        } 
    }

    //Remova um aluno no início da lista.
    public void RemoverInicio() {			
        if (inicio == null) {
            JOptionPane.showConfirmDialog(null, "A Lista está vazia");
        } 
        else {	
            JOptionPane.showMessageDialog(null, "O aluno removido foi: " + inicio.getNome());				
            inicio = inicio.proximo;			
        } 
    } 

    //Remova um aluno no meio da lista. 
    public void RemoverPosicao(int posicao) {
        int i = 1; 
        Aluno aux = inicio;	
        
        if (inicio == null) {
            JOptionPane.showConfirmDialog(null, "A Lista está vazia");
        } 
        if (posicao == 1) {  
            RemoverInicio();
        }
        else {
            while (aux.proximo != null) {  
                aux = aux.proximo;   
                i++;				
            } 

            if (posicao > i || posicao <=0) {  
                JOptionPane.showConfirmDialog(null, "Posição Inválida!");
            } 
            else if (posicao == i) {			
                RemoverFinal();
            } 
            else {						
                aux = inicio;			
                Aluno aux2 = aux;			
                
                while(posicao > 1) {
                    aux2 = aux;
                    aux = aux.proximo;
                    posicao --;
                } 
        	
                JOptionPane.showMessageDialog(null, "O aluno removido foi: " + aux.getNome());	
                aux2.proximo = aux.proximo;
            } 
        }
    } 

    //Apresente cada um dos elementos da lista.
    public void MostrarLista() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null,"A Lista está vazia");
		} 
		else {
			Aluno aux1 = inicio;
			JOptionPane.showMessageDialog(null, "A Lista será mostrada no console");
            System.out.println(System.lineSeparator().repeat(3)+"  ** ALUNOS ** ");  
			while (aux1 != null) {
				System.out.println( "RA: "+aux1.getRA()+
                                    " - Nome: "+aux1.getNome()+
                                    " - Turma: "+aux1.getTurma()+
                                    " - Semestre: "+aux1.getSemestre());
                aux1 = aux1.proximo;
			}
		}
	}
}