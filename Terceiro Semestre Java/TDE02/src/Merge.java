public class Merge {
	private static int[] merge(Fila f, Fila f2) {
		int[] filaFinal = new int[f.getMAX() + f2.getMAX()];
		
		for(int x=0;x<filaFinal.length;x++) { // for que passa por cada parte da fila final
			
			if (f.vazia() && f2.vazia()) {
				break; // verifica se ambas filas estao vazias, caso estejam, significa q o processo acabou
			}
			 
			if (f2.vazia()) { // caso uma so fila esteja vazia, o resto da outra deve ser adicionada
				filaFinal[x] = f.primeiro();
				f.remove();
			}
			else if(f.vazia()) {// caso uma so fila esteja vazia, o resto da outra deve ser adicionada
				filaFinal[x] = f2.primeiro();
				f2.remove();
			}
			
			else if(f.primeiro()<=f2.primeiro()) { // verifica entre os primeiros de cada fila qual o menor, para adicionalo a fila final e removelo de sua fila de origem
				filaFinal[x] = f.primeiro();
				f.remove();
			}
			
			else if(f2.primeiro()<=f.primeiro()) {// verifica entre os primeiros de cada fila qual o menor, para adicionalo a fila final e removelo de sua fila de origem
				filaFinal[x] = f2.primeiro();
				f2.remove();
			}
		}
		System.out.print("["); // for para printar a fila final
		for(int i:filaFinal) {
			if (i!= filaFinal[filaFinal.length-1])
			{System.out.print(i + ",");}
			else {System.out.print(i);}
		}
		System.out.print("]");
		return filaFinal;
	}
	
	public static void main(String[] args) {
		Fila f = new Fila(4);
		Fila f2 = new Fila(5);
		f.insere(12);
		f.insere(35);
		f.insere(52);
		f.insere(64);
		f2.insere(5);
		f2.insere(15);
		f2.insere(23);
		f2.insere(55);
		f2.insere(75);
		merge(f,f2);
	}
}