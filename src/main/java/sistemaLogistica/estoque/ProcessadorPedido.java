package sistemaLogistica.estoque;

import java.util.ArrayList;
import java.util.List;

import sistemaLogistica.pedido.Pedido;
import sistemaLogistica.pedido.ItemPedido;

public class ProcessadorPedido {

	public ResultadoProcessamento processar(Pedido pedido, Estoque estoque) {

		List<FaltaEstoque> faltas = new ArrayList<>();

		for (ItemPedido item : pedido.getItens()) {

			int disponivel = estoque.consultarQuantidade(item.getProduto());

			if (disponivel < item.getQuantidade()) {

				faltas.add(new FaltaEstoque(item.getProduto(), item.getQuantidade(), disponivel));
			}
		}

		if (!faltas.isEmpty()) {
			return new ResultadoProcessamento(false, faltas);
		}

		for (ItemPedido item : pedido.getItens()) {

			estoque.registrarSaida(item.getProduto(), item.getQuantidade());
		}

		pedido.marcarComoProcessado();

		return new ResultadoProcessamento(true, List.of());
	}
}