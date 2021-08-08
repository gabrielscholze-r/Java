public class Banco {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Scholze", 1234);
		Cliente cliente2 = new Cliente("Miuler", 5678);
		Cliente cliente3 = new Cliente("brands", 1238);
		cliente1.operar();
		cliente2.operar();
		cliente3.operar();
	}
}