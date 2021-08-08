package Batalha;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Jogo implements Serializable{
	//Atributos
	private boolean fim ;
	private String mensagem;
	private Mar mar;
	private Piloto piloto;
	//Construtor
	public Jogo() {
		iniciaJogo("Inicio de jogo! Boa Sorte!");
	}
	//métodos
	public void iniciaJogo(String str)
	{
		this.mar = new Mar(7,4,5,10);
		this.mensagem = str;
		this.fim = false;
	}
	public void iniciaPiloto()
	{
		piloto.setDisparos(0);
		piloto.setQtdNavios(7);
		piloto.setQtdSubmarinos(4);
		piloto.setPontos(0);
	}
	public String getMensagem()
	{
		return this.mensagem;
	}
	public void setMensagem(String Mensagem)
	{
		this.mensagem = Mensagem;
	}
	public void criarPiloto(Scanner leitor)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Digite o nome do piloto");
		String nome = reader.nextLine();
		this.piloto = new Piloto(nome);
	}
	public static void clearScreen()
	{
		if (System.getProperty("os.name").contains("Windows"))
			try {
			 new ProcessBuilder("cmd", "/c",
			 "cls").inheritIO().start().waitFor();
			} catch (InterruptedException | IOException e) {
			e.printStackTrace();
			} else
			try {
			 Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean verificaDisparo(int x, int y)
	{
		boolean fimDeJogo = false;
		boolean atingiuInimigo = false;
		Inimigo inimigo = new Inimigo(x,y);
		inimigo.setEstado('x');
		for(Inimigo i : this.mar.getInimigos())
		{
			if (i.getCoord().getX() == x && i.getCoord().getY() == y)
			{
				atingiuInimigo = true;
				inimigo = i;
				if (inimigo.getClass().getName().equals("Batalha.Posto"))
				{
					Posto post = (Posto) inimigo;
					fimDeJogo = post.levarBomba();
					
				}
				else if(inimigo.getClass().getName() == "Batalha.Navio")
				{
					Navio nav = (Navio) inimigo;
					if (nav.getEstado() == '.')
					{
						int qtdNavios = (this.piloto.getQtdNavios()) + 1;
						this.piloto.setQtdNavios(qtdNavios);
						this.piloto.setPontos(this.piloto.getPontos() + nav.getPontos());
					}
					fimDeJogo = nav.levarBomba();
					
					
				}
				else if(inimigo.getClass().getName() == "Batalha.Submarino")
				{
					Submarino sub = (Submarino) inimigo;
					if (sub.getEstado() == '.')
					{
						int qtdSubmarino = (this.piloto.getQtdSubmarinos()) + 1;
						this.piloto.setQtdSubmarinos(qtdSubmarino);
						this.piloto.setPontos(this.piloto.getPontos() + sub.getPontos());
					}
					fimDeJogo = sub.levarBomba();
				}
				
				//break;
				
			}
		}
		if (atingiuInimigo == false)
		{
			this.mar.getInimigos().add(inimigo);
			fimDeJogo = inimigo.levarBomba();
			
			
		}
		this.mensagem =  "(" + y + ", " + x + ") " + inimigo.getMsgBatalha();
		this.piloto.setDisparos(this.piloto.getDisparos()+1);
		return fimDeJogo;
		
	}
	public void mostraJogo()
	{
		clearScreen();
		System.out.println("--------------------------------------------");
		System.out.println("Piloto: " + this.piloto.getNome() + "\n");
		System.out.println("Radar:");
		this.mar.desenharMar();
		System.out.println("Navios Atingidos: " + this.piloto.getQtdNavios());
		System.out.println("Submarinos Atingidos: " + this.piloto.getQtdSubmarinos());
		System.out.println("Disparos : " + this.piloto.getDisparos());
		System.out.println("Pontos : " + this.piloto.getPontos());
		System.out.println("Mensagem: " + this.mensagem);
	}
	public void jogar(Scanner leitor, String partida) throws FileNotFoundException, IOException
	{
		mar.iniciarMar();
		int x = -1;
		int y = -1;
		boolean fimDeJogo = false;
		boolean continuar = true;
		String resp = "";
		if (partida.equals("nova"))
		{
			this.criarPiloto(leitor);
		}
		while(continuar)
		{
			while(!fimDeJogo)
			{
				this.mostraJogo();
				System.out.println("Coordenada X para disparo(entre 0 e 9): ");
				x = leitor.nextInt();
				System.out.println("Coordenada Y para disparo(entre 0 e 9):: ");
				y = leitor.nextInt();
				fimDeJogo = this.verificaDisparo(y, x);
				
			}
			
			this.mostraJogo();
			System.out.println("Deseja salvar partida (s/n)?");
			resp = leitor.next();
			if (resp.equals("s") || resp.equals("S"))
			{
				salvaPartida(this);
			}
			else if (!resp.equals("s") || !resp.equals("S"))
			{
				System.out.println("Entrada inválida! Jogo não foi salvo");
			}
			System.out.println("Deseja jogar novamente (s/n)?");
			resp = leitor.next();
			if (resp.equals("s") || resp.equals("S"))
			{
				iniciaJogo("NOVO jogo! Boa sorte!");
				iniciaPiloto();
				continuar = true;
				fimDeJogo = false;
					
			}
			else
			{
				continuar = false;
				fim = false;
			}
			
		}

	}
	private void salvaPartida(Jogo jogoAtual) throws FileNotFoundException, IOException
	{
		ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Jogo salvo")));
		objectOut.writeObject(jogoAtual);
		objectOut.close();
	}
	private static Jogo recuperaJogo() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Jogo salvo")));
		Jogo jogosalvo = (Jogo)objectIn.readObject();
		objectIn.close();
		return jogosalvo;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean x = true;
		
		while(x)
		{
			Jogo MeuJogo;
			Jogo.clearScreen();
			Scanner reader = new Scanner(System.in);
			System.out.println("ATAQUE AÉREO");
			System.out.println("Digite 1 para iniciar novo jogo\nDigite 2 para carregar um jogo\nDigite 0 para sair.");
			int num = reader.nextInt();
			if (num==0)
			{
				x = false;
			}
			else if (num == 1)
			{
				MeuJogo = new Jogo();
				MeuJogo.jogar(reader, "nova");
				if (MeuJogo.fim)
				{
					x = false;
				}
			}
			
			else if (num == 2)
			{
				MeuJogo = Jogo.recuperaJogo();
				if (MeuJogo!=null)
				{
					MeuJogo.jogar(reader,  "mesma");
				}
			}
			
			else
			{
				System.out.println("Entrada inválida, tente novamente!");
			}
			reader.close();
			Jogo.clearScreen();
			x = false;
			System.out.println("Fim de jogo!");
		}
		
	}
	

	
	
	
}
