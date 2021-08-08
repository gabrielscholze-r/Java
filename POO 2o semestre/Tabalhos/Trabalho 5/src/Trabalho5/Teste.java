package Trabalho5;

public class Teste {
	public static void main(String[] args)
	{
		Principiante j1 = new Principiante("Robert", 0, 10);
		Profissional j2 = new Profissional("Alfredo", 0, 10);
		Senior j3 = new Senior("Tobias", 0, 10, 10);
		
		System.out.println("Principiante");
		j1.imprimir();
		j1.ganhar(20);
		System.out.println("-");
		j1.imprimir();
		j1.perder(10);
		System.out.println("-");
		j1.imprimir();
		System.out.println("_______________");
		
		System.out.println("Profissional");
		j2.imprimir();
		j2.ganhar(10);
		System.out.println("-");
		j2.imprimir();
		j2.perder(5);
		System.out.println("-");
		j2.imprimir();
		System.out.println("_______________");
		
		System.out.println("Senior");
		j3.imprimir();
		j3.ganhar(10);
		System.out.println("-");
		j3.imprimir();
		j3.perder(5);
		System.out.println("-");
		j3.imprimir();
	}
}
