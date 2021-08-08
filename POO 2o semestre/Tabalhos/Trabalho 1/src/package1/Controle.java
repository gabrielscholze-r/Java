package package1;

public class Controle {
	public static void main(String[] args) {
		Semaforo classe = new Semaforo();
		System.out.println(classe.cor);
		for (int i = 0; i<10; i++) {
			classe.MudaProximaCor();
			System.out.println(classe.cor);
			
		}
		classe.MudaCorFixa(1);
		System.out.println(classe.cor);
	}
}
