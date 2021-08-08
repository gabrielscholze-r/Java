package Trabalho7;

public class JamesBond extends Heroi {

	

	public JamesBond(int cor) {
		super(cor, "James Bond");

	}

	public void saltar(float z) {
		System.out.println("JamesBond saltando...");
		this.posicaoZ = z;
		
	}
	
	public void atirar() {
		System.out.println("JamesBond atirando...");
	}
	
	
	
}
