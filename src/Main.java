import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            // Instancia a classe LeituraArquivoTXT
            LeituraArquivoTXT leitor = new LeituraArquivoTXT("");

            // Lê as palavras-chave de um arquivo
            Set<String> palavrasChave = leitor.lerPalavrasChave("src/palavras-chave.txt");

            // Cria o índice remissivo
            HashMap<String, Palavras> indice = leitor.criarIndiceRemissivo("src/Texto1.txt", palavrasChave);


            System.out.println("=>Índice Remissivo baseado no (Texto 1)");
            // Imprime o índice remissivo
            leitor.imprimirIndiceRemissivo(indice);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}