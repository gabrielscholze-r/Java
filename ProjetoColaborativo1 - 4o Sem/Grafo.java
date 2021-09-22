import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;

public class Grafo {
	public ListaAdj[] grafo;
	private int tamanho;
	private Vertice[] vertices;
	private int numeroAresta = 0;
	
	public Grafo(int tamanho) {
		this.tamanho = tamanho;
		this.grafo = new ListaAdj[tamanho];
		this.vertices = new Vertice[tamanho];
		
		for(int i = 0; i < tamanho; i++) {
			vertices[i] = new Vertice();
			grafo[i] = null;
		}
	}
	
	public void criaAdj(int origem, int destino, double custo) {
		if(grafo[origem] == null) {
			grafo[origem] = new ListaAdj(destino,custo);
		}else {
			ListaAdj x = grafo[origem];
			while(x.proximo != null) {
				x = x.proximo;
			}
			x.proximo = new ListaAdj(destino,custo);
		}
	}
	
	public void removeAdj(int origem, int destino) {
		if(grafo[origem] != null) {
			ListaAdj x = grafo[origem];
			ListaAdj y = null;
			while(x.destino != destino) {
				y = x;
				x = x.proximo;
			}
			if(y == null){
				grafo[origem] = x.proximo;
			}else{
				y.proximo = x.proximo;
			}
		}
	}
	
	public void setaInfo(int i, String info) {
		vertices[i].info = info;
	}
	
	public double peso(int i, int j) {
		if(grafo[i] != null) {
			ListaAdj x = grafo[i];
			while(x.destino != j) {
				x = x.proximo;
			}
			return x.peso;
		}
		return 0;
	}

	public Grafo criaGrafo(File file) throws Exception {
		ArrayList<String> nomes = Calcular.getNumeroemails(file);
		int tamanho = nomes.size();
		Grafo g = new Grafo(tamanho); //Criando um novo espaço para o grafo com o número de usuarios diferentes.

		for (int i = 0; i < tamanho; i++) {
			g.vertices[i].info = nomes.get(i);
		}

		BufferedReader br2 = new BufferedReader(new FileReader(file));
		String linha;

		while ((linha = br2.readLine()) != null) {

			String[] splitlinha = linha.split(" ");
			String remetente = splitlinha[0];
			String destinatario = splitlinha[1];
			String peso = splitlinha[2];

			int indexRemetente = 0;
			int indexDestinatario = 0;

			for(int i = 0; i<g.vertices.length; i++){
				if(g.vertices[i].info.equals(remetente)){
					indexRemetente = i;
					break;
				}
			}

			for(int i = 0; i<g.vertices.length; i++){
				if(g.vertices[i].info.equals(destinatario)){
					indexDestinatario = i;
					break;
				}
			}

			g.criaAdj(indexRemetente, indexDestinatario, Double.parseDouble(peso));
			g.numeroAresta++;
		}

		br2.close();
		return g;
	}

	public int numeroVertices(){
		return tamanho;
	}

	public int numeroArestas(){
		return numeroAresta;
	}

	public void maiorGrauSaida(){
		int[] maiores = new int[20];
		String[] nomes = new String[20];

		for(int i = 0; i < 20; i++){
			maiores[i] = 0;
		}

		for(int i = 0; i < grafo.length; i++){
			int soma = 0;
			ListaAdj l = grafo[i];

			while(l != null){
				soma += l.peso;
				l = l.proximo;
			}
			
			if(soma > maiores[19]){
				maiores[19] = soma;
				nomes[19] = vertices[i].info;
				int x = 18;
				int y = 19;
				while(x >= 0 && maiores[y] > maiores[x]){
					int z = maiores[x];
					String nomeAnterior = nomes[x];
					nomes[x] = nomes[y];
					nomes[y] = nomeAnterior;
					maiores[x] = maiores[y];
					maiores[y] = z;
					x--;
					y--;
				}	
			}
		}
		
		for(int i = 0; i < 20; i++){
			System.out.println(i+1+"°: "+nomes[i]+": "+maiores[i]);
		}
	}

	public void maiorEntrada(File file) throws Exception{
		int[] maiores = new int[20];
		String[] nomes = new String[20];

		for(int i = 0; i < 20; i++){
			maiores[i] = 0;
		}
        
        String linha;

        for(int i = 0; i < vertices.length; i++){
			int soma = 0;
			BufferedReader br2 = new BufferedReader(new FileReader(file));
			while ((linha = br2.readLine()) != null) {
				String[] splitlinha = linha.split(" ");
				String destinatario = splitlinha[1];
	
				if(destinatario.equals(vertices[i].info)){
					soma += Integer.parseInt(splitlinha[2]);
				}
			}

			if(soma > maiores[19]){
				maiores[19] = soma;
				nomes[19] = vertices[i].info;
				int x = 18;
				int y = 19;
				while(x >= 0 && maiores[y] > maiores[x]){
					int z = maiores[x];
					String nomeAnterior = nomes[x];
					nomes[x] = nomes[y];
					nomes[y] = nomeAnterior;
					maiores[x] = maiores[y];
					maiores[y] = z;
					x--;
					y--;
				}	
			}
			br2.close();
		}

		for(int i = 0; i < 20; i++){
			System.out.println(i+1+"°: "+nomes[i]+": "+maiores[i]);
		}
	}

	public int[] adjacentes(int i) {
        int[] adj = new int[tamanho];

        for(int x = 0; x < tamanho; x++){
            adj[x] = -1;
        }
        ListaAdj l = grafo[i];
		int x = 0;
		while(l != null){
			adj[x] = l.destino;
			l = l.proximo;
			x++;
		}
        return adj;
    }

