package Trabalho7;

public class DrNo extends Terrorista {
	
	public DrNo(int cor) {
		super(cor);
	}
	
	public void saltar(float z) {
		System.out.println("DrNo saltando...");
		this.posicaoZ = z;
	}
	
	public void atirar() {
		System.out.println("DrNo atirando...");
	}
	
	public void correr(float x, float y) {
		System.out.println("DrNo correndo...");
		this.posicaoX = x;
		this.posicaoY = y;
	}

}
