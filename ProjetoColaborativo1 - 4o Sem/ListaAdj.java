public class ListaAdj {
	public int destino;
	public double peso;
	public ListaAdj proximo;
	
	public ListaAdj(int destino, double peso) {
		this.destino = destino;
		this.peso = peso;
		this.proximo = null;
	}
}
