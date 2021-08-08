package Trabalho7;

public class Pinguim extends Ladrao {
	
	public Pinguim(int cor) {
		super(cor);
	}
	
	public void atirar() {
		System.out.println("Pinguim atirando...");
	}
	
	public void correr(float x, float y) {
		System.out.println("Pinguim atirando...");
		this.posicaoX = x;
		this.posicaoY = y;
	}


}
