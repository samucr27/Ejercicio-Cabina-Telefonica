import java.util.ArrayList;
import java.util.List;

public class CabinaTelefonica {
    private int id;
    private List<Llamada> llamadas;

    public CabinaTelefonica(int id) {
        this.id = id;
        this.llamadas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CabinaTelefonica{" +
                "id=" + id +
                ", llamadas=" + llamadas +
                '}';
    }

    public void registrarLlamada(Llamada.Tipo tipo) {
        Llamada llamada = new Llamada(tipo);
        llamadas.add(llamada);
        System.out.println("Llamada registrada: " + llamada);
    }
    public void mostrarInfo(){
        int totalLlamadas = llamadas.size();
        int totalMinutos = 0;
        int totalCosto = 0;

        for (Llamada l : llamadas) {
            totalMinutos += l.getDuracion();
            totalCosto += l.getPrecio();
        }

        System.out.println("Cabina #" + id);
        System.out.println("Total de llamadas: " + totalLlamadas);
        System.out.println("Duración total: " + totalMinutos + " min");
        System.out.println("Costo total: $" + totalCosto);
    }

    public void reiniciar(){
        llamadas.clear();
        System.out.println("Cabina #" + id + " reiniciada");
    }
}