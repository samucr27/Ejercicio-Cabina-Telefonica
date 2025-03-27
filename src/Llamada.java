public class Llamada {
    public enum Tipo {LOCAL, LARGA_DISTANCIA, CELULAR} //enum es un tipo de dato especial que permite definir un conjunto de constantes relacionadas

    private Tipo tipo;
    private int duracion;
    private double precio;

    public Llamada(Tipo tipo) {
        this.tipo = tipo;
        this.duracion = (int) (Math.random() * 10) + 1;
        this.precio = calcularCosto();
    }

    private double calcularCosto() {
        switch (tipo) {
            case LOCAL:
                return duracion * 50;
            case LARGA_DISTANCIA:
                return duracion * 350;
            case CELULAR:
                return duracion * 150;
            default:
                return 0;
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "tipo=" + tipo +
                ", duracion=" + duracion +
                ", precio=" + precio +
                '}';
    }
}