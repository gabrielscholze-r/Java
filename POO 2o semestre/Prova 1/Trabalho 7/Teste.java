package Trabalho7;

public class Teste {
	
	public static void main(String[] args) {
		Batman bat = new Batman (1);
		Coringa coring = new Coringa(2);
		Pinguim ping = new Pinguim(2);
		JamesBond james = new JamesBond (1);
		DrNo dr = new DrNo (2);
		GoldFinger gold = new GoldFinger(2);
		bat.atirar(); // chamada de método do Bataman
		bat.correr(20, 30); // chamada de método herdado
		bat.camuflar(2); // chamada de método do Bataman
		bat.saltar(20); // chamada de método herdado
		System.out.println("----------------------");
		coring.correr(20, 30);
		coring.atirar();
		coring.saltar(5);
		System.out.println("----------------------");
		ping.correr(20, 30);
		ping.atirar();
		ping.saltar(4);
		System.out.println("----------------------");
		james.atirar();
		james.correr(20, 30);
		james.saltar(5);
		System.out.println("----------------------");
		dr.correr(20, 30);
		dr.atirar();
		dr.saltar(3);
		System.out.println("----------------------");
		gold.personificar(james);
		gold.camuflar(1);
		gold.correr(20, 30);
		gold.atirar();
		gold.saltar(2);
		}

}
