package Trabalho7;

public class Batman extends Heroi implements Camuflagem {
	
	public Batman(int cor) {
		super(cor, "Batman");

	}
	
	public void camuflar(int cor) {
		System.out.println("Batman camuflando....");
		super.cor = cor;
	}
	
	public void atirar() {
		System.out.println("Batman atirando...");
	}
	
}
