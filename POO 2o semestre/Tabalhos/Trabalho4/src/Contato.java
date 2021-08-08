import java.util.ArrayList;


public class Contato {

    private String nome;
    private ArrayList<Mensagem> mensagens;


    public Contato(String nome) {
        this.nome = nome;
        mensagens = new ArrayList<Mensagem>();
    }


    public ArrayList<Mensagem> getMensagens(){

        return mensagens;

    }

    public void imprimirMensagens(){

        for (Mensagem mensagem : mensagens) {
            System.out.println("Mensagens do contato: " + mensagem.getTexto() );
        }
 
    }
    public String getNome()
    {
    	return this.nome;
    }
    
}