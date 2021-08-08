package Matematica;

public class Retangulo {
	private float ladoH;
	private float ladoV;
	public void definir_lados(float h, float v) {
		this.ladoH = h;
		this.ladoV = v;
	}
	public float area() {
		return ladoH*ladoV;
	}
	public float perimetro(){
		return 2*ladoH + 2*ladoV;
	}
}
