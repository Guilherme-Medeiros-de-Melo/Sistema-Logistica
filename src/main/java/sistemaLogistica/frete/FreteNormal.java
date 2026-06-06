package sistemaLogistica.frete;

public class FreteNormal implements CalculadoraFrete {

	@Override
	public double calcularFrete(double pesoTotal, double valorPedido) {

		if (pesoTotal <= 10) {
			return 20.0;
		}

		if (pesoTotal <= 50) {
			return 40.0;
		}

		return 80.0;
	}
}