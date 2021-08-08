import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Contador_Palavras {
	public Arvore teste(File f) throws FileNotFoundException {
		File[] listaDeArquivos = f.listFiles();
		Arvore a = new Arvore();
		a.raiz = new NoArvore();

		for(int i = 0; i < listaDeArquivos.length;i++) {
			Scanner sc = new Scanner(listaDeArquivos[i]);
			String nomeArquivo = listaDeArquivos[i].getName();
			
			while(sc.hasNext()) {
				String palavra = sc.next();
			    NoArvore no = a.raiz;
			    if(verifica(a.raiz,palavra)) {
			    	while(no != null) {
				    	if(palavra.compareTo(no.lista.primeiro.palavra) == 0) {
							break;
						}else if(palavra.compareTo(no.lista.primeiro.palavra) > 0) {
							no = no.direita;
						}else if(palavra.compareTo(no.lista.primeiro.palavra) < 0) {
							no = no.esquerda;
						}
				    }
			    	
					No x = no.lista.primeiro;
					while (x != null) {
						if (x.nomeArquivo.equals(nomeArquivo)) {
							x.freq++;
							break;
						}
						x = x.proximo;
					}
					if(x == null) {
						no.lista.insereOrdenado(palavra, 1, nomeArquivo);
					}
			    }else {
			    	a.insere_elemento(a, palavra, 1, nomeArquivo);
			    }
			}
			sc.close();
		}
		return a;
	}
	
	public boolean verifica(NoArvore no, String palavra) throws FileNotFoundException{
		if (no == null || no.lista.primeiro == null) {
			return false;
		}else if(palavra.compareTo(no.lista.primeiro.palavra) == 0) {
			return true;
		}else if(palavra.compareTo(no.lista.primeiro.palavra) > 0) {
			return verifica(no.direita,palavra);
		}else if(palavra.compareTo(no.lista.primeiro.palavra) < 0) {
			return verifica(no.esquerda,palavra);
		}
		return false;
	}
	
	public void pesquisa(Arvore a, String palavra) throws FileNotFoundException {
        if (!this.verifica(a.raiz, palavra)) {
            System.out.println("Essa palavra não foi encontrada.");
        } else {
            NoArvore x = a.raiz;

            while(palavra.compareTo(x.lista.primeiro.palavra) != 0) {
                if (palavra.compareTo(x.lista.primeiro.palavra) > 0) {
                    x = x.direita;
                } else if (palavra.compareTo(x.lista.primeiro.palavra) < 0) {
                    x = x.esquerda;
                }
            }

            System.out.println("Palavra: " + x.lista.primeiro.palavra);
            No no = x.lista.primeiro;

            int y;
            for(y = 0; no != null; no = no.proximo) {
                System.out.println("Nome do Arquivo: '" + no.nomeArquivo + "' || Frequência: " + no.freq);
                y += no.freq;
            }

            System.out.println("Frequência total = " + y);
        }

    }
	
	public static void main(String[] args) throws FileNotFoundException{
		Contador_Palavras cp = new Contador_Palavras();
		Arvore a = cp.teste(new File("C:\\Users\\carli\\OneDrive\\Área de Trabalho\\teste"));
		a.imprime_preordem(a.raiz);
		System.out.println(a.altura(a, a.raiz.esquerda));
		System.out.println(a.altura(a, a.raiz.direita));
	}
}