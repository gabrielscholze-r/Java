package Trabalho5;

public class Senior extends Profissional{
	private double premio;
	
	public Senior(String nome, int pontos, double bonus, double premio)
	{
		super(nome, pontos, bonus);
		this.premio = premio;
	}
	
	public void imprimir()
	{
		super.imprimir();
		System.out.println("Prêmio: " + premio);
	}
	
	public void ganhar(int p)
	{
		super.ganhar(p);
		this.premio *= 2;
	}
	
	public void perder(int p)
	{
		super.perder(p);
		this.premio /= 2;
	}
}
