
import Logica.LogicaCuenta;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){

        Random random = new Random();

        //Creacion de cuentas
        LogicaCuenta logicaCuenta = LogicaCuenta.getInstancia();

        for(int i = 0; i < 10; i++){
            if(!(random.nextBoolean())){
                logicaCuenta.CrearCuentaCorriente(random.nextDouble());
            }else{
                logicaCuenta.CrearCajaAhorro(random.nextDouble());
            }
        }
        //Iteracion concurrente que modifica el saldo de las cuentas creadas anteriormente
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int j = 0; j <= 10000; j++){
            int cuenta = random.nextInt(0,10);
            double saldo = random.nextDouble();
            executor.submit(() -> {
                if (!(random.nextBoolean())) {
                    logicaCuenta.AgregarSaldo(cuenta, saldo);
                } else {
                    logicaCuenta.QuitarSaldo(cuenta, saldo);
                }
            });
        }
        executor.shutdown();
        //impresion de saldo y cant. movimientos de las cuentas
        for (int i = 0; i < 10; i++){
            double saldo = logicaCuenta.ConsultarSaldo(i);
            int mov = logicaCuenta.ConsultarMovimientos(i);
            System.out.printf("Cuenta num. %d, tiene %.2f saldo, con %d movimientos realizados.%n",i,saldo,mov);
        }

    }
}
