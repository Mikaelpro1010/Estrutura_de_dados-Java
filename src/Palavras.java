import java.util.LinkedList;

public class Palavras {
    private String palavra;
    private LinkedList<Integer> linhas;

    public Palavras(String palavra) {
        this.palavra = palavra;
        this.linhas = new LinkedList<>();
    }

    public String getPalavra() {
        return palavra;
    }

    public LinkedList<Integer> getLinhas() {
        return linhas;
    }

    public void adicionarLinha(int linha) {
        this.linhas.add(linha);
    }

    @Override
    public String toString() {
        return "Palavra: '" + palavra + "', Linhas: " + linhas;
    }
}
