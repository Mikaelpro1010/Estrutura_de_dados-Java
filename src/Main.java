import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            // Lista de palavras-chave
            Set<String> palavrasChave = new HashSet<>();
            palavrasChave.add("programming");
            palavrasChave.add("programs");
            palavrasChave.add("easy");
            palavrasChave.add("by");
            palavrasChave.add("human-engineered");
            palavrasChave.add("and");
            palavrasChave.add("be");
            palavrasChave.add("to");

            // Instancia a classe LeituraArquivoTXT
            LeituraArquivoTXT leitor = new LeituraArquivoTXT("");
            // Cria o índice remissivo
            HashMap<String, Palavras> indice = leitor.criarIndiceRemissivo("src/texto.txt", palavrasChave);
            // Imprime o índice remissivo
            leitor.imprimirIndiceRemissivo(indice);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}