import java.util.Random;
import java.util.Scanner;

public class Questoao4 {
	public int aleatorio;
	
	public void geraNumero()
	{
		Random gerador = new Random();
		aleatorio = gerador.nextInt(1000) + 1;
	}
	public static void main(String[] args) 
	{
		boolean running = true;
		Questoao4 q = new Questoao4();
		q.geraNumero();
		System.out.println("Adivinhe o número entre 1 e 1000");
		while (running) 
		{
			Scanner chute = new Scanner(System.in);
			int n = chute.nextInt();
			if (n == q.aleatorio)
			{
				System.out.println("Certa a resposta!");
				System.out.println("Deseja jogar novamente? Sim = 1; Não = 2");
				int resposta = chute.nextInt();
				if (resposta == 2) {
					running = false;
				}
				
			}
			else
			{
				if (n < q.aleatorio){
					System.out.println("Muito baixo, tente novamente");
				}
				else 
				{
					System.out.println("Muito alto, tente novamente");
				}
			}
		}
	}
}
