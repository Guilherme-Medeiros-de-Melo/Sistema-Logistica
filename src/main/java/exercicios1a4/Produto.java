package exercicios1a4;
import java.util.*;
import java.util.stream.Collectors;

class Produto {
    private String nome;
    private String categoria;

    public Produto(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public static Map<String, Integer> agruparPorCategoria(List<Produto> produtos) {

        Map<String, Integer> contagem = new HashMap<>();

        // Percorre a lista e contabiliza os produtos
        for (Produto produto : produtos) {
            contagem.merge(produto.getCategoria(), 1, Integer::sum);
        }

        // Ordena por quantidade decrescente
        return contagem.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

}