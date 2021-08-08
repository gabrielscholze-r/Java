package Trabalho5;

public class Profissional extends Jogador{
	private double capital;
	
	public Profissional(String nome, int score, double capital)
	{
		super(nome, score);
		this.capital = capital;
	}
	
	public void imprimir()
	{
		super.imprimir();
		System.out.println("Capital: " + capital);
	}
	public void ganhar(int p)
	{
		super.score += p;
		this.capital += p*4;
	}
	public void perder(int p)
	{
		super.score -= p;
		this.capital -= p*4;
	}
}
