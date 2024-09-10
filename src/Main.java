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
            HashMap<String, Palavras> indice = leitor.criarIndiceRemissivo("src/texto.txt", palavrasChave);


            System.out.println("=>Índice Remissivo baseado no (Texto 1)");
            // Imprime o índice remissivo
            leitor.imprimirIndiceRemissivo(indice);
            System.out.println("_________________________");
            System.out.println("(Texto 1): ");
            System.out.println(
                    "\"Aqueles que semeiam com lágrimas,\n" +
                    "com cantos de alegria colherão. Aqueles que saem chorando\n" +
                    "enquanto lançam a semente,\n" +
                    "voltarão com cantos de alegria,\n" +
                    "trazendo os seus feixes.\n" +
                    "Essa mensagem é para você que pensa em desistir,\n" +
                    "calma, continue lançando a semente!\"");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}