	public void Dijkstra(String origem, String destino){
		int x = 0;
		int y = 0;
		boolean passouOrigem = false;
		boolean passouDestino = false;

		for(int i = 0; i < vertices.length; i++){
			if(passouDestino && passouOrigem){
				break;
			}
			if(vertices[i].info.equals(origem)){
				x = i;
				passouOrigem = true;
			}if(vertices[i].info.equals(destino)){
				y = i;
				passouDestino = true;
			}
		}

        ArrayList<Integer> caminho = new ArrayList<Integer>();

        double[] distancia = new double[tamanho];
        int[] pai = new int[tamanho];
        boolean[] aberto = new boolean[tamanho];

        for(int i = 0; i < tamanho; i++){
            if(i == x){
                distancia[i] = 0;
                pai[i] = -1;
                aberto[i] = true;
            }else{
                distancia[i] = Integer.MAX_VALUE;
                pai[i] = -1;
                aberto[i] = true;
            }
        }

        while(true){
            double menorDist = Integer.MAX_VALUE;
            int menorIndex = -1;
            for(int i = 0; i < tamanho; i++){
                if(aberto[i] && distancia[i] < menorDist){
                    menorDist = distancia[i];
                    menorIndex = i;
                }
            }

            if(menorIndex == -1){
                break;
            }

            aberto[menorIndex] = false;
            int[] adj = new int[tamanho];
            adj = adjacentes(menorIndex);

            for(int i : adj){
                if(i != -1 && distancia[menorIndex] + 1/peso(menorIndex, i) < distancia[i]){
                    distancia[i] = distancia[menorIndex] + 1/peso(menorIndex, i);
                    pai[i] = menorIndex;
                }else if(i == -1){
					break;
				}
            }
			if(menorIndex == y){
				break;
			}
        }

        int p = y;
        while(p!=-1){
            caminho.add(p);
            p = pai[p];
        }
		Collections.reverse(caminho);
        System.out.println("menor distancia entre "+origem+" e "+destino+" é: "+distancia[y]);
        System.out.println("Caminho entre  "+origem+" e "+destino+" é:");
		for(int i = 0; i < caminho.size(); i++){
			System.out.println(vertices[caminho.get(i)].info);
		}
    }

	public void buscaProfundidade(int atual, int destino, ArrayList<Integer> caminho){
		if(!caminho.contains(atual)){
			caminho.add(atual);
		}

		if(atual == destino){
			System.out.println("Caminho: ");
			for(int i = 0; i < caminho.size(); i++){
				System.out.println(vertices[caminho.get(i)].info+" ");
			}
		}

		int[] adj = adjacentes(atual);
		for(int i : adj){
			if(!caminho.contains(i)){
				if(i == -1){
					break;
				}
				buscaProfundidade(i, destino, caminho);
				if(caminho.contains(destino)){
					break;
				}
			}
		}
	}

	public void buscarLargura(int atual, int destino, ArrayList<Integer> caminho){
		ArrayList<Integer> listaSaltos = new ArrayList<>();

		for(int i = 0; i < tamanho; i++){
			ArrayList<Integer> visitados = new ArrayList<>();
			saltos(atual, i, listaSaltos, visitados);
			if(listaSaltos.contains(destino)){
				break;
			}
		}
		System.out.println(vertices[atual].info);
		for(int i : listaSaltos){
			System.out.println(vertices[i].info);
			if(i == destino){
				break;
			}
		}
	}

	public void saltos(int origem, int pulos, ArrayList<Integer> listaSaltos, ArrayList<Integer> visitados){
		int[] adj = adjacentes(origem);
		
		if(!visitados.contains(origem)){
			visitados.add(origem);
		}

		if(pulos == 1){
			for(int i : adj){
				if(i == -1){
					break;
				}else if(!listaSaltos.contains(i) && !visitados.contains(i)){
					listaSaltos.add(i);
				}
			}
		}
		if(pulos > 1){
			for(int i : adj){
				if(i == -1){
					break;
				}
				if(!visitados.contains(i)){
					saltos(i, pulos-1, listaSaltos,visitados);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		Grafo g = new Grafo(0);
		File file = new File("dadosFinal.txt");
		g = g.criaGrafo(file);

		//O n. de vértices do grafo:
		//System.out.println("Vertices: "+g.numeroVertices());

	    //O n. de arestas do grafo:
		 //System.out.println("Arestas: "+g.numeroArestas());

		//Os 20 indivíduos que possuem maior grau de saída e o valor correspondente:
		//g.maiorGrauSaida();

		//Os 20 indivíduos que possuem maior grau de entrada e o valor correspondente:
		//g.maiorEntrada(file);

		//"susan.scott@enron.com" = 519
		//"tana.jones@enron.com" = 820

		//Profundidade:
		// ArrayList<Integer> caminho = new ArrayList<>();
		// g.buscaProfundidade(519, 820, caminho);

		//Largura:
		// ArrayList<Integer> caminho = new ArrayList<>();
		// g.buscarLargura(519, 820, caminho);

		//Saltos:
		// ArrayList<Integer> visitados = new ArrayList<>();
		// ArrayList<Integer> listaSaltos = new ArrayList<>();
		// g.saltos(519, 5, listaSaltos, visitados);
		// for(int i: listaSaltos){
		// 	System.out.println(g.vertices[i].info);
		// }
		// System.out.println(listaSaltos.size());

		//Dijkstra:
		//g.Dijkstra("susan.scott@enron.com", "tana.jones@enron.com");
	}
}