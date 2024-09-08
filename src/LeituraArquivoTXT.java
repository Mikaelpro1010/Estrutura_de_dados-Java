import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LeituraArquivoTXT extends Palavras {

    // Construtor para herdar a palavra da classe Palavras
    public LeituraArquivoTXT(String palavra) {
        super(palavra);
    }

    // Método para criar o índice remissivo
    public HashMap<String, Palavras> criarIndiceRemissivo(String caminho, Set<String> palavrasChave) throws FileNotFoundException {
        // Criando a estrutura Hash Table para armazenar as palavras-chave e suas linhas
        HashMap<String, Palavras> indiceRemissivo = new HashMap<>();

        File file = new File(caminho);
        Scanner leitura = new Scanner(file);

        int numeroLinha = -1; // Contador de linhas começando em -1

        try {
            while (leitura.hasNextLine()) {
                numeroLinha++; // Incrementa o número da linha, começando em 0 na primeira linha
                String linha = leitura.nextLine();
                // Tratamento da linha para incluir palavras com hífen como "human-engineered"
                String[] palavras = linha.split("[\\s,;:.!?()\\[\\]\"']+"); // Divide a linha em palavras com mais separadores

                for (String palavra : palavras) {
                    palavra = palavra.toLowerCase(); // Converte para minúscula para busca case-insensitive

                    if (palavrasChave.contains(palavra)) {
                        // Verifica se a palavra-chave já está no índice remissivo
                        Palavras palavraObj;
                        if (!indiceRemissivo.containsKey(palavra)) {
                            palavraObj = new Palavras(palavra);
                            indiceRemissivo.put(palavra, palavraObj);
                        } else {
                            palavraObj = indiceRemissivo.get(palavra);
                        }

                        // Adiciona o número da linha à lista encadeada correspondente à palavra-chave
                        palavraObj.adicionarLinha(numeroLinha);
                    }
                }
            }
        } finally {
            leitura.close(); // Fecha o scanner
        }

        return indiceRemissivo;
    }

    // Método para imprimir o índice remissivo em ordem alfabética
    public void imprimirIndiceRemissivo(HashMap<String, Palavras> indiceRemissivo) {
        // Obter as chaves (palavras) e ordená-las
        List<String> palavrasOrdenadas = new ArrayList<>(indiceRemissivo.keySet());
        Collections.sort(palavrasOrdenadas);

        // Iterar sobre as palavras ordenadas e imprimir o índice remissivo
        for (String palavra : palavrasOrdenadas) {
            System.out.println(indiceRemissivo.get(palavra));
        }
    }
}
