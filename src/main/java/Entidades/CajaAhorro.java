package Entidades;

import DTO.IGestionSaldo;

public class CajaAhorro extends Cuenta implements IGestionSaldo {
    private int cantOperaciones;

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        this.saldo += monto;
        cantOperaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        this.saldo -= monto;
        cantOperaciones++;
        return true;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public int getOperaciones() {
        return cantOperaciones;
    }
}
