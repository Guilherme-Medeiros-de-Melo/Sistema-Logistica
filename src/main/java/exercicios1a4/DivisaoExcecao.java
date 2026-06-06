package exercicios1a4;
public class DivisaoExcecao {
    public static double processarDivisao(String valor1, String valor2) {

        try {
            int numero1 = Integer.parseInt(valor1);
            int numero2 = Integer.parseInt(valor2);

            if (numero2 == 0) {
                throw new ArithmeticException("divisão por zero não é permitida.");
            }

            return (double) numero1 / numero2;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "valor inválido informado.");
        }
    }

    public static void executarDivisão(String valor1, String valor2) {

        try {
            double resultado = processarDivisao(valor1, valor2);
            System.out.println("Resultado: " + resultado);

        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());

        }
    }
}