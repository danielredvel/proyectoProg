import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class menu_departamento implements menu {
    int opcionElegida;
    private ArrayList lista_reservas;
    int año ,mes ,dia ,hora ,minutos;
    String duracion;
    public  menu_departamento(){
        this.opcionElegida = 0;
        this.lista_reservas = new ArrayList();

    }
    @Override
    public void escribir_menu() {
        Scanner in = new Scanner(System.in);
        System.out.print("""
               1) Añadir reserva
               2) Cancelar reserva
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
                 String nombre;
                 System.out.println("Dime la fecha y hora");
                 //Try y catch
                 System.out.println("Indica el año:");
                 this.año = in.nextInt();
                 System.out.println("Indica el mes:");
                 this.mes = in.nextInt();
                 System.out.println("Indica el dia:");
                 this.dia = in.nextInt();
                 System.out.println("Indica la hora:");
                 this.hora = in.nextInt();
                 System.out.println("Indica los minutos:");
                 this.minutos = in.nextInt();
                 LocalDateTime f1 = LocalDateTime.of( año,mes,dia, hora,minutos);

                 System.out.println("Dime el nombre de la sala que reserva");
                 nombre = in.nextLine();
                 buscable.buscar_nombre(nombre,menu_admin.lista_salas);
                 System.out.println("Dime el tiempo que reservas");
                 Duration d1 = Duration.parse(duracion);
                 this.duracion = in.nextLine();
                 reserva r1 = new reserva(f1,nombre,d1);
                 añadible.añadir(r1,lista_reservas);

             break;

             case 2:
             break;

             case 3:
                 listable.listar(lista_reservas);
             break;
             case 4:
             break;
         }

    }

    public ArrayList getLista_reservas() {
        return lista_reservas;
    }
}
