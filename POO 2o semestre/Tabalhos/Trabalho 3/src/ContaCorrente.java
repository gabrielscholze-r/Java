public class ContaCorrente {
	private int numero;
	private double saldo;
	private Cliente cliente;
	public ContaCorrente() {
		this.saldo = 0;
	}
	public void setNumero(int numeroNovo) {
		this.numero = numeroNovo;
	}
	
	public void depositar(int depo) {
		this.saldo = this.saldo + depo;
		System.out.println("Saldo: " + saldo);
	}
	public double retirar(double valor) {
		if (saldo - valor>=0) {
			saldo -= valor;
			System.out.println("Saldo: " + saldo);
			return valor;
			
		}
		else {
			System.out.println("Saldo insuficiente");
			System.out.println("Saldo: " + saldo);
			return 0;
		}
	}
	public void verificar() {
		System.out.println(String.format("Saldo restante: %s", this.saldo));
	}
	public void imprimir() {
		System.out.println("Conta: " + numero);
		System.out.println("Saldo: " + saldo);
	}
}
