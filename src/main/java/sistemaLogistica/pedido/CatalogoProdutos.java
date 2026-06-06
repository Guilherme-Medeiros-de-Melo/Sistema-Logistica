package sistemaLogistica.pedido;

import java.util.*;
import java.util.stream.Collectors;

public class CatalogoProdutos {

	private final Map<Integer, Produto> produtos = new HashMap<>();

	public void adicionarProduto(Produto produto) {

		if (produtos.containsKey(produto.getId())) {
			throw new IllegalArgumentException("Já existe um produto com id " + produto.getId());
		}

		produtos.put(produto.getId(), produto);
	}

	public Produto buscarPorId(int id) {
		return produtos.get(id);
	}

	public List<Produto> listarPorCategoria(String categoria) {

		return produtos.values().stream().filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
				.collect(Collectors.toList());
	}

	public Produto produtoMaisCaro() {

		return produtos.values().stream().max(Comparator.comparingDouble(Produto::getPreco)).orElse(null);
	}
}