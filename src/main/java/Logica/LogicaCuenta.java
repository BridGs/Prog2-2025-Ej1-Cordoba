package Logica;

import Entidades.CajaAhorro;
import Entidades.Cuenta;
import Entidades.CuentaCorriente;

import javax.tools.DocumentationTool;
import java.util.ArrayList;
import java.util.List;

public final class LogicaCuenta {
    private static LogicaCuenta instancia;
    private List<Cuenta> listaCuentas;

    private LogicaCuenta(){
         this.listaCuentas = new ArrayList<>();
    }

    public synchronized static LogicaCuenta getInstancia(){
        if(instancia == null){
            instancia = new LogicaCuenta();
        }
        return instancia;
    }

    public synchronized boolean AgregarSaldo(int numCuenta, double monto){
        boolean temp = false;
        Cuenta cuenta = listaCuentas.get(numCuenta);
            if(cuenta instanceof CuentaCorriente){
                temp = ((CuentaCorriente) cuenta).agregarSaldo(monto);
            }else {
                temp = ((CajaAhorro) cuenta).agregarSaldo(monto);
            }

        return temp;
    }

    public synchronized boolean QuitarSaldo(int numCuenta, double monto){
        boolean temp = false;
        Cuenta cuenta = listaCuentas.get(numCuenta);
            if(cuenta instanceof CuentaCorriente){
                 temp = ((CuentaCorriente) cuenta).quitarSaldo(monto);
            }else {
                 temp =  ((CajaAhorro) cuenta).quitarSaldo(monto);
            }

        return temp;
    }

    public double ConsultarSaldo(int numCuenta){
        double temp = 0.0;
        Cuenta cuenta = listaCuentas.get(numCuenta);
            if(cuenta instanceof CuentaCorriente){
                temp = ((CuentaCorriente) cuenta).getSaldo();
            }else {
                temp = ((CajaAhorro) cuenta).getSaldo();
            }

        return temp;
    }

    public int ConsultarMovimientos(int numCuenta){
        int temp = 0;
        Cuenta cuenta = listaCuentas.get(numCuenta);
            if(cuenta instanceof CuentaCorriente){
                temp = ((CuentaCorriente) cuenta).getOperaciones();
            }else {
                temp = ((CajaAhorro) cuenta).getOperaciones();
            }
        return temp;
    }

    public void CrearCuentaCorriente(){
        CuentaCorriente cuenta = new CuentaCorriente();
        listaCuentas.add(cuenta);
    }
    public void CrearCajaAhorro(){
        CajaAhorro cuenta = new CajaAhorro();
        listaCuentas.add(cuenta);
    }
}
