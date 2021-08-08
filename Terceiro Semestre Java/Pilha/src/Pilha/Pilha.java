package Pilha;

public class Pilha {
	public int[] dados;
	private int topo;
	public int max;
	
	public Pilha(int tam)
	{
		this.max=tam;
		this.dados = new int[tam];
		this.topo = -1;
	}
	public boolean cheia()
	{
		return (topo == max-1);
	}
	public boolean vazia()
	{
		return (topo==-1);
	}
	public boolean empilhar(int num)
	{
		if (!cheia())
		{
			this.dados[topo+1] = num;
			topo++;
			return true;
		}
		else
		{return false;}
	}
	public int desempilhar()
	{
		if (vazia())
		{
			System.out.println("Nada para desempilhar");
			return 0;
		}
		else {
			topo--;
			return this.dados[topo+1];
		}
		
	}
	public int retornaTopo()
	{
		if (vazia())
		{
			System.out.println("Pilha vazia");
			return 0;
		}
		return this.dados[topo];
	}
	public static void main(String[] args) {
		Pilha p = new Pilha(5);
		p.empilhar(3);
		System.out.println(p.retornaTopo());
		System.out.println("Número desempilhado: " + p.desempilhar());
		System.out.println(p.retornaTopo());

	}
	
	
}
