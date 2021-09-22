import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Calcular {
    public static ArrayList<String> nomes;

    public static ArrayList<String> getNumeroemails(File file) throws IOException {
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        String linha;

        nomes = new ArrayList<>();

        while ((linha = br2.readLine()) != null) {
            String[] splitlinha = linha.split(" ");
            String remetente = splitlinha[0];
            String destinatario = splitlinha[1];

            if(!nomes.contains(remetente)){
                nomes.add(remetente);
            }

            if(!nomes.contains(destinatario)){
                nomes.add(destinatario);
            }
        }
        br2.close();
        return nomes;
    }
}