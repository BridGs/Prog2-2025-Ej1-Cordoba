
import Logica.LogicaCuenta;

import java.util.Random;

public class Main {
    public static void main(String[] args){

        Random random = new Random();

        LogicaCuenta logicaCuenta = LogicaCuenta.getInstancia();

        for(int i = 0; i <= 10; i++){
            if(!(random.nextBoolean())){
                logicaCuenta.CrearCuentaCorriente();
            }else{
                logicaCuenta.CrearCajaAhorro();
            }
        }

        Thread[] thread = new Thread[10];

        for (int j = 0; j <= 10000; j++){
            if(!(random.nextBoolean())){
                logicaCuenta.
            }else{

            }
        }

    }
}
