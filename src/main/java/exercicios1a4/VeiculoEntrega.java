package exercicios1a4;
import java.util.ArrayList;
import java.util.List;

abstract class VeiculoEntrega {

    protected double velocidadeMedia;

    public VeiculoEntrega(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public abstract double calcularTempoEntrega(double distanciaKm);
}

class Caminhao extends VeiculoEntrega {

    public Caminhao() {
        super(60);
    }

    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        return distanciaKm / velocidadeMedia;
    }
}

class Moto extends VeiculoEntrega {

    public Moto() {
        super(80);
    }

    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        return distanciaKm / velocidadeMedia;
    }
}