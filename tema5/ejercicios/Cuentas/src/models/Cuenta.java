package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import tools.Bordes;

public class Cuenta {
    private int numeroCuenta;
    private double saldo;
    private Cliente titular;
    private ArrayList<Movimiento> movimientos;

    //////////////////////////////////////////////////////
    // CONSTRUCTORES
    //////////////////////////////////////////////////////

    public Cuenta(int numeroCuenta, double saldo, Cliente titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.movimientos = new ArrayList<Movimiento>();
    }

    //////////////////////////////////////////////////////
    // GETTERS & SETTERS
    //////////////////////////////////////////////////////

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    //////////////////////////////////////////////////////
    // MÉTODOS
    //////////////////////////////////////////////////////

    public void ingresar(double cantidad) {
        // el ingreso debe ser positivo
        if (cantidad < 0) {
            System.out.println("ERROR: No se puede ingresar una cantidad negativa");
            return;
        }

        // se ingresa y se registra
        saldo += cantidad;
        movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.INGRESO));
        System.out.println("Se han ingresado correctamente " + cantidad + "€ en la cuenta " + numeroCuenta);
    }

    public void retirar(double cantidad) {
        // el retiro debe ser positivo
        if (cantidad < 0) {
            System.out.println("ERROR: No se puede retirar una cantidad negativa");
            return;
        }

        // si no hay suficiente saldo
        if (cantidad > saldo) {
            System.out.println("ERROR: No hay suficiente saldo");
            return;
        }

        // se retira y se registra
        saldo -= cantidad;
        movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.RETIRO));
        System.out.println("Se han retirado correctamente " + cantidad + "€ de la cuenta " + numeroCuenta);
    }

    private String obtenerMovimientos() {
        String s = "";
        for (Movimiento m : movimientos) {
            s += m.toString() + "\n";
        }
        return s;
    }

    public void verDatos() {
        String s = "";
        // char ostias = 'sks';
        s += "Nº cuenta: " + numeroCuenta + "\n";
        s += "Titular: " + titular.nombreCompleto() + ", domicilio en " + titular.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "------------------------  M O V I M I E N T O S  ------------------------\n";
        s += obtenerMovimientos();
        Bordes.mostrarTextoConBordes(s);
    }

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta
                + ", Titular=" + titular.nombreCompleto()
                + ", Saldo=" + saldo
                + "]";
    }

    //////////////////////////////////////////////////////
    // CLASE MOVIMIENTO
    //////////////////////////////////////////////////////
    private class Movimiento {
        private static final byte INGRESO = 0;
        private static final byte RETIRO = 1;

        private LocalDateTime fechaHora;
        private double importe;
        private double saldoFinal;
        private byte tipo;

        public Movimiento(LocalDateTime fechaHora, double importe, byte tipo) {
            this.fechaHora = fechaHora;
            this.importe = importe;
            this.saldoFinal = saldo;
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return (tipo == INGRESO ? "INGRESO" : " RETIRO")
                    + " [Fecha = " + fechaHora.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
                    + ", Hora = " + fechaHora.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
                    + ", Importe = " + importe + "€"
                    + ", Saldo = " + saldoFinal + "€"
                    + "]";
        }
    }
}
