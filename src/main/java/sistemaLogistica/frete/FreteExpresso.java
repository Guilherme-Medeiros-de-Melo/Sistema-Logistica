package sistemaLogistica.frete;

public class FreteExpresso implements CalculadoraFrete {

	@Override
	public double calcularFrete(double pesoTotal, double valorPedido) {

		return 50.0 + (pesoTotal * 2.0);
	}
}