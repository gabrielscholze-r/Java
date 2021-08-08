package Trabalho7;


abstract class Terrorista extends Vilao{
	
	public Terrorista(int cor) {
		super(cor);
	}
	
	public void saltar(float z) {
		System.out.println("Terrorista saltando...");
		this.posicaoZ = z;
	}
	
	public void atirar() {
		System.out.println("Terrorista atirando...");
	}

}
