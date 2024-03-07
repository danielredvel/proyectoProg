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
        Object o;
        String nombre;
        String mensaje="año";
         switch(opcionElegida){
             case 1:
                 Reserva r1 = new Reserva();
                 Añadible.añadir(r1,lista_reservas);

             break;

             case 2:
                 System.out.println("Sala y fecha y hora de la Sala que deseas retirar");
                 nombre = in.nextLine();
                 System.out.println("Dime la fecha y hora");
                 //Try y catch
                 try {
                     System.out.println("Indica el año:");
                     this.año = Integer.parseInt(in.nextLine());

                     System.out.println("Indica el mes:");
                     mensaje = "mes";
                     this.mes = Integer.parseInt(in.nextLine());

                     System.out.println("Indica el dia:");
                     mensaje = "dia";
                     this.dia = Integer.parseInt(in.nextLine());

                     System.out.println("Indica la hora:");
                     mensaje = "hora";
                     this.hora = Integer.parseInt(in.nextLine());

                     System.out.println("Indica los minutos:");
                     mensaje= "minutos";
                     this.minutos = Integer.parseInt(in.nextLine());

                 } catch (NumberFormatException nfe){
                     if (mensaje.equals("hora")){
                         System.out.println("Error al escribir la "+mensaje);
                     } else if (mensaje.equals("minutos")) {
                         System.out.println("Error al escribir los "+mensaje);
                     } else {
                         System.out.println("Error al escribir el "+mensaje);
                     }
                 }
                 LocalDateTime f2 = LocalDateTime.of( año,mes,dia, hora,minutos);

                 System.out.println("Dime el nombre de la Sala que Reserva");
                 nombre = in.nextLine();
                 if (Buscable.buscar_nombre(nombre, Menu_admin.lista_salas)!=null){
                 Reserva r2 = new Reserva(f2, nombre);
                 Eliminable.eliminar(r2, lista_reservas);
             } else System.out.println("La Reserva no existe");




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
