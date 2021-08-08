package Tad;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa("Roger", "Santos", 25, 1000);
		Scanner scan = new Scanner(System.in);
		System.out.println("Quantas pessoas deseja alocar?");
		int n = scan.nextInt();
		Pessoa[] p = new Pessoa[n];
		for (int i = 0; i<p.length;i++)
		{
			System.out.println("_________________________________");
			System.out.println("Insira o nome da Pessoa");
			String nome = scan.next();
			System.out.println("Insira o sobrenome da Pessoa");
			String sobrenome = scan.next();
			System.out.println("Insira a idade da Pessoa");
			int idade = scan.nextInt();
			System.out.println("Insira o salário da Pessoa");
			int salario = scan.nextInt();
			System.out.println("_________________________________");
			
			p[i] = new Pessoa(nome, sobrenome, idade, salario);

		}
		System.out.println("================================================");
		System.out.println("Dados das pessoas:");
		for (Pessoa i : p)
		{
			
			System.out.println("Nome: " + i.getNome());
			System.out.println("Sobreome: " + i.getSobrenome());
			System.out.println("Idade: " + i.getIdade());
			System.out.println("Salário: " + i.getSalario());
			System.out.println("_________________________________");
		}
		
	}
}
