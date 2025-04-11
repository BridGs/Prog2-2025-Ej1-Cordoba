package Builder;

public class ConstructorCajaAhorro implements BuilderCuenta{

    private double saldo;

    @Override
    public void cantidadSaldo(double saldo) {
        this.saldo = saldo;
    }
}
