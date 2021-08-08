public class ListaSE {
	public No primeiro;
	public No ultimo;
	
	public ListaSE() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public boolean vazia() {
		return(this.primeiro == null);
	}
	
	public void inserePrimeiro(int elemento) {
		No p = new No(elemento);
		if(vazia()) {
			this.primeiro = p;
			this.ultimo = p;
		} else {
			p.proximo = this.primeiro;
			this.primeiro = p;
		}
	}
	
	public void insereDepois(No no, int elemento) {
		if(!vazia()) {
			No x = new No(elemento);
			
			if (no.proximo == null) {
				ultimo = x;
			}
			x.proximo = no.proximo;
			no.proximo = x;
		}
	}
	
	public void insereUltimo(int elemento) {
		if(vazia()) {
			inserePrimeiro(elemento);
		} else {
			No p = new No(elemento);
			this.ultimo.proximo = p;
			this.ultimo = p;
		}
	}
	
	public void insereOrdenado(int elemento) {
		if(vazia() || elemento <= primeiro.dado) {
			inserePrimeiro(elemento);
		} else if(elemento >= ultimo.dado) {
			insereUltimo(elemento);
		} else {
			No x = primeiro;
			No y = null;
			while(elemento > x.dado) {
				y = x;
				x = x.proximo;
			}
			No p = new No(elemento);
			p.proximo = x;
			y.proximo = p;
		}
	}
	
	public void mostraLista(){
		if(!vazia()) {
			System.out.print("[");
	        No x = primeiro;
	        while(x.proximo!=null){
	            System.out.print(x.dado + ",");
	            x = x.proximo;
	        }
	        System.out.print(x.dado + "]");
	        System.out.println("\nHeader = [" + primeiro.dado + "," + ultimo.dado   +"]");
		}
		else {
			System.out.println("Lista vazia.");
		}
    }
	
	public int retiraPrimeiro(){
		if (vazia()){
			System.out.println("Lista Vazia");
			return 0;
		}
		int n = primeiro.dado;
		if (this.primeiro == this.ultimo){
			primeiro = null;
			ultimo = null;
		}
		else{
			primeiro = this.primeiro.proximo;
		}
		return n;
	}
	
	public int retiraUltimo(){
		No p = primeiro;
		while (p.proximo!=ultimo){
			p = p.proximo;
		}
		int n = ultimo.dado;
		ultimo = p;
		ultimo.proximo = null;
		return n;
	}
	
	public int retiraDepois(No no) {
		if(vazia() || no == ultimo) {
			return 0;
		}
		if (no.proximo == ultimo) {
			ultimo = no;
		}
		
		int x = no.proximo.dado;
		no.proximo = no.proximo.proximo;
		return x;
	}
	
	public int ultimo_elemento()
	{
		return ultimo.dado;
	}
	
	public int soma(No p) {
		if(p ==null) {
			return 0;
		}
		else {
			return p.dado + soma(p.proximo);
		}
	}
	
	public boolean verifica(int x, No p) { 
		if(p == null) {
			return false;
		}else if (x == p.dado) {
			return true;
		}else {
			return(verifica(x, p.proximo));
		}
	}
	
	public int contagem(No p) { 
		if(p == null) {
			return 0;
		}
		else {
			return 1 + contagem(p.proximo);
		}
	}
	
	public int retorna(int x, No p,int y) {
		y+= 1;
		if (p == null) {
			return 0;
		} else if(x == y) {
			return p.dado;
		} else {
			return retorna(x,p.proximo,y);
		}
	}
	
	public double similaridade(ListaSE l1, ListaSE l2) {
		double x = 0;
		double y = 0;
		double z = 0;
		for (int i = 1;i <= l1.contagem(l1.primeiro);i++) {
			x += l1.retorna(i, l1.primeiro, 0) * l2.retorna(i, l2.primeiro, 0);
			y += l1.retorna(i, l1.primeiro, 0) * l1.retorna(i, l1.primeiro, 0);
			z += l2.retorna(i, l2.primeiro, 0) * l2.retorna(i, l2.primeiro, 0);
		}
		return  x / Math.sqrt(y*z);
	}
	
	public ListaSE intersecao(ListaSE l1, ListaSE l2) {
		ListaSE listaFinal = new ListaSE();
		for(int i = 1;i <= l1.contagem(l1.primeiro);i++) {
			for(int x = 1;x <= l1.contagem(l1.primeiro);x++) {
				if(l1.retorna(i, l1.primeiro, 0) == l2.retorna(x, l2.primeiro, 0)) {
					if(!listaFinal.verifica(l1.retorna(i, l1.primeiro, 0), listaFinal.primeiro)) {
						listaFinal.insereOrdenado(l1.retorna(i, l1.primeiro, 0));
					}
				}
			}
		}
		return listaFinal;
	}
	
	public static void main(String[] args) {
		ListaSE l = new ListaSE();
		ListaSE l1 = new ListaSE();
		l.insereOrdenado(3);
		l.insereOrdenado(2);
		l1.insereOrdenado(2);
		l1.insereOrdenado(3);
		l1.intersecao(l1, l).mostraLista();
	}
}