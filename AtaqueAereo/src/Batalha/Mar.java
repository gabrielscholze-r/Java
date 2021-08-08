package Batalha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Mar implements Serializable{
	//atributos
	private int navios;
	private int submarinos;
	private int postos;
	private int tamanho;
	private ArrayList<Inimigo> inimigos;
	//construtor
	public Mar(int navios, int submarinos, int postos, int tamanho) {
		this.navios = navios;
		this.submarinos = submarinos;
		this.postos = postos;
		this.tamanho = tamanho;
		this.inimigos = new ArrayList<Inimigo>();
	}
	//metodos
	public ArrayList<Inimigo> getInimigos()
	{
		return inimigos;
	}
	public void setInimigos(ArrayList<Inimigo> inimigos)
	{
		this.inimigos = inimigos;
	}
	public void iniciarMar()
	{
		int i;
        for(i = 0; i<this.navios; i++) {
            Coordenadas coord = acharLocalizacao();
            inimigos.add(new Navio(coord.getX(), coord.getY()));
        }

        for(i = 0; i<this.submarinos; i++) {
            Coordenadas coord = acharLocalizacao();
            inimigos.add(new Submarino(coord.getX(), coord.getY()));
        }

        for(i = 0; i<this.postos; i++) {
            Coordenadas coord = acharLocalizacao();
            inimigos.add(new Posto(coord.getX(), coord.getY()));
        }
	}
	public void desenharMar()
	{
		char[][] mar = new char[this.tamanho][this.tamanho];
		Random rand = new Random();
		System.out.println("     ________________________________________");
		System.out.println("     | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
		System.out.println("     ==+==+==+==+==+==+==+==+==+==+==+==+==+==");
		int counter = 0;
		for (int x = 0; x < this.tamanho; x++)
		{
			int counter2 = 0;
			for (int y = 0; y < this.tamanho; y++)
			{
				counter2++;
				mar[x][y] = '.';
				for (Inimigo i : this.inimigos)
				{
					if (i.getCoord().getX() == x && i.getCoord().getY() == y)
					{
						mar[x][y] = i.getEstado();
					}
				}
				if (counter2==10)
				{
					System.out.println(" | " + mar[x][y] + " | ");
					System.out.println("     ==+==+==+==+==+==+==+==+==+==+==+==+==+==");
				}
				else if (counter2 == 1)
				{
					System.out.print(" | " + counter + " | " + mar[x][y]);
				}
				else
				{
					System.out.print(" | " + mar[x][y]);
				}
				
				//System.out.print(" | " + mar[x][y]);
			}
			
			
			counter++;
		}
	}
	public Coordenadas acharLocalizacao()
	{
		int x = 0;
		int y = 0;
		boolean ocupado = true; 
		Random rand = new Random();
		while(ocupado)
		{
			
				x = rand.nextInt(this.tamanho);
				y = rand.nextInt(this.tamanho);
				ocupado = false;
				for (Inimigo ini : this.inimigos)
				{
					if (ini.getCoord().getX() == x && ini.getCoord().getY() == y)
					{
						ocupado = true;
					}
				}
				
			
		}
		return new Coordenadas(x, y);
	}
	
	
	
}
