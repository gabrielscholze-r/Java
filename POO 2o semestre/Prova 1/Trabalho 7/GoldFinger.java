package Trabalho7;

public class GoldFinger extends Terrorista implements Personificacao{
	
	private Heroi heroi;
	
	public GoldFinger(int cor) {
		super(cor);
	}
	
	public void personificar(Heroi h) {
		System.out.println("Goldfinger personoficando " + h.getNome());
		this.heroi = h;
	}
	
	public void camuflar(int cor) {
		System.out.println("Goldfinger camuflando....");
		super.cor = cor;
	}
	
	public void saltar(float z) {
		System.out.println("GoldFinger saltando...");
		this.posicaoZ = z;
	}


}
