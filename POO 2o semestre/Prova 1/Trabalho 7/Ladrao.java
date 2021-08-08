package Trabalho7;

abstract class Ladrao extends Vilao{
	
	public Ladrao(int cor) {
		super(cor);
	}
	
	public void saltar(float z) {
		System.out.println("Ladrão saltando...");
		this.posicaoZ = z;
	}
	
	public void atirar() {
		System.out.println("Ladrão atirando...");
	}
	
}
