package DTO;

public class DTOCuentaCorriente {
    private double saldo;
    private int cantOperaciones;
    private int giroDescubierto;

    private DTOCuentaCorriente(Builder builder){
        this.saldo = builder.saldo;

    }

    public double getSaldo() {
        return saldo;
    }
    public int GetOperaciones(){
        return cantOperaciones;
    }
    public int getGiroDescubierto(){
        return giroDescubierto;
    }

    public static class Builder{
        private double saldo;
        private int cantOperaciones;
        private int giroDescubierto;

        public Builder conSaldo(double saldo){
            this.saldo = saldo;
            return this;
        }
        public Builder conOperaciones(int cantOperaciones){
            this.cantOperaciones = cantOperaciones;
            return this;
        }
        public Builder conGiroDescubierto(int giroDescubierto){
            this.giroDescubierto = giroDescubierto;
            return this;
        }
        public DTOCuentaCorriente build(){
            return new DTOCuentaCorriente(this);
        }

    }

}
