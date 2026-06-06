package sistemaLogistica.estoque;

import java.util.List;

public class ResultadoProcessamento {

	private final boolean sucesso;
	private final List<FaltaEstoque> faltas;

	public ResultadoProcessamento(boolean sucesso, List<FaltaEstoque> faltas) {

		this.sucesso = sucesso;
		this.faltas = faltas;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public List<FaltaEstoque> getFaltas() {
		return faltas;
	}
}