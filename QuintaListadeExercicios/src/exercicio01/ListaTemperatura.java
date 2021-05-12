package exercicio01;
import javax.swing.JOptionPane;

public class ListaTemperatura {
    private NO inicio;			
	
	public ListaTemperatura() {		
		inicio = null;				
	} 
	
	//Verificar se a lista está vazia
	public boolean ListaVazia() {	
		if (inicio == null) {
			return true;			
		}
		return false;				
	} 

	//Adicionar uma temperatura no início da lista
	public void AdicionaInicio(int e) {			
		NO n = new NO(e);						
		n.prox = inicio;						
		inicio = n;								
	}
	
	//Adicionar uma temperatura no final da lista
	public void AdicionaFinal(int e) { 	
		if (inicio == null) {			
			NO n = new NO(e);			
			inicio = n;					
		}  
		else {
			try {
				NO aux = inicio;	
                			
				while (aux.prox != null) {		
					aux = aux.prox;				
				} 

				NO n = new NO(e);				
				aux.prox = n;								
			} 
			catch (Exception e2) {
				System.err.println("Ocorreu um erro");
			}
		}  
	} 

	//Adicionar uma temperatura em determinada posição da lista
	public void AdicionarPosicao(int e, int posicao) {
		NO novo = new NO(e);		
		
		if ( posicao == 1 ) {
			AdicionaInicio(e);
		} 
		else {
			NO aux = inicio;			
			int cont = 1;				
			
			while (aux.prox != null && cont < posicao--) {  
				aux = aux.prox;		
				cont ++;
			} 
			
			if ( cont == posicao-- ) {  		
				novo.prox = aux.prox;	
				aux.prox = novo;		
			} 
			else {
				JOptionPane.showConfirmDialog(null, "Posição Inválida!");
			} 
		} 
	} 

	//Remover a temperatura do início da lista
	public int RemoverInicio() {			
		int r = -1;
		if (inicio == null) {
			JOptionPane.showConfirmDialog(null, "A Lista está vazia");
		} 
		else {
			r = inicio.dados;			
			inicio = inicio.prox;			
		} 
		return r;
	} 
	
	//Remover a temperatura do final da lista
	public int RemoveFinal() {					
		int r = -1;								
		if (inicio == null ) {
			JOptionPane.showConfirmDialog(null, "A Lista está vazia");
		}
		else {
			if (inicio.prox == null) {			
				r = inicio.dados;				
				inicio = null;					
			} 
			else {
				NO aux1 = inicio;			
				NO aux2 = inicio;
				
				while (aux1.prox != null) {  
					aux2 = aux1;			
					aux1 = aux1.prox;		
				} 
				
				r = aux1.dados;				
				aux2.prox = null;			
			} 
		} 
		return r;
	}
	
	//Remover a temperatura de determinada posição da lista
	public int RemoverPosicao(int posicao) {
		int e = -1, i = 1; 
		NO aux = inicio;	
		
		if (inicio == null) {
			JOptionPane.showConfirmDialog(null, "A Lista está vazia");
			return e;
		} 
		if (posicao == 1) {  
			e = RemoverInicio();
			return e;
		}
		else {

			while (aux.prox != null) {  
				aux = aux.prox;   
				i++;				
			} 

			if (posicao > i || posicao <=0) {  
				JOptionPane.showConfirmDialog(null, "Posição Inválida!");
				return e;
			} 
			else if (posicao == i) {			
				e = RemoveFinal();
				return e;
			} 
			else {						
				aux = inicio;			
				NO aux2 = aux;			
				
				while(posicao > 1) {
					aux2 = aux;
					aux = aux.prox;
					posicao --;
				} 
				
				e = aux.dados;
				aux2.prox = aux.prox;
				return e;
			} 
		}
	} 
	
	//Apresentar lista
	public void MostrarLista() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null,"A Lista está vazia");
		} 
		else {
			NO aux1 = inicio;
			JOptionPane.showMessageDialog(null, "A Lista será mostrada no console");
			while (aux1 != null) {
				System.out.println(aux1.dados);
				aux1 = aux1.prox;
			}
		}
	} 
} 