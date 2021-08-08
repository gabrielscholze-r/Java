package Trabalho5;

public class Principiante extends Jogador{
	private double bonus;
	public Principiante(String nome, int pontos, double bonus) {
		super(nome, pontos);
		this.bonus = bonus;
	}
	public void imprimir() {
		super.imprimir();
		System.out.println("Bônus: " + bonus);
		
	}
	public void ganhar(int p)
	{
		super.score += p;
		this.bonus += 0.1*p;
	}
	public void perder(int p)
	{
		super.score -= p;
		this.bonus -= 0.1*p;

	}
}
