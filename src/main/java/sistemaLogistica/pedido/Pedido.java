package sistemaLogistica.pedido;

import java.time.LocalDateTime;
import java.util.*;

import sistemaLogistica.frete.CalculadoraFrete;

public class Pedido {

	private final int id;
	private final LocalDateTime dataCriacao;
	private boolean processado;

	private final Map<Produto, ItemPedido> itens = new HashMap<>();

	public Pedido(int id) {
		this.id = id;
		this.dataCriacao = LocalDateTime.now();
	}

	public void adicionarItem(Produto produto, int quantidade) {

		if (quantidade <= 0) {
			throw new IllegalArgumentException("Quantidade inválida.");
		}

		ItemPedido item = itens.get(produto);

		if (item != null) {
			item.adicionarQuantidade(quantidade);
		} else {
			itens.put(produto, new ItemPedido(produto, quantidade, produto.getPreco()));
		}
	}

	public void removerItem(Produto produto) {
		itens.remove(produto);
	}

	public double calcularFrete(CalculadoraFrete calculadora) {

		return calculadora.calcularFrete(calcularPesoTotal(), calcularValorTotal());
	}

	public double calcularValorTotal() {

		return itens.values().stream().mapToDouble(ItemPedido::getValorTotal).sum();
	}

	public double calcularPesoTotal() {

		return itens.values().stream().mapToDouble(ItemPedido::getPesoTotal).sum();
	}

	public Collection<ItemPedido> getItens() {
		return itens.values();
	}

	public boolean isProcessado() {
		return processado;
	}

	public void marcarComoProcessado() {
		this.processado = true;
	}
}