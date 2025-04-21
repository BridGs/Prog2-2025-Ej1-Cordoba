package DTO;

public class DTOCajaAhorro {
    private double saldo;
    private int cantOperaciones;

    private DTOCajaAhorro(Builder builder){
        this.saldo = builder.saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public int GetOperaciones(){
        return cantOperaciones;
    }

    private static class Builder{
        private double saldo;
        private int cantOperaciones;

        public Builder conSaldo(double saldo){
            this.saldo =saldo;
            return this;
        }
        public Builder conCantOperaciones(int cantOperaciones){
            this.cantOperaciones = cantOperaciones;
            return this;
        }
        public DTOCajaAhorro build(){
            return new DTOCajaAhorro(this);
        }
    }
}
