package Batalha;

public class Submarino extends Inimigo{
	public Submarino(int x, int y) {
		super(x, y);
		this.setPontos(7);
	}
	
	public boolean levarBomba()
	{
		if (this.getEstado() == '.')
		{
			this.setMsgBatalha("BOOMM! Submarino Atingido");
			this.setEstado('S');
		}
		else
		{
			this.setMsgBatalha("CRASH! Caiu nos destroços de um submarino");
		}
		return false;
	}
}
