package sistemaLogistica;

import sistemaLogistica.estoque.Estoque;
import sistemaLogistica.estoque.ProcessadorPedido;
import sistemaLogistica.estoque.ResultadoProcessamento;
import sistemaLogistica.frete.FreteExpresso;
import sistemaLogistica.frete.FreteNormal;
import sistemaLogistica.pedido.CatalogoProdutos;
import sistemaLogistica.pedido.Pedido;
import sistemaLogistica.pedido.Produto;

public class Main {

	public static void main(String[] args) {
		// Produtos e Catálogo
		CatalogoProdutos catalogo = new CatalogoProdutos();

		catalogo.adicionarProduto(new Produto(1, "Notebook", 2.0, 4500.0, "Eletrônicos"));
		catalogo.adicionarProduto(new Produto(2, "Mouse", 0.2, 80.0, "Eletrônicos"));
		catalogo.adicionarProduto(new Produto(3, "Geladeira", 50.0, 3200.0, "Eletrodomésticos"));
		catalogo.adicionarProduto(new Produto(4, "Monitor", 4.0, 1200.0, "Eletrônicos"));

		System.out.println("Produto ID 2: " + catalogo.buscarPorId(2));

		System.out.println("\nProdutos da categoria Eletrônicos:");
		catalogo.listarPorCategoria("Eletrônicos").forEach(System.out::println);

		System.out.println("\nProduto mais caro:");
		System.out.println(catalogo.produtoMaisCaro());
		System.out.println();
		
		// Controle de Estoque
		Produto notebook = catalogo.buscarPorId(1);

		Estoque estoque = new Estoque();

		estoque.registrarEntrada(notebook, 10);
		estoque.registrarEntrada(notebook, 5);

		estoque.registrarSaida(notebook, 3);

		System.out.println("Quantidade disponível: " + estoque.consultarQuantidade(notebook));

		System.out.println("\nHistórico:");

		estoque.consultarHistorico(notebook).forEach(System.out::println);
		System.out.println();

		// Estrutura de pedidos e Frete
		Produto geladeira = catalogo.buscarPorId(3);

		Produto monitor = catalogo.buscarPorId(4);

		Pedido pedido = new Pedido(11);

		pedido.adicionarItem(geladeira, 2);
		pedido.adicionarItem(monitor, 1);
		
		System.out.println(pedido.getItens());

		double freteNormal = pedido.calcularFrete(new FreteNormal());

		double freteExpresso = pedido.calcularFrete(new FreteExpresso());

		System.out.println("Peso total: " + pedido.calcularPesoTotal() + " kg");

		System.out.println("Frete normal: R$ " + freteNormal);

		System.out.println("Frete expresso: R$ " + freteExpresso);
		System.out.println();

		// Entrada
		Produto monitor1 = catalogo.buscarPorId(4);

		Produto mouse = catalogo.buscarPorId(2);

		Estoque estoque1 = new Estoque();

		estoque1.registrarEntrada(monitor1, 5);
		estoque1.registrarEntrada(mouse, 10);

		Pedido pedido1 = new Pedido(12);

		pedido1.adicionarItem(monitor1, 3);
		pedido1.adicionarItem(mouse, 15);

		ProcessadorPedido processador = new ProcessadorPedido();

		ResultadoProcessamento resultado = processador.processar(pedido1, estoque1);

		if (resultado.isSucesso()) {

			System.out.println("Pedido processado com sucesso.");

		} else {

			System.out.println("Pedido não pode ser processado.");

			resultado.getFaltas().forEach(System.out::println);
		}
	}
}