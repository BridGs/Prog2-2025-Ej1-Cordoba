package Entidades;

import DTO.IGestionSaldo;

public class CuentaCorriente extends Cuenta implements IGestionSaldo {

    private double giroDescubierto = -2000;
    private int cantOperaciones;

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        this.saldo += monto;
        cantOperaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if ((this.saldo - monto) <= giroDescubierto ){
            this.saldo -= monto;
            cantOperaciones++;
            return true;
        }else {
            return false;
        }
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
