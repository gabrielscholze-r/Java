
public class Arvore {
	public No raiz;

	public Arvore() {
		this.raiz = null;
	}

	public void insere(int valor) {
		No novo = new No(valor);
		No p = raiz;
		No q = null;

		if (raiz == null) {
			raiz = novo;
		} else {
			while (p != null) {
				q = p;
				if (valor < p.dado) {
					p = p.esquerda;
				} else {
					p = p.direita;
				}
			}
			if (valor < q.dado) {
				q.esquerda = novo;
			} else {
				q.direita = novo;
			}
		}
	}

	public boolean verifica(int valor) {
		No p = raiz;
		No q = null;
		if (raiz == null) {
			return false;
		} else {
			while (p != null) {
				q = p;
				if (p.dado == valor) {
					return true;
				}
				if (valor < p.dado) {
					p = p.esquerda;
				} else {
					p = p.direita;
				}
			}
			return false;
		}
	}
	
	public int maior() {
		if (raiz == null) {
			return 0;
		}
		No n = raiz;
		while (n.direita != null) {
			n = n.direita;
		}
		return n.dado;
	}
	
	public int menor() {
		if (raiz == null) {
			return 0;
		}
		No n = raiz;
		while (n.esquerda != null) {
			n = n.esquerda;
		}
		return n.dado;
	}

	public void preordem(No no) {
		if (no != null) {
			System.out.print(no.dado + " ");
			preordem(no.esquerda);
			preordem(no.direita);
		}
	}
	
	public void inordem(No no) {
		if (no != null) {
			inordem(no.esquerda);
			System.out.print(no.dado + " ");
			inordem(no.direita);
		}
	}
	
	public void posordem(No no) {
		if (no != null) {
			posordem(no.esquerda);
			posordem(no.direita);
			System.out.print(no.dado + " ");
		}
	}

	public static void main(String[] args) {
		Arvore a = new Arvore();
		a.insere(10);
		a.insere(11);
		a.insere(13);
		a.insere(12);
		a.insere(14);
		a.insere(5);
		a.insere(4);
		a.insere(7);
		a.insere(6);
		System.out.println("Menor");
		System.out.println(a.menor());
		System.out.println("Maior");
		System.out.println(a.maior());
		
		a.preordem(a.raiz);
		System.out.println("");
		a.inordem(a.raiz);
		System.out.println("");
		a.posordem(a.raiz);
	}
}