package Tad;

import java.util.Scanner;


//A sample Java program to sort an array of integers
//using Arrays.sort(). It by default sorts in
//ascending order
import java.util.Arrays;
public class qst4 {
	  public static void main(String[] args) {
		  Scanner enter = new Scanner(System.in);
		  System.out.println("Insira o tamanho desejado para o vetor: ");
		  int n = enter.nextInt();
		  int v[] = new int[n];
		  int i;
		  for (i=0; i<n; i++) {
			  System.out.printf("Informe %2do. valor de %d: ", (i+1), n);
			  v[i] = enter.nextInt(); //pede todos os valores com base no tamanho do vetor
		  }

		  //calculos
		  int soma = 0;
		  Arrays.sort(v); // Ajusta o array do menor para o maior valor
		  int menor = v[0]; //o menor valor passa ser o primeiro
		  int maior = v[v.length-1]; //pega o ultimo valor do vetor, ou seja, o maior
		  for (i=0; i<n; i++) {
			  soma = soma + v[i]; //soma dos valores
		  }
		  System.out.printf("\n");
		  for (i=0; i<n; i++) {
			  if (v[i] == menor)
				  System.out.printf("v[%d] = %2d <--- menor valor\n", i, v[i]);
			  else if (v[i] == maior)
	              System.out.printf("v[%d] = %2d <--- maior valor\n", i, v[i]);
	          else System.out.printf("v[%d] = %2d\n", i, v[i]);
		  }

		  
	  	}

	}
