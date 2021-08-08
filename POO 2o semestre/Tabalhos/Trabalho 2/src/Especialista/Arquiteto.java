package Especialista;

class Arquiteto {
	private static String nome = "Oscar Niemeyer";
	private static int idade = 104;
	private static void exibir_dados_pessoais()
	{
		System.out.println( nome );
		System.out.println( idade + " anos");
	}
	public static void main(String[] args)
	{
		exibir_dados_pessoais();
		System.out.println( "Area do circulo de raio 5 = " + Matematica.Circulo.area( 5 ) );
		System.out.println( "Perimetro do circulo de raio 5 = " + Matematica.Circulo.perimetro( 5 ) );
		System.out.println( "Com raio = 10:");
		Matematica.Circulo.defina_raio( 10 );
		System.out.println( "area = " + Matematica.Circulo.area() );
		System.out.println( "perimetro = "+ Matematica.Circulo.perimetro());
	}	
}

