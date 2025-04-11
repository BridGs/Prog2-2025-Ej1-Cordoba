package Builder;

public class ConstructorCuentaCorriente implements BuilderCuenta{

    private double saldo;
    @Override
    public void cantidadSaldo(double saldo) {
        this.saldo = saldo;
    }
}
