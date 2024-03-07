import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu_departamento implements Menu {
    int opcionElegida;
    private ArrayList lista_reservas;
    int año ,mes ,dia ,hora ,minutos;
    String duracion;
    public Menu_departamento(){
        this.opcionElegida = 0;
        this.lista_reservas = new ArrayList();

    }
    @Override
    public void escribir_menu() {
        Scanner in = new Scanner(System.in);
        System.out.print("""
               1) Añadir Reserva
               2) Cancelar Reserva
               3) Listar todas las reservas
               4) Cerrar sesión
                """);
        this.opcionElegida= Integer.parseInt(in.nextLine());
        this.opcion(this.opcionElegida);
        in.close();
    }

    @Override
    public void opcion(int opcionElegida) {
        Scanner in = new Scanner(System.in);
         switch(opcionElegida){
             case 1:
                 Reserva r1 = new Reserva();
                 Añadible.añadir(r1,lista_reservas);

             break;

             case 2:
             break;

             case 3:
                 Listable.listar(lista_reservas);
             break;
             case 4:
             break;
         }

    }

    public ArrayList getLista_reservas() {
        return lista_reservas;
    }
}
