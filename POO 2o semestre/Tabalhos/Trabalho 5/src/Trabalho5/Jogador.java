package Trabalho5;

public class Jogador {
	private String nome;
	protected int score;
	
	public Jogador (String nome, int Score) {
		this.nome = nome;
		this.score = Score;
	}
	public void imprimir() {
		System.out.println("Nome: " + nome);
		System.out.println("Score: " + score);
	}
}



