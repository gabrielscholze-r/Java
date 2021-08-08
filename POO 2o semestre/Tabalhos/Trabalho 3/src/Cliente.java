import java.util.Scanner;

public class Cliente {
	private String nome;
	private ContaCorrente contaCorrente;
	
	public Cliente(String nome, int numeroConta) {
		this.nome = nome;
		contaCorrente = new ContaCorrente();
		contaCorrente.setNumero(numeroConta);
	}
	
	public void operar() {
		Scanner dep = new Scanner(System.in);
		System.out.println("Valor que deseja depositar");
		int deposito = dep.nextInt();
		contaCorrente.depositar(deposito);
		Scanner ret = new Scanner(System.in);
		System.out.println("Valor que deseja retirar");
		int retirar = ret.nextInt();
		contaCorrente.retirar(retirar);
		contaCorrente.verificar();
		System.out.println("Nome: " + nome);
		contaCorrente.imprimir();
		}
}	
