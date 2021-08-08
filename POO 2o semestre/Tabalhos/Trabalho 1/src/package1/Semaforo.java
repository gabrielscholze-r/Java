package package1;

public class Semaforo {
	public int cor = 2;
	public void MudaProximaCor() {
		if (cor == 2)
			this.cor = 0;
		else if (cor == 1)
			this.cor = 2;
		else if (cor == 0)
			this.cor = 1;
	}
	public void MudaCorFixa(int corFixa) {
		cor = corFixa;
		
	}
	public int MostraCor() {
		return cor;
	}
		
			
	
	
	
	
}
