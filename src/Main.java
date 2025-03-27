import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<CabinaTelefonica> cabinas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        int op;
        do {
            System.out.println("""
                    MENU
                    1. Agregar Cabina
                    2. Registrar llamada
                    3. Mostrar informacion de las cabinas
                    4. Reiniciar cabina
                    5. Salir
                    """);
        op = teclado.nextInt();

            switch (op){
                case 1 ->{
                    int id = cabinas.size() + 1;
                    cabinas.add(new CabinaTelefonica(id));
                    System.out.println("Cabina #"+id+" creada");
                }
                case 2 ->{
                    if (cabinas.isEmpty()){
                        System.out.println("No hay registradas");
                    }
                    System.out.println("Seleccione la cabina (1-"+ cabinas.size()+"): ");
                    int cabinaId = teclado.nextInt();
                    if (cabinaId < 1 || cabinaId > cabinas.size()){
                        System.out.println("Cabina invalida");
                    }
                    System.out.println("""
                            Seleccione el tipo de llamada
                            1. Local
                            2. Larga distancia
                            3. Celular
                            """);
                    int TipoOp = teclado.nextInt();
                    Llamada.Tipo tipo;

                    switch (TipoOp){
                        case 1 ->{
                            tipo = Llamada.Tipo.LOCAL;
                        }
                        case 2 ->{
                            tipo = Llamada.Tipo.LARGA_DISTANCIA;
                        }
                        case 3 ->{
                            tipo = Llamada.Tipo.CELULAR;
                        }
                        default -> {
                            System.out.println("Opcion incorrecta");
                            continue;
                        }
                    }
                    cabinas.get(cabinaId - 1).registrarLlamada(tipo);
                }
                case 3 ->{
                    if (cabinas.isEmpty()){
                        System.out.println("No hay registradas");
                    }
                    for (CabinaTelefonica cabina : cabinas) {
                        cabina.mostrarInfo();
                    }
                }
                case 4 ->{
                    if (cabinas.isEmpty()){
                        System.out.println("No hay cabinas registradas");
                    }
                    System.out.print("Seleccione la cabina a reiniciar (1-" + cabinas.size() + "): ");
                    int reinId = teclado.nextInt();
                    if (reinId < 1 || reinId > cabinas.size()){
                        System.out.println("Cabina invalida");
                    }
                    cabinas.get(reinId - 1).reiniciar();
                    System.out.println("Cabina #" + reinId + " reiniciada.");
                }
                case 5 ->{
                    System.out.println("Saliendo");
                }
                default -> {
                    System.out.println("Opcion incorrecta");
                }
            }

        } while (op !=5);

        teclado.close();
    }
}