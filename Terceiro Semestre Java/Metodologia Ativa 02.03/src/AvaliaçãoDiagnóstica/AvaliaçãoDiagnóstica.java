package AvaliaçãoDiagnóstica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AvaliaçãoDiagnóstica {
	public static void main(String[] args) {
		int[] i = {1,2,3,4};
		int[] M = {1, 1, 1, 3, 3, 3};
		System.out.println(Media(i));
		int Moda[] = {1, 1, 2, 3};
        float saida[] = {};
        
        Map<Float, Integer> frequenciaNumeros = new HashMap<>();
        
        int maiorFrequencia = 0;
        
        for (float numero : Moda) {
            // Verificar se o número já está na lista
            Integer quantidade = frequenciaNumeros.get(numero);
            
            
            // Lista de números
            if (quantidade == null) {
                quantidade = 1;
            }  else {
                quantidade += 1;
            }
            
            frequenciaNumeros.put(numero, quantidade);
            
            if (maiorFrequencia < quantidade) {
                maiorFrequencia = quantidade;
            }
        }
        
        System.out.print("A(s) moda(s) é (são) : ");
        
        
        
        for (Float numeroChave : frequenciaNumeros.keySet()) {
            
            int quantidade = frequenciaNumeros.get(numeroChave);
            
            if (maiorFrequencia == quantidade) {
                System.out.print(numeroChave + " ");
                saida = Arrays.copyOf(saida, saida.length + 1);
                saida[saida.length - 1] = numeroChave;
            }
        
        }
        System.out.println();
        
        if(saida.length != 1) {
            System.out.println("Não Existe Moda Única!!");
        } else {
            System.out.println("Moda única!");
        }
    }

	
	public static int Media(int[] array)
	{
		int soma = 0;
		for (int i = 0; i<array.length;i++)
		{
			soma = soma + array[i];
		}
		return soma/array.length;
	}
	//moda eu n sei caraiovaisefoder
	
	


}
