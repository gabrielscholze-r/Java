package Batalha;

public class Navio extends Inimigo{

	public Navio(int x, int y) {
		super(x, y);
		this.setPontos(5);
	}
	
	public boolean levarBomba()
	{
		if (this.getEstado() == '.')
		{
			this.setMsgBatalha("BOOMM! Navio Atingido");
			this.setEstado('N');
		}
		else
		{
			this.setMsgBatalha("CRASH! Caiu nos destro�os de um navio");
		}
		return false;
	}
}
