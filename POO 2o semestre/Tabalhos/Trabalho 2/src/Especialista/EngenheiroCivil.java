package Especialista;

import java.lang.reflect.Method;

public class EngenheiroCivil {
	public void exibir_dados_pessoais() throws Exception{
	Arquiteto a = new Arquiteto();
	Method m = Arquiteto.class.getDeclaredMethod("exibir_dados_pessoais");
	m.setAccessible(true);
	m.invoke(a);

	}
	public static void main(String[] args) throws Exception {
		Especialista.EngenheiroCivil Eng = new Especialista.EngenheiroCivil();
		Eng.exibir_dados_pessoais();
		Matematica.Retangulo classe = new Matematica.Retangulo();
		classe.definir_lados(4.7f, 8.2f);
		System.out.println(classe.area());
		System.out.println(classe.perimetro());
	}
	
	
}
