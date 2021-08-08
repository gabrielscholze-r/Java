import java.util.ArrayList;
import java.util.Scanner;
import java.lang.NullPointerException;


public class Usuário {
	private String nome;
	private ArrayList<Contato> contato;
	public Usuário(String nome) {
		this.nome = nome;
		contato = new ArrayList<Contato>();
		
	}
	public void inserirContato(String nomeContato) {
		contato.add(new Contato(nomeContato));
	}
	public void enviarMensagem(String Nome, String Mensagem) {
		Contato ccontato= encontraContato(nome);
		if(contato != null){
            Mensagem msg = new Mensagem(this.nome + ": " + Mensagem);
            ccontato.getMensagens().add(msg);
            System.out.println("Mensagem enviada a " + nome);
		}
		else{
            System.out.println("Contato nao existe");
        }
		
		
    }
	public void receberMensagem(String nomeContato, String Mensagem) {
		Contato ccontato= encontraContato(nome);
		if(contato != null){
            Mensagem msg = new Mensagem(this.nome + ": " + Mensagem);
            ccontato.getMensagens().add(msg);
		}
		else{
            System.out.println("Contato nao existe");
        }
		
	}
	
	public void imprimirMensagens(String nomeContato) {
		Contato contato = encontraContato(nome);
        contato.imprimirMensagens();
	}
	public Contato encontraContato(String nomeContato) {
		for (Contato contato : this.contato) {
            if (contato.getNome().equals(nomeContato)) {
                return contato;
            }
        }
        return null;
			
	}
	public static void main(String[] args) {
		boolean running = true;
		while (running) {
			Scanner n = new Scanner(System.in);
			System.out.println("1) Adicionar contato; 2) Enviar msg para contato; 3) Receber msg de\r\n" + 
					"contato; 4) Imprimir conversas; 5) Fim.");
			Usuário user = new Usuário("");
			int num = n.nextInt();
			switch (num) {
				case 1:
					System.out.println("Insira o nome do Contato.");
					Scanner n2 = new Scanner(System.in);
					String nome = n2.nextLine();
					user.inserirContato(nome);
					System.out.println("Contato Inserido");
					break;
				case 2:
					Scanner n3 = new Scanner(System.in);
					System.out.println("Selecione o contato");
					String NomeContato = n3.nextLine();
					if ( user.encontraContato(NomeContato) != (null)) {
						Scanner n4 = new Scanner(System.in);
						System.out.println("Insira a mensagem");
						String Mensagem = n4.nextLine();
						user.enviarMensagem(NomeContato, Mensagem);
						break;
					}
					else {
						
						System.out.println("Contato Inexistente");	
						break;
					}
				case 3:
					Scanner n5 = new Scanner(System.in);
					System.out.println("Selecione o contato");
					String nomeContato = n5.nextLine();
					if ( user.encontraContato(nomeContato) == null) {
						System.out.println("Contato Inexistente");	
						break;
					}
					else {
						Scanner n6 = new Scanner(System.in);
						System.out.println("Insira a mensagem");
						String Mensagem = n6.nextLine();
						user.receberMensagem(nomeContato, Mensagem);
						break;
					}
				case 4:
					Scanner n7 = new Scanner(System.in);
					System.out.println("Selecione o contato");
					String Nomecontato = n7.nextLine();				
					if ( user.encontraContato(Nomecontato) == null) {
						System.out.println("Contato Inexistente");	
						break;
					}
					else {
						user.imprimirMensagens(Nomecontato);
						break;
					
					}
				case 5:
					running = false;
				
			
			}
			
		}
		
	}
	
}
