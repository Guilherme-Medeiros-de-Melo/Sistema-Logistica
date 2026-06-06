package exercicios1a4;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		//Manipulação de Collections
	    List<Integer> numeros = List.of(3, 7, 2, 9, 4, 7, 3, 5, 8, 3, 1, 0, 5, 6, 8, 7);
	
	    List<Integer> resultadoNumeros = ManipulaCollection.filtrarOrdenar(numeros);
	
	    System.out.println(resultadoNumeros + "\n");
	    
	    //Agrupamento de produtos por categoria
	    List<Produto> produtos = List.of(
                new Produto("Notebook", "Eletrônicos"),
                new Produto("Mouse", "Eletrônicos"),
                new Produto("Teclado", "Eletrônicos"),
                new Produto("Camiseta", "Vestuário"),
                new Produto("Calça", "Vestuário"),
                new Produto("Arroz", "Alimentos"),
                new Produto("Feijão", "Alimentos"),
                new Produto("Macarrão", "Alimentos"),
                new Produto("Detergente", "Limpeza"),
                new Produto("Sabão em Pó", "Limpeza"),
                new Produto("Esponja", "Limpeza"),
                new Produto("Geladeira", "Eletrodomésticos"),
                new Produto("Microondas", "Eletrodomésticos"),
                new Produto("Monitor", "Eletrônicos"),
                new Produto("WebCam", "Eletrônicos"),
                new Produto("Cadeira", "Móveis"),
                new Produto("Mesa", "Móveis")
        );
	    
        Map<String, Integer> resultadoProduto = Produto.agruparPorCategoria(produtos);

        resultadoProduto.forEach((categoria, quantidade) ->
                System.out.println(categoria + " -> " + quantidade));
        
        System.out.println();

        //Cálculo de Tempo de Entrega
        int distancia = 120;

        List<VeiculoEntrega> veiculos = new ArrayList<>();
        veiculos.add(new Caminhao());
        veiculos.add(new Moto());

        for (VeiculoEntrega veiculo : veiculos) {

            double tempo = veiculo.calcularTempoEntrega(distancia);

            System.out.printf(
                "%s - tempo estimado: %.2f horas%n",
                veiculo.getClass().getSimpleName(),
                tempo
            );
        }
        
        System.out.println();
        
        //Tratamento de Exceções
        DivisaoExcecao.executarDivisão("10", "2");

        DivisaoExcecao.executarDivisão("abc", "5");

        DivisaoExcecao.executarDivisão("10", "0");
        
        System.out.println();
        
        
	}
}