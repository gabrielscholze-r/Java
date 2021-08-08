package Trabalho7;

abstract class Personagem {
	
	private boolean vivo;
	protected float posicaoX;
	protected float posicaoY;
	protected float posicaoZ;
	protected int cor;
	
	public Personagem(int cor) {
		this.cor = cor;
	}
	
	abstract public void correr(float x, float y);
	
	abstract public void saltar(float z);
	
	abstract public void atirar();
	
	public void morrer() {
		
	}
	
	
}
