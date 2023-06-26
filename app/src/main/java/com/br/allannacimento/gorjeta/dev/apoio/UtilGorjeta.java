package com.br.allannacimento.gorjeta.dev.apoio;

public class UtilGorjeta {

    public static double calcularGorjeta(double valor) {

        double gorjeta = valor * 0.10;

        return gorjeta;

    }

    public static double calcularTotal(double valor1, double valor2){

        double resultado = valor1 + valor2;

        return resultado;

    }

    public static String formatarResultado(double resultado) {
        return String.format("R$ %.2f", resultado);
    }

}
