package util;

public class ICMS {
    public static double calcularICMS(double preco, double aliquota) {
        return preco * (aliquota / 100.0);
    }
}
